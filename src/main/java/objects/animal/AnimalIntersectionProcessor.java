package objects.animal;

import java.util.ArrayList;

import common.controllers.IntersectionDitector;
import common.controllers.ObjectsGetter;
import objects.physicalobject.BigTrunk;
import objects.physicalobject.Bonus;
import objects.physicalobject.Car;
import objects.physicalobject.Crocodile;
import objects.physicalobject.End;
import objects.physicalobject.Log;
import objects.physicalobject.Seal;
import objects.physicalobject.Snake;
import objects.physicalobject.Trunk;
import objects.physicalobject.Turtle;
import objects.physicalobject.WetTurtle;
import scene.view.World;
/**
 * The processor of animal intersection, provides a method to handle intersection with every kind of object in the game.
 * <p>
 * It has the reference to Animal object so that it has the control of the whole Animal object.
 * It has a AnimalIntersectionDitector which is used to ditects intersection in the world.
 * It is one component of Animal.
 * 
 * @author ryan
 *
 */
public class AnimalIntersectionProcessor {
	
	/**
	 * Reference to Animal object.
	 * With this reference, AnimalIntersectionProcessor gets the control of the whole Animal object.
	 */
	private Animal animal;
	
	/**
	 * Creates an AnimalIntersectionProcessor.
	 * 
	 * @param animal the reference to Animal object
	 */
	public AnimalIntersectionProcessor(Animal animal) {
		this.animal = animal;
	}
	
	/**
	 * Handles all situations about intersection between animal and all kinds of game objects in the current world.
	 * <p>
	 * It only changes the status, location and pts(for Bonus and End) of animal. 
	 * Other animal controllers handles the updates of animal information. 
	 * <p>
	 * If instecting with the following objects:
	 * <ul>
	 * <li>Bonus: Player gets 500 extra pts if the bonus if active, and set the bonus to unavaliable so that the animal can't get bonus twice.
	 * <li>Snake: Animal dies, the status of animal is set to 2(water death).
	 * <li>Car: Animal dies, the status of animal is set to 1(car death).
	 * <li>Trunk: Animal dies, the status of animal is set to 1(car death).
	 * <li>BigTrunk: Animal dies, the status of animal is set to 1(car death).
	 * <li>Log: Animal get moves with the log at the same speed and the same direction.
	 * <li>Turtle: Animal get moves with the turtle at the same speed and the same direction.
	 * <li>WetTurtle: Animal get moves with the wet turtle at the same speed and the same direction if the turtle is not sunk, otherwise it dies, the status is set to 2(water death).
	 * <li>Crocodile: Animal get moves with the crocodile at the same speed and the same direction if the crocodile doesn't open mouth, otherwise it dies, the status is set to 2(water death).
	 * <li>End: Adds 50pts to animal, resets the highest position of animal, sets the end image for the end place, resets the animal and updates information of animal. If animal already got this end place, deletes the pts added to the animal. 
	 * <li>else(in water): Animal dies, the status of animal is set to 2(water death).
	 * </ul>
	 */
	public void processIntersection() {
		
		if (IntersectionDitector.checkIntersection(animal, Bonus.class)) {
			Bonus bonus = IntersectionDitector.getIntersectingObject(animal, Bonus.class);
			if (bonus.isAvaliable() && bonus.isActive()) {
				bonus.eaten();
				animal.updateScore(500);
			}
		}
		else if (IntersectionDitector.checkIntersection(animal, Snake.class)) {
			this.animal.getAnimalModel().setStatus(2);
		}
		else if (IntersectionDitector.checkIntersection(animal, Car.class)) {
			this.animal.getAnimalModel().setStatus(1);
		} 
		else if (IntersectionDitector.checkIntersection(animal, Trunk.class)) {
			this.animal.getAnimalModel().setStatus(1);
		} 
		else if (IntersectionDitector.checkIntersection(animal, BigTrunk.class)) {
			this.animal.getAnimalModel().setStatus(1);
		} 
		else if (IntersectionDitector.checkIntersection(animal, Seal.class)) {
			if (IntersectionDitector.getIntersectingObject(animal, Seal.class).isSunk()) {
				this.animal.getAnimalModel().setStatus(2);
			}
			this.animal.move(IntersectionDitector.getIntersectingObject(animal, Seal.class).getSpeed(),0);
		}
		else if (IntersectionDitector.checkIntersection(animal, Crocodile.class)) {
			if (IntersectionDitector.getIntersectingObject(animal, Crocodile.class).isOpen()) {
				this.animal.getAnimalModel().setStatus(2);
			}
			this.animal.move(IntersectionDitector.getIntersectingObject(animal, Crocodile.class).getSpeed(),0);
		}
		else if (IntersectionDitector.checkIntersection(animal, WetTurtle.class)) {
			if (IntersectionDitector.getIntersectingObject(animal, WetTurtle.class).isSunk()) {
				this.animal.getAnimalModel().setStatus(2);
			} else {
				this.animal.move(IntersectionDitector.getIntersectingObject(animal, WetTurtle.class).getSpeed(),0);
			}
		} 
		else if (IntersectionDitector.checkIntersection(animal, Log.class) && this.animal.getAnimalModel().isNoMove() == false) {
			this.animal.move(IntersectionDitector.getIntersectingObject(animal, Log.class).getSpeed(),0);
		} 
		else if (IntersectionDitector.checkIntersection(animal, Turtle.class) && this.animal.getAnimalModel().isNoMove() == false) {
			this.animal.move(IntersectionDitector.getIntersectingObject(animal, Turtle.class).getSpeed(),0);
		} 
		else if (IntersectionDitector.checkIntersection(animal, End.class)) {
			End intersectingEnd = IntersectionDitector.getIntersectingObject(animal, End.class);
			if (IntersectionDitector.checkIntersection(intersectingEnd, Bonus.class)) {
				Bonus bonus = IntersectionDitector.getIntersectingObject(intersectingEnd, Bonus.class);
				if (bonus.isAvaliable() && bonus.isActive()) {
					bonus.eaten();
					animal.updateScore(500);
				}
			}
			if (intersectingEnd.isActivated()) {
				this.animal.getAnimalModel().reachWrongEnd();
				this.animal.updateScore(-50);
			}
			this.animal.updateScore(50);
			this.animal.getAnimalModel().setHighestPosition(800);
			intersectingEnd.setEnd();
			this.animal.resetAnimal();
			this.animal.getAnimalModel().reachEnd();
		}
		else if (this.animal.getY()<413) {
			this.animal.getAnimalModel().setStatus(2);
		}
		checkEndBonus();
	}
	
	/**
	 * Sets Bonus unavaliable if the End is activated.
	 * <p>
	 * Firstly gets the current World, checks if Bonus is intersecting with any End in the World (if Animal gets Bonus, the Bonus will disappear and cannot intersect with End)
	 * If they are intersecting, checks if the intersected End is activated, if yes, then automatically sets the Bonus unavaliable and inactive.
	 */
	public void checkEndBonus() {
		World world = IntersectionDitector.getWorld(animal);
		Bonus bonus = ((ArrayList<Bonus>) ObjectsGetter.getObjects(world, Bonus.class)).get(0);
		if (IntersectionDitector.checkIntersection(bonus, End.class)) {
			End intersectedEnd = IntersectionDitector.getIntersectingObject(bonus, End.class);
			if (intersectedEnd.isActivated()) {
				bonus.setAvaliable(false);
				bonus.setActive(false);
			}
		}
	}
	
}
