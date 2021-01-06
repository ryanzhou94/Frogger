package objects.animal;

/**
 * This class provides several methods the checks if the position of Animal is valid and correct its position.
 * <p>
 * It needs the reference to Animal so that the position setter could get and set Animal: getting cordinates and setting movement.
 * 
 * @author ryan
 *
 */
public class AnimalPositionSetter {
	
	/**
	 * Reference to Animal object.
	 * <p>
	 * With this reference, AnimalPositionSetter gets the control of the whole Animal object.
	 */
	private Animal animal;
	
	/**
	 * Creates an AnimalPositionSetter and saves the reference to the animal.
	 * @param animal the reference to Animal object
	 */
	public AnimalPositionSetter(Animal animal) {
		this.animal = animal;
	}
	
	/**
	 * Prevent the animal from getting out of the game scene border.
	 * <ul>
	 * <li>If the animal gets the lower boundary, move upper with 10 pixels.
	 * <li>If the animal gets the right boundary, move left with 10 pixels.
	 * <li>If the animal gets the left boundary, move right with 10 pixels.
	 * </ul>
	 */
	public void correctPosition() {
		if (this.animal.getY()>765) {
			this.animal.move(0, -10);
		}
		if (this.animal.getX()<=0) {
			this.animal.move(10, 0);
		}
		if (this.animal.getX()>=570) {
			this.animal.move(-10, 0);
		}
	}
	
	/**
	 * Reset the location of the animal to (300, 702) and make the animal movable.
	 */
	public void resetLocation() {
		this.animal.setX(300);
		this.animal.setY(702);
		this.animal.getAnimalModel().setNoMove(false);;
	}
}
