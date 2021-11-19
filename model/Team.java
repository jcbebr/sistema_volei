package model;

public class Team {

    private final int id;
    private String name;
    private int wins;

    public Team(int id, String name) {
        super();
        this.id = id;
        this.name = name;
        this.wins = 0;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }
}