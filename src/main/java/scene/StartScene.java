package scene;

import scene.controller.StartSceneController;
import scene.view.StartSceneView;

/**
 * The high level of start scene which has start scene view (V) and start scene controller (C).
 * <p>
 * This is the entity of start scene.
 * 
 * @author ryan
 *
 */
public class StartScene {
	
	/**
	 * The view of the start scene which keeps all GUI components.
	 */
	private StartSceneView startSceneView;
	
	/**
	 * The controller of the start scene which handles all event happen on the start scene.
	 */
	private StartSceneController startSceneController;
	
	/**
	 * Creates an entity of the start scene.
	 * <p>
	 * Passes the view(V) into the controller(C).
	 */
	public StartScene() {
		this.startSceneView = new StartSceneView();
		this.startSceneController = new StartSceneController(getStartSceneView());
	}

	public StartSceneView getStartSceneView() {
		return startSceneView;
	}

	public void setStartSceneView(StartSceneView startSceneView) {
		this.startSceneView = startSceneView;
	}

	public StartSceneController getStartSceneController() {
		return startSceneController;
	}

	public void setStartSceneController(StartSceneController startSceneController) {
		this.startSceneController = startSceneController;
	}
}
