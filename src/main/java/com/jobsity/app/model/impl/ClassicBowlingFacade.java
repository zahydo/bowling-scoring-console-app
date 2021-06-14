package com.jobsity.app.model.impl;

import com.jobsity.app.model.interfaces.GameBuilder;
import com.jobsity.app.model.interfaces.GameFacade;
import com.jobsity.app.model.interfaces.GameScoring;

import java.util.ArrayList;
import java.util.HashMap;

import com.jobsity.app.model.entities.Game;

public class ClassicBowlingFacade extends GameFacade {

    public ClassicBowlingFacade() {
        super();
    }

    @Override
    public void runGame(HashMap<String, ArrayList<String>> data) {
        GameBuilder builder = new ClassicBowlingBuilder();
        builder.buildPlayers(data);
        Game game = builder.getGame();
        GameScoring scoring = new ClassicBowlingScoring();
        scoring.calculate(game);
        this.setGame(game);
    }

    @Override
    protected void showScoring() {
        System.out.println(game);
    }
}
