package randomenvironment;


import util.Dimentions;
import util.Direction;
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
	
	/**
	 * Returns TRUE if Out of Bounds 
	 */
	public boolean detectOutOfBounds() {
		return !Dimentions.isInsideMap(vector2D);
	}
	/**
	 * @return retorna true, si me movi afuera del mapa
	 */
	public abstract boolean move();
	
	public abstract void update();
	
	//CONSULTAR ESTO
	public static final int BIRD=0;
	public static final int BRICK=1;
	public abstract int getType();
	public Direction getDirection() {
		return Direction.UNDIFINED;
	}
		
	public boolean isColliding(Vector2D v) {
		return vector2D.isColiding(v);
	}
	
	
	
//	public abstract void behaviourOOB(LinkedList<Bullet> deleteBullets);
}
