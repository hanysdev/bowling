package com.bowling.view;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import com.bowling.game.Game;

@Named
@ViewScoped
public class GameView implements Serializable {

    private static final long serialVersionUID = 4086913265235153599L;

    private int totalScore;
    private int possibleRoll;
    Game game;
    int counter;

    @PostConstruct
    private void init() {
	game = new Game();
	totalScore = 0;
	possibleRoll = 10;
    }

    public void doTheRoll(int pinsFallen) {
	countPossibleRoll(pinsFallen);

    }

    public int score() {
	int score = game.score();
	return score;
    }

    private void countPossibleRoll(int pinsFallen) {
	game.roll(pinsFallen);
	if (pinsFallen == 10) {
	    possibleRoll = 10;
	    counter = 0;
	} else if (pinsFallen < 10 && counter == 0) {
	    possibleRoll = 10 - pinsFallen;
	    counter++;
	} else {
	    possibleRoll = 10;
	    counter = 0;
	}
    }

    public int getTotalScore() {
	totalScore = score();
	return totalScore;
    }

    public int getPossibleRoll() {
	return this.possibleRoll;
    }

    public Game getGame() {
	return game;
    }

}
