package objects.physicalobject;

import javafx.scene.image.Image;
import objects.MovableObject;

/**
 * Wet turtle in the game scene.
 * <p>
 * Animal can safely stand on WetTurtle when it is not sunk.
 * Animal will die if WetTurtle is sunk.
 * 
 * @author ryan
 *
 */
public class WetTurtle extends MovableObject{
	
	/**
	 * Images for turtle
	 */
	private Image[] wetTurtleImages = new Image[3];
	
	private Image noneImage;
	
	
	/**
	 * State of WetTurtle.
	 * True if WetTurtle is not sunk, false if it is sunk.
	 */
	private boolean sunk = false;
	
	/**
	 * Action type WetTurtle class.
	 */
	private ActionType actionType;
	
	/**
	 * Creates a WetTurtle.
	 * <p>
	 * WetTurtle has four images for moving. Constructors loads different images for its movement.
	 * 
	 * @param xpos x coordinate of the wet turtle
	 * @param ypos y coordinate of the wet turtlee
	 * @param w width of the wet turtle
	 * @param h height of the wet turtle
	 * @param speed speed of the wet turtle
	 */
	public WetTurtle(int xpos, int ypos, int w, int h, double speed) {
		wetTurtleImages[0] = new Image("file:src/main/resources/TurtleAnimation1.png", w, h, true, true);
		wetTurtleImages[1] = new Image("file:src/main/resources/TurtleAnimation2Wet.png", w, h, true, true);
		wetTurtleImages[2] = new Image("file:src/main/resources/TurtleAnimation3Wet.png", w, h, true, true);
		setX(xpos);
		setY(ypos);
		setSpeed(speed);
		actionType = new WetTurtleAction(this);
		setImage(getWetTurtleImages()[0]);
	}

	/**
	 * The action that WetTurtle does in current frame.
	 * <p>
	 * It moves horizontally. It will sink for 1s in every 4s.
	 * 
	 * @param now the current time
	 */
	@Override
	public void act(long now) {
		actionType.act(now);
	}
	
	/**
	 * Checks if the wet turtle is sunk.
	 * 
	 * @return true if the wet turtle is sunk, false if the wet turtle is not sunk
	 */
	public boolean isSunk() {
		return sunk;
	}

	public void setSunk(boolean sunk) {
		this.sunk = sunk;
	}

	@SuppressWarnings("exports")
	public Image[] getWetTurtleImages() {
		return wetTurtleImages;
	}

	@SuppressWarnings("exports")
	public void setWetTurtleImages(Image[] wetTurtleImages) {
		this.wetTurtleImages = wetTurtleImages;
	}

	@SuppressWarnings("exports")
	public Image getNoneImage() {
		return noneImage;
	}

	@SuppressWarnings("exports")
	public void setNoneImage(Image noneImage) {
		this.noneImage = noneImage;
	}
}
