package randomenvironment;

import java.util.LinkedList;

import util.Dimentions;
import util.Vector2D;

public abstract class Bullet {
	
	Vector2D vector2D;
	
	public Vector2D getVector2D() {
		return vector2D;
	}

	public void setVector2D(Vector2D vector2D) {
		Vector2D pos = new Vector2D(vector2D);
		this.vector2D = pos;
	}
	
	/**Returns TRUE if Out of Bounds */
	public boolean detectOutOfBounds() {
		return !(((this.vector2D.getPosx()>=Dimentions.LEFT_LIMITS)&&(this.vector2D.getPosx()<=Dimentions.RIGHT_LIMITS)
				&&((this.vector2D.getPosy()>=Dimentions.RIGHT_LIMITS)&&(this.vector2D.getPosy()<=Dimentions.UP_LIMITS))));
	}
	
	public abstract void behaviourOOB(LinkedList<Bullet> deleteBullets);
	
	public void move() {}
	
}
