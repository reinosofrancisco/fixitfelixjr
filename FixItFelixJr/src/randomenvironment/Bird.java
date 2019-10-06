package randomenvironment;

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
	
	/**Moves the Bird on the current Direction */
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

//	/**If OOB, i flip direction  */
//	public void behaviourOOB(LinkedList<Bullet> deleteBullets) {
//		if (this.detectOutOfBounds()) {
//			if (this.direction == Direction.RIGHT) {
//				this.direction = Direction.LEFT;
//			}else this.direction = Direction.RIGHT;
//		}
//}
	

}
