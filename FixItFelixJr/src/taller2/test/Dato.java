package taller2.test;
import taller2.modelo.Dibujable;
import taller2.modelo.InformacionDibujable;

public class Dato implements Dibujable{
	
	int x;
	int y;
	Character c;
	
	public Dato(int x, int y, Character c) {
		super();
		this.x = x;
		this.y = y;
		this.c = c;
	}

	public InformacionDibujable getInformacionDibujable() {
		return new InformacionDibujable(x, y, c);
	}

	


}
