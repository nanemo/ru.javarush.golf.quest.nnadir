package ru.javarush.quest.service;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import ru.javarush.quest.entity.Answer;
import ru.javarush.quest.impl.AnswerDao;
import ru.javarush.quest.impl.QuestionDao;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

class AbstractAnswerTest {
    private static AbstractAnswer abstractAnswer;
    private static AbstractQuestion abstractQuestion;

    @BeforeAll
    static void testInit() {
        abstractAnswer = new AnswerDao();
        abstractQuestion = new QuestionDao();
    }

    @Test
    void testGetAnswerInOrder() {
        for (Long i = 1L; i <= abstractQuestion.getQuestionSize(); i++) {
            Answer answersInOrder = abstractAnswer.getAnswersInOrder(i);
            assertNotNull(answersInOrder);
        }
    }

    @ParameterizedTest
    @NullSource
    void testIfIdIsNullWhenGetAnswerInOrder(Long id) {
        assertNull(abstractAnswer.getAnswersInOrder(id));
    }

    @Test
    void testGetWrongAnswer() {
        for (Long i = 1L; i < abstractQuestion.getQuestionSize(); i++) {
            assertNotNull(abstractAnswer.getWrongAnswerDescription(i));
        }
    }

    @ParameterizedTest
    @NullSource
    void testIfIdIsNullWhenGetWrongAnswerInOrder(Long id) {
        assertNull(abstractAnswer.getWrongAnswerDescription(id));
    }

}