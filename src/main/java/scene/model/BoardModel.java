package scene.model;

import common.controllers.ScoreFileProcesser;

/**
 * The model(M in MVC pattern) of the board. 
 * <p>
 * It saves the score of the player, the lives of the player, the 
 * level of the game and the highest score.
 * 
 * @author Ryan
 *
 */
public class BoardModel{
	
	/**
	 * The score of the player.
	 */
	private int score;		
	
	/**
	 * The lives left of the player.
	 */
	private int lives;		
	
	/**
	 * The level of the current game.
	 * <ul>
	 * <li>1 : Easy
	 * <li>2 : Medium
	 * <li>3 : Hard
	 * <li>4 : Hell
	 * </ul>
	 */
	private int level;	
	
	/**
	 * The highest score of the whole game.
	 */
	private int highestScore;	
	
	/**
	 * Constructs the board model with Animal's score and lives.
	 * <p>
	 * The level is initialized by the parameter level. The highest 
	 * score is got from local score file. If the score is null, 
	 * initializes with 0, else with the first score (the highest score)
	 * in the score file.
	 * 
	 * @param score the score of Animal
	 * @param lives the lives of Animal
	 * @param level the level of the game
	 */
	public BoardModel(int score, int lives, int level) {
		this.score = score;	
		this.lives = lives;	
		this.level = level;
		if (ScoreFileProcesser.getScoreList().size() > 0) {
			this.highestScore = ScoreFileProcesser.getScoreList().get(0);
		} else {
			this.highestScore = 0;
		}
	}
	
	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
	
	public int getLives() {
		return lives;
	}

	public void setLives(int lives) {
		this.lives = lives;
	}

	public int getLevel() {
		return level;
	}
	
	public void setLevel(int level) {
		this.level = level;
	}

	public int getHighestScore() {
		return highestScore;
	}

	public void setHighestScore(int highestScore) {
		this.highestScore = highestScore;
	}
	
}
