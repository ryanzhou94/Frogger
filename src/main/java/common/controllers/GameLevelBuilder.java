package common.controllers;

import objects.animal.Animal;
import objects.physicalobject.BigTrunk;
import objects.physicalobject.Bonus;
import objects.physicalobject.Car;
import objects.physicalobject.Crocodile;
import objects.physicalobject.End;
import objects.physicalobject.Log;
import objects.physicalobject.Seal;
import objects.physicalobject.Snake;
import objects.physicalobject.Trunk;
import objects.physicalobject.Turtle;
import objects.physicalobject.WetTurtle;
import scene.view.World;

/**
 * This class builds all level worlds for the game and provides the interface for game designers to make changes on the game.
 * <p>
 * All configure is set up in this class. 
 * All methods are static 
 * It constructs specific worlds with added game objects including instance of Animal.
 * It intensively controls all levels of game.
 * Currently, there is only 4 levels in this game.
 * 
 * @author ryan
 *
 */
public class GameLevelBuilder {
	
	/**
	 * Builds a specific World based on the level.
	 * <p>
	 * It only accepts level from 1 to 4.
	 * If the level parameter is less than 1 or greater than 4, it print an error message to the console and return null.
	 * <ul>
	 * <li>Level 1: Easy and friendly to beginners.
	 * <li>Level 2: The speed of game objects are normal, needs a bit of practice.
	 * <li>Level 3: Hard. Needs excellent reflexes and speed.
	 * <li>Level 4: Hell. No one has succeeded in this level. Good luck!
	 * <li>To be continue...
	 * </ul>
	 * 
	 * @param level level of the game (from 1 to 4)
	 * @return a constructed World 
	 */
	public static World builWorld(int level) {
		World world = null;
		switch (level) {
		case 1:{
			world = buildLevel1();
			break;
		}
		case 2:
			world = buildLevel2();
			break;
		case 3:
			world = buildLevel3();
			break;
		case 4:
			world = buildLevel4();
			break;
		default:
			System.out.println("No Such A Level of Game");
			break;
		}
		return world;
	}
	
	/**
	 * Builds a world in level 1.
	 * <p>
	 * In level one, the speeds of every objects have been slowed down.
	 * It has more normal turtle than wet turtle.
	 * There is no crocodile or snake in this level.
	 * If you can't make it, just be patient and practice.
	 * 
	 * @return a World in level 1
	 */
	public static World buildLevel1() {
		World world = new World();
		world.add(new Trunk(0, 649, 120, 120, 1));
//		world.add(new Trunk(300, 649, 120, 120, 1));
		world.add(new Trunk(600, 649, 120, 120, 1));
		world.add(new BigTrunk(0, 540, 200, 200, 1));
		world.add(new BigTrunk(500, 540, 200, 200, 1));
		world.add(new Car(100, 597, 50, 50, -1));
		world.add(new Car(250, 597, 50, 50, -1));
//		world.add(new Car(400, 597, 50, 50, -1));
		world.add(new Car(550, 597, 50, 50, -1));
		world.add(new Car(500, 490, 50, 50, -4));
		world.add(new Turtle(700, 376, 130, 130, -1));
		world.add(new WetTurtle(600, 217, 130, 130, -1));
		world.add(new Turtle(400, 217, 130, 130, -1));
		world.add(new Turtle(200, 217, 130, 130, -1));
		world.add(new WetTurtle(500, 376, 130, 130, -1));
		world.add(new Turtle(300, 376, 130, 130, -1));
		world.add(new Log("file:src/main/resources/log3.png", 150, 150, 0, 166, 0.75));
		world.add(new Log("file:src/main/resources/log3.png", 150, 150, 220, 166, 0.75));
		world.add(new Log("file:src/main/resources/log3.png", 150, 150, 440, 166, 0.75));
		world.add(new Log("file:src/main/resources/logs.png", 300, 300, 0, 276, -2));
		world.add(new Log("file:src/main/resources/logs.png", 300, 300, 400, 276, -2));
		world.add(new Log("file:src/main/resources/log3.png", 150, 150, 50, 329, 0.75));
		world.add(new Log("file:src/main/resources/log3.png", 150, 150, 270, 329, 0.75));
		world.add(new Log("file:src/main/resources/log3.png", 150, 150, 490, 329, 0.75));
		world.add(new End(13,96));
		world.add(new End(141,96));
		world.add(new End(141 + 141-13,96));
		world.add(new End(141 + 141-13+141-13+1,96));
		world.add(new End(141 + 141-13+141-13+141-13+3,96));
		world.add(new Bonus(285, 115, 30));
		world.add(Animal.getInstace());
		SpeedController.setObjectSpeedInRatio(world, Log.class, 0.8);
		SpeedController.setObjectSpeedInRatio(world, Car.class, 0.8);
		SpeedController.setObjectSpeedInRatio(world, WetTurtle.class, 0.8);
		SpeedController.setObjectSpeedInRatio(world, Turtle.class, 0.8);
		printSpeed(world);
		return world;
	}
	
	/**
	 * Builds a world in level 1.
	 * <p>
	 * In level two, the speeds of every objects are normal.
	 * Crocodiles are added to this level of game.
	 * If you can't make it, just be patient and practice.
	 * 
	 * @return a World in level 2
	 */
	public static World buildLevel2() {
		World world = new World();
		world.add(new Trunk(0, 649, 120, 120, 1));
		world.add(new Trunk(300, 649, 120, 120, 1));
		world.add(new Trunk(600, 649, 120, 120, 1));
		world.add(new BigTrunk(0, 540, 200, 200, 1));
		world.add(new BigTrunk(500, 540, 200, 200, 1));
		world.add(new Car(100, 597, 50, 50, -1));
		world.add(new Car(250, 597, 50, 50, -1));
		world.add(new Car(400, 597, 50, 50, -1));
		world.add(new Car(550, 597, 50, 50, -1));
		world.add(new Car(500, 490, 50, 50, -5));
		world.add(new Turtle(700, 376, 130, 130, -1));
		world.add(new Turtle(600, 217, 130, 130, -1));
		world.add(new Turtle(400, 217, 130, 130, -1));
		world.add(new WetTurtle(200, 217, 130, 130, -1));
		world.add(new WetTurtle(500, 376, 130, 130, -1));
		world.add(new Turtle(300, 376, 130, 130, -1));
		world.add(new Log("file:src/main/resources/log3.png", 150, 150, 0, 166, 0.75));
		
//		world.add(new Log("file:src/main/resources/log3.png", 150, 150, 220, 166, 0.75));
		world.add(new Log("file:src/main/resources/log3.png", 150, 150, 440, 166, 0.75));
		world.add(new Log("file:src/main/resources/logs.png", 300, 300, 0, 276, -2));
		world.add(new Log("file:src/main/resources/logs.png", 300, 300, 400, 276, -2));
		world.add(new Log("file:src/main/resources/log3.png", 150, 150, 50, 329, 0.75));
		world.add(new Crocodile(270, 325, 150, 150, 0.75));
		world.add(new Crocodile(490, 325, 150, 150, 0.75));
//		world.add(new Log("file:src/main/resources/log3.png", 150, 150, 270, 329, 0.75));
//		world.add(new Log("file:src/main/resources/log3.png", 150, 150, 490, 329, 0.75));
		world.add(new End(13,96));
		world.add(new End(141,96));
		world.add(new End(141 + 141-13,96));
		world.add(new End(141 + 141-13+141-13+1,96));
		world.add(new End(141 + 141-13+141-13+141-13+3,96));
		world.add(new Bonus(32, 115, 30));
		world.add(Animal.getInstace());
		SpeedController.setObjectSpeedInRatio(world, Log.class, 1.25);
		SpeedController.setObjectSpeedInRatio(world, Crocodile.class, 1.25);
		SpeedController.setObjectSpeedInRatio(world, Turtle.class, 1.25);
		SpeedController.setObjectSpeedInRatio(world, WetTurtle.class, 1.25);
		printSpeed(world);
		return world;
	}
	
	/**
	 * Builds a world in level 3
	 * <p>
	 * In level 3, the speeds of every objects have been accelerated about 60%.
	 * It has more wet turtle than normal turtle.
	 * Snakes are added to this level of game.
	 * Be careful with cars. They are crazy.
	 * 
	 * @return a World in level 3
	 */
	public static World buildLevel3() {
		World world = new World();
		world.add(new Trunk(0, 649, 120, 120, 1));
		world.add(new Trunk(300, 649, 120, 120, 1));
		world.add(new Trunk(600, 649, 120, 120, 1));
		world.add(new BigTrunk(0, 540, 200, 200, 1));
		world.add(new BigTrunk(500, 540, 200, 200, 1));
		world.add(new Car(100, 597, 50, 50, -2));
		world.add(new Car(250, 597, 50, 50, -2));
		world.add(new Car(400, 597, 50, 50, -2));
		world.add(new Car(550, 597, 50, 50, -2));
		world.add(new Car(500, 490, 50, 50, -6));
		world.add(new Turtle(700, 376, 130, 130, -1));
		world.add(new WetTurtle(600, 217, 130, 130, -1));
		world.add(new Turtle(400, 217, 130, 130, -1));
		world.add(new WetTurtle(200, 217, 130, 130, -1));
		world.add(new WetTurtle(500, 376, 130, 130, -1));
		world.add(new Turtle(300, 376, 130, 130, -1));
//		world.add(new Log("file:src.main.resources/images/log3.png", 150, 150, 0, 166, 0.75));
		world.add(new Crocodile(0, 158, 150, 150, 0.75));
		world.add(new Log("file:src/main/resources/log3.png", 150, 150, 220, 166, 0.75));
		world.add(new Log("file:src/main/resources/log3.png", 150, 150, 440, 166, 0.75));
		world.add(new Log("file:src/main/resources/logs.png", 300, 300, -50, 276, -2));
		world.add(new Log("file:src/main/resources/logs.png", 300, 300, 350, 276, -2));
		world.add(new Log("file:src/main/resources/log3.png", 150, 150, 50, 329, 0.75));
		world.add(new Crocodile(270, 325, 150, 150, 0.75));
		world.add(new Seal(-140, 173, 55, 60, 0.75));
		world.add(new Seal(-50, 340, 55, 60, 0.75));
//		world.add(new Log("file:src/main/resources/log3.png", 150, 150, 270, 329, 0.75));
		world.add(new Log("file:src/main/resources/log3.png", 150, 150, 490, 329, 0.75));
//		world.add(new Snake(350, 440, 55, 55, -1));
		world.add(new End(13,96));
		world.add(new End(141,96));
		world.add(new End(141 + 141-13,96));
		world.add(new End(141 + 141-13+141-13+1,96));
		world.add(new End(141 + 141-13+141-13+141-13+3,96));
		world.add(new Bonus(546, 115, 30));
		world.add(Animal.getInstace());
		SpeedController.setObjectSpeedInRatio(world, Seal.class, 1.6);
		SpeedController.setObjectSpeedInRatio(world, Log.class, 1.6);
		SpeedController.setObjectSpeedInRatio(world, Snake.class, 1.5);
		SpeedController.setObjectSpeedInRatio(world, Crocodile.class, 1.6);
		SpeedController.setObjectSpeedInRatio(world, Car.class, 1.2);
		SpeedController.setObjectSpeedInRatio(world, Turtle.class, 1.8);
		SpeedController.setObjectSpeedInRatio(world, WetTurtle.class, 1.8);
		printSpeed(world);
		return world;
	}
	
	/**
	 * Builds a world in level 4
	 * <p>
	 * Good luck to you.
	 * It is the hell.
	 * 
	 * @return a World in level 4
	 */
	public static World buildLevel4() {
		World world = new World();
		world.add(new Trunk(0, 649, 120, 120, 1));
		world.add(new Trunk(300, 649, 120, 120, 1));
		world.add(new Trunk(600, 649, 120, 120, 1));
		world.add(new BigTrunk(0, 540, 200, 200, 1));
		world.add(new BigTrunk(500, 540, 200, 200, 1));
		world.add(new Car(100, 597, 50, 50, -2));
		world.add(new Car(250, 597, 50, 50, -2));
		world.add(new Car(400, 597, 50, 50, -2));
		world.add(new Car(550, 597, 50, 50, -2));
		world.add(new Car(500, 490, 50, 50, -8));
		world.add(new WetTurtle(700, 376, 130, 130, -1));
		world.add(new WetTurtle(600, 217, 130, 130, -1));
		world.add(new Turtle(400, 217, 130, 130, -1));
		world.add(new WetTurtle(200, 217, 130, 130, -1));
		world.add(new WetTurtle(500, 376, 130, 130, -1));
		world.add(new Turtle(300, 376, 130, 130, -1));
		world.add(new Crocodile(0, 158, 150, 150, 0.75));
		world.add(new Log("file:src/main/resources/log3.png", 150, 150, 220, 166, 0.75));
//		world.add(new Log("file:src/main/resources/log3.png", 150, 150, 440, 166, 0.75));
		world.add(new Seal(540, 175, 55, 60, 0.75));
		world.add(new Log("file:src/main/resources/logs.png", 300, 300, 0, 276, -2.25));
		world.add(new Log("file:src/main/resources/logs.png", 300, 300, 400, 276, -2.25));
//		world.add(new Log("file:src/main/resources/log3.png", 150, 150, 50, 329, 0.75));
		world.add(new Crocodile(50, 325, 150, 150, 0.75));
//		world.add(new Crocodile(270, 325, 150, 150, 0.75));
		world.add(new Crocodile(490, 325, 150, 150, 0.75));
		world.add(new Log("file:src/main/resources/log3.png", 150, 150, 270, 329, 0.75));
//		world.add(new Log("file:src/main/resources/log3.png", 150, 150, 490, 329, 0.75));
		world.add(new Snake(350, 440, 55, 55, -1));
		world.add(new End(13,96));
		world.add(new End(141,96));
		world.add(new End(141 + 141-13,96));
		world.add(new End(141 + 141-13+141-13+1,96));
		world.add(new End(141 + 141-13+141-13+141-13+3,96));
		world.add(new Bonus(416, 115, 30));
		world.add(new Bonus(32, 115, 30));
		world.add(Animal.getInstace());
		SpeedController.setObjectSpeedInRatio(world, Seal.class, 1.8);
		SpeedController.setObjectSpeedInRatio(world, Log.class, 1.8);
		SpeedController.setObjectSpeedInRatio(world, Snake.class, 2.5);
		SpeedController.setObjectSpeedInRatio(world, Crocodile.class, 1.8);
		SpeedController.setObjectSpeedInRatio(world, Car.class, 1.35);
		SpeedController.setObjectSpeedInRatio(world, Turtle.class, 2);
		SpeedController.setObjectSpeedInRatio(world, WetTurtle.class, 2);
		printSpeed(world);
		return world;
	}
	
	/**
	 * Prints information about the speed of all movable game objects.
	 * 
	 * @param world the world that game objects are in
	 */
	public static void printSpeed(World world) {
		System.out.println("-----------------------------------");
		System.out.println("Wet turtle speed \t= " + SpeedController.getObjectSpeed(world, WetTurtle.class));
		System.out.println("Turtle speed \t\t= " + SpeedController.getObjectSpeed(world, Turtle.class));
		System.out.println("Log speed \t\t= " + SpeedController.getObjectSpeed(world, Log.class));
		System.out.println("Car speed \t\t= " + SpeedController.getObjectSpeed(world, Car.class));
		System.out.println("Trunk speed \t\t= " + SpeedController.getObjectSpeed(world, Trunk.class));
		System.out.println("Big Trunk speed \t= " + SpeedController.getObjectSpeed(world, BigTrunk.class));
		System.out.println("-----------------------------------");
	}
	
	
	
}
