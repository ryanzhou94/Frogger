package scene.controller;

import objects.animal.Animal;
import scene.model.GameSceneModel;
import scene.view.GameSceneView;

/**
 * The controller (C in MVC pattern) of the game scene.
 * <p>
 * It handles every event happens in the game scene.
 * It controls all models and all view including Animal and Board.
 * 
 * @author ryan
 *
 */
public class GameSceneController {
	
	/**
	 * The model of game scene. It keeps the model of Animal and the model of Board.
	 */
	private GameSceneModel gameSceneModel;
	
	/**
	 * The view of game scene. It has the view of the game scene.
	 */
	private GameSceneView gameSceneView;
	
	/**
	 * The controller of Board. It updates information in GameSceneController.
	 */
	private BoardController boardController;
	
	/**
	 * The music player.
	 */
	private GameMusicPlayer gameMusicPlayer;
	
	/**
	 * The game level controller.
	 */
	private GameLevelController gameLevelController;
	
	/**
	 * The timer of the game. It handles everything happens in the game. It is the real handler of the GameSceneController.
	 */
	private GameTimer timer;
	
	/**
	 * Creates a GameSceneController and initializes all models, views and controllers.
	 * <p>
	 * It creates a GameMusicPlayer, GameLevelController and a timer.
	 * 
	 * @param gameSceneModel model of the game scene
	 * @param gameSceneView view of the game scene
	 */
	public GameSceneController(GameSceneModel gameSceneModel, GameSceneView gameSceneView) {
		this.setGameSceneModel(gameSceneModel);
		this.setGameSceneView(gameSceneView);
		setBoardController(new BoardController(gameSceneModel.getBoardModel(), gameSceneView.getBoardView(), Animal.getInstace()));
		gameMusicPlayer = new GameMusicPlayer();
		setGameLevelController(new GameLevelController(getBoardController()));
		timer = new GameTimer(gameSceneModel, gameSceneView, this);
	}
	
	/**
	 * Starts the game: starts the music, starts the timer to handle events.
	 */
	public void startGame() {
		gameMusicPlayer.playMusic();
        timer.start();			
    }
	
	/**
	 * Stops the game: stops the music, stops the timer to handle events.
	 */
	public void stopGame() {
		gameMusicPlayer.stopMusic();
		timer.stop();
	}

	public BoardController getBoardController() {
		return boardController;
	}

	public void setBoardController(BoardController boardController) {
		this.boardController = boardController;
	}

	public GameLevelController getGameLevelController() {
		return gameLevelController;
	}

	public void setGameLevelController(GameLevelController gameLevelController) {
		this.gameLevelController = gameLevelController;
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
}
