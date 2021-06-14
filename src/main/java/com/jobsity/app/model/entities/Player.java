package com.jobsity.app.model.entities;

import java.util.LinkedList;

public class Player {
    private String name;
    private Integer score;
    private LinkedList<Frame> frames;

    public LinkedList<Frame> getFrames() {
        return frames;
    }

    public void setFrames(LinkedList<Frame> frames) {
        this.frames = frames;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name + ": " + (frames != null ? frames.size() : 0)+ " frames. Score: " + score;
    }
}
