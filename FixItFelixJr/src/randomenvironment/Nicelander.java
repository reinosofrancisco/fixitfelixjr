package randomenvironment;

import building.Building;
import entities.Felix;
import util.Dimentions;
import util.GameConstants;
import util.Vector2D;

public class Nicelander {
	
	//private static final int COOLDOWN=0;
	
	
	private Vector2D pos;
	private int screenTime=GameConstants.NICELANDER_SCREENTIME;
	public final static int CAKETIME=GameConstants.NICELANDER_CAKETIME; //la guardo acá para mejor legibilidad de codigo
	private static int nicelanderCooldown=0;
	

	public Nicelander() {
		nicelanderCooldown=GameConstants.NICELANDER_COOLDOWN;
	}
	
	public Nicelander(Vector2D pos) {
		this();
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
	
	private boolean checkCollition() {
		Felix f=Felix.getInstnance();
		if(screenTime<CAKETIME && pos.isColiding(f.getVector2D())) {
			f.giveInmunity(GameConstants.FELIX_INMUNE);
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
		if (screenTime>0) {
			screenTime--;
			return checkCollition();
		}
		else {
			return true;
		}
	}

	public static int getCooldown() {
		return nicelanderCooldown;
	}
	
	
	
	
	

}
