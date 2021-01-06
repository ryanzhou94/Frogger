package common.controllers;

import javafx.scene.Node;
import objects.MovableObject;
import scene.view.World;

/**
 * This class provides static methods to get and set the speed of one class of objects in a world.
 * 
 * @author ryan
 *
 */
public class SpeedController {
	
	/**
	 * Gets the speed of one class of objects in the given world.
	 * 
	 * @param <A> the class
	 * @param world the given world
	 * @param cls the class name
	 * @return the current speed of one class of objects
	 */
	@SuppressWarnings("unchecked")
	public static <A extends MovableObject> double getObjectSpeed(World world, Class<A> cls) {
		double speed = 0;
		for (Node n: world.getChildren()) {
            if (cls.isInstance(n)) {
                speed = ((A)n).getSpeed();
                break;
            }
        }
		return speed;
	}
	
	/**
	 * Sets the speed of one class of objects in the given world.
	 * 
	 * @param <A> the class 
	 * @param world the given world
	 * @param cls the class name
	 * @param speed the setting speed of one class of objects
	 */
	@SuppressWarnings("unchecked")
	public static <A extends MovableObject> void setObjectSpeed(World world, Class<A> cls, double speed) {
		for (Node n: world.getChildren()) {
            if (cls.isInstance(n)) {
                ((A)n).setSpeed(speed);
            }
        }
	}
	
	/**
	 * Sets the speed of one class of objects with a ratio.
	 * 
	 * @param <A> the class
	 * @param world the given world
	 * @param cls the class name
	 * @param ratio the ratio of current speed
	 */
	@SuppressWarnings("unchecked")
	public static <A extends MovableObject> void setObjectSpeedInRatio(World world, Class<A> cls, double ratio) {
		for (Node n: world.getChildren()) {
            if (cls.isInstance(n)) {
                ((A)n).setSpeed(((A)n).getSpeed() * ratio);
            }
        }
	}
}
