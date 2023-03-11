package ru.javarush.quest.service;


import ru.javarush.quest.entity.Answer;

public interface AbstractAnswer {
    Answer getAnswersInOrder(Long count);

    String getWrongAnswerDescription(Long count);

}