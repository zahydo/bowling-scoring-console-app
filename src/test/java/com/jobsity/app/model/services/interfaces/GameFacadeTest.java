package com.jobsity.app.model.services.interfaces;

import com.jobsity.app.model.services.impl.ClassicBowlingFacade;
import com.jobsity.app.util.Utils;
import java.util.ArrayList;
import java.util.HashMap;
import junit.framework.TestCase;

public class GameFacadeTest extends TestCase {
    
    public GameFacadeTest(String testName) {
        super(testName);
    }

    public void testRunGame() {
        System.out.println("runGame");
        HashMap<String, ArrayList<String>> data = Utils.getTestData();
        GameFacade instance = new ClassicBowlingFacade();
        instance.runGame(data);
        assertEquals(instance.getGame().getPlayers().size(), 1);
        assertEquals(instance.getGame().getPlayers().get(0).getFrames().size(), 10);
        assertEquals(instance.getGame().getPlayers().get(0).getScore().intValue(), 300);
    }
    
}
