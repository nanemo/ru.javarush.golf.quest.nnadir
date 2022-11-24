package ru.javarush.quest.service;

import java.sql.Connection;
import java.sql.DriverManager;

public abstract class AbstractDao {
    public Connection connect() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");

        String url = "jdbc:mysql://db:3306/quest_nadir";
        String username = "root";
        String password = "root";

        return DriverManager.getConnection(url, username, password);
    }

}
