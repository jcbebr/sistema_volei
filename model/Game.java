package model;

import java.util.ArrayList;

public class Game {

    private ArrayList<int[]> sets;
    private Team team0;
    private Team team1;
    private int currentSet;

    public Game() {
        super();
        sets = new ArrayList<>();
    }

    public ArrayList<int[]> getSets() {
        return sets;
    }

    public Team getTeam0() {
        return team0;
    }

    public void setTeam0(Team team0) {
        this.team0 = team0;
    }

    public Team getTeam1() {
        return team1;
    }

    public void setTeam1(Team team1) {
        this.team1 = team1;
    }

    public int getCurrentSet() {
        return currentSet;
    }

    public void setCurrentSet(int currentSet) {
        this.currentSet = currentSet;
    }

}