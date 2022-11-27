package ru.javarush.quest.controller;

import ru.javarush.quest.service.Context;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "RegisterServlet", value = "/register")
public class RegisterServlet extends HttpServlet {
    private final Context context = Context.getDaoControllerInstance();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String accountName = req.getParameter("account_name");
        String login = req.getParameter("login");
        String password = req.getParameter("password");

        if (accountRegister(accountName, login, password)) {
            req.setAttribute("account_name", accountName);
            req.getRequestDispatcher("/login").forward(req, resp);
        } else {
            resp.sendRedirect("/register");
        }
    }

    private boolean accountRegister(String accountName, String login, String password) {
        return context.accountRegister(accountName, login, password);
    }

}
