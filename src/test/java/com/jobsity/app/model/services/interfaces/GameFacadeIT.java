package com.jobsity.app.model.services.interfaces;

import com.jobsity.app.access.FileReader;
import com.jobsity.app.access.interfaces.DataAccessInterface;
import com.jobsity.app.model.entities.Game;
import com.jobsity.app.model.services.impl.ClassicBowlingBuilder;
import com.jobsity.app.model.services.impl.ClassicBowlingFacade;
import com.jobsity.app.model.services.impl.ClassicBowlingScoring;
import com.jobsity.app.presentation.impl.ClassicBowlingView;
import com.jobsity.app.presentation.services.GameView;
import java.util.ArrayList;
import java.util.HashMap;
import junit.framework.TestCase;

public class GameFacadeIT extends TestCase {
    
    public GameFacadeIT(String testName) {
        super(testName);
    }

    public void testInitGame() {
        System.out.println("initGame");
        GameFacade facade = new ClassicBowlingFacade();
        DataAccessInterface<HashMap<String, ArrayList<String>>> access = new FileReader("rolls_test.txt");
        GameBuilder builder = new ClassicBowlingBuilder();
        builder.buildPlayers(access.getData());
        Game classicBowlingGame = builder.getGame();
        GameScoring scoring = new ClassicBowlingScoring();
        scoring.calculate(classicBowlingGame);
        facade.setGame(classicBowlingGame);
        GameView view = new ClassicBowlingView();
        view.showScoring();
        assertEquals(classicBowlingGame.getPlayers().size(), 1);
        assertEquals(classicBowlingGame.getPlayers().get(0).getFrames().size(), 10);
        assertEquals(classicBowlingGame.getPlayers().get(0).getScore().intValue(), 300);
    }
    
}
