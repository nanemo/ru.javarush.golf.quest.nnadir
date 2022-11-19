package ru.javarush.quest.impl;

import ru.javarush.quest.entity.Account;
import ru.javarush.quest.service.AbstractDao;
import ru.javarush.quest.service.LoginDao;

import java.sql.*;


public class LoginImpl extends AbstractDao implements LoginDao {

    @Override
    public boolean registerUser(String name, String login, String password) {
        if (accountIsExist(login, password)) {
            return false;
        }
        boolean execute = true;
        try (Connection connection = connect();
             PreparedStatement preStatement = connection.prepareStatement("insert into accounts " +
                             "(accounts.account_name, accounts.login, accounts.`password`) values (?, ?, ?)"
                     , Statement.RETURN_GENERATED_KEYS)) {
            preStatement.setString(1, name);
            preStatement.setString(2, login);
            preStatement.setString(3, password);
            preStatement.execute();
        } catch (Exception e) {
            e.printStackTrace();
            execute = false;
        }
        return execute;
    }

    @Override
    public Account getAccountByLoginAndPassword(String login, String password) throws RuntimeException {
        Account account = null;
        try (Connection connection = connect();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM accounts where accounts.login = ? AND accounts.password = ?")) {
            preparedStatement.setString(1, login);
            preparedStatement.setString(2, password);
            preparedStatement.execute();

            ResultSet rs = preparedStatement.getResultSet();

            while (rs.next()) {
                account = getLogin(rs);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return account;
    }

    private boolean accountIsExist(String login, String password) {
        Account account = getAccountByLoginAndPassword(login, password);

        return account != null;
    }

    private Account getLogin(ResultSet rs) {
        Account account = null;
        try {
            Long id = rs.getLong("id");
            String accountName = rs.getString("account_name");
            String login = rs.getString("login");
            String password = rs.getString("password");

            account = new Account(id, accountName, login, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return account;
    }

}
