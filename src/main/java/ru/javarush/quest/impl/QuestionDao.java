package ru.javarush.quest.impl;

import ru.javarush.quest.entity.Question;
import ru.javarush.quest.service.AbstractDao;
import ru.javarush.quest.service.AbstractQuestion;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class QuestionDao extends AbstractDao implements AbstractQuestion {
    @Override
    public Question getNextQuestion(Long id) {
        Question question = null;
        try (Connection connection = connect();
             Statement stmt = connection.createStatement()) {
            stmt.execute("SELECT * from questions where id=" + id);
            ResultSet rs = stmt.getResultSet();

            while (rs.next()) {
                question = (getQuestion(rs));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return question;
    }

    @Override
    public int getQuestionSize() {
        List<Question> question = new ArrayList<>();
        try (Connection connection = connect();
             Statement stmt = connection.createStatement()) {
            stmt.execute("SELECT * from questions");
            ResultSet rs = stmt.getResultSet();

            while (rs.next()) {
                question.add(getQuestion(rs));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return question.size();
    }

    private Question getQuestion(ResultSet rs) throws SQLException {
        Question question;
        question = new Question(rs.getLong("id"), rs.getString("question"));
        return question;
    }


}
