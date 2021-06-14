package com.jobsity.app.model.services.interfaces;

import com.jobsity.app.model.entities.Game;
import com.jobsity.app.model.services.impl.ClassicBowlingBuilder;
import com.jobsity.app.util.Utils;
import java.util.ArrayList;
import java.util.HashMap;
import junit.framework.TestCase;

public class GameBuilderTest extends TestCase {
    
    public GameBuilderTest(String testName) {
        super(testName);
    }

    public void testGetGame() {
        System.out.println("getGame");
        GameBuilder instance = new ClassicBowlingBuilder();
        Game expResult = null;
        Game result = instance.getGame();
        assertEquals(expResult, result);
    }

    public void testCreateNewGame() {
        System.out.println("createNewGame");
        GameBuilder instance = new ClassicBowlingBuilder();
        instance.createNewGame();
        instance.getGame();
        Game emptyGame = new Game();
        assertEquals(instance.getGame().getName(), emptyGame.getName());
    }

    public void testConfigureGame() {
        System.out.println("configureGame");
        GameBuilder instance = new ClassicBowlingBuilder();
        instance.configureGame();
        Game configuredGame = Utils.getClassicBowlingGame();
        assertEquals(instance.getGame().getName(), configuredGame.getName());
        assertEquals(instance.getGame().getFrameLimit(), configuredGame.getFrameLimit());
        assertEquals(instance.getGame().getRollsLimit(), configuredGame.getRollsLimit());
    }

    public void testBuildPlayers() {
        System.out.println("buildPlayers");
        HashMap<String, ArrayList<String>> data = Utils.getTestData();
        GameBuilder instance = new ClassicBowlingBuilder();
        instance.buildPlayers(data);
        assertEquals(instance.getGame().getPlayers().size(), 1);
        assertEquals(instance.getGame().getPlayers().get(0).getFrames().size(), 10);
    }
    
}
