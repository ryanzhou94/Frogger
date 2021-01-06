package objects.physicalobject;

import javafx.scene.image.Image;
import objects.MovableObject;

/**
 * Trunk in the game scene.
 * <p>
 * When Animal hits on Trunk in game scene, it kills Animal.
 * 
 * @author ryan
 *
 */
public class Trunk extends MovableObject{
	
	/**
	 * Action type of Trunk class.
	 */
	private ActionType actionType;
	
	/**
	 * Creates a Trunk.
	 * 
	 * @param xpos x coordinate of the trunk
	 * @param ypos y coordinate of the trunk
	 * @param w width of the trunk
	 * @param h height of the trunk
	 * @param speed speed of the trunk
	 */
	public Trunk(int xpos, int ypos, int w, int h, double speed) {
		setX(xpos);
		setY(ypos);
		setImage(new Image("file:src/main/resources/truck1Right.png", w,h, true, true));
		actionType = new TrunkAction(this);
		setSpeed(speed);
	}
	
	/**
	 * The action that Trunk does in current frame.
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
