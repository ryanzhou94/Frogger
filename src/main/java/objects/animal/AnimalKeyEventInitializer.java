package objects.animal;

import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

/**
 * This class provides methods to set the handle methods to handle key event.
 * <p>
 * Player needs to press 'W', 'S', 'A' and 'D' to control the animal to move.
 * This class attaches the animal movement to player's key event.
 * 
 * @author ryan
 *
 */
public class AnimalKeyEventInitializer {
	
	/**
	 * The reference to the animal object.
	 */
	private Animal animal;
	
	/**
	 * The state of animal, true for still, false for jumping.
	 */
	private boolean isSecond = false;
	
	/**
	 * The movement for every step in x-axis.
	 */
	private double movmentInX = 10.666666*2;
	
	/**
	 * The movement for every step in y-axis.
	 */
	private double movmentInY = 13.3333333*2;
	
	/**
	 * Initialize key event handles for pressing and release.
	 * 
	 * @param animal the animal that needs initialization of key events
	 */
	public AnimalKeyEventInitializer(Animal animal) {
		this.animal = animal;
		setKeyOn();
		setKeyOff();
	}
	
	/**
	 * Initialize handler for pressed keys.
	 * <p>
	 * When a key('W', 'A', 'S', 'D') is pressed, the animal jumps twice with two diffrent images.
	 * <ul>
	 * <li>W: up
	 * <li>A: left
	 * <li>S: down
	 * <li>D: right
	 * </ul>
	 */
	private void setKeyOn() {
		this.animal.setOnKeyPressed(new EventHandler<KeyEvent>() {
			public void handle(KeyEvent event){
				if (animal.getAnimalModel().isNoMove()) {
					
				} else {
					if (isSecond) {
						if (event.getCode() == KeyCode.W) {	  
							animal.move(0, -movmentInY);
							animal.setImage(animal.getAnimalImagesController().getAliveImages()[0]);
						}
						else if (event.getCode() == KeyCode.A) {	            	
							animal.move(-movmentInX, 0);
							animal.setImage(animal.getAnimalImagesController().getAliveImages()[1]);
						}
						else if (event.getCode() == KeyCode.S) {	            	
							animal.move(0, movmentInY);
							animal.setImage(animal.getAnimalImagesController().getAliveImages()[2]);
						}
						else if (event.getCode() == KeyCode.D) {	            	
							animal.move(movmentInX, 0);
							animal.setImage(animal.getAnimalImagesController().getAliveImages()[3]);
						}
						isSecond = false;
					} 
					else {
						if (event.getCode() == KeyCode.W) {	  
							animal.move(0, -movmentInY);
							animal.setImage(animal.getAnimalImagesController().getAliveImages()[4]);
						}
						else if (event.getCode() == KeyCode.A) {	            	
							animal.move(-movmentInX, 0);
							animal.setImage(animal.getAnimalImagesController().getAliveImages()[5]);
						}
						else if (event.getCode() == KeyCode.S) {	            	
							animal.move(0, movmentInY);
							animal.setImage(animal.getAnimalImagesController().getAliveImages()[6]);
						}
						else if (event.getCode() == KeyCode.D) {	            	
							animal.move(movmentInX, 0);
							animal.setImage(animal.getAnimalImagesController().getAliveImages()[7]);
						}
						isSecond = true;
					}		
				}
			}
		});	
	}
	
	/**
	 * Initialize handler for key release.
	 * <p>
	 * When a key('W', 'A', 'S', 'D') is released, the animal jumps once.
	 * <ul>
	 * <li>W: up
	 * <li>A: left
	 * <li>S: down
	 * <li>D: right
	 * </ul>
	 */
	private void setKeyOff() {
		this.animal.setOnKeyReleased(new EventHandler<KeyEvent>() {
			public void handle(KeyEvent event) {
				if (animal.getAnimalModel().isNoMove()) {
					
				}
				else {
					if (event.getCode() == KeyCode.W) {	  
						if (animal.getY() < animal.getAnimalModel().getHighestPosition()) {
							animal.getAnimalModel().setHighestPosition(animal.getY());
							animal.updateScore(10);
						}
						animal.move(0, -movmentInY);
						animal.setImage(animal.getAnimalImagesController().getAliveImages()[0]);
					}
					else if (event.getCode() == KeyCode.A) {	            	
						animal.move(-movmentInX, 0);
						animal.setImage(animal.getAnimalImagesController().getAliveImages()[1]);
					}
					else if (event.getCode() == KeyCode.S) {	            	
						animal.move(0, movmentInY);
						animal.setImage(animal.getAnimalImagesController().getAliveImages()[2]);
					}
					else if (event.getCode() == KeyCode.D) {	            	
						animal.move(movmentInX, 0);
						animal.setImage(animal.getAnimalImagesController().getAliveImages()[3]);
					}
					isSecond = false;
				}
			}
		});
	}
}
