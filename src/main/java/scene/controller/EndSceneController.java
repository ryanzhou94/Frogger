package scene.controller;

import common.controllers.ScoreFileProcesser;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import objects.animal.Animal;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import scene.HistoryScene;
import scene.view.EndSceneView;

/**
 * The controller (C in MVC) of EndSceneView which sets event handlers for buttons in view.
 * 
 * @author ryan
 *
 */
public class EndSceneController {

	/**
	 * The view of the end scene.
	 */
	private EndSceneView endSceneView;
	
	/**
	 * Creates a controller of end view and sets button clicking event handlers.
	 * 
	 * @param endSceneView the view, V in MVC
	 */
	public EndSceneController(EndSceneView endSceneView) {
		this.endSceneView = endSceneView;
		setConfirmButton();
	}

	/**
	 * Sets event handlers for buttons.
	 * <p>
	 * Displays the score of Animal to the player and asks player to input his name.
	 * If the name is empty, generate an alert to ask player to input again.
	 * If the name is valid, pass the name and the score of player to ScoreFileProcesser.
	 */
	public void setConfirmButton() {
		Button confrimButton = (Button) endSceneView.getScene().lookup("#confirmButton");
		TextField inputTextField = (TextField) endSceneView.getScene().lookup("#inputText");
		confrimButton.setOnAction(e -> {
			if (inputTextField.getText().trim().isEmpty()) {
				Alert alert = new Alert(AlertType.INFORMATION);
            	alert.setTitle("Error");
           		alert.setHeaderText("Please enter a valid name");
           		alert.show();
			} else {
				ScoreFileProcesser.processList(inputTextField.getText(), Animal.getInstace().getAnimalModel().getScore());
				HistoryScene historyScene = new HistoryScene();
				Stage stage = (Stage) endSceneView.getScene().getWindow();
				stage.setScene(historyScene.getHistorySceneView().getScene());
			}
		});
	}
}
