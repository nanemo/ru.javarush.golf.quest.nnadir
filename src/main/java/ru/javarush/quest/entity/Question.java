package ru.javarush.quest.entity;

public class Question {
    private final Long id;
    private final String description;

    public Question(Long id, String description) {
        this.id = id;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}

