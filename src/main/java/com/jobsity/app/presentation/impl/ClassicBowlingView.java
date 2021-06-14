package com.jobsity.app.presentation.impl;

import java.util.logging.Logger;

import com.jobsity.app.model.entities.Game;
import com.jobsity.app.model.services.impl.ClassicBowlingFacade;
import com.jobsity.app.model.services.interfaces.GameFacade;
import com.jobsity.app.presentation.services.GameView;

public class ClassicBowlingView implements GameView {
    private final Logger LOG = Logger.getLogger(ClassicBowlingView.class.getName());
    private GameFacade facade;

    public ClassicBowlingView() {
        this.facade = new ClassicBowlingFacade();
        this.facade.initGame();
    }

    public GameFacade getFacade() {
        return facade;
    }

    public void setFacade(GameFacade facade) {
        this.facade = facade;
    }

    @Override
    public void showScoring() {
        LOG.info("Start: Show Scoring");
        System.out.println("------------------------------- Final Score -------------------------------");
        Game game = this.facade.getGame();
        System.out.println(game);
    }

}