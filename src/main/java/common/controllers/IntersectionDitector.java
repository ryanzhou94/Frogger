package common.controllers;

import objects.GameObject;
import scene.view.World;

public class IntersectionDitector {
	
	/**
	 * Gets reference to the world that the animal is currently in.
	 * <p>
	 * Animal extends from ImageView which has a method to get the parent container.
	 * In Frogger, the container of animal is always World objects.
	 * Needs to cast the type of parent container into World.
	 * 
	 * @param gameObject the object that is currently in a world
	 * @return the world that the animal is currently in
	 */
	public static World getWorld(GameObject gameObject) {
		return (World)gameObject.getParent();
	}
	
	/**
	 * Checks if the object is intersecting with any other objects in specific class in the current world.
	 * <p>
	 * Uses the Node.intersects(Bounds args0) to checks if two nodes are intersecting.
	 * 
	 * @param <A> the class name
	 * @param gameObject the object that is currently in a world
	 * @param cls class of objects that needs to be checked in the current world
	 * @return true if animal is intersecting with any cls objects in the current world, false if not intersecting.
	 */
	public static <A extends GameObject> boolean checkIntersection(GameObject gameObject, Class<A> cls) {
		for (A object: ObjectsGetter.getObjects(getWorld(gameObject), cls)) {
            if (object.intersects(gameObject.getBoundsInLocal())) {
            	return true;
            }
        }
		return false;
	}
	
	/**
	 * Checks if the object is intersecting with any other objects in specific class in the current world, if yes then gets the object, if no then gets null.
	 * 
	 * @param <A> the class name
	 * @param gameObject the object that is currently in a world
	 * @param cls cls class of objects that needs to be checked in the current world
	 * @return the object in cls class which is currently intersecting with Animal object, null if no object in cls is intersecting with Animal object
	 */
	public static <A extends GameObject> A getIntersectingObject(GameObject gameObject, Class<A> cls) {
		A intersectingObject = null;
        for (A object: ObjectsGetter.getObjects(getWorld(gameObject), cls)) {
            if (object.intersects(gameObject.getBoundsInLocal())) {
            	intersectingObject = object;
                break;
            }
        }
        return intersectingObject;
	}

}
