package com.jobsity.app.model.services.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.jobsity.app.model.entities.Frame;
import com.jobsity.app.model.entities.Player;
import com.jobsity.app.model.services.interfaces.GameBuilder;
import com.jobsity.app.model.util.Constants;
import com.jobsity.app.model.util.Utils;
import com.jobsity.app.model.util.Validators;

public class ClassicBowlingBuilder extends GameBuilder {
    private static final Logger LOG = Logger.getLogger(ClassicBowlingBuilder.class.getName());

    @Override
    public void buildPlayers(HashMap<String, ArrayList<String>> data) {
        LOG.info("Start: Build players");
        try {
            if (game == null || game.getFrameLimit() == null) {
                configureGame();
            }
            if (Validators.isCompleteRolls(data, this.getGame())) {
                data.keySet().stream().forEach(player -> {
                    LOG.log(Level.INFO, "Start: Building player: {0}", player);
                    Player playerObject = new Player();
                    playerObject.setName(player);
                    playerObject.setFrames(buildFrames(data, player));
                    if (game.getPlayers() == null) {
                        game.setPlayers(new ArrayList<>());
                    }
                    game.getPlayers().add(playerObject);
                });
            }
            LOG.info("Done: Build players");
        } catch (Exception e) {
            LOG.log(Level.SEVERE, e.getMessage(), e.fillInStackTrace());
            System.exit(0);
        }
    }

    private LinkedList<Frame> buildFrames(HashMap<String, ArrayList<String>> data, String player) {
        LinkedList<Frame> frames = new LinkedList<>();
        int frameCounter=0;
        ArrayList<String> rolls = data.get(player);
        int i = 0;
        while (i < rolls.size()){
            try {
                String roll = rolls.get(i);
                if (roll.equals("10") && frameCounter < game.getFrameLimit() - 1) {
                    frames.add(new Frame(frameCounter, roll, null, null, true, false, 10, 0));
                    i++;
                } else {
                    int ball1 = Utils.convertRollStringToInt(roll);
                    int ball2 = Utils.convertRollStringToInt(rolls.get(i+1));
                    if (frameCounter < game.getFrameLimit() - 1) {
                        int subTotalScore = ball1 + ball2;
                        boolean spare = subTotalScore == 10;
                        frames.add(new Frame(frameCounter, roll, rolls.get(i +1), null, false, spare, subTotalScore, 0));
                        i = i +2;
                    } else {
                        int ball3 = Utils.convertRollStringToInt(rolls.get(i+2));
                        int subTotalScore = ball1 + ball2 + ball3;
                        frames.add(new Frame(frameCounter, roll, rolls.get(i +1), rolls.get(i + 2), false, false, subTotalScore, 0));
                        i = i +3;
                    }
                }
                frameCounter++;
            } catch (IndexOutOfBoundsException e) {
                LOG.log(Level.SEVERE, "Check rolls for: '" + player + "'", e);
                System.exit(0);
            }
        }
        if (frameCounter != game.getFrameLimit()) {
            LOG.log(Level.SEVERE, "Check rolls for: ''{0}''", player);
            System.exit(0);
        }
        return frames;
    }

    @Override
    public void configureGame() {
        if (game == null) {
            this.createNewGame();
        }
        game.setFrameLimit(Constants.DEFAULT_FRAME_LIMIT);
        game.setRollsLimit(Constants.DEFAULT_ROLLS_LIMIT);
        game.setRollsMinLimit(Constants.DEFAULT_ROLLS_MIN);
        game.setName("Classic Bowling Game");
    }
}
