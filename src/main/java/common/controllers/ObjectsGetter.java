package common.controllers;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.Node;
import objects.GameObject;
import scene.view.World;

/**
 * This class provides static method(s) to get all objects in one class in a given world.
 * 
 * @author ryan
 *
 */
public class ObjectsGetter {

	/**
	 * Gets all objects in the same given class in a given world.
	 * 
	 * @param <A> the class
	 * @param world the given world
	 * @param cls the class name
	 * @return all objects in the same given class in a given world
	 */
	@SuppressWarnings("unchecked")
	public static <A extends GameObject> List<A> getObjects(World world, Class<A> cls) {
        ArrayList<A> someArray = new ArrayList<A>();
        for (Node n: world.getChildren()) {
            if (cls.isInstance(n)) {
                someArray.add((A)n);
            }
        }
        return someArray;
    }
	
}
