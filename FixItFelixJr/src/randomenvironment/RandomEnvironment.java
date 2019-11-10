package randomenvironment;

import java.util.LinkedList;
import java.util.List;

import util.Dimentions;
import util.Vector2D;

public class RandomEnvironment {

	LinkedList<Bullet> bullets = new LinkedList<>();

	private static RandomEnvironment INSTANCE;

	private RandomEnvironment() {
		addBirds();
	}

	private void addBirds() {
		bullets.addFirst(new Bird(new Vector2D(Dimentions.RIGHT_LIMITS, Dimentions.UP_LIMITS)));
		bullets.addFirst(new Bird(new Vector2D(Dimentions.LEFT_LIMITS, Dimentions.UP_LIMITS - 1)));
	}

	public static RandomEnvironment getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new RandomEnvironment();
		}
		return INSTANCE;
	}

	// ------------------------------------------//
	//  Getters for the graphic
	// ------------------------------------------//
	public List<Bullet> getBullets() {
		return bullets;
	}

	// ------------------------------------------//
	// Summoning
	// ------------------------------------------//

	/** Summons an amount of 'Brick' to a linkedList */
	public void summonBricks() {
//		int i;
//		for( i = 0; i<bricksAmount; i++) {
//			Brick brick = new Brick(dif);
//			brick.setVector2D(pos);
//			bricks.addFirst(brick);		/**Always ADD FIRST */
//		}	
//		System.out.println("Summoning " + bricksAmount + " Bricks on " + pos.toString());	
//		setBricksCooldown(genericCD);
		bullets.add(new Brick());
	}

	public void update() {
		for (Bullet bullet : bullets) {
			bullet.update();
		}
	}

	public void restartEntities() {

		bullets = new LinkedList<Bullet>();
		addBirds();

	}

	public void deleteBrick(Brick brick) {
		bullets.remove(brick);

	}
	
}
