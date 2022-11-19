package ru.javarush.quest.service;

import ru.javarush.quest.entity.Account;

public interface LoginDao {
    boolean registerUser(String name, String login, String password);

    Account getAccountByLoginAndPassword(String login, String password) throws RuntimeException;

}
