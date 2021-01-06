package scene.view;

import common.modules.DataBox;
import common.modules.InputBox;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import objects.animal.Animal;

/**
 * The end scene diaplayed after the game is over.
 * <p>
 * In this scene, the game shows score of the player and asks player to input his name.
 * There is a button used to confirm the input of name.
 * It only receives non-empty string.
 * If the name is null, a alert window is shown.
 * 
 * @author ryan
 *
 */
public class EndSceneView {
	
	/**
	 * The end scene.
	 */
	private Scene scene;
	
	/**
	 * Creates an EndScene.
	 */
	public EndSceneView() {
		this.scene = createEndScene();
	}

	/**
	 * Creates an end scene.
	 * <p>
	 * On the end scene, there is databox showing the score of player it the previous game.
	 * Below the databox, there is an input box prompting the player to enter his/her name.
	 * If the player enters a non-empty string, the button creates a history scene which displays all history score with rank number and player name.
	 * If the player enters an empty string, an alert will show on the scene to ask user to enter a valid name.
	 * 
	 * @return the constructed end scene
	 */
	private Scene createEndScene() {
		Label overLabel = new Label("GAME OVER");
		overLabel.setId("overLabel");
		DataBox scoreBox = new DataBox("Your Score:", Animal.getInstace().getAnimalModel().getScore(), 40);
		scoreBox.setId("scoreBox");
		scoreBox.getLabel().setId("scoreBoxLabel");
		InputBox inputBox = new InputBox("Your name:");
		inputBox.getButton().setId("confirmButton");
		inputBox.getTextFile().setId("inputText");
		
		overLabel.setTranslateX(160);
		overLabel.setTranslateY(220);
		scoreBox.setTranslateX(185);
		scoreBox.setTranslateY(340);
		inputBox.setTranslateX(185);
		inputBox.setTranslateY(450);
		
		inputBox.setId("inputBox");
		inputBox.getText().setId("inputBoxText");
		AnchorPane anchorPane = new AnchorPane();
		anchorPane.getChildren().addAll(overLabel, scoreBox, inputBox);
		Scene scene = new Scene(anchorPane,600,800);
		scene.getStylesheets().add("file:src/main/resources/EndScreen.css");
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
