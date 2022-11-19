package ru.javarush.quest.controller;

import ru.javarush.quest.entity.Account;
import ru.javarush.quest.service.Context;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {
    private static final String ACCOUNT_NAME = "account_name";
    private static final String LOGIN = "login";
    private static final String PASSWORD = "password";
    private final Context context = Context.getDaoControllerInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String accountName = req.getParameter(ACCOUNT_NAME);
        req.setAttribute(ACCOUNT_NAME, accountName);
        req.getRequestDispatcher("home.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter(LOGIN);
        String password = req.getParameter(PASSWORD);
        Account account = logIn(login, password);
        if (account != null) {
            req.setAttribute(ACCOUNT_NAME, account.getName());
            req.getRequestDispatcher("home.jsp").forward(req, resp);
        } else {
            resp.sendRedirect("login.jsp");
        }
    }

    private Account logIn(String login, String password) {
        return context.accountIsRegistered(login, password);
    }

}
