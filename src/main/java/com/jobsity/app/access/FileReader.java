package com.jobsity.app.access;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Optional;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Stream;

import com.jobsity.app.model.util.Validators;
import com.jobsity.app.util.Contants;

public class FileReader implements DataAccessInterface<HashMap<String, ArrayList<Integer>>> {
    final Logger LOG = Logger.getLogger(FileReader.class.getName());

    @Override
    public HashMap<String, ArrayList<Integer>> getData() {
        HashMap<String, ArrayList<Integer>> data = new HashMap<>();
        Path path = Paths.get(Contants.DEFAULT_FILE_NAME);
        try {
            long rollsCount = Files.lines(path).count();
            if (rollsCount == 0) {
                throw new IOException("Verify '" + Contants.DEFAULT_FILE_NAME + "' is not an empty file");
            }
            Stream<String> fileLines = Files.lines(path);

            fileLines.forEach(fileLine -> {
                try {
                    if (Validators.isValidRoll(fileLine)) {
                        String[] playerRoll = fileLine.split(" ");
                        String player = playerRoll[0];
                        String rollString = playerRoll[1].toUpperCase();
                        Integer roll = !rollString.equals("F") ? Integer.parseInt(rollString) : 0;
                        if (!data.containsKey(player)) {
                            ArrayList<Integer> rolls = new ArrayList<Integer>();
                            rolls.add(roll);
                            data.put(player, rolls);
                        } else {
                            data.get(player).add(roll);
                        }
                    }
                } catch (IOException e) {
                    LOG.log(Level.SEVERE, e.getMessage(), e.fillInStackTrace());
                }
            });
            fileLines.close();
            Set<String> players = data.keySet();
            Optional<String> invalidPlayer = players.stream().filter(player -> {
                return data.get(player).size() > 21 || data.get(player).size() < 12;
            }).findFirst();
            if (invalidPlayer.isPresent()) {
                int size = data.get(invalidPlayer.get()).size();
                if (size > 21) {
                    throw new Exception("'" + invalidPlayer.get() + "' has " + (size - 21)  + " extra rolls");
                }
                if (size < 12) {
                    throw new Exception("'" + invalidPlayer.get() + "' has " + (21-size)  + " pending rolls");
                }
            }
        } catch (Exception e) {
            LOG.log(Level.SEVERE, e.getMessage(), e.fillInStackTrace());
        }
        return data;
    }
}
