package entities;

import game.Map;
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
	//mueve el personaje si puede moverse
	public boolean move(Direction d,Window[][] w) {
		 int x=this.pos.getPosx();
		 int y=this.pos.getPosy(); 
		 int nx=x+d.getUnitVector().getPosx();
		 int ny=y+d.getUnitVector().getPosy();
		 if(isInsideMap(nx, ny)){ //in boundries
			 if(w[y-1][x-1].canIMove(d) &&
					 w[ny-1][nx-1].canIMove(d)){ //windows allow movement
				 
				 pos=pos.add(d.getUnitVector());
				 System.out.println("[FELIX] I moved to pos " + this.pos.toString());
				 return true;
			 }			 
		 }
		  		 
		 return false;
		 
		 
		 
		 }

	/**
	 * @param nx
	 * @param ny
	 * @return
	 */
	private boolean isInsideMap(int nx, int ny) {
		return nx<= Dimentions.WIDTH && ny<Dimentions.HEIGHT && nx>0 && ny>0;
	}
	
	public int fix() {
		Window w = Map.getWindow(pos);	
		if(ham.fix()) {
			System.out.println("The Window is being Repaired!");
			return w.repaired();
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
