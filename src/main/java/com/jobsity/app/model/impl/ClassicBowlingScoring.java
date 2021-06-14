package com.jobsity.app.model.impl;

import java.util.ListIterator;

import com.jobsity.app.model.entities.Frame;
import com.jobsity.app.model.entities.Game;
import com.jobsity.app.model.interfaces.GameScoring;
import com.jobsity.app.util.Utils;

public class ClassicBowlingScoring implements GameScoring {

    @Override
    public void calculate(Game game) {
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
            System.out.println("Player '" + player.getName() + "': " + player.getFrames().getLast().getTotalScore());
        });

    }

    private void calculateTotalScoringByFrame(Frame frame, Frame frameNext, Frame frameNextNext, Frame framePrevious) {
        int prevTotal = framePrevious != null ? framePrevious.getTotalScore() : 0;
        int currentFrameTotal = prevTotal + 0;
        // from 0 to 8 frame
        if (frame != null && frameNext != null && frameNextNext != null) {
            if (frame.isStrike()) {
                if (frameNext.isStrike()) {
                    currentFrameTotal = currentFrameTotal + frame.getSubTotalScore() + frameNext.getSubTotalScore();
                    if (frameNextNext.isStrike()) {
                        currentFrameTotal = currentFrameTotal + frameNextNext.getSubTotalScore();
                    } else {
                        currentFrameTotal = currentFrameTotal + Utils.convertRollStringToInt(frameNextNext.getBall1());
                    }
                } else {
                    currentFrameTotal = currentFrameTotal + frame.getSubTotalScore() + frameNext.getSubTotalScore();
                }
            } else if (frame.isSpare()) {
                currentFrameTotal = currentFrameTotal + frame.getSubTotalScore()
                        + Utils.convertRollStringToInt(frameNext.getBall1());
            } else {
                currentFrameTotal = currentFrameTotal + frame.getSubTotalScore();
            }
            // 9 frame
        } else if (frame != null && frameNext != null && frameNextNext == null) {
            if (frame.isStrike()) {
                currentFrameTotal = currentFrameTotal + frame.getSubTotalScore()
                        + Utils.convertRollStringToInt(frameNext.getBall1())
                        + Utils.convertRollStringToInt(frameNext.getBall2());
            } else if (frame.isSpare()) {
                currentFrameTotal = currentFrameTotal + frame.getSubTotalScore()
                        + Utils.convertRollStringToInt(frameNext.getBall1());
            } else {
                currentFrameTotal = currentFrameTotal + frame.getSubTotalScore();
            }
        } else {
            currentFrameTotal = currentFrameTotal + frame.getSubTotalScore();
        }
        frame.setTotalScore(currentFrameTotal);
    }

}
