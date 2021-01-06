package objects;

import common.interfaces.Movable;

/**
 * This class extends from GameObject class and implements Movable interface.
 * <p>
 * MovableObject is a subclass of GameObject.
 * All subclasses of this class have to implement act() method.
 * It is an abstract class and has a double field of speed.
 * MovableObject implemtns Movable interfaces and implements the concrete move() method.
 * All objects of its subclasses can move in the game scene.
 * Movable objects include: Animal, Crocodile, Log, Turtle, WetTurtle, Seal, Car, BigTrunk and Trunk.
 * 
 * @author ryan
 *
 */
public abstract class MovableObject extends GameObject implements Movable{
	
	/**
	 * The speed of movable objects in the game scene.
	 */
	private double speed;
	
	/**
	 * Moves the object in x-axis and y-axis.
	 * 
	 * @param dx displacement in x-axis
	 * @param dy displacement in y-axis
	 */
	@Override
	public void move(double dx, double dy) {
		setX(getX() + dx);
		setY(getY() + dy);
	}

	public double getSpeed() {
		return speed;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}
}
