package com.jobsity.app.presentation.impl;

import java.util.logging.Logger;

import com.jobsity.app.model.entities.Frame;
import com.jobsity.app.model.entities.Game;
import com.jobsity.app.model.services.impl.ClassicBowlingFacade;
import com.jobsity.app.model.services.interfaces.GameFacade;
import com.jobsity.app.model.util.Utils;
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
        String frameLine = String.format("%-20s", "Frame");
        for (String frame : game.getFramesIds()) {
            frameLine = frameLine.concat(String.format("%-4s %-4s %-4s", frame, "", ""));
        }
        System.out.println(frameLine);
        game.getPlayers().stream().map(player -> {
            System.out.println(String.format("%-20s", player.getName()));
            return player;
        }).forEachOrdered(player -> {
            String pinFalls = String.format("%-20s", "Pinfalls");
            String score = String.format("%-20s", "Score");
            for (Frame frame : player.getFrames()) {
                if (frame.isStrike()) {
                    pinFalls = pinFalls.concat(String.format("%-4s %-4s %-4s", "", "X", ""));
                } else if (frame.isSpare()) {
                    pinFalls = pinFalls.concat(String.format("%-4s %-4s %-4s", frame.getBall1(), "/", ""));
                } else {
                    if (frame.getId() == game.getFrameLimit() - 1) {
                        pinFalls = pinFalls.concat(String.format("%-4s %-4s %-4s",
                                Utils.getStrikeFromRoll(frame.getBall1()), Utils.getStrikeFromRoll(frame.getBall2()),
                                Utils.getStrikeFromRoll(frame.getBall3())));
                    } else {
                        pinFalls = pinFalls
                                .concat(String.format("%-4s %-4s %-4s", frame.getBall1(), frame.getBall2(), ""));
                    }
                }
                score = score.concat(String.format("%-4s %-4s %-4s", frame.getTotalScore(), "", ""));
            }
            System.out.println(pinFalls);
            System.out.println(score);
        });

    }

}