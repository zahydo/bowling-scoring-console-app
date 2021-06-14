package com.jobsity.app.model.util;

public class Utils {
    public static int convertRollStringToInt(String roll) {
        return roll != null ? Integer.parseInt(roll.toUpperCase().equals("F") ? "0" : roll) : 0;
    }

    public static String getStrikeFromRoll(String roll) {
        return roll.equals("10") ? "X" : roll;
    }
}
