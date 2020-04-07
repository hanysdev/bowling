package com.bowling.frames;

public class Frame {

    private int firstRoll;
    private int secondRoll;

    private boolean strike;
    private boolean spare;

    private int possibleSecondRoll;

    private int frameScore;

    public int getFirstRoll() {
	return firstRoll;
    }

    public void setFirstRoll(int firstRoll) {
	this.firstRoll = firstRoll;
    }

    public int getSecondRoll() {
	return secondRoll;
    }

    public void setSecondRoll(int secondRoll) {
	this.secondRoll = secondRoll;
    }

    public int getPossibleSecondRoll() {
	return possibleSecondRoll;
    }

    public void setPossibleSecondRoll(int possibleSecondRoll) {
	this.possibleSecondRoll = possibleSecondRoll;
    }

    public int getFrameScore() {
	return frameScore;
    }

    public void setFrameScore(int frameScore) {
	this.frameScore = frameScore;
    }

    public boolean isStrike() {
	return strike;
    }

    public void setStrike() {
	this.strike = true;
    }

    public boolean isSpare() {
	return spare;
    }

    public void setSpare() {
	this.spare = true;
    }
}
