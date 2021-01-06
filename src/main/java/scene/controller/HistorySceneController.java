package scene.controller;

import javafx.scene.control.Button;
import javafx.stage.Stage;
import objects.animal.Animal;
import scene.StartScene;
import scene.view.HistorySceneView;

/**
 * The controller (C in MVC) of HistorySceneView which sets event handlers for buttons in view.
 * 
 * @author ryan
 *
 */
public class HistorySceneController {

	/**
	 * The view of the history scene.
	 */
	private HistorySceneView historySceneView;
	
	/**
	 * Creates a controller of history view and sets button clicking event handlers.
	 * 
	 * @param historySceneView the view, V in MVC
	 */
	public HistorySceneController(HistorySceneView historySceneView) {
		this.historySceneView = historySceneView;
		setRestartButton();
	}

	/**
	 * Sets event handlers for buttons.
	 */
	public void setRestartButton() {
		Button restartButton = (Button) historySceneView.getScene().lookup("#restartButton");
		restartButton.setOnAction(e -> {
			Animal.clearInstance();
			StartScene startScene = new StartScene();
			Stage stage = (Stage) historySceneView.getScene().getWindow();
			stage.setScene(startScene.getStartSceneView().getScene());
		});
	}
}
