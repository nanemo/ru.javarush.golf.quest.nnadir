package ru.javarush.quest.entity;

public class Account {
    private Long id;
    private final String name;
    private final String login;
    private String password;
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

    public void setId(Long id) {
        this.id = id;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Account)) return false;

        Account account = (Account) o;

        if (!id.equals(account.id)) return false;
        if (!name.equals(account.name)) return false;
        if (!login.equals(account.login)) return false;
        return password.equals(account.password);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + login.hashCode();
        result = 31 * result + password.hashCode();
        return result;
    }

}
