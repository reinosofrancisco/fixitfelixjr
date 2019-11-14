package entities;

import building.Building;
import exceptions.CanIMoveExeption;
import exceptions.HammerOnCooldownExeption;
import game.Core;

import util.Dimentions;
import util.Direction;
import util.GameConstants;
import util.Vector2D;
import windows.Window;

public class Felix {
	

	
	
	
	
	
	private final Vector2D initial= new Vector2D(1,1);
	private Vector2D pos=new Vector2D(initial);
	private int lives = GameConstants.FELIX_LIVES;
	private int inmune = GameConstants.FELIX_INMUNE;
	private Hammer ham = Hammer.getInstance();
	
	
	
	private static Felix instance;
	
	
	
	private Felix() {
		
	}
	
	
	public static Felix getInstnance() {
		if (instance==null) {
			instance=new Felix();
		}
		return instance;
		
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
		Window[][] w = Building.getInstance().getWindows();
		 Vector2D newPos= this.pos.add(d.getUnitVector());
		 
		 if(Dimentions.isInsideMap(newPos)) {
			 try {
				w[pos.getPosx()-1][pos.getPosy()-1].canIMove(d);
				w[newPos.getPosx()-1][newPos.getPosy()-1].canIMove((d.getUnitVector().product(-1)).getDirection());
				pos=newPos;
				System.out.println("\n Felix se mueve a: \t" + pos.toString());
				return true;
			 }
			 catch(CanIMoveExeption e)
			 {
				 System.out.println("Felix no se puede mover");
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
		 try{
			 ham.fix();
		 }
		catch(HammerOnCooldownExeption e)
		 {
			return 0;
		 }
		int points=w[pos.getPosx()-1][pos.getPosy()-1].repair();
		System.out.println("The Window is being Repaired! + " + points + "points. IsWindowHealthy-->" + w[pos.getPosx()-1][pos.getPosy()-1].isHealthy());
		return points;
	}
	
	public void update() {
		if(inmune>0) {
			inmune--;
		}
		ham.update();
		if(lives == 0)
		{
			Core.getInstance().gameOver(true);
		}
	}

	
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
			Core.getInstance().gameOver(false);
		}
	}

	public void collidedBrick() {
		lives--;
		if(!isAlive()) {
			Core.getInstance().gameOver(false);
		}
	}
	
	public boolean isAlive() {
		return lives>0;
	}

	/**
	 * Vuelve todas las Variables de instancia a su estado original, para poder volver a jugar
	 */
	public void restartGame() {
		ham.restartGame();
		inmune= GameConstants.FELIX_INMUNE;
		lives= GameConstants.FELIX_LIVES;
		pos= new Vector2D(initial);
	}
	

}
enum FelixState {
	KILLEDBYBIRD,
	KILLEDBYBRICK,
	INMUNITY,
	DEFAULT;
}
