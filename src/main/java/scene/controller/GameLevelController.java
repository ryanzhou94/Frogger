package scene.controller;

import objects.animal.Animal;

/**
 * It updates the board and animal when player gets to the next level.
 * <p>
 * It is one controller of GameSceneController.
 * 
 * @author ryan
 *
 */
public class GameLevelController {
	
	/**
	 * The controlled BoardController.
	 */
	private BoardController boardController;
	
	/**
	 * Creates a GameLevelController.
	 * 
	 * @param boardController BoardController
	 */
	public GameLevelController(BoardController boardController) {
		this.boardController = boardController;
	}
	
	/**
	 * Calls nextLevel() both in BoardController and Animal to updates scores in Board and Animal.
	 * The score of Animal is added with 1000pts.
	 */
	public void nextLevel() {
		boardController.nextLevel();
		Animal.getInstace().nextLevel();
	}
	
}
