package common.interfaces;


/**
 * Applies observer design pattern. It provides method to update score and left lives in Board.
 * 
 * @author ryan
 *
 */
public interface AnimalObserver {
	
	/**
	 * Updates the score and lives on the board (model and view)
	 * 
	 * @param score the new score
	 * @param lives the new number of lives
	 */
	public void update(int score, int lives);
	
}
