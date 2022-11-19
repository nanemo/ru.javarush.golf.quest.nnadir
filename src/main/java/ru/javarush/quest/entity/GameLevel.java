package ru.javarush.quest.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class GameLevel {
    private Long id;
    private Stage levelName;
    private Question question;
    private Answer answer;

    public GameLevel(Long id, Stage levelName, Question question, Answer answer) {
        this.id = id;
        this.levelName = levelName;
        this.question = question;
        this.answer = answer;
    }

}
