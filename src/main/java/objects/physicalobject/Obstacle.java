package objects.physicalobject;

import javafx.scene.image.Image;
import objects.MovableObject;

/**
 * Obstacle in the game scene.
 * <p>
 * When Animal hits on Obstacle in game scene, it kills Animal.
 * 
 * @author ryan
 *
 */
public class Obstacle extends MovableObject {
	
	/**
	 * Action type of Obstacle class.
	 */
	private ActionType actionType;
	
	/**
	 * Creates a Obstacle.
	 * 
	 * @param imageLink URL for the image
	 * @param xpos	x-coordinate of the obstacle
	 * @param ypos  y-coordinate of the obstacle
	 * @param speed speed of the obstacle
	 * @param w width of the image
	 * @param h height of the image
	 */
	public Obstacle(String imageLink, int xpos, int ypos, double speed, int w, int h) {
		setX(xpos);
		setY(ypos);
		setImage(new Image(imageLink, w,h, true, true));
		actionType = new ObstacleAction(this);
		setSpeed(speed);
	}
	
	/**
	 * The action that Obstacle does in current frame.
	 * <p>
	 * It moves horizontally.
	 * 
	 * @param now the current time
	 */
	@Override
	public void act(long now) {
		actionType.act(now);
	}
}
