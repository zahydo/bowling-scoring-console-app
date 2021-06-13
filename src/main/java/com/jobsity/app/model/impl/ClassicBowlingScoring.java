package com.jobsity.app.model.impl;

import java.util.ListIterator;

import com.jobsity.app.model.entities.Frame;
import com.jobsity.app.model.entities.Game;
import com.jobsity.app.model.interfaces.GameScoring;


public class ClassicBowlingScoring implements GameScoring{

    @Override
    public void calculate(Game game) {
        game.getPlayers().forEach(player -> {
            int index = 0;
            ListIterator<Frame> iterator = player.getFrames().listIterator(index);
            while(iterator.hasNext()) {
                Frame frame = iterator.next();
                Frame frameNext;
                Frame frameNextNext;
                try {
                    frameNext = player.getFrames().get(index + 1) != null ? player.getFrames().get(index +1) : null;
                } catch (IndexOutOfBoundsException e) {
                    frameNext = null;
                }
                try {
                    frameNextNext = player.getFrames().get(index + 2) != null ? player.getFrames().get(index +2) : null;
                } catch (IndexOutOfBoundsException e) {
                    frameNextNext = null;
                }
                index++;
            }
        });
    }
    
}
