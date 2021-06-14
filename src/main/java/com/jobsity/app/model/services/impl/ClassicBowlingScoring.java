package com.jobsity.app.model.services.impl;

import java.util.ListIterator;
import java.util.logging.Logger;

import com.jobsity.app.model.entities.Frame;
import com.jobsity.app.model.entities.Game;
import com.jobsity.app.model.services.interfaces.GameScoring;
import com.jobsity.app.model.util.Utils;

public class ClassicBowlingScoring implements GameScoring {
    private static final Logger LOG = Logger.getLogger(ClassicBowlingScoring.class.getName());

    @Override
    public void calculate(Game game) {
        LOG.info("Start: Calculate scoring");
        game.getPlayers().forEach(player -> {
            int index = 0;
            ListIterator<Frame> iterator = player.getFrames().listIterator();
            while (iterator.hasNext()) {
                Frame frame = iterator.next();
                Frame frameNext;
                Frame frameNextNext;
                Frame framePrevious = null;
                if (iterator.previousIndex() > 0) {
                    framePrevious = player.getFrames().get(index - 1);
                }
                try {
                    frameNext = player.getFrames().get(index + 1) != null ? player.getFrames().get(index + 1) : null;
                } catch (IndexOutOfBoundsException e) {
                    frameNext = null;
                }
                try {
                    frameNextNext = player.getFrames().get(index + 2) != null ? player.getFrames().get(index + 2)
                            : null;
                } catch (IndexOutOfBoundsException e) {
                    frameNextNext = null;
                }
                calculateTotalScoringByFrame(frame, frameNext, frameNextNext, framePrevious);
                index++;
            }
            player.setScore(player.getFrames().getLast().getTotalScore());
        });
        LOG.info("Done: Scoring calculated");
    }

    private void calculateTotalScoringByFrame(Frame frame, Frame frameNext, Frame frameNextNext, Frame framePrevious) {
        int prevTotal = framePrevious != null ? framePrevious.getTotalScore() : 0;
        int currentFrameTotal = prevTotal + 0;
        // frames: 0 - antepenultimate
        if (frame != null && frameNext != null && frameNextNext != null) {
            if (frame.isStrike()) {
                // if current is strike check the next
                if (frameNext.isStrike()) {
                    // if next also is strike check the second next, sum current subTotalScore + next subTotalScore
                    currentFrameTotal = currentFrameTotal + frame.getSubTotalScore() + frameNext.getSubTotalScore();
                    if (frameNextNext.isStrike()) {
                        // if second next also is strike, sum subTotalScore from second next
                        currentFrameTotal = currentFrameTotal + frameNextNext.getSubTotalScore();
                    } else {
                        // if second next is not strike, sum ball1 from second next
                        currentFrameTotal = currentFrameTotal + Utils.convertRollStringToInt(frameNextNext.getBall1());
                    }
                } else {
                    // if next is not strike, sum subTotalScore from next + current subTotalScore
                    currentFrameTotal = currentFrameTotal + frame.getSubTotalScore() + frameNext.getSubTotalScore();
                }
            } else if (frame.isSpare()) {
                // if current is stripe, sum ball1 from next + current subTotalScore
                currentFrameTotal = currentFrameTotal + frame.getSubTotalScore()
                        + Utils.convertRollStringToInt(frameNext.getBall1());
            } else {
                // if current is not stripe/strike, sum current subTotalScore
                currentFrameTotal = currentFrameTotal + frame.getSubTotalScore();
            }
        // frame: penultimate
        } else if (frame != null && frameNext != null && frameNextNext == null) {
            if (frame.isStrike()) {
                // if current is strike, sum ball1,ball2 from next + current subTotalScore
                currentFrameTotal = currentFrameTotal + frame.getSubTotalScore()
                        + Utils.convertRollStringToInt(frameNext.getBall1())
                        + Utils.convertRollStringToInt(frameNext.getBall2());
            } else if (frame.isSpare()) {
                // if current is spare, sum ball1 from next + current subTotalScore
                currentFrameTotal = currentFrameTotal + frame.getSubTotalScore()
                        + Utils.convertRollStringToInt(frameNext.getBall1());
            } else {
                // if current is not spare/strike, sum current subTotalScore
                currentFrameTotal = currentFrameTotal + frame.getSubTotalScore();
            }
        // frame: last
        } else {
            // if current is the last frame, sum current subTotalScore
            currentFrameTotal = currentFrameTotal + frame.getSubTotalScore();
        }
        frame.setTotalScore(currentFrameTotal);
    }

}
