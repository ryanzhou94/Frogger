package objects.physicalobject;

import common.interfaces.Changeable;
import common.interfaces.Sinkable;

/**
 * Interface for GameObject's action.
 * 
 * @author ryan
 *
 */
public interface ActionType {
	
	/**
	 * The action that GameObjects does in every frame
	 * 
	 * @param now the current time
	 */
	public void act(long now);
}

/**
 * Obstacle action controller.
 * 
 * @author ryan
 *
 */
class ObstacleAction implements ActionType{
	
	/**
	 * Controlled Obstacle.
	 */
	private Obstacle obstacle;
	
	public ObstacleAction(Obstacle obstacle) {
		this.obstacle = obstacle;
	}
	
	/**
	 * Obstacle moves at its speed. When it gets out of the boundary, reset the position.
	 * 
	 * @param now the current time
	 */
	@Override
	public void act(long now) {
		obstacle.move(obstacle.getSpeed() , 0);
		if (obstacle.getX() > 600 && obstacle.getSpeed()>0)
			obstacle.setX(-200);
		if (obstacle.getX() < -50 && obstacle.getSpeed()<0)
			obstacle.setX(600);
	}
}

/**
 * Car action controller.
 * 
 * @author ryan
 *
 */
class CarAction implements ActionType{
	
	/**
	 * Controlled Car.
	 */
	private Car car;
	
	public CarAction(Car car) {
		this.car = car;
	}

	/**
	 * Car moves at its speed. When it gets out of the boundary, resets the position.
	 * 
	 * @param now the current time
	 */
	@Override
	public void act(long now) {
		car.move(car.getSpeed() , 0);
		if (car.getX() > 600 && car.getSpeed()>0)
			car.setX(-200);
		if (car.getX() < -50 && car.getSpeed()<0)
			car.setX(600);
	}
}

/**
 * Trunk action controller.
 * 
 * @author ryan
 *
 */
class TrunkAction implements ActionType{
	
	/**
	 * Controlled Trunk.
	 */
	private Trunk trunk;
	
	public TrunkAction(Trunk trunk) {
		this.trunk = trunk;
	}

	/**
	 * Trunk moves at its speed. When it gets out of the boundary, resets the position.
	 * 
	 * @param now the current time
	 */
	@Override
	public void act(long now) {
		trunk.move(trunk.getSpeed() , 0);
		if (trunk.getX() > 600 && trunk.getSpeed()>0)
			trunk.setX(-200);
		if (trunk.getX() < -50 && trunk.getSpeed()<0)
			trunk.setX(600);
	}
}

/**
 * BigTrunk action controller.
 * 
 * @author ryan
 *
 */
class BigTrunkAction implements ActionType{
	
	/**
	 * Controlled Trunk.
	 */
	private BigTrunk bigTrunk;
	
	public BigTrunkAction(BigTrunk bigTrunk) {
		this.bigTrunk = bigTrunk;
	}

	/**
	 * BigTrunk moves at its speed. When it gets out of the boundary, resets the position.
	 * 
	 * @param now the current time
	 */
	@Override
	public void act(long now) {
		bigTrunk.move(bigTrunk.getSpeed() , 0);
		if (bigTrunk.getX() > 600 && bigTrunk.getSpeed()>0)
			bigTrunk.setX(-200);
		if (bigTrunk.getX() < -50 && bigTrunk.getSpeed()<0)
			bigTrunk.setX(600);
	}
}


/**
 * Turtle action controller
 * 
 * @author ryan
 *
 */
class TurtleAction implements ActionType, Changeable{

	/**
	 * Controlled Turtle.
	 */
	private Turtle turtle;
	
	public TurtleAction(Turtle turtle) {
		this.turtle = turtle;
	}
	
	
	/**
	 * Turtle moves at its speed. When it gets out of the boundary, resets the position.
	 * 
	 * @param now the current time
	 */
	@Override
	public void act(long now) {
		changeImage(now);
		turtle.move(turtle.getSpeed() , 0);
		if (turtle.getX() > 600 && turtle.getSpeed()>0)
			turtle.setX(-200);
		if (turtle.getX() < -75 && turtle.getSpeed()<0)
			turtle.setX(600);
	}

	/**
	 * Set the images for Turtle on current time
	 * <p>
	 * It changes in every 3s.
	 * 
	 * @param now the current time
	 */
	@Override
	public void changeImage(long now) {
		if (now/900000000  % 3 ==0) {
			turtle.setImage(turtle.getTurtleImages()[0]);
		}
		else if (now/900000000 % 3 == 1) {
			turtle.setImage(turtle.getTurtleImages()[1]);
		}
		else if (now/900000000 %3 == 2) {
			turtle.setImage(turtle.getTurtleImages()[2]);
		}
	}
}

/**
 * WetTurtle action controller
 * 
 * @author ryan
 *
 */
class WetTurtleAction implements ActionType, Sinkable, Changeable{

	/**
	 * Controlled WetTurtle 
	 */
	private WetTurtle wetTurtle;
	
	public WetTurtleAction(WetTurtle wetTurtle) {
		this.wetTurtle = wetTurtle;
	}
	
	
	/**
	 * WetTurtle moves at its speed. When it gets out of the boundary, resets the position.
	 * 
	 * @param now the current time
	 */
	@Override
	public void act(long now) {
		changeImage(now);
		wetTurtle.move(wetTurtle.getSpeed() , 0);
		if (wetTurtle.getX() > 600 && wetTurtle.getSpeed()>0)
			wetTurtle.setX(-200);
		if (wetTurtle.getX() < -75 && wetTurtle.getSpeed()<0)
			wetTurtle.setX(600);
	}

	/**
	 * Set the images for WetTurtle on current time
	 * <p>
	 * It changes in every 4s.
	 * 
	 * @param now the current time
	 */
	@Override
	public void changeImage(long now) {
		if (now/900000000  % 4 ==0) {
			wetTurtle.setImage(wetTurtle.getWetTurtleImages()[1]);
			emerge();
		}
		else if (now/900000000 % 4 == 1) {
			wetTurtle.setImage(wetTurtle.getWetTurtleImages()[0]);
		}
		else if (now/900000000 %4 == 2) {
			wetTurtle.setImage(wetTurtle.getWetTurtleImages()[2]);
		} 
		else if (now/900000000 %4 == 3) {
			wetTurtle.setImage(wetTurtle.getNoneImage());
			sink();
		}
	}

	/**
	 * Sinks into water and animal cannot stand on it.
	 */
	@Override
	public void sink() {
		wetTurtle.setSunk(true);
	}

	/**
	 * Emerges from water and animal can stand on it.
	 */
	@Override
	public void emerge() {
		wetTurtle.setSunk(false);
	}
}

/**
 * Crocodile action controller.
 * 
 * @author ryan
 *
 */
class CrocodileAction implements ActionType, Changeable{
	
	/**
	 * Controlled Crodile.
	 */
	private Crocodile crocodile;
	
	public CrocodileAction(Crocodile crocodile) {
		this.crocodile = crocodile;
	}

	/**
	 * Crocodile moves at its speed. When it gets out of the boundary, resets the position.
	 * 
	 * @param now the current time
	 */
	@Override
	public void act(long now) {
		changeImage(now);
		crocodile.move(crocodile.getSpeed(), 0);
		if (crocodile.getX()>600 && crocodile.getSpeed()>0)
			crocodile.setX(-220);
		if (crocodile.getX()<-300 && crocodile.getSpeed()<0)
			crocodile.setX(600);
	}

	/**
	 * Set the images of Crocodile based on the current time.
	 * <p>
	 * It opens its mouth for 1s in every 7s and closes its moth for 6s in every 7s.
	 * 
	 * @param now the current time 
	 */
	@Override
	public void changeImage(long now) {
		if (now/900000000  % 7 == 0) {
			crocodile.setImage(crocodile.getCrocodileImages()[0]);
			crocodile.setOpen(true);
		} else {
			crocodile.setImage(crocodile.getCrocodileImages()[1]);
			crocodile.setOpen(false);
		}
	}
	
}

/**
 * Bonus action controller.
 */
class BonusAction implements ActionType, Sinkable, Changeable{
	
	/**
	 * Controlled Bonus.
	 */
	private Bonus bonus;
	
	public BonusAction(Bonus bonus) {
		this.bonus = bonus;
	}

	/**
	 * Bonus doesn't move, it changes images.
	 * 
	 * @param now the current time
	 */
	@Override
	public void act(long now) {
		changeImage(now);
	}

	/**
	 * Set the image of Bonus based on the current time.
	 * <p>
	 * It appears for 2s in every 3s. When it is unavailable, sets it invisible.
	 * 
	 * @param now the current time
	 */
	@Override
	public void changeImage(long now) {
		if (bonus.isAvaliable()) {
			if (now/900000000  % 3 == 0) {
				sink();
				bonus.setImage(bonus.getNoImage());
			} else {
				emerge();
				bonus.setImage(bonus.getBonusImages());
			}
		}else {
			bonus.setImage(bonus.getNoImage());
		}
	}

	/**
	 * Sinks into water and animal cannot get extra pts.
	 */
	@Override
	public void sink() {
		bonus.setActive(false);
	}

	/**
	 * Emerges from water and animal can get extra pts if it gets the bonus.
	 */
	@Override
	public void emerge() {
		bonus.setActive(true);
	}
}

/**
 * Log action controller.
 * 
 * @author ryan
 *
 */
class LogAction implements ActionType {

	/**
	 * Controlled Log.
	 */
	private Log log;
	
	public LogAction(Log log) {
		this.log = log;
	}
	
	/**
	 * Log moves at its speed. When it gets out of the boundary, resets the position.
	 * 
	 * @param now the current time
	 */
	@Override
	public void act(long now) {
		log.move(log.getSpeed() , 0);
		if (log.getX()>600 && log.getSpeed()>0)
			log.setX(-220);
		if (log.getX()<-300 && log.getSpeed()<0)
			log.setX(600);
	}
}

/**
 * Seal action controller.
 * 
 * @author ryan
 *
 */
class SealAction implements ActionType, Sinkable, Changeable{
	
	/**
	 * Controlled Seal.
	 */
	private Seal seal;

	public SealAction(Seal seal) {
		this.seal = seal;
	}
	
	/**
	 * Seal moves at its speed. When it gets out of the boundary, resets the position.
	 * 
	 * @param now the current time
	 */
	@Override
	public void act(long now) {
		seal.move(seal.getSpeed(), 0);
		changeImage(now);
		if (seal.getX()>600 && seal.getSpeed()>0)
			seal.setX(-220);
		if (seal.getX()<-300 && seal.getSpeed()<0)
			seal.setX(600);
	}

	/**
	 * Set the images for Seal on current time
	 * <p>
	 * It changes in every 4s.
	 * 
	 * @param now the current time
	 */
	@Override
	public void changeImage(long now) {
		if (now/900000000  % 4 == 0) {
			sink();
			seal.setImage(seal.getNoneImage());
		} else {
			emerge();
			seal.setImage(seal.getSealImage());
		}
	}

	@Override
	public void sink() {
		seal.setSunk(true);
	}

	@Override
	public void emerge() {
		seal.setSunk(false);
	}
}

/**
 * Snake action controller.
 * 
 * @author ryan
 *
 */
class SnakeAction implements ActionType, Changeable{
	
	/**
	 * Controlled Snake.
	 */
	private Snake snake;
	
	public SnakeAction(Snake snake) {
		this.snake = snake;
	}
	
	/**
	 * Snake only moves on Log with its own speed.
	 * <p>
	 * Normally its speed is greater than Log so that Snake can actually move on Log rather than following Log.
	 * When Snake gets to one end of Log, it turns back with the same value of previous speed. 
	 * It uses World saved in Snake to get all Log objects currently in World and checks if they are instersecting
	 * with Snake. If Snake is intersecting with Log(s), store the reference to the Log, and Snake keeps its 
	 * movement. If no Log is intersecting with Snake, then Snake turns back. This basically implements the 
	 * movement of Snake on Log.
	 * <p>
	 * When Snake disappears in game scene, it truns to be waiting, and waits for new Log because Snake 
	 * can't swim.
	 * When Snake finds a proper Log, the coordinate of Snake will be set with the same coordinate
	 * as new Log.
	 * 
	 * @param now the current time
	 */
	@Override
	public void act(long now) {
		changeImage(now);
		snake.move(snake.getSpeed(), 0);
		if (snake.getX() < 0) {
			changeSpeed();
		} else if (snake.getX() > 600) {
			changeSpeed();
		}
	}

	public void changeSpeed() {
		snake.setSpeed(snake.getSpeed() * (-1));
	}
	
	/**
	 * Set the image of Bonus based on the current time.
	 * <p>
	 * It changes images in every second and it has three images for moving.
	 * 
	 * @param now the current time
	 */
	@Override
	public void changeImage(long now) {
		if (snake.getSpeed() < 0) {
			if (now/900000000  % 3 == 0) {
				snake.setImage(snake.getSnakeImages()[0]);
			} else if (now/900000000 % 3 == 1) {
				snake.setImage(snake.getSnakeImages()[1]);
			} else {
				snake.setImage(snake.getSnakeImages()[2]);
			}
		} else {
			
			if (now/900000000  % 3 == 0) {
				snake.setImage(snake.getSnakeRightImages()[0]);
			} else if (now/900000000 % 3 == 1) {
				snake.setImage(snake.getSnakeRightImages()[1]);
			} else {
				snake.setImage(snake.getSnakeRightImages()[2]);
			}
		}
	}
	
}

