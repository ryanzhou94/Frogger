package scene.view;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

/**
 * The start scene of the whole game.
 * <p>
 * Player can choose to play the game directly or learn the rules about the game.
 * 
 * @author ryan
 *
 */
public class StartSceneView {

	/**
	 * The start scene.
	 */
	private Scene scene;
	
	/**
	 * Creates a start scene.
	 */
	public StartSceneView() {
		this.scene = createScene();
	}

	/**
	 * Creates an start scene which has two buttons.
	 * <p>
	 * Player can choose to play the game directly or learn the rules about the game.
	 * 
	 * @return the constructed start scene
	 */
	private Scene createScene() {
		Label label = new Label("ONE  PLAYER  ONLY");
	    Button startButton = new Button("START");
	    startButton.setId("startButton");
	    Button infoButton = new Button("INFO");
	    infoButton.setId("infoButton");

	    /*
	     * Sets position in the pane.
	     */
	    label.setTranslateX(140);
	    label.setTranslateY(525);
	    startButton.setTranslateX(190);
	    startButton.setTranslateY(600);
	    infoButton.setTranslateX(330);
	    infoButton.setTranslateY(600);
	    AnchorPane anchorPane = new AnchorPane();
	    anchorPane.getChildren().addAll(label, startButton, infoButton);
	    Scene scene = new Scene(anchorPane,600,800);
	    scene.getStylesheets().add("file:src/main/resources/StartScreen.css");
	    scene.getStylesheets().add("file:src/main/resources/Button.css");
		return scene;
	}
	
	@SuppressWarnings("exports")
	public Scene getScene() {
		return scene;
	}
}
