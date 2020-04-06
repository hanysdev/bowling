package com.bowling.frames;

public class StandardFrame {

    private int firstRoll;
    private int secondRoll;

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
}
