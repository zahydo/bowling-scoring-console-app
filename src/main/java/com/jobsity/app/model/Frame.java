package com.jobsity.app.model;

import java.io.Serializable;

public class Frame implements Serializable {
    private int ball1;
    private int ball2;
    private int ball3;
    private boolean strike = false;
    private boolean spare = false;
    private int subTotalScore;
    private int totalScore;

    public int getBall1() {
        return ball1;
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

    public int getBall3() {
        return ball3;
    }

    public void setBall3(int ball3) {
        this.ball3 = ball3;
    }

    public int getBall2() {
        return ball2;
    }

    public void setBall2(int ball2) {
        this.ball2 = ball2;
    }

    public void setBall1(int ball1) {
        this.ball1 = ball1;
    }
}
