package felix.game.RandomEnvironment;

import felix.game.utilities.Position;

public class Nicelander {
	Position pos;
	int screenTime;
	

	public Nicelander() {};
	
	public Nicelander(Position pos, int screenTime) {
		super();
		this.pos = pos;
		this.screenTime = screenTime;
	}
	
	public Position getPos() {
		return pos;
	}
	public void setPos(Position pos) {
		this.pos = pos;
	}
	public int getScreenTime() {
		return screenTime;
	}
	public void setScreenTime(int screenTime) {
		this.screenTime = screenTime;
	}
	
	
	

}
