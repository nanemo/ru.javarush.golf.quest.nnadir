package ru.javarush.quest.impl;

import ru.javarush.quest.entity.Question;
import ru.javarush.quest.service.AbstractDao;
import ru.javarush.quest.service.QuestionDao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class QuestionImpl extends AbstractDao implements QuestionDao {
    @Override
    public Question getNextQuestion(int count) {
        Question question = null;
        try (Connection connection = connect();
             Statement stmt = connection.createStatement()) {
            stmt.execute("SELECT * from questions where id=" + count);
            ResultSet rs = stmt.getResultSet();

            while (rs.next()) {
                question = (getQuestion(rs));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return question;
    }

    private Question getQuestion(ResultSet rs) throws SQLException {
        Question question;
        question = new Question(rs.getLong("id"), rs.getString("question"));
        return question;
    }

}
