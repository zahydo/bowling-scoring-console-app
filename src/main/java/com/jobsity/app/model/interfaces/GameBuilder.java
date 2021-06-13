package com.jobsity.app.model.interfaces;

import java.util.ArrayList;
import java.util.HashMap;

import com.jobsity.app.model.entities.Game;

public abstract class GameBuilder {
    protected Game game;
    public Game getGame(){
        return game;
    }
    public void createNewGame(){
        game = new Game();
    }
    public abstract void configureGame();
    public abstract void buildPlayers(HashMap<String, ArrayList<String>> data);
}
