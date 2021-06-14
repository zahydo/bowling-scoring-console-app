package com.jobsity.app.presentation.impl;

import java.util.logging.Logger;

import com.jobsity.app.model.entities.Frame;
import com.jobsity.app.model.entities.Game;
import com.jobsity.app.model.entities.Player;
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
        String frameLine = String.format("%-1s\t\t", "Frame");
        for (String frame : game.getFramesIds()) {
            frameLine = frameLine.concat(String.format("%1s\t", frame));
        }
        System.out.println(frameLine);
        for (Player player : game.getPlayers()) {
            System.out.println(String.format("%-1s", player.getName()));
            String pinFalls = String.format("%1s\t", "Pinfalls");
            for (Frame frame : player.getFrames()) {
                if (frame.isStrike()) {
                    pinFalls = pinFalls.concat(String.format("\t%s", "X"));
                } else if (frame.isSpare()) {
                    pinFalls = pinFalls.concat(String.format("%s %s\t", frame.getBall1(), "/"));
                } else {
                    if (frame.getId() == game.getFrameLimit() -1) {
                        pinFalls = pinFalls.concat(String.format("%s %s %s\t", frame.getBall1(), frame.getBall2(), frame.getBall3()));
                    } else {
                        pinFalls = pinFalls.concat(String.format("%s %s\t", frame.getBall1(), frame.getBall2()));
                    }
                }
            }
            System.out.println(pinFalls);
        }

    }

}