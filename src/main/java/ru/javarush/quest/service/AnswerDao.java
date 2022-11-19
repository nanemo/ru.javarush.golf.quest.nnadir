package ru.javarush.quest.service;


import ru.javarush.quest.entity.Answer;

public interface AnswerDao {
    Answer getAnswersInOrder(int count);

    String wrongAnswerDescription(int count);

}
