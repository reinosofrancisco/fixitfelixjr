package randomenvironment;

import util.Dimentions;
import util.Vector2D;

public class Nicelander {
	Vector2D pos;
	int screenTime;
	int cakeTime;
	

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
	
	public int getCakeTime() {
		return cakeTime;
	}

	public void setCakeTime(int cakeTime) {
		this.cakeTime = cakeTime;
	}

	/**Returns TRUE if Out of Bounds */
	public boolean detectOutOfBounds() {
		return !(((this.pos.getPosx()>0)&&(this.pos.getPosx()<Dimentions.WIDTH)
				&&((this.pos.getPosy()>0)&&(this.pos.getPosy()<Dimentions.HEIGHT))));
	}
	
	

	
	
	

}
