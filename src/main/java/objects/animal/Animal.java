package objects.animal;

import java.util.ArrayList;

import common.interfaces.AnimalObserver;
import common.interfaces.ObservableAnimal;
import objects.MovableObject;

/**
 * Animal is the antity of the player in the frogger game.
 * <p>
 * Player controls the animal by pressing 'W', 'A', 'S' and 'D' on keyboard to move the frogger in the game scene.
 * It has a model which saves all information about the object of Animal. 
 * It has a view which saves all images about Animal.
 * Both model and view of animal have no relationship with other components and have no control of other modules.
 * It has position setter, level controller, death controller, key event handler, intersection processor and the reference to its observers.
 * Whenever higher level of controllers call the method, updateScore(), in Animal, it updates the score in AnimalModel 
 * and notifies all listeners (BoardController) to update information in BoardView and BoardModel.
 * The Animal class uses Singleton design pattern to make it globally accessible to all other modules and components.
 * 
 * @author ryan
 *
 */
public class Animal extends MovableObject implements ObservableAnimal{
	
	/**
	 * Singleton instance.
	 */
	private static Animal instance = null;
	
	/**
	 * The images of Animal.
	 */
	private AnimalView animalView;
	
	/**
	 * The Animal model which keeps all information about the animal object.
	 */
	private AnimalModel animalModel;
	
	/**
	 * Animal position setter sets the coordinate and position of the animal.
	 * It needs the control of the whole Animal.
	 * It has the reference to the Animal object.
	 */
	private AnimalPositionSetter animalPositionSetter;
	
	/**
	 * Animal's death controller handles the status changes and view changes after the Animal is dead.
	 */
	private AnimalDeathController animalDeathController;
	
	/**
	 * It initializes player's key event.
	 */
	private AnimalKeyEventInitializer animalKeyEventInitializer;
	
	/**
	 * The processor of animal intersection handles intersection with every kind of object in the game.
	 */
	private AnimalIntersectionProcessor animalIntersectionProcessor;
	
	/**
	 * Observers of Animal. When the score or lives of the animal object changes, observers will be notified.
	 */
	private ArrayList<AnimalObserver> animalObservers;
	
	/**
	 * Creates an Animal object.
	 * <p>
	 * The constructor uses composition to create several modules that owned by the Animal object.
	 * It creates an Animal with 5 lives(default) but developers could manually change it in this contructors.
	 * It creates an Animal view.
	 * It creates several controllers.
	 * It creates an array list of all listeners.
	 * It resets the Animal object including the position, status and image view of the object.
	 * The constructor is a private constructor because Singleton is applied on Animal.
	 * Only one instance of Animal is allowed to create and exists.
	 * To create an Animal instance, the method, getInstance() will be called to get the single instance.
	 */
	private Animal() {
		this.animalModel = new AnimalModel(5);
		this.animalView = new AnimalView();
		this.animalPositionSetter = new AnimalPositionSetter(this);
		this.animalDeathController = new AnimalDeathController(this);
		this.animalKeyEventInitializer = new AnimalKeyEventInitializer(this);
		this.animalIntersectionProcessor = new AnimalIntersectionProcessor(this);
		this.animalObservers = new ArrayList<AnimalObserver>();
		resetAnimal();
	}
	
	/**
	 * Using Singleton design pattern to get the only instance of Animal.
	 * <p>
	 * In this case, all modules anc components can access to the Animal instance and the information about Animal can be synchronized.
	 * 
	 * @return the only Singleton Animal object.
	 */
	public static Animal getInstace() {
		if (instance == null) {
			instance = new Animal();
		}
		return instance;
	}
	
	/**
	 * Clear the only instance of Animal.
	 * <p>
	 * When player ends the game and wants to restart the game, the previous Animal instance should be cleared so that other components won't access to the old Animal instance.
	 */
	public static void clearInstance() {
		if (instance != null) {
			instance = null;
		}
	}
	
	/**
	 * Checks if the animal oversteps the boundary of the game, handles the animal's intersection with other game objects and checks the status of the animal.
	 * <p>
	 * It runs in every frame to make the game continuously.
	 * 
	 * @param now the current time
	 */
	@Override
	public void act(long now) {
		this.animalPositionSetter.correctPosition();
		this.animalIntersectionProcessor.processIntersection();
		this.animalDeathController.checkStatus(now);
	}
	
	/**
	 * It calls nextLevel() in AnimalModel to updates the status and number of ends of AnimalModel and add 1000pts for player.
	 * <p>
	 * The updateScore() in Animal also notifies the BoardController to update information of Animal both in BoardModel and BoardView.
	 */
	public void nextLevel() {
		this.animalModel.nextLevel();
		updateScore(1000);
	}
	
	/**
	 * Sets the animal to the original position, sets the animal to live and sets the image of the animal.
	 * <p>
	 * This is normally called when the animal dies or reaches the end destination.
	 */
	public void resetAnimal() {
		animalPositionSetter.resetLocation();
		animalModel.setStatus(0);
		resetImage();
	}
	
	/**
	 * Sets the image of Animal to the alive image.
	 * <p>
	 * This is normally called when the animal dies or reaches the end destination.
	 */
	public void resetImage() {
		 this.setImage(this.getAnimalView().getAliveImages()[0]);
	}
	
	/**
	 * Changes the score of the animal and notifies all observers.
	 * <p>
	 * It calls the method, increasePoints(), in animal model to make changes on the score of the animal.
	 * It notifies all observers by calling the method, notifyAnimalObserver(), to update corresponding information.
	 * It accepts positive or negative integers.
	 * 
	 * @param difference increament or decrement of Animal's score
	 */
	public void updateScore(int difference) {
		this.animalModel.increasePoints(difference);
		notifyAnimalObserver();
	}
	
	/**
	 * Adds a new observer to the array list.
	 * 
	 * @param newObserver the new animal observer that observes Animal
	 */
	@Override
	public void register(AnimalObserver newObserver) {
		this.animalObservers.add(newObserver);
	}

	/**
	 * Removes a new observer from the array list.
	 * 
	 * @param deleteObserver the deleted animal observer that observes Animal
	 */
	@Override
	public void unregister(AnimalObserver deleteObserver) {
		int index = this.animalObservers.indexOf(deleteObserver);
		this.animalObservers.remove(index);
	}

	/**
	 * Notifies all animal observers to update the score and the number of lives of the animal.
	 * <p>
	 * It calls update() method defined in AnimalObserver interface.
	 * Observers get the new score and new number of lives.
	 */
	@Override
	public void notifyAnimalObserver() {
		for (AnimalObserver animalObserver : animalObservers) {
			animalObserver.update(animalModel.getScore(), animalModel.getLives());
		}
	}

	public AnimalModel getAnimalModel() {
		return animalModel;
	}

	public AnimalPositionSetter getAnimalPositionSetter() {
		return animalPositionSetter;
	}

	public AnimalDeathController getAnimalDeathController() {
		return animalDeathController;
	}

	public AnimalView getAnimalImagesController() {
		return getAnimalView();
	}

	public AnimalKeyEventInitializer getAnimalKeyEventInitializer() {
		return animalKeyEventInitializer;
	}

	public AnimalIntersectionProcessor getAnimalIntersectionProcessor() {
		return animalIntersectionProcessor;
	}

	public AnimalView getAnimalView() {
		return animalView;
	}
}
