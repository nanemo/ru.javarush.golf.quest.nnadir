package ru.javarush.quest.entity;

import lombok.Getter;
import lombok.ToString;

@Getter
public class Answer {
    private final Long id;
    private final String  correctAnswer;
    private final String wrongAnswer;

    public Answer(Long id, String correctAnswer, String wrongAnswer) {
        this.id = id;
        this.correctAnswer = correctAnswer;
        this.wrongAnswer = wrongAnswer;
    }

    @Override
    public String toString() {
        return "Answer{" +
                "id=" + id +
                ", correctAnswer='" + correctAnswer + '\'' +
                ", wrongAnswer='" + wrongAnswer + '\'' +
                '}';
    }
}
