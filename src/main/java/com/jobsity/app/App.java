package com.jobsity.app;

import com.jobsity.app.presentation.impl.ClassicBowlingView;
import com.jobsity.app.presentation.services.GameView;

/**
 * Bowling Scoring app
 *
 */
public class App {
    public static void main(String[] args) {
        GameView view = new ClassicBowlingView();
        view.showScoring();
    }
}
