package com.jobsity.app.model.interfaces;

import java.util.ArrayList;
import java.util.HashMap;

import com.jobsity.app.access.FileReader;
import com.jobsity.app.access.interfaces.DataAccessInterface;
import com.jobsity.app.model.entities.Game;

public abstract class GameFacade {
    protected Game game;

    public void setGame(Game game) {
        this.game = game;
    }

    public Game getGame() {
        return this.game;
    }

    protected abstract void runGame(HashMap<String, ArrayList<String>> data);
    protected abstract void showScoring();

    public void initGame() {
        DataAccessInterface<HashMap<String, ArrayList<String>>> access = new FileReader();
        runGame(access.getData());
        showScoring();
    }
}
