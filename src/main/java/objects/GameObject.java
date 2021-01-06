package objects;

import common.interfaces.Actable;
import javafx.scene.image.ImageView;

/**
 * All game objects extends this abstract class.
 * <p>
 * GameObject is the subclass of ImageView, it has an image of the object in the game scene.
 * It is an abstract class and has no concrete method or field. 
 * It implements Actable interface which allows game objects to act and response to event in every frame.
 * All its subclasses have to implements act().
 * Game objects include: Animal, Crocodile, Turtle, WetTurtle, Log, End, Digit, Car, Trunk, BigTrunk, Bonus, Snake and Seal.
 * 
 * @author ryan
 *
 */
public abstract class GameObject extends ImageView implements Actable{
	
}
