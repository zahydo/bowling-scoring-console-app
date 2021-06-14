package com.jobsity.app.util;

import com.jobsity.app.model.entities.Game;
import com.jobsity.app.model.util.Constants;
import java.util.ArrayList;
import java.util.HashMap;

public class Utils {
    public static HashMap<String, ArrayList<String>> getTestData() {
        HashMap<String, ArrayList<String>> data = new HashMap<>();
        ArrayList<String> rolls = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            rolls.add("10");
        }
        data.put("CARL", rolls);
        return data;
    }
    
    public static Game getClassicBowlingGame() {
        Game game = new Game();
        game.setFrameLimit(Constants.DEFAULT_FRAME_LIMIT);
        game.setRollsLimit(Constants.DEFAULT_ROLLS_LIMIT);
        game.setRollsMinLimit(Constants.DEFAULT_ROLLS_MIN);
        game.setName("Classic Bowling Game");
        return game;
    }
}
