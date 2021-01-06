package objects.physicalobject;

import javafx.scene.image.Image;
import objects.GameObject;

/**
 * Destination in the game scene.
 * <p>
 * Before Animal gets to this, this is not activated and the image is empty.
 * When Animal gets to this, this is set to activated and the image is a frog.
 * It also used to check intersection with Animal.
 * 
 * @author ryan
 *
 */
public class End extends GameObject{
	
	/**
	 * Checks if the end is activated.
	 */
	private boolean activated = false;	
	
	/**
	 * Creates an End.
	 * 
	 * @param x x coordinate of the end point
	 * @param y y coordinate of the end point
	 */
	public End(int x, int y) {
		setX(x);	
		setY(y);
		setImage(new Image("file:src/main/resources/End.png", 65, 65, true, true));
	}
	
	/**
	 * Changes the image of the end point if player has reached it.
	 */
	public void setEnd() {
		setImage(new Image("file:src/main/resources/FrogEnd.png", 65, 65, true, true));
		setActivated(true);
	}
	
	public boolean isActivated() {
		return this.activated;
	}

	@Override
	public void act(long now) {
		
	}

	public void setActivated(boolean activated) {
		this.activated = activated;
	}
	

}
