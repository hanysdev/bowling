package com.bowling.game;

import java.util.ArrayList;
import java.util.List;

import com.bowling.frames.Frame;

public class Game {

    private int roll = 0;
    private int[] rolls = new int[21];
    private int lastExtraRoll = 0;

    List<Frame> framesList = new ArrayList<>();

    public Game() {
    }

    public void roll(int pinsFallen) {
	rolls[roll++] = pinsFallen;
    }

    public int score() {
	int score = 0;
	int cursor = 0;
	framesList.clear();
	for (int frame = 0; frame < 10; frame++) {
	    Frame frameObject = new Frame();
	    if (isStrike(cursor)) {
		score += 10 + rolls[cursor + 1] + rolls[cursor + 2];
		fillTheFrame(cursor, frameObject, score);
		frameObject.setStrike();
		lastExtraRoll = rolls[cursor + 2];
		cursor++;
	    } else if (isSpare(cursor)) {
		score += 10 + rolls[cursor + 2];
		fillTheFrame(cursor, frameObject, score);
		frameObject.setSpare();
		cursor += 2;
	    } else {
		score += rolls[cursor] + rolls[cursor + 1];
		fillTheFrame(cursor, frameObject, score);
		cursor += 2;
	    }
	    if (frame == 9) {
		if (rolls[cursor] == 10) {
		    frameObject.setSecondRoll(rolls[cursor + 1]);
		}
	    }
	    framesList.add(frameObject);
	}
	return score;
    }

    private void fillTheFrame(int cursor, Frame frameObject, int score) {
	frameObject.setFirstRoll(rolls[cursor]);
	if (rolls[cursor] != 10) {
	    frameObject.setSecondRoll(rolls[cursor + 1]);
	}
	if (rolls[cursor] == 10) {
	    frameObject.setSecondRoll(0);
	}
	if (frameObject.getFirstRoll() + frameObject.getSecondRoll() != 0)
	    frameObject.setFrameScore(score);
    }

    private boolean isStrike(int cursor) {
	return rolls[cursor] == 10;
    }

    private boolean isSpare(int cursor) {
	return rolls[cursor] + rolls[cursor + 1] == 10;
    }

    public void roll(int... rolls) {
	for (int pinsDown : rolls) {
	    roll(pinsDown);
	}
    }

    public List<Frame> getFramesList() {
	return framesList;
    }

    public int getLastExtraRoll() {
	return lastExtraRoll;
    }

    public void setLastExtraRoll(int lastExtraRoll) {
	this.lastExtraRoll = lastExtraRoll;
    }

}
