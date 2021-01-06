package objects.physicalobject;

import javafx.scene.image.Image;
import objects.MovableObject;

/**
 * Car in the game scene.
 * <p>
 * When Animal hits on Car in game scene, it kills Animal.
 * 
 * @author ryan
 *
 */
public class Car extends MovableObject{

	/**
	 * Action type of Car class.
	 */
	private ActionType actionType;
	
	/**
	 * Creates a Car.
	 * <p>
	 * It sets the image of the car, sets its own action type 
	 * and sets the speed of the car.
	 * 
	 * @param xpos x coordinate of the car
	 * @param ypos y coordinate of the car
	 * @param w width of the car
	 * @param h height of the car
	 * @param speed speed of the car
	 */
	public Car(int xpos, int ypos, int w, int h, double speed) {
		setX(xpos);
		setY(ypos);
		setImage(new Image("file:src/main/resources/car1Left.png", w,h, true, true));
		actionType = new CarAction(this);
		setSpeed(speed);
	}

	/**
	 * The action that Car does in current frame.
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
