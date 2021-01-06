package scene;

import scene.controller.InfoSceneController;
import scene.view.InfoSceneView;

/**
 * The high level of Info scene which has info scene view (V) and info scene controller (C).
 * <p>
 * This is the entity of info scene.
 * 
 * @author ryan
 *
 */
public class InfoScene {
	
	/**
	 * The view of the info scene which keeps all GUI components.
	 */
	private InfoSceneView infoSceneView;
	
	/**
	 * The controller of the info scene which handles all event happen on the info scene.
	 */
	private InfoSceneController infoSceneController;

	/**
	 * Creates an entity of the info scene.
	 * <p>
	 * Passes the view(V) into the controller(C).
	 */
	public InfoScene() {
		this.infoSceneView = new InfoSceneView();
		this.infoSceneController = new InfoSceneController(getInfoSceneView());
	}
	
	public InfoSceneView getInfoSceneView() {
		return infoSceneView;
	}

	public void setInfoSceneView(InfoSceneView infoSceneView) {
		this.infoSceneView = infoSceneView;
	}

	public InfoSceneController getInfoSceneController() {
		return infoSceneController;
	}

	public void setInfoSceneController(InfoSceneController infoSceneController) {
		this.infoSceneController = infoSceneController;
	}
}
