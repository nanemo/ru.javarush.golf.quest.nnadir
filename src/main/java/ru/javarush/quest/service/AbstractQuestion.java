package ru.javarush.quest.service;

import ru.javarush.quest.entity.Question;

public interface AbstractQuestion {
    Question getNextQuestion(Long count);

    int getQuestionSize();

}
