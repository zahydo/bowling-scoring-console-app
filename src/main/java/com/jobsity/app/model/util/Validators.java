package com.jobsity.app.model.util;

import java.io.IOException;

import com.jobsity.app.util.Contants;

public class Validators {

    public static boolean isValidRoll(String data) throws IOException {
        boolean isValid = true;
        String errorMessage = "'" + data + "' is not a valid entry";
        String[] dataArray = data.split(" ");
        if (dataArray.length > 0) {
            if (dataArray.length == 2) {
                String roll = dataArray[1];
                String player = dataArray[0];
                if (!roll.matches(Contants.REGGEX_VALID_ROLL_INPUT)) {
                    isValid = false;
                    throw new IOException(errorMessage);
                }
                if (player.length() > 30) {
                    isValid = false;
                    throw new IOException("Player '" + player + "' is not a valid name");
                }
            } else {
                isValid = false;
            }
        } else {
            isValid = false;
        }
        return isValid;
    }
}
