package objects.physicalobject;

import javafx.scene.image.Image;
import objects.MovableObject;

/**
 * Turtle in the game scene.
 * <p>
 * Animal could safely stands on Turtle.
 * 
 * @author ryan
 *
 */
public class Turtle extends MovableObject{
	/*
	 * Images for Turtle
	 */
	private Image[] turtleImages = new Image[3];
	
	/**
	 * Action type of Turtle class.
	 */
	private ActionType actionType;
	
	/**
	 * Creates a Turtle.
	 * <p>
	 * Turtle has three images for moving. Constructors loads three different images for its movement.
	 * 
	 * @param xpos x coordinate of the turtle
	 * @param ypos y coordinate of the turtlee
	 * @param w width of the turtle
	 * @param h height of the turtle
	 * @param speed speed of the turtle
	 */
	public Turtle(int xpos, int ypos, int w, int h, double speed) {
		getTurtleImages()[0] = new Image("file:src/main/resources/TurtleAnimation1.png", w, h, true, true);
		getTurtleImages()[1] = new Image("file:src/main/resources/TurtleAnimation2.png", w, h, true, true);
		getTurtleImages()[2] = new Image("file:src/main/resources/TurtleAnimation3.png", w, h, true, true);
		setX(xpos);
		setY(ypos);
		setSpeed(speed);
		actionType = new TurtleAction(this);
		setImage(getTurtleImages()[0]);
	}
	
	/**
	 * The action that Turtle does in current frame.
	 * <p>
	 * It moves horizontally.
	 * 
	 * @param now the current time
	 */
	@Override
	public void act(long now) {
		actionType.act(now);
	}
	
	@SuppressWarnings("exports")
	public Image[] getTurtleImages() {
		return turtleImages;
	}

	@SuppressWarnings("exports")
	public void setTurtleImages(Image[] turtleImages) {
		this.turtleImages = turtleImages;
	}
}
