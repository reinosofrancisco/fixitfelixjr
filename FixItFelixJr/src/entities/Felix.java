package entities;

import randomenvironment.RandomEnvironment;
import util.Dimentions;
import util.Direction;
import util.Vector2D;
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
	public boolean move(Direction d,Window[][] w) {		 
		 Vector2D newPos= this.pos.add(d.getUnitVector());
		 
		 if(Dimentions.isInsideMap(newPos)) {
			 if(w[pos.getPosx()-1][pos.getPosy()-1].canIMove(d) && w[newPos.getPosx()-1][newPos.getPosy()-1].canIMove((d.getUnitVector().product(-1)).getDirection())) {
				 pos=newPos;
				 
				 System.out.println("\n Felix se mueve a: \t" + pos.toString()+ "\n");
				 
				 return true;
			 }
		 }
		 return false;
		 
		 
		 }

	
	/**
	 * @param w the array of windows
	 * @return number of points after trying to fix window
	 */
	public int fix(Window[][] w) {
		if(ham.fix()) {
			System.out.println("The Window is being Repaired!");
			return w[pos.getPosx()-1][pos.getPosy()-1].repaired();
		}
		else return 0;
	}
	
	public void update(RandomEnvironment re) {
		if(inmune>0) {
			inmune--;
		}
		ham.update();
		isColliding(re);
		//check colitions with tarta
	}
	
	public void updateAll(Direction dir) {
		//move(dir);
		testingMove(dir);
		
	}
	
	public void testingMove(Direction dir) {
		this.pos = this.pos.add(dir.getUnitVector());
		System.out.println("Soy felipe y me estoy moviendo" + this.pos.toString());
	}
	
	private void isColliding(RandomEnvironment re) {
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
