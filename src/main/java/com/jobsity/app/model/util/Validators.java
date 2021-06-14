package com.jobsity.app.model.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

import com.jobsity.app.model.entities.Game;

public class Validators {

    public static boolean isValidRoll(String data) throws IOException {
        boolean isValid = true;
        String errorMessage = "'" + data + "' is not a valid entry";
        String[] dataArray = data.split(" ");
        if (dataArray.length > 0) {
            if (dataArray.length == 2) {
                String roll = dataArray[1];
                String player = dataArray[0];
                if (!roll.matches(Constants.REGGEX_VALID_ROLL_INPUT)) {
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

    public static boolean isCompleteRolls(HashMap<String, ArrayList<String>> data, Game game) throws Exception {
        Set<String> players = data.keySet();
        boolean isComplete = true;
        Integer ROLLS_MIN_LIMIT = game.getRollsMinLimit();
        Integer ROLLS_MAX_LIMIT = game.getRollsLimit();
        String invalidPlayer = players.stream().filter(player -> {
            return data.get(player).size() > ROLLS_MAX_LIMIT || data.get(player).size() < ROLLS_MIN_LIMIT;
        }).findFirst().orElse(null);
        if (invalidPlayer != null) {
            int size = data.get(invalidPlayer).size();
            if (size > ROLLS_MAX_LIMIT) {
                isComplete = false;
                throw new Exception("'" + invalidPlayer + "' has " + (size - ROLLS_MAX_LIMIT) + " extra rolls");
            } else if (size < ROLLS_MIN_LIMIT) {
                isComplete = false;
                throw new Exception("'" + invalidPlayer + "' has " + (ROLLS_MAX_LIMIT - size) + " pending rolls");
            }
        }
        return isComplete;
    }
}
