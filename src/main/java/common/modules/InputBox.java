package common.modules;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

/**
 * InputBox is a combined VBox which is used to collect input from the player.
 * <p>
 * InputBox collects player's name and saves its name
 * and score to local file. InputBox contains a container VBox, 
 * a prompt Text, a TextField for inputing
 * and a Button for submitting.
 * 
 * @author ryan
 *
 */
public class InputBox extends VBox{
	
	/**
	 * The prompt text for player.
	 */
	Text text;
	
	/**
	 * The input text field for player to input.
	 */
	TextField textFile;
	
	/**
	 * The button for submitting the input.
	 */
	Button button;
	
	/**
	 * Creates a VBox, a Text, a TextField and a Button and add them to the VBox.
	 * <p>
	 * The text in Text is title and the text in Button is "Confirm".
	 * 
	 * @param title the title of InputBox
	 */
	public InputBox(String title) {
		super(10);
		text = new Text(title);
		text.setFill(Color.WHITE);
		textFile = new TextField();
		button = new Button("Confirm");
		this.getChildren().addAll(this.text, this.textFile, this.button);
		
	}

	@SuppressWarnings("exports")
	public Text getText() {
		return text;
	}

	@SuppressWarnings("exports")
	public void setText(Text text) {
		this.text = text;
	}

	@SuppressWarnings("exports")
	public TextField getTextFile() {
		return textFile;
	}

	@SuppressWarnings("exports")
	public void setTextFile(TextField textFile) {
		this.textFile = textFile;
	}

	@SuppressWarnings("exports")
	public Button getButton() {
		return button;
	}

	@SuppressWarnings("exports")
	public void setButton(Button button) {
		this.button = button;
	}
	
}
