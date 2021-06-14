package com.jobsity.app;

import com.jobsity.app.model.util.Constants;
import com.jobsity.app.presentation.impl.ClassicBowlingView;
import com.jobsity.app.presentation.services.GameView;

/**
 * Bowling Scoring app
 *
 */
public class App {
    public static void main(String[] args) {
        String fileName;
        try {
            fileName = args[0];
        } catch (ArrayIndexOutOfBoundsException e) {
            fileName = Constants.DEFAULT_FILE_NAME;
        }
        GameView view = new ClassicBowlingView(fileName);
        view.showScoring();
    }
}
