package entities;

import java.util.Random;

import randomenvironment.RandomEnvironment;
import util.Direction;
import util.Vector2D;
import windows.Window;

public class Ralph 
{
	private Vector2D pos;
	private Direction dir= Direction.RIGHT;
	private float velocity=1;
	private int bricksAmount;
	
	public Ralph() {
	}
	
	public Ralph(Vector2D pos, Direction dir, int bricksAmount)
	{
		this.pos= pos;
		this.dir= dir;
		this.bricksAmount= bricksAmount;
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
		switch (new Random().nextInt(1)) {
		case 0: {
			this.pos.add(Direction.RIGHT.getUnitVector());
			System.out.println("[RALPH] I moved to pos " + this.pos.toString());
			break;
		}
		case 1:{
			this.pos.add(Direction.LEFT.getUnitVector());
			System.out.println("[RALPH] I moved to pos " + this.pos.toString());
			break;
		}
		default:
			break;

		}
	}
	
	
	/**
	 *  Rompe una cantidad de ventanas al azar
	 * @param d representa la dificultad depende de este rompe mas o menos ventanas
	 * @param w son las ventanas del edificio
	 * @return retorna si pudo romper ventanas
	 */
	public boolean breakBuilding(double d, Window[][] w )
	{
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
	public void summonBricks(Double difficulty, RandomEnvironment re) {
		if((this.bricksAmount !=0) && (re.getBricksCooldown()!=0)) {
			re.summonBricks(this.pos,1,difficulty);
			this.bricksAmount--;
		}
	}
	
}
