package scene.view;

import common.controllers.ScoreFileProcesser;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

/**
 * The history scene of the game which displays the history score.
 * <p>
 * A button is provided to go back to the start scene to restart the game.
 * 
 * @author ryan
 *
 */
public class HistorySceneView {
	
	/**
	 * The history scene.
	 */
	private Scene scene;
	
	/**
	 * Creates a history scene.
	 */
	public HistorySceneView() {
		this.scene = createEndScene();
	}

	/**
	 * Creates an history scene which displays all history score and player names.
	 * <p>
	 * It firsyly creates GUI nodes, and reads data from local file.
	 * Then constructs the table with data.
	 * A button is provided to go back to the start scene to restart the game.
	 * 
	 * @return the constructed end scene
	 */
	private Scene createEndScene() {
		Label label = new Label("SCORE RANKING");
		ScoreTable table = new ScoreTable(ScoreFileProcesser.getNameList(), ScoreFileProcesser.getScoreList());
		GridPane rankPane = table;
		rankPane.setId("scoreTable");
		Button button = new Button("RESTART");
		button.setId("restartButton");
		
		label.setTranslateX(170);
		label.setTranslateY(170);
		rankPane.setTranslateX(125);
		rankPane.setTranslateY(220);
		button.setTranslateX(245);
	    button.setTranslateY(640);
		AnchorPane anchorPane = new AnchorPane();
		anchorPane.getChildren().addAll(label, rankPane, button);
		Scene scene = new Scene(anchorPane, 600, 800);
		scene.getStylesheets().add("file:src/main/resources/HistoryScreen.css");
		scene.getStylesheets().add("file:src/main/resources/Button.css");
		return scene;
	}

	@SuppressWarnings("exports")
	public Scene getScene() {
		return scene;
	}

	@SuppressWarnings("exports")
	public void setScene(Scene scene) {
		this.scene = scene;
	}
	
}
