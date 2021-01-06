package scene.view;

import common.controllers.GameLevelBuilder;
import javafx.scene.Scene;

/**
 * The view (V in MVC pettern) of the game scene which keeps all views like BoardView and World.
 * <p>
 * It builds the game scene with a world which contains all game objects. 
 * It also contains the view of board to display.
 * In this class, no concreate game object is specified except the game board.
 * 
 * @author ryan
 *
 */
public class GameSceneView {
	
	/**
	 * The view of the game board.
	 * Used to display game and player information.
	 * It is kept by GameSceneView and initialized whenever a new game scene is built.
	 */
	private BoardView boardView;
	
	/**
	 * The actual scene of the whole world.
	 */
	private Scene scene;
	
	/**
	 * Creates a view of the world.
	 * <p>
	 * It needs a world which contains all game objects to constructs the scene.
	 * The size of the scene is 600*800 in default.
	 * 
	 * @param level the level of game
	 */
	public GameSceneView(int level) {
		boardView = new BoardView();
		World world = GameLevelBuilder.builWorld(level);
		world.setId("world");
		world.getChildren().add(boardView.gethBox());
		scene = new Scene(world, 600, 800);
		scene.getStylesheets().add("file:src/main/resources/GameScreen.css");
	}

	@SuppressWarnings("exports")
	public Scene getScene() {
		return scene;
	}

	@SuppressWarnings("exports")
	public void setScene(Scene scene) {
		this.scene = scene;
	}

	public BoardView getBoardView() {
		return boardView;
	}

	public void setBoardView(BoardView boardView) {
		this.boardView = boardView;
	}

}
