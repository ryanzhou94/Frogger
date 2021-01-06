package common.modules;

import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import scene.view.Digit;

/**
 * A combined Vbox for displaying a title and a series of number images.
 * 
 * @author ryan
 *
 */
public class DataBox extends VBox{
	
	/**
	 * The title of the VBox.
	 */
	private Label label;
	
	/**
	 * The container of images of images.
	 */
	private HBox hBox;
	
	/**
	 * The standard size of images.
	 */
	private int imageSize;
	
	/**
	 * Constructs the VBox to contain a Label and a HBox.
	 * <p>
	 * The Label was created with a title passed into the constructor
	 * The HBox contains images of digits.
	 * 
	 * @param title the name of the box
	 * @param number the number that needs to be displayed
	 * @param imageSize the size of digit size
	 */
	public DataBox(String title, int number, int imageSize) {
		super(5);
		label = new Label(title);
		this.imageSize = imageSize;
		this.label.setTextFill(Color.WHITE);
		hBox = new HBox(-6);		
		setNumber(number);
		this.getChildren().addAll(label, hBox);
	}
	
	/**
	 * Constructs the VBox to contain a Label and a HBox.
	 * <p>
	 * The Label was created with a title passed into the constructor
	 * The HBox contains images of digits.
	 * 
	 * @param title the name of the box
	 * @param number the number that needs to be displayed
	 */
	public DataBox(String title, int number) {
		this(title, number, 30);
	}
	
	/**
	 * Constructs the VBox to contain a Label and a HBox.
	 * <p>
	 * The Label was created with a title passed into the constructor
	 * The HBox contains images of digits.
	 * 
	 * @param title the name of the box
	 */
	public DataBox(String title) {
		this(title, 0);
	}
	
	/**
	 * Default constructor.
	 */
	public DataBox() {
		super();
	}
	
	
	/**
	 * Display a number on board view.
	 * <p>
	 * Firstly clear previous images
	 * and then add the images of the new number.
	 * 
	 * @param number the number that needs to be displayed 
	 */
	public void setNumber(int number) {
		clearNumber();
		addImageToBox(processNumber(number));
	}
	
	/**
	 * Remove the original number images in HBox.
	 */
	public void clearNumber() {
		getHBox().getChildren().clear();
	}
	
	/**
	 * Convert the number into a string.
	 * <p>
	 * If it is less than 10, add "000" in front of the number
	 * else if it is less than 100, add "00" in front of the number
	 * else if it is less than 1000, add "0" in front of the number.
	 * 
	 * @param number score of the player
	 * @return a processed string of a number with leading "0"
	 */
	public String processNumber(int number) {
		String numberString = "";
		if (getLabel().getText().contentEquals("SCORE") || getLabel().getText().contentEquals("HI-SCORE")) {
			if (number < 10) {
				numberString = "000";
			} else if (number < 100) {
				numberString = "00";
			} else if (number < 1000) {
				numberString = "0";
			}
		}
		numberString += String.valueOf(number);
		return numberString;
	}
	
	/**
	 * Add the images of the number to the HBox digit by digit.
	 * 
	 * @param numberString the number that needs to be displayed
	 */
	private void addImageToBox(String numberString) {
		for (int i = 0; i < numberString.length(); i++) {
			getHBox().getChildren().add(new Digit(Character.getNumericValue(numberString.charAt(i)), this.imageSize));
		}		
	}
	
	@SuppressWarnings("exports")
	public HBox getHBox() {
		return this.hBox;
	}
	
	@SuppressWarnings("exports")
	public void setHBox(HBox hBox) {
		this.hBox = hBox;
	}

	@SuppressWarnings("exports")
	public Label getLabel() {
		return this.label;
	}

	@SuppressWarnings("exports")
	public void setText(Label label) {
		this.label = label;
	}

	public int getImageSize() {
		return imageSize;
	}

	public void setImageSize(int imageSize) {
		this.imageSize = imageSize;
	}	
}
