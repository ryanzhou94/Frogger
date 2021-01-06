package app;

import javafx.application.Application;
import javafx.stage.Stage;
import scene.StartScene;

/**
 * The only entry of the game.
 * <p>
 * It creates a stage of the frogger game and a start scene.
 * 
 * @author ryan
 *
 */
public class Main extends Application {
	
	public static void main(String[] args) {
		launch(args);
	}
  
	@SuppressWarnings("exports")
	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Frogger");
		StartScene startScene = new StartScene();
		primaryStage.setScene(startScene.getStartSceneView().getScene());
		primaryStage.show();
	}
}
