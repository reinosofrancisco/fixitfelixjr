package randomenvironment;

import java.util.LinkedList;

import util.Direction;

public class Brick extends Bullet {
	
	private final Direction direction = Direction.DOWN;

	public Direction getDirection() {
		return direction;
	}
	
	/**Moves the Brick down 1 Vector2D in Y.	*/
	public void move() {
		this.vector2D = this.vector2D.add(Direction.DOWN.getUnitVector());
	}
	
	public void behaviourOOB(LinkedList<Bullet> deleteBullets){
		if (this.detectOutOfBounds())
			deleteBullets.addFirst(this);
		
	}
	
	
}


