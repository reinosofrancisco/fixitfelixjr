package randomenvironment;

import util.Dimentions;
import util.Vector2D;

public class Nicelander {
	Vector2D pos;
	int screenTime;
	int cakeTime;
	

	public Nicelander() {};
	
	public Nicelander(Vector2D pos, int screenTime,int cakeTime) {
		super();
		this.pos = pos;
		this.screenTime = screenTime;
		this.cakeTime=cakeTime;
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
	
	public int getCakeTime() {
		return cakeTime;
	}

	public void setCakeTime(int cakeTime) {
		this.cakeTime = cakeTime;
	}

	/**Returns TRUE if Out of Bounds */
	public boolean detectOutOfBounds() {
		return !(((this.pos.getPosx()>=Dimentions.LEFT_LIMITS)&&(this.pos.getPosx()<=Dimentions.RIGHT_LIMITS)
				&&((this.pos.getPosy()>=Dimentions.DOWN_LIMITS)&&(this.pos.getPosy()<=Dimentions.UP_LIMITS))));
	}

	public boolean isColliding(Vector2D felixVector) {
		if(screenTime<cakeTime) {
			return pos.isColiding(felixVector);
		}
		return false;
	}
	
	
	
	
	

}
