package ru.javarush.quest.controller;

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
    private static Long nextId = 0L;
    private final Context context = Context.getDaoControllerInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (nextId > context.getQuestionSize()) {
            nextId = 0L;
        }
        String accountName = req.getParameter(ACCOUNT_NAME);
        req.setAttribute(ACCOUNT_NAME, accountName);
        req.setAttribute(QUESTION, getQuestion().getDescription());
        req.setAttribute(COR_ANSWER, context.getAnswer(nextId).getCorrectAnswer());
        req.setAttribute(WRO_ANSWER, context.getAnswer(nextId).getWrongAnswer());
        req.getRequestDispatcher("firstPage.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        boolean booleanForAnswer = Boolean.parseBoolean(req.getParameter("boolean_for_answer"));
        if (booleanForAnswer) {
            if (nextId == context.getQuestionSize()) {
                req.setAttribute(ACCOUNT_NAME, req.getParameter(ACCOUNT_NAME));
                req.getRequestDispatcher("winPage.jsp").forward(req, resp);
                nextId = 0L;
            } else {
                req.setAttribute(ACCOUNT_NAME, req.getParameter(ACCOUNT_NAME));
                req.setAttribute(QUESTION, getQuestion().getDescription());
                req.setAttribute(COR_ANSWER, context.getAnswer(nextId).getCorrectAnswer());
                req.setAttribute(WRO_ANSWER, context.getAnswer(nextId).getWrongAnswer());
            }
            req.getRequestDispatcher("firstPage.jsp").forward(req, resp);
        } else {
            req.setAttribute(ACCOUNT_NAME, req.getParameter(ACCOUNT_NAME));
            req.setAttribute("wrong_answer_description", context.getWrongAnswerDescription(nextId));
            req.getRequestDispatcher("errorPage.jsp").forward(req, resp);
            nextId = 0L;
        }
    }

    private Question getQuestion() {
        if (nextId < context.getQuestionSize() + 1) {
            getCount();
        }
        return context.getQuestion(nextId);
    }

    private static void getCount() {
        nextId++;
    }

}
