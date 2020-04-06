package com.bowling.view;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import com.bowling.gameUtils.Game;

@Named
@ViewScoped
public class GameView implements Serializable {

    private static final long serialVersionUID = 4086913265235153599L;

    private int totalScore;
    private int possibleRoll;
    Game game;

    @PostConstruct
    private void init() {
	game = new Game();
	totalScore = 0;
	possibleRoll=10;
    }

    public void doTheRoll(int pinsFallen) {
	game.roll(pinsFallen);
    }

    public int score() {
	int score = game.score();
	return score;
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
