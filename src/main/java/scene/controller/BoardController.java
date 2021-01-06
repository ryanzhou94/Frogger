package scene.controller;

import common.interfaces.AnimalObserver;
import common.interfaces.Displayable;
import common.interfaces.ObservableAnimal;
import scene.model.BoardModel;
import scene.view.BoardView;

/**
 * The controller(C in MVC pattern) of the board.
 * <p>
 * It updates the board model and board view. The board controller is 
 * responsible for all operation on the board view and model. 
 * It listens to the observable animal and updates the model 
 * and the view whenever there is change made in Animal.
 * 
 * @author ryan
 *
 */
public class BoardController implements AnimalObserver, Displayable{

	/**
	 * The model of the board which saves data of the board.
	 */
	private BoardModel boardModel;
	
	/**
	 * The view of the board which displays the physical board.
	 */
	private BoardView boardView;
	
	/**
	 * Constructs the board controller with a board model and a board view.
	 * <p>
	 * It saves the references to the board model and board view. It displays
	 * the numbers in physicial board view. It registers itself in Animal to be
	 * a listener.
	 * 
	 * @param boardModel the model of the board
	 * @param boardView the view of the board
	 * @param animal	the observable animal which is used to register the controllre
	 */
	public BoardController(BoardModel boardModel, BoardView boardView, ObservableAnimal animal) {
		this.boardModel = boardModel;
		this.boardView = boardView;
		displayModel();
		animal.register(this);
	}
	
	/**
	 * Display the score and lives of Animal from board model onto the physical board.
	 */
	@Override
	public void displayModel() {
		boardView.getScoreBox().setNumber(boardModel.getScore());
		boardView.getLivesBox().setNumber(boardModel.getLives());
		boardView.getLevelBox().setNumber(boardModel.getLevel());
		boardView.getHiScorBox().setNumber(boardModel.getHighestScore());
	}
	
	/**
	 * Update board model and view when the player gets to the next level game.
	 * <p>
	 * It increases the level in model by 1 and displays the level on board view.
	 */
	public void nextLevel() {
		boardModel.setLevel(boardModel.getLevel() + 1);
		boardView.getLevelBox().setNumber(boardModel.getLevel());
	}
	
	/**
	 * Updates the new score and new lives in board model and board view.
	 * <p>
	 * It is called in observable Animal 'notifyObserver()' function.
	 * 
	 * @param score the new score from Animal
	 * @param lives the new lives from Animal
	 */
	@Override
	public void update(int score, int lives) {
		updateScore(score);
		updateLives(lives);
	}
	
	/**
	 * Updates the new score in board model and board view.
	 * 
	 * @param score the new score from Animal
	 */
	private void updateScore(int score) {
		getBoardModel().setScore(score);
		getBoardView().getScoreBox().setNumber(score);
	}
	
	/**
	 * Updates the new lives in board model and board view.
	 * 
	 * @param lives the new lives from Animal
	 */
	private void updateLives(int lives) {
		getBoardModel().setLives(lives);
		getBoardView().getLivesBox().setNumber(lives);
	}
	
	/**
	 * Updates the new highest score in board view.
	 * 
	 * @param hiScore the new highest score
	 */
	public void updateHIScore(int hiScore) {
		getBoardView().getHiScorBox().setNumber(hiScore);
	}
	
	public BoardModel getBoardModel() {
		return boardModel;
	}


	public void setBoardModel(BoardModel boardModel) {
		this.boardModel = boardModel;
	}


	public BoardView getBoardView() {
		return boardView;
	}


	public void setBoardView(BoardView boardView) {
		this.boardView = boardView;
	}


}
