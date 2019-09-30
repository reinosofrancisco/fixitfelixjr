package Entities;

import felix.game.utilities.Vector2D;

public class Felix {
	
	Vector2D pos;
	int cantVidas;
	int inmune;
	Hammer ham;
	
	//vidas getters && setters
	public void setCantVidas(int cantVidas) {
		this.cantVidas = cantVidas;
	}
	public int getCantVidas() {
		return cantVidas;
	}
	//mueve el personaje si puede moverse
	public boolean mover(Vector2D d) {
		 private Window w[] = Map.getWindows();
		 int x=this.pos.getPosx();
		 int y=this.pos.getPosy();
		 if(w[x][y].canIMove(d) &&
				 w[x+d.getPosx()][y+d.getPosy()].canIMove(d.product(-1))) {
			 
			 pos=pos.add(d);
			 return true;
		 }
		 return false;
		 
		 }
	public int arreglar() {
		private Window w=Map.getVentana(pos);
		if(ham.fix()) {
			return w.arreglar();
		}
		else return 0;
		
	}
	
	public void update() {
		inmune--;
		ham.update();
		//check colitions with tarta
	}
	
	
	

}
