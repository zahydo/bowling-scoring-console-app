package com.jobsity.app.util;

public class Utils {
    public static int convertRollStringToInt(String roll) {
        return Integer.parseInt(roll.toUpperCase().equals("F") ? "0" : roll);
    }
}
