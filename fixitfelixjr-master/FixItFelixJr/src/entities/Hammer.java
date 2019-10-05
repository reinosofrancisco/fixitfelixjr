package entities;

/*
 * The idea behind having a hammer class is for it storage its cooldown
 * la idea detrás de tener una clase martillo es guardar el cooldown del mismo
 * entre golpe y golpe
 * 
 */
public class Hammer {

	private int cooldown=0;
	private final int cooldownAmmount;
	
	Hammer(int cooldwAmm) {
		cooldownAmmount=cooldwAmm;
	}
	
	//retorna true si pudo arreglar y resetea el cooldown
	//false en caso contrario
	public boolean fix() {
		if(canFix()) {
			cooldown+=cooldownAmmount;
		}
		else {
			return false;
		}
		return true;
	}
	//retorna si puede arreglar
	public boolean canFix() {
		return cooldown==0;
	}
	//updatea el cooldown
	public void update() {
		cooldown--;
	}
	
}
