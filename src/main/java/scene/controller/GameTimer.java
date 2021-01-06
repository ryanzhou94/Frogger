package scene.controller;

import java.util.List;

import common.controllers.GameChecker;
import common.controllers.ObjectsGetter;
import javafx.animation.AnimationTimer;
import javafx.stage.Stage;
import objects.GameObject;
import scene.EndScene;
import scene.GameScene;
import scene.model.GameSceneModel;
import scene.view.GameSceneView;
import scene.view.World;

/**
 * The timer of the game. It handles everything happens in the game. It is the real handler of the GameSceneController.
 */
public class GameTimer extends AnimationTimer{

	/**
	 * The model of game scene.
	 */
	private GameSceneModel gameSceneModel;
	
	/**
	 * The view of game scene.
	 */
	private GameSceneView gameSceneView;
	
	/**
	 * The controller of game scene.
	 */
	private GameSceneController gameSceneController;
	
	/**
	 * Creates a timer of the game.
	 * 
	 * @param gameSceneModel model of game scene
	 * @param gameSceneView view of game scene
	 * @param gameSceneController controller of game scene
	 */
	public GameTimer(GameSceneModel gameSceneModel, GameSceneView gameSceneView, GameSceneController gameSceneController) {
		super();
		this.gameSceneModel = gameSceneModel;
		this.gameSceneView = gameSceneView;
		this.gameSceneController = gameSceneController;
	}
	
	/**
	 * It defines a series of strategies to handle all kinds of events happen during the running game.
	 * <p>
	 * It has a handle function which excutes in every frame of time.
	 * It calls act() method from every class objects in the current game world.
	 * It dynamically checks if current score of player is greater than the highest score in history, if so, updates the view of Board.
	 * It checks if the current game is over. If the lives of Animal is less than 1 or Animal gets 5 ends.
	 * If the current game is over, it checks if the player can go to the next level game.
	 * If the player is allowed to go to the next level of game, updates information and creates the scene and world of the next level and set the stage to next level.
	 * If the player runs out of lives or passes all levels, creates an EndScene and jump to it.
	 * 
	 * @param now the current time
	 */
	@Override
	public void handle(long now) {
		List<GameObject> objects = ObjectsGetter.getObjects((World)gameSceneView.getScene().lookup("#world"), GameObject.class);
        for (GameObject anObject: objects) {
        	anObject.act(now);
        }
    	if (gameSceneModel.getAnimalModel().getScore() > gameSceneModel.getBoardModel().getHighestScore()) {
    		gameSceneController.getBoardController().updateHIScore(gameSceneModel.getAnimalModel().getScore());
		}
    	if (GameChecker.gameOver(gameSceneModel.getAnimalModel())) {
    		gameSceneController.stopGame();
    		if (GameChecker.nextLevel(gameSceneModel.getAnimalModel(), gameSceneModel.getBoardModel())) {
    			gameSceneController.getGameLevelController().nextLevel();
				GameScene scene = new GameScene(gameSceneModel.getBoardModel().getLevel());
				Stage stage = (Stage) gameSceneView.getScene().getWindow();
        		stage.setScene(scene.getScene());
        		scene.getGameSceneController().startGame();
			} else {
        		EndScene scene = new EndScene();
        		Stage stage = (Stage) gameSceneView.getScene().getWindow();
        		stage.setScene(scene.getEndSceneView().getScene());
			}
    	}
	}
}
