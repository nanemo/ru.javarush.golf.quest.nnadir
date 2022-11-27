package ru.javarush.quest.entity;

public class Answer {
    private final Long id;
    private final String correctAnswer;
    private final String wrongAnswer;

    public Answer(Long id, String correctAnswer, String wrongAnswer) {
        this.id = id;
        this.correctAnswer = correctAnswer;
        this.wrongAnswer = wrongAnswer;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public String getWrongAnswer() {
        return wrongAnswer;
    }

}
