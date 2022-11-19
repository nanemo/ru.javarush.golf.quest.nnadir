package ru.javarush.quest.service;

import ru.javarush.quest.entity.Question;

public interface QuestionDao {
    Question getNextQuestion(int count);

}
