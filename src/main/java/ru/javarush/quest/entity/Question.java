package ru.javarush.quest.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@ToString
public class Question {
    private final Long id;
    private final String description;

    public Question(Long id, String description) {
        this.id = id;
        this.description = description;
    }

}

