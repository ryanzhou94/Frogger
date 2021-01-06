package objects.physicalobject;

import javafx.scene.image.Image;
import objects.MovableObject;

/**
 * Crocodile in the game scene.
 * <p>
 * When Animal hits on BigTrunk in game scene, if it doesn't open its mouth, 
 * Animal could stand on it safely. If it opens its mouth, Animal would die if 
 * standing on it.
 * 
 * @author ryan
 *
 */
public class Crocodile extends MovableObject{
	
	/**
	 * The images of Crocodile.
	 */
	private Image[] crocodileImages = new Image[2];
	
	/**
	 * State of the mouth.
	 * <p>
	 * It's true when the mouth if open and false when the mouth is closed.
	 */
	private boolean open = false;
	
	/**
	 * Action type of Bonus class.
	 */
	private ActionType actionType;
	
	/**
	 * Creates a Crocodile.
	 * <p>
	 * It sets the image of the crocodile, sets its own action type 
	 * and sets the speed of the crocodile.
	 * 
	 * @param xpos x coordinate of the crocodile
	 * @param ypos y coordinate of the crocodile
	 * @param w width of the crocodile
	 * @param h height of the crocodile
	 * @param speed speed of the crocodile
	 */
	public Crocodile(int xpos, int ypos, int w, int h, double speed) {
		getCrocodileImages()[0] = new Image("file:src/main/resources/crocodile1.png", w, h, true, true);
		getCrocodileImages()[1] = new Image("file:src/main/resources/crocodile2.png", w, h, true, true);
		setX(xpos);
		setY(ypos);
		setSpeed(speed);
		actionType = new CrocodileAction(this);
		setImage(getCrocodileImages()[0]);
	}
	
	/**
	 * The action that Crocodile does in current frame.
	 * <p>
	 * It swims in the river horizontally. It opens its mouth for 1s in every 6s.
	 * 
	 * @param now the current time
	 */
	@Override
	public void act(long now) {
		actionType.act(now);
	}
	
	public boolean isOpen() {
		return open;
	}

	public void setOpen(boolean open) {
		this.open = open;
	}

	@SuppressWarnings("exports")
	public Image[] getCrocodileImages() {
		return crocodileImages;
	}

	@SuppressWarnings("exports")
	public void setCrocodileImages(Image[] crocodileImages) {
		this.crocodileImages = crocodileImages;
	}

}
