package com.jobsity.app.model.services.interfaces;

import java.util.ArrayList;
import java.util.HashMap;

import com.jobsity.app.access.FileReader;
import com.jobsity.app.access.interfaces.DataAccessInterface;
import com.jobsity.app.model.entities.Game;

public abstract class GameFacade {
    protected Game game;
    protected String fileName;

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileName() {
        return this.fileName;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public Game getGame() {
        return this.game;
    }

    protected abstract void runGame(HashMap<String, ArrayList<String>> data);

    public void initGame() {
        DataAccessInterface<HashMap<String, ArrayList<String>>> access = new FileReader(this.fileName);
        runGame(access.getData());
    }
}
