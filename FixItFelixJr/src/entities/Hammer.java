package entities;

import util.GameConstants;

/*
 * The idea behind having a hammer class is for it storage its cooldown
 * la idea detrás de tener una clase martillo es guardar el cooldown del mismo
 * entre golpe y golpe
 * 
 */
public class Hammer {

	private final int cooldownAmmount=GameConstants.FELIX_HAMMER_COOLDOWN;
	private int cooldown=0;
	private static Hammer INSTANCE;
	
	private Hammer() {
		
		
	}
	
	
	public static Hammer getInstance() {
		if (INSTANCE==null) {
			INSTANCE=new Hammer();
		}
		return INSTANCE;
		
	}
	
	
	//retorna true si pudo arreglar y resetea el cooldown
	//false en caso contrario
	public boolean fix() {
		if(canFix()) {
			cooldown+=cooldownAmmount;
			return true;
		}
		else {
			return false;
		}
	}
	//retorna si puede arreglar
	public boolean canFix() {
		return cooldown==0;
	}
	//updatea el cooldown
	public void update() {
		if(cooldown>0) {
			cooldown--;			
		}
	}
	
}
