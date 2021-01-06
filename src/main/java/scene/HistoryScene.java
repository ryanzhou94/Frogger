package scene;

import scene.controller.HistorySceneController;
import scene.view.HistorySceneView;

/**
 * The high level of history scene which has history scene view (V) and history scene controller (C).
 * <p>
 * This is the entity of history scene.
 * 
 * @author ryan
 *
 */
public class HistoryScene {

	/**
	 * The view of the history scene which keeps all GUI components.
	 */
	private HistorySceneView historySceneView;
	
	/**
	 * The controller of the history scene which handles all event happen on the history scene.
	 */
	private HistorySceneController historySceneController;
	
	/**
	 * Creates an entity of the history scene.
	 * <p>
	 * Passes the view(V) into the controller(C).
	 */
	public HistoryScene() {
		this.setHistorySceneView(new HistorySceneView());
		this.setHistorySceneController(new HistorySceneController(getHistorySceneView()));
	}

	public HistorySceneView getHistorySceneView() {
		return historySceneView;
	}

	public void setHistorySceneView(HistorySceneView historySceneView) {
		this.historySceneView = historySceneView;
	}

	public HistorySceneController getHistorySceneController() {
		return historySceneController;
	}

	public void setHistorySceneController(HistorySceneController historySceneController) {
		this.historySceneController = historySceneController;
	}
	
}
