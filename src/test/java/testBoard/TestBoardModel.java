package testBoard;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import scene.model.BoardModel;

public class TestBoardModel {

	BoardModel boadModel = new BoardModel(1000, 3, 2);
	
	@Test
	public void testConstructor() {
		assertEquals(1000, boadModel.getScore());
		assertEquals(3, boadModel.getLives());
		assertEquals(2, boadModel.getLevel());
	}
	
	@Test
	public void testScoreSet_Get() {
		boadModel.setScore(1001);
		assertEquals(1001, boadModel.getScore());
	}
	
	@Test
	public void testLivesSet_Get() {
		boadModel.setLives(0);
		assertEquals(0, boadModel.getLives());
	}
	
	@Test
	public void testLevelSet_Get() {
		boadModel.setLevel(4);
		assertEquals(4, boadModel.getLevel());
	}
	
	@Test
	public void testHighestScoreSet_Get() {
		boadModel.setHighestScore(9999);
		assertEquals(9999, boadModel.getHighestScore());
	}

}
