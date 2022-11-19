package ru.javarush.quest.impl;

import ru.javarush.quest.entity.Answer;
import ru.javarush.quest.service.AbstractDao;
import ru.javarush.quest.service.AnswerDao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AnswerImpl extends AbstractDao implements AnswerDao {
    @Override
    public Answer getAnswersInOrder(int count) {

        Answer answer = null;
        try (Connection connection = connect();
             Statement stmt = connection.createStatement()) {
            stmt.execute("SELECT * from answers where id=" + count);
            ResultSet resultSet = stmt.getResultSet();

            while (resultSet.next()) {
                answer = (getAnswer(resultSet));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return answer;
    }

    @Override
    public String wrongAnswerDescription(int count) {
        String wrongAnswerDescription = null;
        try (Connection connection = connect();
             Statement stmt = connection.createStatement()) {
            stmt.execute("SELECT d.description FROM description_for_wrong_answer d LEFT JOIN answers " +
                    "ON answers.id = d.id where d.id = " + count);
            ResultSet rs = stmt.getResultSet();
            while (rs.next()) {
                wrongAnswerDescription = getWrongAnswerDescription(rs);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return wrongAnswerDescription;
    }

    private String getWrongAnswerDescription(ResultSet rs) throws SQLException {
        return rs.getString("description");
    }

    private Answer getAnswer(ResultSet rs) throws SQLException {
        Answer answer;
        long id = rs.getLong("id");
        String correctAnswer = rs.getString("correct_answer");
        String wrongAnswer = rs.getString("wrong_answer");

        answer = new Answer(id, correctAnswer, wrongAnswer);
        return answer;
    }
}
