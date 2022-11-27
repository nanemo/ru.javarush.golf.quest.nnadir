package ru.javarush.quest.entity;

public class Account {
    private final Long id;
    private final String name;
    private final String login;
    private final String password;
    private int playCount;
    private int winCount;
    private int gameOverCount;

    public Account(Long id, String name, String login, String password) {
        this.id = id;
        this.name = name;
        this.login = login;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLogin() {
        return login;
    }

    public int getPlayCount() {
        return playCount;
    }

    public void setPlayCount(int playCount) {
        this.playCount = playCount;
    }

    public int getWinCount() {
        return winCount;
    }

    public void setWinCount(int winCount) {
        this.winCount = winCount;
    }

    public int getGameOverCount() {
        return gameOverCount;
    }

    public void setGameOverCount(int gameOverCount) {
        this.gameOverCount = gameOverCount;
    }


}
