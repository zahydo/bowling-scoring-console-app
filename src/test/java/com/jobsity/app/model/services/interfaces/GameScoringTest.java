package com.jobsity.app.model.services.interfaces;

import com.jobsity.app.model.entities.Game;
import com.jobsity.app.model.services.impl.ClassicBowlingBuilder;
import com.jobsity.app.model.services.impl.ClassicBowlingScoring;
import com.jobsity.app.util.Utils;
import java.util.ArrayList;
import java.util.HashMap;
import junit.framework.TestCase;

public class GameScoringTest extends TestCase {
    
    public GameScoringTest(String testName) {
        super(testName);
    }

    public void testCalculate() {
        System.out.println("calculate");
        HashMap<String, ArrayList<String>> data = Utils.getTestData();
        GameBuilder builder = new ClassicBowlingBuilder();
        builder.buildPlayers(data);
        Game classicBowlingGame = builder.getGame();
        GameScoring instance = new ClassicBowlingScoring();
        instance.calculate(classicBowlingGame);
        assertEquals(classicBowlingGame.getPlayers().size(), 1);
        assertEquals(classicBowlingGame.getPlayers().get(0).getFrames().size(), 10);
        assertEquals(classicBowlingGame.getPlayers().get(0).getScore().intValue(), 300);
    }
}
