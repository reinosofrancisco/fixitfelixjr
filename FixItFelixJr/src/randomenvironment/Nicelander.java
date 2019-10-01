package randomenvironment;

import util.Vector2D;

public class Nicelander {
	Vector2D pos;
	int screenTime;
	

	public Nicelander() {};
	
	public Nicelander(Vector2D pos, int screenTime) {
		super();
		this.pos = pos;
		this.screenTime = screenTime;
	}
	
	public Vector2D getPos() {
		return pos;
	}
	public void setPos(Vector2D pos) {
		this.pos = pos;
	}
	public int getScreenTime() {
		return screenTime;
	}
	public void setScreenTime(int screenTime) {
		this.screenTime = screenTime;
	}
	
	
	

}
