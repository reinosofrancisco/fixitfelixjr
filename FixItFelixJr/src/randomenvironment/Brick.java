package randomenvironment;


import entities.Felix;
import entities.Ralph;
import game.Core;
import game.Difficulty;
import util.Direction;
import util.GameConstants;
import util.Vector2D;

public class Brick extends Bullet {
	
	private final Direction direction = Direction.DOWN;
	private double mult;
	private static int cooldown = 0;
	

	public Brick() {
		mult=Difficulty.getInstance().getDifficulty();
		super.setVector2D(new Vector2D(Ralph.getInstance().getPos()));
		cooldown=GameConstants.BRICK_COOLDOWN;
	}
	
	public Direction getDirection() {
		return direction;
	}
	
	public void setMult(double m) {
		mult=m;
	}

	/**
	 * Mueve al ladrilo (Solo un Y, para abajo)
	 * @return retorna true, si se pudo mover
	 */
	public boolean move() {
		this.vector2D = this.vector2D.add(Direction.DOWN.getUnitVector().product(mult*.2));
		return detectOutOfBounds();
		
	}
	public static int getCooldown() {
		return cooldown;
	}
	
	public static void updateCooldown() {
		if(cooldown>0) {
			cooldown--;
		}
	}

	public void update() {
		Felix f = Felix.getInstnance();
		// if i collide with felix or get out of the map after moving
		if (isColliding(f.getVector2D())) {
			f.collidedBrick();		
			Core.getInstance().brickHit();
			RandomEnvironment.getInstance().deleteBrick(this);
		}
		if(move()) {
			RandomEnvironment.getInstance().deleteBrick(this);
		}
		System.out.println("[BRICK] After moving i am in position  " + getVector2D().toString());					
	}
	@Override
	public int getType() {
		return Bullet.BRICK;
	}
	
}


