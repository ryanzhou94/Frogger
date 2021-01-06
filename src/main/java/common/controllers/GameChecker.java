package common.controllers;

import objects.animal.AnimalModel;
import scene.model.BoardModel;

/**
 * Provides necessary static methods to check if the game is over or should go to the next level.
 * 
 * @author ryan
 *
 */
public class GameChecker {
	
	/**
	 * Checks if the player pass the game with necessary conditions.
	 * 
	 * @param animalModel the model of the Animal
	 * @return true if the player has reached five different destinations or no life left, otherwise false
	 */
	public static boolean gameOver(AnimalModel animalModel) {
		return animalModel.getStatus() == 3;
	}
	
	/**
	 * Checks if the player is qualified to enter the next level.
	 * 
	 * @param animalModel the model of the Animal
	 * @param boardModel the model of the Board
	 * @return true if the player has at least 1 live and got 5 ends, false if the player doesn't have at least 1 live or dpesn't get 5 ends or the current level is 4 and no level left.
	 */
	public static boolean nextLevel(AnimalModel animalModel, BoardModel boardModel) {
		if (boardModel.getLevel() >= 4) {
			return false;
		} else {
			return animalModel.getEnds() == 5 && animalModel.getLives() > 0;
		}
	}
	
}
