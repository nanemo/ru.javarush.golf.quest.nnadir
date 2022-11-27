package ru.javarush.quest.controller;

import ru.javarush.quest.service.Context;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

@WebServlet(name = "LogicServlet", value = "/logic/*")
public class LogicServlet extends HttpServlet {
    private static final String ACCOUNT_NAME = "account_name";
    private static final String QUESTION = "question";
    private static final String COR_ANSWER = "cor_answer";
    private static final String WRO_ANSWER = "wro_answer";
    private final Context context = Context.getDaoControllerInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (context.getNextId() > context.getQuestionSize()) {
            context.setNextId(0L);
        }
        String accountName = req.getParameter(ACCOUNT_NAME);
        req.setAttribute(ACCOUNT_NAME, accountName);
        req.setAttribute(QUESTION, context.getQuestion().getDescription());
        req.setAttribute(COR_ANSWER, context.getAnswer(context.getNextId()).getCorrectAnswer());
        req.setAttribute(WRO_ANSWER, context.getAnswer(context.getNextId()).getWrongAnswer());
        req.getRequestDispatcher("firstPage.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String booleanForAnswer = req.getParameter("boolean_for_answer");
        if (Objects.equals(booleanForAnswer, "true")) {
            if (context.getNextId() == context.getQuestionSize()) {
                req.setAttribute(ACCOUNT_NAME, req.getParameter(ACCOUNT_NAME));
                req.getRequestDispatcher("winPage.jsp").forward(req, resp);
                context.setNextId(0L);
            } else {
                req.setAttribute(ACCOUNT_NAME, req.getParameter(ACCOUNT_NAME));
                req.setAttribute(QUESTION, context.getQuestion().getDescription());
                req.setAttribute(COR_ANSWER, context.getAnswer(context.getNextId()).getCorrectAnswer());
                req.setAttribute(WRO_ANSWER, context.getAnswer(context.getNextId()).getWrongAnswer());
            }
            req.getRequestDispatcher("firstPage.jsp").forward(req, resp);
        } else {
            req.setAttribute(ACCOUNT_NAME, req.getParameter(ACCOUNT_NAME));
            req.setAttribute("wrong_answer_description", context.getWrongAnswerDescription(context.getNextId()));
            req.getRequestDispatcher("errorPage.jsp").forward(req, resp);
            context.setNextId(0L);
        }
        resp.sendRedirect("firstPage.jsp");
    }

}
