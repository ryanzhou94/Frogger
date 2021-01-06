package objects.physicalobject;

import javafx.scene.image.Image;
import objects.GameObject;

/**
 * Bonus in the game scene.
 * <p>
 * When Animal gets Bonus in the game, Animal gets 1000pts.
 * 
 * @author ryan
 *
 */
public class Bonus extends GameObject{
	
	/**
	 * The first image of Bonus.
	 */
	private Image bonusImages;
	
	/**
	 * The second image of Bonus.
	 */
	private Image noImage;
	
	/**
	 * Action type of Bonus class.
	 */
	private ActionType actionType;
	
	/**
	 * State of Bonus.
	 * <p>
	 * If it is true, it is visible to the player.
	 * Else the player can't get the bonus even when the player gets the bonus.
	 */
	private boolean active = true;
	
	/**
	 * State of Bonus.
	 * <p>
	 * If it is true, Animal can eat it. When Animal have eaten it, it 
	 * becomes false and Animal can't eat it or see it.
	 */
	private boolean avaliable = true;
	
	/**
	 * Creates a Bonus.
	 * <p>
	 * It sets the image of Bonus and action type.
	 * 
	 * @param x x coordinate of Bonus
	 * @param y y coordinate of Bonus
	 * @param dim the diameter of the image
	 */
	public Bonus(double x, double y, int dim) {
		bonusImages = new Image("file:src/main/resources/bonus.png", dim, dim, true, true);
		actionType = new BonusAction(this);
		setImage(bonusImages);
		setX(x);
		setY(y);
	}
	
	/**
	 * The action that Bonus does in current frame.
	 * <p>
	 * It appears in one of the destination for a period of time and 
	 * deisappears for a period of time.
	 * 
	 * @param now the current time
	 */
	@Override
	public void act(long now) {
		actionType.act(now);
	}
	
	/**
	 * Sets status to be eaten.
	 */
	public void eaten() {
		setAvaliable(false);
		setActive(false);
	}

	
	public boolean isActive() {
		return active;
	}
	
	public void setActive(boolean active) {
		this.active = active;
	}

	public boolean isAvaliable() {
		return avaliable;
	}

	public void setAvaliable(boolean avaliable) {
		this.avaliable = avaliable;
	}
	
	@SuppressWarnings("exports")
	public Image getBonusImages() {
		return bonusImages;
	}
	
	@SuppressWarnings("exports")
	public Image getNoImage() {
		return noImage;
	}

}
