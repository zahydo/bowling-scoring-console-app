package com.jobsity.app.model.services.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Logger;

import com.jobsity.app.model.entities.Game;
import com.jobsity.app.model.services.interfaces.GameBuilder;
import com.jobsity.app.model.services.interfaces.GameFacade;
import com.jobsity.app.model.services.interfaces.GameScoring;

public class ClassicBowlingFacade extends GameFacade {
    private final Logger LOG = Logger.getLogger(ClassicBowlingFacade.class.getName());

    public ClassicBowlingFacade() {
        super();
    }

    @Override
    public void runGame(HashMap<String, ArrayList<String>> data) {
        LOG.info("Start: Runing game...");
        GameBuilder builder = new ClassicBowlingBuilder();
        builder.buildPlayers(data);
        Game game = builder.getGame();
        GameScoring scoring = new ClassicBowlingScoring();
        scoring.calculate(game);
        this.setGame(game);
        LOG.info("Done: Game finished");
    }
}
