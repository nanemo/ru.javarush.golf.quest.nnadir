package ru.javarush.quest.controller;

import ru.javarush.quest.entity.Answer;
import ru.javarush.quest.entity.Question;
import ru.javarush.quest.service.Context;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LogicServlet", value = "/logic/*")
public class LogicServlet extends HttpServlet {
    private static final String ACCOUNT_NAME = "account_name";
    private static final String QUESTION = "question";
    private static final String COR_ANSWER = "cor_answer";
    private static final String WRO_ANSWER = "wro_answer";

    private static int count = 0;
    private final Context context = Context.getDaoControllerInstance();

    private static synchronized void getCount() {
        count++;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (count > 3) count = 0;
        String accountName = req.getParameter(ACCOUNT_NAME);
        req.setAttribute(ACCOUNT_NAME, accountName);
        req.setAttribute(QUESTION, getQuestion().getDescription());
        req.setAttribute(COR_ANSWER, getAnswer().getCorrectAnswer());
        req.setAttribute(WRO_ANSWER, getAnswer().getWrongAnswer());
        req.getRequestDispatcher("firstPage.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        boolean booleanForAnswer = Boolean.parseBoolean(req.getParameter("boolean_for_answer"));
        if (booleanForAnswer) {
            if (count == 3) {
                req.setAttribute(ACCOUNT_NAME, req.getParameter(ACCOUNT_NAME));
                req.getRequestDispatcher("winPage.jsp").forward(req, resp);
                count = 0;
            } else {
                req.setAttribute(ACCOUNT_NAME, req.getParameter(ACCOUNT_NAME));
                req.setAttribute(QUESTION, getQuestion().getDescription());
                req.setAttribute(COR_ANSWER, getAnswer().getCorrectAnswer());
                req.setAttribute(WRO_ANSWER, getAnswer().getWrongAnswer());
            }
            req.getRequestDispatcher("firstPage.jsp").forward(req, resp);
        } else {
            req.setAttribute(ACCOUNT_NAME, req.getParameter(ACCOUNT_NAME));
            req.setAttribute("wrong_answer_description", getWrongAnswerDescription());
            req.getRequestDispatcher("errorPage.jsp").forward(req, resp);
            count = 0;
        }
    }

    private Answer getAnswer() {
        return context.getAnswer(count);
    }

    private Question getQuestion() {
        if (count < 4) {
            getCount();
        }
        return context.getQuestion(count);
    }

    private String getWrongAnswerDescription() {
        return context.getWrongAnswerDescription(count);
    }

}
