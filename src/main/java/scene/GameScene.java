package scene;

import javafx.scene.Scene;
import scene.controller.GameSceneController;
import scene.model.GameSceneModel;
import scene.view.GameSceneView;

/**
 * The high level of game scene which has game scene model (M), game scene view (V) and game scene controller (C).
 * <p>
 * This is the entity of game scene.
 * 
 * @author ryan
 *
 */
public class GameScene {
	
	/**
	 * The model of the game scene which keeps all models like AnimalModel and BoardModel.
	 */
	private GameSceneModel gameSceneModel;
	
	/**
	 * The view of the game scene which keeps all views like BoardView and World.
	 */
	private GameSceneView gameSceneView;
	
	/**
	 * The whole controller of the game scene which handles all event happen in the game.
	 */
	private GameSceneController gameSceneController;
	
	/**
	 * Creates a game scene in specific level.
	 * <p>
	 * Creates a game model and a game view. Passes the references to the model and view to the controller contructor and creates a game constructor.
	 * 
	 * @param level the level of game
	 */
	public GameScene(int level) {
		gameSceneModel = new GameSceneModel(level);
		gameSceneView = new GameSceneView(level);
		gameSceneController = new GameSceneController(gameSceneModel, gameSceneView);
	}
	
	@SuppressWarnings("exports")
	public Scene getScene() {
		return gameSceneView.getScene();
	}

	public GameSceneModel getGameSceneModel() {
		return gameSceneModel;
	}

	public void setGameSceneModel(GameSceneModel gameSceneModel) {
		this.gameSceneModel = gameSceneModel;
	}

	public GameSceneView getGameSceneView() {
		return gameSceneView;
	}

	public void setGameSceneView(GameSceneView gameSceneView) {
		this.gameSceneView = gameSceneView;
	}

	public GameSceneController getGameSceneController() {
		return gameSceneController;
	}

	public void setGameSceneController(GameSceneController gameSceneController) {
		this.gameSceneController = gameSceneController;
	}
}
