package objects.physicalobject;

import javafx.scene.image.Image;
import objects.MovableObject;

/**
 * Log in the game scene.
 * <p>
 * Animal could safely stands on Log.
 * 
 * @author ryan
 *
 */
public class Log extends MovableObject {

	/**
	 * Action type of Log class.
	 */
	private ActionType actionType;
	
	/**
	 * Creates a Log.
	 * <p>
	 * There are 3 types of logs according their lengths.
	 * 
	 * @param imageLink URL for the image
	 * @param w the width of the image
	 * @param h the height of the image
	 * @param xpos x-coordinate of the obstacle
	 * @param ypos y-coordinate of the obstacle
	 * @param speed speed of the obstacle
	 */
	public Log(String imageLink, int w, int h, int xpos, int ypos, double speed) {
		setX(xpos);
		setY(ypos);
		setImage(new Image(imageLink, w, h, true, true));
		actionType = new LogAction(this);
		setSpeed(speed);
	}
	
	/**
	 * The action that Log does in current frame.
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
