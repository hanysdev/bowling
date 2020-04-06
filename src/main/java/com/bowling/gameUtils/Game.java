package com.bowling.gameUtils;

import java.util.ArrayList;
import java.util.List;

import com.bowling.frames.StandardFrame;

public class Game {

    private int roll = 0;
    private int[] rolls = new int[21];

    List<StandardFrame> framesList = new ArrayList<>();

    public void roll(int pinsDown) {
	rolls[roll++] = pinsDown;
    }

    public int score() {
	int score = 0;
	int cursor = 0;
	framesList.clear();
	for (int frame = 0; frame < 9; frame++) {
	    StandardFrame frameObject = new StandardFrame();
	    if (isStrike(cursor)) {
		score += 10 + rolls[cursor + 1] + rolls[cursor + 2];
		fillTheFrame(cursor, frameObject, score);
		cursor++;
	    } else if (isSpare(cursor)) {
		score += 10 + rolls[cursor + 2];
		fillTheFrame(cursor, frameObject, score);
		cursor += 2;
	    } else {
		score += rolls[cursor] + rolls[cursor + 1];
		fillTheFrame(cursor, frameObject, score);
		cursor += 2;
	    }
	    framesList.add(frameObject);
	}
	return score;
    }

    private void fillTheFrame(int cursor, StandardFrame frameObject, int score) {
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

    /**
     * For testing purpose mainly
     * 
     * @param comma-separated ints (remember-max 12 dla strike only)
     */
    public void roll(int... rolls) {
	for (int pinsDown : rolls) {
	    roll(pinsDown);
	}
    }

    public List<StandardFrame> getFramesList() {
	return framesList;
    }

}
