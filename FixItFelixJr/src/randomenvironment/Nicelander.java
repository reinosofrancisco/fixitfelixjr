package randomenvironment;

import building.Building;
import entities.Felix;
import util.Dimentions;
import util.GameConstants;
import util.Vector2D;

public class Nicelander {
	
	//private static final int COOLDOWN=0;
	
	
	Vector2D pos;
	int screenTime=GameConstants.NICELANDER_SCREENTIME;
	int cakeTime=GameConstants.NICELANDER_CAKETIME;
	static int nicelanderCooldown=0;
	

	public Nicelander() {
		nicelanderCooldown=GameConstants.NICELANDER_COOLDOWN;
	}
	
	public Nicelander(Vector2D pos) {
		this.pos = pos;
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

//	/**Returns TRUE if Out of Bounds */
//	public boolean detectOutOfBounds() {
//		return !(((this.pos.getPosx()>=Dimentions.LEFT_LIMITS)&&(this.pos.getPosx()<=Dimentions.RIGHT_LIMITS)
//				&&((this.pos.getPosy()>=Dimentions.DOWN_LIMITS)&&(this.pos.getPosy()<=Dimentions.UP_LIMITS))));
//	}

	private boolean isColliding() {
		Felix f=Felix.getInstnance();
		if(screenTime<cakeTime && pos.isColiding(f.getVector2D())) {
			f.giveInmunity(GameConstants.FELIX_INMUNE);
			Building.getInstance().removeNicelander(this);
			return true;
		}
		return false;
	}
	
	public static void update() {
		if (nicelanderCooldown>0) {
			nicelanderCooldown--;			
		}
	}
	
	public boolean updateInstance() {
		if (cakeTime>0) {
			cakeTime--;
		}
		if (screenTime>0) {
			screenTime--;			
		}
		return isColliding();
	}

	public static int getCooldown() {
		return nicelanderCooldown;
	}
	
	
	
	
	

}
