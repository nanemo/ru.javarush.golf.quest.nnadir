package ru.javarush.quest.service;

import ru.javarush.quest.entity.Account;
import ru.javarush.quest.entity.Answer;
import ru.javarush.quest.entity.Question;
import ru.javarush.quest.impl.AnswerDao;
import ru.javarush.quest.impl.LoginDao;
import ru.javarush.quest.impl.QuestionDao;

public class Context {
    private static Context context;
    private static Long nextId = 0L;
    private final AbstractAnswer abstractAnswer = new AnswerDao();
    private final AbstractQuestion abstractQuestion = new QuestionDao();
    private final AbstractLogin abstractLogin = new LoginDao();

    private Context() {
    }

    public static Context getDaoControllerInstance() {
        if (context == null) {
            context = new Context();
        }
        return context;
    }

    public Long getNextId() {
        return nextId;
    }

    public void setNextId(Long nextId) {
        Context.nextId = nextId;
    }

    public Answer getAnswer(Long count) {
        return abstractAnswer.getAnswersInOrder(count);
    }

    public String getWrongAnswerDescription(Long count) {
        return abstractAnswer.getWrongAnswerDescription(count);
    }

    public Question getQuestion(Long count) {
        return abstractQuestion.getNextQuestion(count);
    }

    public int getQuestionSize() {
        return abstractQuestion.getQuestionSize();
    }

    public Account accountIsRegistered(String login, String password) {
        return abstractLogin.getAccountByLoginAndPassword(login, password);
    }

    public boolean accountRegister(String accountName, String login, String password) {
        return abstractLogin.registerUser(accountName, login, password);
    }

    public void getCount() {
        nextId++;
    }

    public Question getQuestion() {
        if (getNextId() < getQuestionSize() + 1) {
            getCount();
        }
        return getQuestion(getNextId());
    }

}
