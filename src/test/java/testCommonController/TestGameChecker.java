package testCommonController;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import common.controllers.GameChecker;
import objects.animal.Animal;
import objects.animal.AnimalModel;
import scene.model.BoardModel;

public class TestGameChecker {

	AnimalModel animalModel = new AnimalModel();
	
	@Test
	public void testGameOver_initialize() {
		assertFalse(GameChecker.gameOver(animalModel));
	}
	
	@Test
	public void testGameOver_5ends() {
		for (int i = 0; i < 5; i++) {
			animalModel.reachEnd();
		}
		assertTrue(GameChecker.gameOver(animalModel));
	}
	
	@Test
	public void testGameOver_0lives() {
		for (int i = 0; i < 5; i++) {
			animalModel.die();
		}
		assertTrue(GameChecker.gameOver(animalModel));
	}

	@Test
	public void testNextLevel_passAllLevels() {
		for (int i = 0; i < 20; i++) {
			animalModel.reachEnd();
		}
		assertTrue(GameChecker.gameOver(animalModel));
	}
	
	@Test
	public void testNextLevel_0lives() {
		for (int i = 0; i < 5; i++) {
			animalModel.die();
		}
		assertTrue(GameChecker.gameOver(animalModel));
	}
	
}
