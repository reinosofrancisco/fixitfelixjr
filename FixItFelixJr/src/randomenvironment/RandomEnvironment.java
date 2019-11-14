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
		bullets.add(new Brick());
	}

	public void update() {
		for (Bullet bullet : bullets) {
			bullet.update();
		}
	}

	/**
	 * Vuelve todas las Variables de instancia a su estado original, para poder volver a jugar
	 */
	public void restartEntities() {

		bullets = new LinkedList<Bullet>();
		addBirds();

	}

	public void deleteBrick(Brick brick) {
		bullets.remove(brick);

	}
}
