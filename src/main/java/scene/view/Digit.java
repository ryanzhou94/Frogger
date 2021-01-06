package scene.view;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * Digit image in game scene.
 * 
 * @author ryan
 *
 */
public class Digit extends ImageView{
	
	/**
	 * Creates a Digit of a specific number.
	 * 
	 * @param num the number of the digit 
	 * @param dim image size of the digit
	 */
	public Digit(int num, int dim) {
		setImage(new Image("file:src/main/resources/" + num + ".png", dim, dim, true, true));
	}
}
