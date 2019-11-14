package entities;

import exceptions.HammerOnCooldownExeption;
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
	public void fix() throws HammerOnCooldownExeption {
		canFix();
		System.out.println("aaaaa");
		cooldown+=cooldownAmmount;
	}
	//retorna si puede arreglar
	public void canFix() throws HammerOnCooldownExeption {
		if (cooldown!=0)
		{
			throw new HammerOnCooldownExeption();
		}
	}
	//updatea el cooldown
	public void update() {
		if(cooldown>0) {
			cooldown--;			
		}
	}


	public void restartGame() {
		cooldown=0;
		
	}
	
}
