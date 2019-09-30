package felix.game.RandomEnvironment;

import felix.game.utilities.*;

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
		
	}
	
	/**Moves the Bird one Vector2D to left / right 
	 * NO VERIFICA NADA*/
	public void move(Direction dir) {
		this.direction = dir;
		if ((this.direction == Direction.LEFT)||(this.direction == Direction.LEFT))
			this.vector2D.add(this.direction.getUnitVector());
	}

}
