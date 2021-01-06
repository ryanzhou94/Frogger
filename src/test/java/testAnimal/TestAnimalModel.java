package testAnimal;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import objects.animal.AnimalModel;

public class TestAnimalModel {

	AnimalModel animalModel = new AnimalModel();
	
	@Test
	public void testConstructor() {
		assertEquals(5, animalModel.getLives());
		assertEquals(0, animalModel.getScore());
		assertEquals(0, animalModel.getStatus());
		assertEquals(0, animalModel.getEnds());
		assertEquals(800, animalModel.getHighestPosition());
	}
	
	@Test 
	public void testNextLevel() {
		animalModel.nextLevel();
		assertEquals(0, animalModel.getStatus());
		assertEquals(0, animalModel.getEnds());
	}
	
	@Test
	public void testReachEnd() {
		int end = animalModel.getEnds();
		animalModel.reachEnd();
		assertEquals(end + 1, animalModel.getEnds());
	}
	
	@Test
	public void testReachWrongEnd() {
		int end = animalModel.getEnds();
		animalModel.reachEnd();
		animalModel.reachWrongEnd();
		assertEquals(end, animalModel.getEnds());
	}
	
	@Test
	public void testDie() {
		int lives = animalModel.getLives();
		animalModel.die();
		assertEquals(lives - 1, animalModel.getLives());
	}
	
	@Test
	public void testIncreaseScore() {
		int score = animalModel.getScore();
		animalModel.increasePoints(1000);
		assertEquals(score + 1000, animalModel.getScore());
	}
	
	@Test
	public void testScoreSet_Get() {
		animalModel.setScore(500);
		assertEquals(500, animalModel.getScore());
	}
	
	@Test
	public void testStatusSet_Get() {
		animalModel.setStatus(1);
		assertEquals(1, animalModel.getStatus());
		assertTrue(animalModel.isNoMove());
	}
	
	@Test
	public void testHighPositionSet_Get() {
		animalModel.setHighestPosition(300);
		assertEquals(300, animalModel.getHighestPosition());
	}
	
}
