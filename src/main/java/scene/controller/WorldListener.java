package scene.controller;

import java.util.List;

import common.controllers.ObjectsGetter;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import objects.animal.Animal;
import scene.view.World;

/**
 * The controller class controls the world that passed to it.
 * <p>
 * It initializes the key event listener
 * in the world so that the World could response to player's action.
 * 
 * @author ryan
 *
 */
public class WorldListener {

	/**
	 * The world which is controlled by the world controller.
	 */
	private World world;
	
	/**
	 * Constructs the controller and saves the world reference.
	 * 
	 * @param world the world which is controlled by the world controller
	 */
	public WorldListener(World world) {
		this.world = world;
	}
	
	/**
	 * Add key event listener to the world to make the world response to the key events.
	 * <p>
	 * It finds Animal in World and attaches the key event to Animal's event handlers.
	 * It handles press and release of keys.
	 */
	public void initializeKeyEventListener() {
		this.world.sceneProperty().addListener(new ChangeListener<Scene>() {
    		
			@Override
			public void changed(ObservableValue<? extends Scene> observable, Scene oldValue, Scene newValue) {
				if (newValue != null) {
					newValue.setOnKeyReleased(new EventHandler<KeyEvent>() {
						
						@Override
						public void handle(KeyEvent event) {
							if(world.getOnKeyReleased() != null) {
								world.getOnKeyReleased().handle(event);
							}
							List<Animal> myAnimals = ObjectsGetter.getObjects(world, Animal.class);
							for (Animal anAnimal: myAnimals) {
								if (anAnimal.getOnKeyReleased() != null) {
									anAnimal.getOnKeyReleased().handle(event);
								}
							}

						}
					});
					newValue.setOnKeyPressed(new EventHandler<KeyEvent>() {
						
						@Override
						public void handle(KeyEvent event) {
							
							if(world.getOnKeyPressed() != null) {
								world.getOnKeyPressed().handle(event);
							}
							List<Animal> myAnimals = ObjectsGetter.getObjects(world, Animal.class);
							for (Animal anAnimal: myAnimals) {
								if (anAnimal.getOnKeyPressed() != null) {
									anAnimal.getOnKeyPressed().handle(event);
								}
							}
						}
					});
				}
			}
		});
	}
	
}
