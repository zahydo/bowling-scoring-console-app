package com.jobsity.app.access;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Stream;

import com.jobsity.app.access.interfaces.DataAccessInterface;
import com.jobsity.app.model.util.Constants;
import com.jobsity.app.model.util.Validators;

public class FileReader implements DataAccessInterface<HashMap<String, ArrayList<String>>> {
    private final Logger LOG = Logger.getLogger(FileReader.class.getName());
    private String fileName;

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public FileReader() {
    }

    public FileReader(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public HashMap<String, ArrayList<String>> getData() {
        LOG.info("Start: Loading Data...");
        HashMap<String, ArrayList<String>> data = new HashMap<>();
        Path path = Paths.get(fileName != null ? fileName : Constants.DEFAULT_FILE_NAME);
        try {
            long rollsCount = Files.lines(path).count();
            if (rollsCount == 0) {
                throw new IOException("Verify '" + Constants.DEFAULT_FILE_NAME + "' is not an empty file");
            }
            try (Stream<String> fileLines = Files.lines(path)) {
                fileLines.forEach(fileLine -> {
                    try {
                        if (Validators.isValidRoll(fileLine)) {
                            String[] playerRoll = fileLine.split(" ");
                            String player = playerRoll[0].toUpperCase();
                            String roll = playerRoll[1].toUpperCase();
                            if (!data.containsKey(player)) {
                                ArrayList<String> rolls = new ArrayList<>();
                                rolls.add(roll);
                                data.put(player, rolls);
                            } else {
                                data.get(player).add(roll);
                            }
                        }
                    } catch (IOException e) {
                        LOG.log(Level.SEVERE, e.getMessage(), e.fillInStackTrace());
                        System.exit(0);
                    }
                });
            }
            LOG.info("Done: Data successfully loaded");
        } catch (IOException e) {
            LOG.log(Level.SEVERE, "No such file: " + fileName, e.fillInStackTrace());
            System.exit(0);
        }
        return data;
    }
}
