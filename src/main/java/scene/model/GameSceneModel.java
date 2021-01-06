package scene.model;

import objects.animal.Animal;
import objects.animal.AnimalModel;

/**
 * The model (M in MVC) of game scene which keeps all models like AnimalModel and BoardModel in this class.
 * 
 * @author ryan
 *
 */
public class GameSceneModel {
	
	/**
	 * AnimalModel keeps all information about Animal object.
	 */
	private AnimalModel animalModel;
	
	/**
	 * BoardModel keeps all information about Board object.
	 */
	private BoardModel boardModel;
	
	/**
	 * Creates a GameSceneModel which contains a model of Animal and a model of Board.
	 * <p>
	 * It gets the Singleton instance of Animal and constructs a new BoardModel with specific level.
	 * 
	 * @param level the level of the game
	 */
	public GameSceneModel(int level) {
		animalModel = Animal.getInstace().getAnimalModel();
		boardModel = new BoardModel(animalModel.getScore(), animalModel.getLives(), level);
	}

	public BoardModel getBoardModel() {
		return boardModel;
	}

	public void setBoardModel(BoardModel boardModel) {
		this.boardModel = boardModel;
	}

	public AnimalModel getAnimalModel() {
		return animalModel;
	}

	public void setAnimalModel(AnimalModel animalModel) {
		this.animalModel = animalModel;
	}
}
