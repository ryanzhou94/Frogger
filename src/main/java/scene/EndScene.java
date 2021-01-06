package scene;

import scene.controller.EndSceneController;
import scene.view.EndSceneView;

/**
 * The high level of end scene which has end scene view (V) and end scene controller (C).
 * <p>
 * This is the entity of end scene.
 * 
 * @author ryan
 *
 */
public class EndScene {

	/**
	 * The view of the end scene which keeps all GUI components.
	 */
	private EndSceneView endSceneView;
	
	/**
	 * The controller of the end scene which handles all event happen on the end scene.
	 */
	private EndSceneController endSceneController;
	
	/**
	 * Creates an entity of the end scene.
	 * <p>
	 * Passes the view(V) into the controller(C).
	 */
	public EndScene() {
		endSceneView = new EndSceneView();
		endSceneController = new EndSceneController(endSceneView);
	}

	public EndSceneView getEndSceneView() {
		return endSceneView;
	}

	public void setEndSceneView(EndSceneView endSceneView) {
		this.endSceneView = endSceneView;
	}

	public EndSceneController getEndSceneController() {
		return endSceneController;
	}

	public void setEndSceneController(EndSceneController endSceneController) {
		this.endSceneController = endSceneController;
	}
	


}
