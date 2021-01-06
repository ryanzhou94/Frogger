package objects.physicalobject;

import javafx.scene.image.Image;
import objects.MovableObject;

/**
 * Seal in the game scene.
 * <p>
 * Animal can safely stand on Seal when it is not sunk.
 * Animal will die if Seal is sunk.
 * 
 * @author ryan
 *
 */
public class Seal extends MovableObject{

	/**
	 * Image for Seal.
	 */
	private Image sealImage;
	
	/**
	 * Sunk image for Seal.
	 */
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
	 * Creates a Seal.
	 * <p>
	 * Seal has one images for moving. Constructors loads different images for its movement.
	 * 
	 * @param xpos x coordinate of the seal
	 * @param ypos y coordinate of the seal
	 * @param w width of the seal
	 * @param h height of the seal
	 * @param speed speed of the seal
	 */
	public Seal(int xpos, int ypos, int w, int h, double speed) {
		setSealImage(new Image("file:src/main/resources/seal.png", w, h, true, true));
		setX(xpos);
		setY(ypos);
		setSpeed(speed);
		actionType = new SealAction(this);
		setImage(getSealImage());
		
	}
	
	/**
	 * The action that Seal does in current frame.
	 * <p>
	 * It moves horizontally. It will sink for 1s in every 4s.
	 * 
	 * @param now the current time
	 */
	@Override
	public void act(long now) {
		actionType.act(now);
	}
	
//	/**
//	 * Set the images for Seal on current time
//	 * <p>
//	 * It changes in every 4s.
//	 * 
//	 * @param now the current time
//	 */
//	public void setSealImage(long now) {
//		if (now/900000000  % 4 == 0) {
//			setImage(getNoneImage());
//			setSunk(true);
//		} else {
//			setImage(sealImage);
//			setSunk(false);
//		}
//	}
	
	/**
	 * Checks if the Seal is sunk.
	 * 
	 * @return true if the Seal is sunk, false if it is not sunk
	 */
	public boolean isSunk() {
		return sunk;
	}

	public void setSunk(boolean sunk) {
		this.sunk = sunk;
	}

	@SuppressWarnings("exports")
	public Image getSealImage() {
		return sealImage;
	}

	@SuppressWarnings("exports")
	public void setSealImage(Image sealImage) {
		this.sealImage = sealImage;
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
