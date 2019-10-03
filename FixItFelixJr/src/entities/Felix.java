package entities;

import game.Map;
import randomenvironment.RandomEnvironment;
import util.Direction;
import util.Vector2D;
import windows.TwoPanels;
import windows.Window;

public class Felix {
	
	Vector2D pos;
	int lives;
	int inmune;
	Hammer ham;
	
	public Felix() {};
	
	/**Felix initial Vector, lives amount, inmunity status & Hammer hitting Cooldown */
	public Felix(Vector2D p,int lives,int inm,int cooldw){
		this.pos=p;
		this.lives=lives;
		this.inmune=30;
		this.ham=new Hammer(cooldw);
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
			 System.out.println("[FELIX] I moved to pos " + this.pos.toString());
			 return true;
		 }
		 return false;
		 
		 }
	
	public int fix() {
		Window w = Map.getWindow(pos);	
		if(ham.fix()) {
			System.out.println("The Window is being Repaired!");
			return w.repaired();
		}
		else return 0;
	}
	
	public void update() {
		inmune--;
		ham.update();
		//check colitions with tarta
	}
	
	public void updateAll(Direction dir) {
		//move(dir);
		testingMove(dir);
		
	}
	
	public void testingMove(Direction dir) {
		this.pos = this.pos.add(dir.getUnitVector());
	}
	
	public void isColliding(RandomEnvironment re) {
		if (re.isBirdCollision()) {
			this.lives--;
		}
		if (re.isBrickCollision()) {
			this.lives--;
		}
		if (re.isCakeCollision()) {
			this.inmune = 30; //default invulnerability time
		}	
		
	}
	
	public Vector2D getVector2D() {
		return (this.pos);
	}
	
	

}
