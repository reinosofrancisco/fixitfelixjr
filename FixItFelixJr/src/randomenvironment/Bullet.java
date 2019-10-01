package randomenvironment;

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
	
}
