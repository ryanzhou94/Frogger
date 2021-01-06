package objects.animal;

/**
 * The model (M in MVC pattern) of Animal.
 * <p>
 * It keeps all information about Animal including score, lives, status, ends and the highest position.
 * It is only responsible for keeping the data of Animal and has no control of any other modules or components.
 * The controllers of Animal will access to AnimalModel to get data of Animal.
 * 
 * @author ryan
 *
 */
public class AnimalModel {
	
	/**
	 * The score of Animal.
	 */
	private int score;
	
	/**
	 * The lives left for Animal.
	 */
	private int lives;
	
	/**
	 * The current status of Animal.
	 * <ul>
	 * <li> 0 : alive
	 * <li> 1 : car death
	 * <li> 2 : water death
	 * <li> 3 : game over
	 * </ul>
	 */
	private int status;	
	
	/**
	 * The number of destinations Animal has got to.
	 */
	private int ends;
	
	/**
	 * It tracks the smallest y coordinate of Animal has reached.
	 * The highest position Animal has reached in each round from born place to one destination.
	 */
	private double highestPosition;
	
	/**
	 * It indicates whether Animal can move.
	 * True if Animal can't move, false if Animal can move.
	 */
	private boolean noMove;
	
	/**
	 * Initializes the model of Animal with a number of lives.
	 * Developers could manually set the lives for Animal.
	 * 
	 * @param lives lives for Animal
	 */
	public AnimalModel(int lives) {
		this.score = 0;
		this.status = 0;
		this.ends = 0;
		this.highestPosition = 800;
		this.noMove = false;
		this.lives = lives;
	}
	
	/**
	 * Initializes the model of Animal using a default number of lives.
	 */
	public AnimalModel() {
		this.score = 0;
		this.status = 0;
		this.ends = 0;
		this.highestPosition = 800;
		this.noMove = false;
		this.lives = 5;
	}
	
	/**
	 * Updates the status and number of ends of AnimalModel when player gets to next level.
	 */
	public void nextLevel() {
		this.status = 0;
		this.ends = 0;
	}
	
	/**
	 * Increases the number of ends when Animal reaches empty destination in game scene.
	 * <p>
	 * It checks if the game has ended (next level) after the increament of the number of ends.
	 */
	public void reachEnd() {
		this.ends++;
		checkEnds();
	}
	
	/**
	 * Decreases the number of ends if Animal reaches an old destination in game scene.
	 */
	public void reachWrongEnd() {
		this.ends--;
	}
	
	/**
	 * Checks if the game is over.
	 * <p>
	 * If Animals has got 5 correct ends or Animal runs out of lives, it sets the status of Animal to 3.
	 * If the condition is false, does nothing.
	 */
	public void checkEnds() {
		if (this.ends == 5 || this.lives == 0) {
			this.status = 3;
		}
	}
	
	/**
	 * Decreses the number of lives when Animal dies.
	 * <p>
	 * Checks if the game is over after the decrement.
	 */
	public void die() {
		this.lives--;
		checkEnds();
	}
	
	public int getScore() {
		return this.score;
	}
	
	public void increasePoints(int increament) {
		this.score = this.score + increament;
	}

	public int getLives() {
		return lives;
	}

	public void setLives(int lives) {
		this.lives = lives;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
		if (status > 0 && status < 3) {
			this.noMove = true;
		}
	}

	public int getEnds() {
		return ends;
	}

	public void setEnds(int ends) {
		this.ends = ends;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public boolean isNoMove() {
		return noMove;
	}

	public void setNoMove(boolean noMove) {
		this.noMove = noMove;
	}

	public double getHighestPosition() {
		return highestPosition;
	}

	public void setHighestPosition(double highestPosition) {
		this.highestPosition = highestPosition;
	}
	
}
