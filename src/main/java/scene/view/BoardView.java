package scene.view;

import common.modules.DataBox;
import javafx.scene.layout.HBox;

/**
 * The view (V in MVC pattern) of the board.
 * <p> 
 * It shows the score of the player, lives of the pleyer, 
 * the level of the game and the highst score in history.
 * 
 * @author ryan
 *
 */
public class BoardView {
	
	/**
	 * The parent container for all databoxes.
	 */
	private HBox hBox;
	
	/**
	 * Databox for displaying the currently score the player has.
	 */
	private DataBox scoreBox;
	
	/**
	 * Databox for displaying the currently lives the player has. 
	 */
	private DataBox livesBox;
	
	/**
	 * Databox for displaying the currently level of the game.
	 */
	private DataBox levelBox;
	
	/**
	 * Databox for displaying the highest score.
	 */
	private DataBox hiScorBox;
	
	/**
	 * Initialize the view of the game board. 
	 * <p>
	 * It creates a score box, a lives box, 
	 * a level box and a highest score box. All boxes are initialized with number '0'.
	 * After initialization, all data boxes are added to the top HBox which is 
	 * the whole view of the game board. The interval of element in HBox is 80.
	 */
	public BoardView() {
		sethBox(new HBox(60));
		scoreBox = new DataBox("SCORE", 0);
		livesBox = new DataBox("LIVES", 0);
		levelBox = new DataBox("LEVEL", 0);
		hiScorBox = new DataBox("HI-SCORE", 0);
		gethBox().getChildren().addAll(scoreBox, livesBox, levelBox, hiScorBox);
		gethBox().setTranslateX(20);
		gethBox().setTranslateY(15);
	}

	@SuppressWarnings("exports")
	public HBox gethBox() {
		return hBox;
	}

	@SuppressWarnings("exports")
	public void sethBox(HBox hBox) {
		this.hBox = hBox;
	}

	public DataBox getScoreBox() {
		return scoreBox;
	}

	public void setScoreBox(DataBox scoreBox) {
		this.scoreBox = scoreBox;
	}

	public DataBox getLivesBox() {
		return livesBox;
	}

	public void setLivesBox(DataBox livesBox) {
		this.livesBox = livesBox;
	}

	public DataBox getLevelBox() {
		return levelBox;
	}

	public void setLevelBox(DataBox levelBox) {
		this.levelBox = levelBox;
	}

	public DataBox getHiScorBox() {
		return hiScorBox;
	}

	public void setHiScorBox(DataBox hiScorBox) {
		this.hiScorBox = hiScorBox;
	}

}
