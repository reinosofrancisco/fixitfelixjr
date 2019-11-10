package entities;

import java.util.Random;

import building.Building;
import game.Difficulty;
import randomenvironment.Brick;
import randomenvironment.RandomEnvironment;
import util.Dimentions;
import util.Direction;
import util.GameConstants;
import util.Vector2D;
import windows.Window;

public class Ralph 
{
	private Vector2D pos;
	private Direction dir;
	private float velocity;
	private int bricksAmount;
	
	private static Ralph INSTANCE;
	
	
	
	
	private Ralph() {
		pos=new Vector2D(1,4);
		dir= Direction.RIGHT;
		velocity=1;
		bricksAmount=GameConstants.BRICK_AMMOUNT;
	}
	
//	private Ralph(Vector2D pos, Direction dir, int bricksAmount)
//	{
//		this.pos= pos;
//		this.dir= dir;
//		this.bricksAmount= bricksAmount;
//	}
	
	
	
	public static Ralph getInstance() {
		if (INSTANCE==null) {
			INSTANCE=new Ralph();
		}
		return INSTANCE;
		
	}
	
	
	
	
	
	//This getter&setters should be private
	public Vector2D getPos() {
		return pos;
	}
	public void setPos(Vector2D pos) {
		this.pos = pos;
	}
	public Direction getDir() {
		return dir;
	}
	public void setDir(Direction dir) {
		this.dir = dir;
	}
	public float getVelocity() {
		return velocity;
	}
	public void setVelocity(float velocity) {
		this.velocity = velocity;
	}
	public int getBricksAmount() {
		return bricksAmount;
	}
	public void setBricksAmount(int bricksAmount) {
		this.bricksAmount = bricksAmount;
	}
	
	/*public void move(Direction dir) {
		Vector2D newPos = this.pos.add(dir.getUnitVector());
		if(Dimentions.isInsideMap(newPos)) {
			this.pos = newPos;
			System.out.println("[RALPH] I moved to pos " + this.pos.toString());
			
		}
	}
	*/
	
	//moves a random direction LEFT OR RIGHT
	public void move() {
		Vector2D v;
		if (new Random().nextInt(2) == 0) {
			v = this.pos.add(Direction.RIGHT.getUnitVector());
			System.out.println("[RALPH] I moved to pos " + this.pos.toString());
		} 
		else {
			v = this.pos.add(Direction.LEFT.getUnitVector());
			System.out.println("[RALPH] I moved to pos " + this.pos.toString());
		}
		
		if (Dimentions.isInsideMap(v)) {
			this.pos = v;
		}
	}
	
	
	/**
	 *  Rompe una cantidad de ventanas al azar
	 * @param d representa la dificultad depende de este rompe mas o menos ventanas
	 * @param w son las ventanas del edificio
	 * @return retorna si pudo romper ventanas
	 */
	public boolean breakBuilding()
	{
		Window[][] w = Building.getInstance().getWindows();
		double d = Difficulty.getInstance().getDifficulty();
		double numOfWindB= 1;
		numOfWindB= (numOfWindB * d) +1;
		if(numOfWindB < 2.5)
		{
			int i;
			for(i=0;i<2;i++)
			{
				int f= new Random().nextInt(3);
				int c= new Random().nextInt(4);
				if(!w[f][c].isHealthy())
				{
					w[f][c].breakWindow();
					System.out.println("[RALPH] rompio la ventana, en la fila "+ (f) +" y en la columna "+ (c));
				}
				else System.out.println("[RALPH] No pudo romper la ventana, en la fila "+ (f) +" y en la columna "+ (c)+" ya que estaba rota");
				
			}
			return true;
		}
		else 
		{
			if(numOfWindB > 2.5)
			{
				int i;
				for(i=0;i<3;i++)
				{	
					int f= new Random().nextInt(2);
					int c= new Random().nextInt(4);
					if(!w[f][c].isHealthy())
					{
						w[f][c].breakWindow();
						System.out.println("[RALPH] rompio la ventana, en la fila "+(f)+" y en la columna "+(c));
					}
				}
				return true;
			}		
		}
		return false;
	}
	
	
	/**
	 * Generates 1 brick
	 * @param difficulty 
	 * @param re randomEnvironment to put the brick
	 */
	public void summonBricks() {
		if((bricksAmount !=0) && (Brick.getCooldown()==0)) {
			RandomEnvironment.getInstance().summonBricks();
			this.bricksAmount--;
		}
	}

	public void update() {
		move();
		double num = new Random().nextDouble();
		if(num<=Difficulty.getInstance().getDifficulty()*.2) {
			summonBricks();
			breakBuilding();
		}
		
	}
	
}
