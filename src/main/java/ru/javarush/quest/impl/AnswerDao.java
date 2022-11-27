package ru.javarush.quest.impl;

import ru.javarush.quest.entity.Answer;
import ru.javarush.quest.service.AbstractAnswer;
import ru.javarush.quest.service.AbstractDao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Objects;

public class AnswerDao extends AbstractDao implements AbstractAnswer {
    @Override
    public Answer getAnswersInOrder(Long id) {
        ResultSet rs = null;
        Answer answer = null;
        try (Connection connection = connect();
             Statement stmt = connection.createStatement()) {
            stmt.execute("SELECT * from answers where id=" + id);
            rs = stmt.getResultSet();

            while (rs.next()) {
                answer = (getAnswer(rs));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                Objects.requireNonNull(rs).close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return answer;
    }

    @Override
    public String getWrongAnswerDescription(Long id) {
        ResultSet rs = null;
        String wrongAnswerDescription = null;
        try (Connection connection = connect();
             Statement stmt = connection.createStatement()) {
            stmt.execute("SELECT * FROM description_for_wrong_answer d where d.id = " + id);
            rs = stmt.getResultSet();
            while (rs.next()) {
                wrongAnswerDescription = getWrongAnswerDescription(rs);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                Objects.requireNonNull(rs).close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
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
