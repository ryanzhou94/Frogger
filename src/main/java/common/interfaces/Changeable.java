package common.interfaces;

/**
 * This interface provides methods to change the image of an object.
 * 
 * @author ryan
 *
 */
public interface Changeable {

	/**
	 * Changes images of an object based on the time.
	 * 
	 * @param now the current time
	 */
	public void changeImage(long now);
	
}
