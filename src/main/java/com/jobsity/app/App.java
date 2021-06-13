package com.jobsity.app;

import java.util.ArrayList;
import java.util.HashMap;

import com.jobsity.app.access.FileReader;
import com.jobsity.app.access.interfaces.DataAccessInterface;
import com.jobsity.app.model.impl.ClassicBowlingBuilder;
import com.jobsity.app.model.impl.ClassicBowlingScoring;
import com.jobsity.app.model.interfaces.GameBuilder;
import com.jobsity.app.model.interfaces.GameScoring;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        DataAccessInterface<HashMap<String, ArrayList<String>>> access = new FileReader();
        HashMap<String, ArrayList<String>> data = access.getData();
        GameBuilder builder = new ClassicBowlingBuilder();
        builder.buildPlayers(data);
        GameScoring scoring = new ClassicBowlingScoring();
        scoring.calculate(builder.getGame());
    }
}
