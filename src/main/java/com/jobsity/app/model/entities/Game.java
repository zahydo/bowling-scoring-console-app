package com.jobsity.app.model.entities;

import java.util.ArrayList;

public class Game {
    private ArrayList<Player> players;
    private Integer frameLimit;
    private Integer rollsLimit;
    private Integer rollsMinLimit;
    private String name;

    public Game() {
    }

    public Game(ArrayList<Player> players, String name, Integer frameLimit, Integer rollsLimit, Integer rollsMinLimit) {
        this.players = players;
        this.name = name;
        this.frameLimit = frameLimit;
        this.rollsLimit = rollsLimit;
        this.rollsMinLimit = rollsMinLimit;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public Integer getFrameLimit() {
        return frameLimit;
    }

    public void setFrameLimit(Integer frameLimit) {
        this.frameLimit = frameLimit;
    }

    public Integer getRollsLimit() {
        return rollsLimit;
    }

    public void setRollsLimit(Integer rollsLimit) {
        this.rollsLimit = rollsLimit;
    }

    public Integer getRollsMinLimit() {
        return rollsMinLimit;
    }

    public void setRollsMinLimit(Integer rollsMinLimit) {
        this.rollsMinLimit = rollsMinLimit;
    }

    @Override
    public String toString() {
        return name + " - players: " + players.toString();
    }
}
