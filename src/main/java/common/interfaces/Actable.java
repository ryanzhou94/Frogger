package common.interfaces;

/**
 * The common interface for actable game objects in the game. 
 * All classes which implement this interface have the action in every frame.
 * 
 * @author ryan
 *
 */
public interface Actable {
	
	/**
	 * It defines the action of a game object.
	 * It is called in every frame of the game when the timer starts.
	 * 
	 * @param now the current time
	 */
	public void act(long now);
	
}
