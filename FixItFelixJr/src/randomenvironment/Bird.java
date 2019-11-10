package randomenvironment;

import entities.Felix;
import game.Core;
import util.Direction;
import util.Vector2D;

public class Bird extends Bullet {
	//locked to Left and Right (3 y 4)
	private Direction direction;

	public Direction getDirection() {
		return direction;
	}

	public void setDirection(Direction direction) {
		this.direction = direction;
	}	
	
	public Bird() {}
	
	public Bird(Vector2D pos) {
		this.setVector2D(pos);
		this.direction = Direction.RIGHT;		
	}
	
	/**
	 * Moves the Bird on the current Direction
	 * @return retorna true si se puedo mover 
	 */
	public boolean move() {
		this.vector2D = this.vector2D.add(this.direction.getUnitVector());
		changeDirection();
		return false;
	}
	

	private void changeDirection() {
		if(this.detectOutOfBounds()) {
			this.direction= this.direction==Direction.RIGHT ? Direction.LEFT:Direction.RIGHT;
		}
	}

	public void update() {
		move();
		Felix f= Felix.getInstnance();
		System.out.println("[BIRD] After moving i am in position  " + getVector2D().toString());
		if (isColliding(f.getVector2D())) {
			f.collidedBird();
			Core.getInstance().birdHit();
			//RandomEnvironment.getInstance().deleteBird(this);
		}
		
	}

	
	//PREGUNTAR DESPUES
	@Override
	public int getType() {
		// TODO Auto-generated method stub
		return Bullet.BIRD;
	}
}
