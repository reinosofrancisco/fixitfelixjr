package entities;

import building.Building;
import game.Core;
import randomenvironment.RandomEnvironment;
import util.Dimentions;
import util.Direction;
import util.GameConstants;
import util.Vector2D;
import windows.Window;

public class Felix {
	
	/*
	 * private final int LIVES=3
	 * private final int INMUNE = 1
	 * private final int 
	 */
	
	
	
	
	
	private final Vector2D initial= new Vector2D(1,1);
	private Vector2D pos=new Vector2D(initial);
	private int lives = GameConstants.FELIX_LIVES;
	private int inmune = GameConstants.FELIX_INMUNE;
	private Hammer ham = Hammer.getInstance();
	
	
	
	private static Felix INSTANCE;
	
	
	
	private Felix() {
		
	}
	
//	/**Felix initial Vector, lives amount, inmunity status & Hammer hitting Cooldown */
//	private Felix(Vector2D p,int lives,int inm,int cooldw){
//		
//	}
	
	public static Felix getInstnance() {
		if (INSTANCE==null) {
			INSTANCE=new Felix();
		}
		return INSTANCE;
		
	}
	
	//vidas getters && setters
	public void setCantVidas(int l) {
		this.lives = l;
	}
	public int getLives() {
		return lives;
	}
	
	
	/**
	 * Mueve a felix si se puede mover
	 * @param d define la direcccion en la que se quiere mover feliz
	 * @return retorna true si felix se puede mover en la direccion d, false si no puede
	 */
	public boolean move(Direction d) {
		Window[][] w = Building.getInstance().getWindows();
		 Vector2D newPos= this.pos.add(d.getUnitVector());
		 
		 if(Dimentions.isInsideMap(newPos)) {
			 if(w[pos.getPosx()-1][pos.getPosy()-1].canIMove(d) && w[newPos.getPosx()-1][newPos.getPosy()-1].canIMove((d.getUnitVector().product(-1)).getDirection())) {
				 pos=newPos;
				 
				 System.out.println("\n Felix se mueve a: \t" + pos.toString());
				 
				 return true;
			 }
			
		 }
		 else System.out.println("Felix no se puede mover");
		  return false;
		 }

	
	/**
	 * @param w the array of windows
	 * @return number of points after trying to fix window
	 */
	public int fix() {
		Window[][] w = Building.getInstance().getWindows();
		if(ham.fix()) {
			if(!w[pos.getPosx()-1][pos.getPosy()-1].isHealthy())
			{
				int fedeborralodespues=w[pos.getPosx()-1][pos.getPosy()-1].repaired();
				System.out.println("The Window in X["+ (pos.getPosx()-1)+"]"+"| Y["+(pos.getPosy()-1)+ "] is being Repaired! + " + fedeborralodespues + " points. IsWindowHealthy--> " + w[pos.getPosx()-1][pos.getPosy()-1].isHealthy());
				//return w[pos.getPosx()-1][pos.getPosy()-1].repaired();
				return fedeborralodespues;
			}
			else return 0;
		}
		else return 0;
	}
	
	public void update() {
		if(inmune>0) {
			inmune--;
		}
		ham.update();
	}
//	public void updateAll(Direction dir) {
//		//move(dir);
//		testingMove(dir);
//		
//	}
//	
//	public void testingMove(Direction dir) {
//		this.pos = this.pos.add(dir.getUnitVector());
//		System.out.println("Soy felipe y me estoy moviendo" + this.pos.toString());
//	}
	
	public Vector2D getVector2D() {
		return (this.pos);
	}

	public void restartPosition() {
		pos=new Vector2D(initial);
		
	}

	public void giveInmunity(int felixInmune) {
		inmune=felixInmune;
	}

	public void collidedBird() {
		lives--;
		if(!isAlive()) {
			Core.getInstance().gameOver();
		}
	}

	public void collidedBrick() {
		lives--;
		if(!isAlive()) {
			Core.getInstance().gameOver();
		}
	}
	
	public boolean isAlive() {
		return lives>0;
	}
	

}
enum FelixState {
	KILLEDBYBIRD,
	KILLEDBYBRICK,
	INMUNITY,
	DEFAULT;
}
