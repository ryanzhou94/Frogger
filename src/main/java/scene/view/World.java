package scene.view;

import javafx.scene.layout.Pane;
import objects.GameObject;
import scene.controller.WorldListener;

/**
 * World class is a Pane which contains game objects.
 * <p>
 * It response to the player's key event.
 * 
 * @author Zewei Zhou
 *
 */
public class World extends Pane {
	
	/**
	 * The controller of the World.
	 * It initializes the key event listener
	 * in the world so that the World could response to player's action.
	 */
    private WorldListener worldController;
	
    /**
     * Create a world controller and pass the world to it.
     * <p>
     * The controller sets key event listener to listen to player's action.
     */
    public World() {
    	worldController = new WorldListener(this);
    	worldController.initializeKeyEventListener();
    }

    /**
     * Add the game object into the World.
     * 
     * @param gameObjects the object added into the World
     */
    public void add(GameObject gameObjects) {
        this.getChildren().add(gameObjects);
    }

    /**
     * Remove the game object from the World.
     * 
     * @param gameObjects the object removed from the World
     */
    public void remove(GameObject gameObjects) {
        getChildren().remove(gameObjects);
    }

    /**
     * The action that World does in current frame.
     * 
     * @param now the current time (frame)
     */
    public void act(long now) {
    	
    }
    
	public WorldListener getWorldController() {
		return worldController;
	}

	public void setWorldController(WorldListener worldController) {
		this.worldController = worldController;
	}
}
