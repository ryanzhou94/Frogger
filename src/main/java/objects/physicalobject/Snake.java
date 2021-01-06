package objects.physicalobject;

import javafx.scene.image.Image;
import objects.MovableObject;

/**
 * Snake in the game scene.
 * <p>
 * It moves on the log and when it disappears in the scene, it will randomly appear in the log.
 * When Animal hits on Snake, it kills Animal.
 * When Snake gets the end of a Log, it turns back by changing the speed.
 * 
 * @author ryan
 *
 */
public class Snake extends MovableObject{
	
	/*
	 * Images for moving left
	 */
	private Image[] snakeImages = new Image[3];
	
	/*
	 * Images for moiving right.
	 */
	private Image[] snakeRightImages = new Image[3];
	
	/*
	 * Image for disappearing.
	 */
	Image noneImage;
	
	/**
	 * Action type of Snake class.
	 */
	private ActionType actionTyper;
	
	
	/**
	 * Creates a Snake in the world.
	 * 
	 * @param xpos x coordinate of the snake
	 * @param ypos y coordinate of the snake
	 * @param w width of the snake
	 * @param h height of the snake
	 * @param speed speed of the snake
	 */
	public Snake(int xpos, int ypos, int w, int h, double speed) {
		snakeImages[0] = new Image("file:src/main/resources/snake1.png", w, h, true, true);
		snakeImages[1] = new Image("file:src/main/resources/snake2.png", w, h, true, true);
		snakeImages[2] = new Image("file:src/main/resources/snake3.png", w, h, true, true);
		snakeRightImages[0] = new Image("file:src/main/resources/snake1right.png", w, h, true, true);
		snakeRightImages[1] = new Image("file:src/main/resources/snake2right.png", w, h, true, true);
		snakeRightImages[2] = new Image("file:src/main/resources/snake3right.png", w, h, true, true);
		setX(xpos);
		setY(ypos);
		setSpeed(speed);
		setImage(snakeImages[0]);
		actionTyper = new SnakeAction(this);
	}
	
	/**
	 * The action that Car does in current frame.
	 * <p>
	 * It moves on Log horizontally.
	 * @param now the current time
	 */
	@Override
	public void act(long now) {
		actionTyper.act(now);
	}

	@SuppressWarnings("exports")
	public Image[] getSnakeImages() {
		return snakeImages;
	}

	@SuppressWarnings("exports")
	public void setSnakeImages(Image[] snakeImages) {
		this.snakeImages = snakeImages;
	}

	@SuppressWarnings("exports")
	public Image[] getSnakeRightImages() {
		return snakeRightImages;
	}

	@SuppressWarnings("exports")
	public void setSnakeRightImages(Image[] snakeRightImages) {
		this.snakeRightImages = snakeRightImages;
	}
}
