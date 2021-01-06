package scene.view;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

/**
 * The INFO scene of the game which introduces rules about the game.
 * <p>
 * A 'Resume' button is provided to go back to the start scene.
 * 
 * @author ryan
 *
 */
public class InfoSceneView {
	
	/**
	 * The Info scene.
	 */
	private Scene scene;
	
	/**
	 * Creates an Info scene.
	 */
	public InfoSceneView() {
		this.scene = createScene();
	}

	/**
	 * Creates an info scene which introduces rules about the game.
	 * <p>
	 * A 'Resume' button is provided to go back to the start scene.
	 * 
	 * @return the constructed info scene
	 */
	private Scene createScene() {
		Label label = new Label("--POINT TABLE--");
		VBox vBox = createPointTable();
		vBox.setId("InfoBox");
		Button button = new Button("RESUME");
		button.setId("resumeButton");
		
		/*
	     * Sets position in the pane.
	     */
		label.setTranslateX(160);
		label.setTranslateY(200);
		vBox.setTranslateX(100);
		vBox.setTranslateY(280);
		button.setTranslateX(240);
		button.setTranslateY(600);
		
		AnchorPane anchorPane = new AnchorPane();
		anchorPane.getChildren().addAll(label, vBox, button);
		Scene scene = new Scene(anchorPane, 600, 800);
		scene.getStylesheets().add("file:src/main/resources/Button.css");
		scene.getStylesheets().add("file:src/main/resources/InfoScreen.css");
		return scene;
	}
	
	/**
	 * Creates the point table.
	 * 
	 * @return a Vbox which the point table with game rules
	 */
	@SuppressWarnings("exports")
	public VBox createPointTable() {
		VBox vBox = new VBox();
		Text text1 = new Text("10 PTS FOR EACH STEP\n");
		Text text2 = new Text("50 PTS FOR EVERY FROG");
		Text text3 = new Text("ARRIVED HOME SAFELY\n");
		Text text4 = new Text("1000 PTS FOR SAVING FROGS");
		Text text5 = new Text("INTO FIVE HOMES\n");
		Text text6 = new Text("500 PTS FOR GETTING BONUS");
		text1.setFill(Color.YELLOW);
		text2.setFill(Color.YELLOW);
		text3.setFill(Color.RED);
		text4.setFill(Color.YELLOW);
		text5.setFill(Color.RED);
		text6.setFill(Color.YELLOW);
		vBox.getChildren().addAll(text1, text2, text3, text4, text5, text6);
		return vBox;
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
