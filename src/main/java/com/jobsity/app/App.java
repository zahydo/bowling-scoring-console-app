package com.jobsity.app;

import com.jobsity.app.model.impl.ClassicBowlingFacade;
import com.jobsity.app.model.interfaces.GameFacade;

/**
 * Bowling Scoring app
 *
 */
public class App {
    public static void main(String[] args) {
        GameFacade facade = new ClassicBowlingFacade();
        facade.initGame();
    }
}
