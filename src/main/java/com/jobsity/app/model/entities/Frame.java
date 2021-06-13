package com.jobsity.app.model.entities;

import java.io.Serializable;

public class Frame implements Serializable {

    private int id;
    private String ball1;
    private String ball2;
    private String ball3;
    private boolean strike = false;
    private boolean spare = false;
    private int subTotalScore;
    private int totalScore;

    public Frame() {
    }

    public Frame(int id, String ball1, String ball2, String ball3, boolean strike, boolean spare, int subTotalScore,
            int totalScore) {
        this.id = id;
        this.ball1 = ball1;
        this.ball2 = ball2;
        this.ball3 = ball3;
        this.strike = strike;
        this.spare = spare;
        this.subTotalScore = subTotalScore;
        this.totalScore = totalScore;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(int totalScore) {
        this.totalScore = totalScore;
    }

    public int getSubTotalScore() {
        return subTotalScore;
    }

    public void setSubTotalScore(int subTotalScore) {
        this.subTotalScore = subTotalScore;
    }

    public boolean isSpare() {
        return spare;
    }

    public void setSpare(boolean spare) {
        this.spare = spare;
    }

    public boolean isStrike() {
        return strike;
    }

    public void setStrike(boolean strike) {
        this.strike = strike;
    }

    public String getBall3() {
        return ball3;
    }

    public void setBall3(String ball3) {
        this.ball3 = ball3;
    }

    public String getBall2() {
        return ball2;
    }

    public void setBall2(String ball2) {
        this.ball2 = ball2;
    }

    public void setBall1(String ball1) {
        this.ball1 = ball1;
    }

    public String getBall1() {
        return ball1;
    }

    @Override
    public String toString() {
        return "ID: "+ id + " ("+ ball1 + " - " + ball2 + " - " + ball3 + ") " + subTotalScore + " - " + totalScore;
    }
}
