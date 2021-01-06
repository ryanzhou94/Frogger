package objects.physicalobject;

import javafx.scene.image.Image;
import objects.MovableObject;

/**
 * Big trunk in the game scene.
 * <p>
 * When Animal hits on BigTrunk in game scene, it kills Animal.
 * 
 * @author ryan
 *
 */
public class BigTrunk extends MovableObject{
	
	/**
	 * Imgae for BigTrunk.
	 */
	private Image bigTrunkImage;
	
	/**
	 * Action type of BigTrunk class.
	 */
	private ActionType actionType;
	
	/**
	 * Creates a BigTrunk.
	 * <p>
	 * It sets the image of the big trunk, sets its own action type 
	 * and sets the speed of the big trunk.
	 * 
	 * @param xpos x coordinate of the big trunk
	 * @param ypos y coordinate of the big trunk
	 * @param w width of the big trunk
	 * @param h height of the big trunk
	 * @param speed speed of the big trunk
	 */
	public BigTrunk(int xpos, int ypos, int w, int h, double speed) {
		setX(xpos);
		setY(ypos);
		bigTrunkImage = new Image("file:src/main/resources/truck2Right.png", w,h, true, true);
		actionType = new BigTrunkAction(this);
		setImage(bigTrunkImage);
		setSpeed(speed);
	}

	/**
	 * The action that BigTrunk does in current frame.
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