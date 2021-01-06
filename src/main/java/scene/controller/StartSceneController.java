package scene.controller;

import javafx.scene.control.Button;
import javafx.stage.Stage;
import scene.GameScene;
import scene.InfoScene;
import scene.view.StartSceneView;

/**
 * The controller (C in MVC) of StartSceneView which sets event handlers for buttons in view.
 * 
 * @author ryan
 *
 */
public class StartSceneController {
	
	/**
	 * The view of the start scene.
	 */
	private StartSceneView startSceneView;
	
	/**
	 * Creates a controller of start view and sets button clicking event handlers.
	 * 
	 * @param startSceneView the view, V in MVC
	 */
	public StartSceneController(StartSceneView startSceneView) {
		this.startSceneView = startSceneView;
		onButtonClick();
	}
	
	/**
	 * Sets event handlers for buttons.
	 */
	public void onButtonClick() {
		setStartButton();
		setInfoButton();
	}
	
	/**
	 * Clicks on this button, creates a info scene and sets it to current stage.
	 */
	public void setStartButton() {
		Button startButton = (Button) startSceneView.getScene().lookup("#startButton");
		startButton.setOnAction(e -> {
			GameScene gameScene = new GameScene(1);
			Stage stage = (Stage) startSceneView.getScene().getWindow();
			stage.setScene(gameScene.getScene());
			gameScene.getGameSceneController().startGame();
		});
	}
	
	/**
	 * Creates a info scene and sets it to current stage.
	 */
	public void setInfoButton() {
		Button infoButton = (Button) startSceneView.getScene().lookup("#infoButton");
		infoButton.setOnAction(e -> {
			InfoScene infoScene = new InfoScene();
			Stage stage = (Stage) startSceneView.getScene().getWindow();
			stage.setScene(infoScene.getInfoSceneView().getScene());
		});
	}
	
}
