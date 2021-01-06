package objects.animal;

import javafx.scene.image.Image;

/**
 * Animal's death controller handles the status changes and view changes after the Animal is dead.
 * <p>
 * It accesses to AnimalModel by using the reference to Animal and checks if the Animal is dead.
 * It has {@link checkStatus(long now)} to check the status of the Animal. 
 * This class also handles the view (images) of Animal when it dies.
 * 
 * @author ryan
 *
 */
public class AnimalDeathController {
	
	/**
	 * Reference to Animal object.
	 * <p>
	 * With this reference, AnimalDeathController gets the control of the whole Animal object.
	 */
	private Animal animal;
	
	/**
	 * Time counter.
	 */
	private int carD = 0;
	
	/**
	 * Saves the reference to Animal instance.
	 * @param animal Animal that will be handled death
	 */
	public AnimalDeathController(Animal animal) {
		this.animal = animal;
	}
	
	/**
	 * It runs in every frame to check if Animal is dead, if dead, sets coresponding view.
	 * <p>
	 * If the status of Animal equals to 1(car death), sets car death images for Animal and reset the position of Animal.
	 * If the status of Animal equals to 2(water death), sets water death images for Animal and reset the position of Animal.
	 * Else, it does nothing.
	 * 
	 * @param now the current time
	 */
	public void checkStatus(long now) {
		if (this.animal.getAnimalModel().getStatus() == 1) {
			setCarDeath(now);
		}
		if (this.animal.getAnimalModel().getStatus() == 2) {
			setWaterDeath(now);
		}
	}
	
	/**
	 * Handles the car death: set car death images for Animal.
	 * <p>
	 * There are 3 images for car death of Animal.
	 * It changes the images in every 1s.
	 * 
	 * @param now the current time
	 */
	private void setCarDeath(long now) {
		if ((now)% 11 == 0) {
			carD++;
		}
		if (carD > 0 && carD <4) {
			this.animal.setImage(getImage(this.animal.getAnimalImagesController(), carD));
		} else if (carD == 4) {
			this.animal.resetAnimal();
			die();
			this.carD = 0;
		}
	}
	
	/**
	 * Handles the water death: set water death images for Animal.
	 * <p>
	 * There are 4 images for water death of Animal.
	 * It changes the images in every 1s.
	 * 
	 * @param now the current time
	 */
	private void setWaterDeath(long now) {
		if ((now)% 11 ==0) {
			carD++;
		}
		if (carD > 0 && carD < 5) {
			this.animal.setImage(getImage(this.animal.getAnimalImagesController(), carD));
		} else if (carD == 5) {
			this.animal.resetAnimal();
			die();
			this.carD = 0;
		}
	}
	
	/**
	 * When Animal dies, it checks if the score of Animal is greater than 50pts, if it is than decrease 50pts.
	 * <p>
	 * Updates information in AnimalModel: decrease the lives of Animal and checks if the game is over.
	 * It notifies all Animal listeners (BoardController) to update information in BoardModel and BoardView.
	 */
	private void die() {
		if (this.animal.getAnimalModel().getScore() > 50) {
			this.animal.updateScore(-50);
		}
		this.animal.getAnimalModel().die();
		this.animal.notifyAnimalObserver();
	}
	
	private Image getImage(AnimalView animalImagesController, int number) {
		return animalImagesController.getWaterDeatImages()[number - 1];
	}
	
}
