package ru.javarush.quest.service;

import ru.javarush.quest.entity.Account;
import ru.javarush.quest.entity.Answer;
import ru.javarush.quest.entity.Question;
import ru.javarush.quest.impl.AnswerImpl;
import ru.javarush.quest.impl.LoginImpl;
import ru.javarush.quest.impl.QuestionImpl;

public class Context{
    private static Context context;
    private final AnswerDao answerDao = new AnswerImpl();
    private final QuestionDao questionDao = new QuestionImpl();
    private final LoginDao loginDao = new LoginImpl();

    private Context() {
    }

    public static Context getDaoControllerInstance() {
        if (context == null) {
            context = new Context();
        }
        return context;
    }

    public Answer getAnswer(int count) {
        return answerDao.getAnswersInOrder(count);
    }

    public String getWrongAnswerDescription(int count) {
        return answerDao.wrongAnswerDescription(count);
    }

    public Question getQuestion(int count) {
        return questionDao.getNextQuestion(count);
    }

    public Account accountIsRegistered(String login, String password){
        return loginDao.getAccountByLoginAndPassword(login, password);
    }

    public boolean accountRegister(String accountName, String login, String password) {
        return loginDao.registerUser(accountName, login, password);
    }
}
