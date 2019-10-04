package randomenvironment;

import java.util.LinkedList;

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
	
	/**Moves the Bird one Vector2D to left / right 
	 * NO VERIFICA NADA*/
	public void move(Direction dir) {
		this.direction = dir;
		if ((this.direction == Direction.LEFT)||(this.direction == Direction.LEFT))
			this.vector2D.add(this.direction.getUnitVector());
	}
	
	/**Moves the Bird on the current Direction */
	public void move() {
		this.direction.getUnitVector();
		this.vector2D = this.vector2D.add(this.direction.getUnitVector());
		//this.vector2D = this.vector2D.add(this.vector2D); La suma de vectores SI funciona
	}
	
	/**If OOB, i flip  */
	public void behaviourOOB(LinkedList<Bullet> deleteBullets) {
		if (this.detectOutOfBounds()) {
			if (this.direction == Direction.RIGHT) {
				this.direction = Direction.LEFT;
			}else this.direction = Direction.RIGHT;
		}
		
	}

}
