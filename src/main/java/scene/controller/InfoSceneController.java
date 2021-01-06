package scene.controller;

import javafx.scene.control.Button;
import javafx.stage.Stage;
import scene.StartScene;
import scene.view.InfoSceneView;

/**
 * The controller (C in MVC) of StartSceneView which sets event handlers for buttons in view.
 * 
 * @author ryan
 *
 */
public class InfoSceneController {
	
	/**
	 * The view of the info scene.
	 */
	private InfoSceneView infoSceneView;
	
	/**
	 * Creates a controller of info view and sets button clicking event handlers.
	 * 
	 * @param infoSceneView the view, V in MVC
	 */
	public InfoSceneController(InfoSceneView infoSceneView) {
		this.infoSceneView = infoSceneView;
		setResumeButton();
	}

	/**
	 * Sets event handlers for buttons.
	 */
	public void setResumeButton() {
		Button resumeButton = (Button) infoSceneView.getScene().lookup("#resumeButton");
		resumeButton.setOnAction(e -> {
			StartScene startScene = new StartScene();
			Stage stage = (Stage) infoSceneView.getScene().getWindow();
			stage.setScene(startScene.getStartSceneView().getScene());
		});
	}
}
