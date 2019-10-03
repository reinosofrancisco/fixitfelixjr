package entities;

import game.Map;
import util.Direction;
import util.Vector2D;
import windows.Window;

public class Felix {
	
	Vector2D pos;
	int lives;
	int inmune;
	Hammer ham;
	
	public Felix() {};
	
	public Felix(Vector2D p,int lives,int inm,int cooldw){
		pos=p;
		this.lives=lives;
		inmune=30;
		ham=new Hammer(cooldw);
	}
	
	//vidas getters && setters
	public void setCantVidas(int l) {
		this.lives = l;
	}
	public int getLives() {
		return lives;
	}
	//mueve el personaje si puede moverse
	public boolean move(Direction d) {
		 Window[][] w = Map.getWindows();
		 int x=this.pos.getPosx();
		 int y=this.pos.getPosy();
		 if(w[x][y].canIMove(d) &&
				 w[x+d.getUnitVector().getPosx()][y+d.getUnitVector().getPosy()].canIMove(d)) {
			 
			 pos=pos.add(d.getUnitVector());
			 return true;
		 }
		 return false;
		 
		 }
	public int fix() {
		Window w=Map.getWindow(pos);
		if(ham.fix()) {
			return w.repaired();
		}
		else return 0;
	}
	
	public void update() {
		inmune--;
		ham.update();
		//check colitions with tarta
	}
	
	public Vector2D getVector2D() {
		return (this.pos);
	}
	
	

}
