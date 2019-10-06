package entities;

import java.util.Random;

import randomenvironment.RandomEnvironment;
import util.Dimentions;
import util.Direction;
import util.Vector2D;

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
	
	public void move(Direction dir) {
		Vector2D newPos = this.pos.add(dir.getUnitVector());
		if(Dimentions.isInsideMap(newPos)) {
			this.pos = newPos;
			System.out.println("[RALPH] I moved to pos " + this.pos.toString());
			
		}
	}
	
	
	//moves a random direction LEFT OR RIGHT
	public void move() {
		switch (new Random().nextInt(1)) {
		case 0: {
			this.pos.add(Direction.RIGHT.getUnitVector());
			break;
		}
		case 1:{
			this.pos.add(Direction.LEFT.getUnitVector());
			break;
		}
		default:
			break;

		}
	}
	
	
	
	public boolean breakBuilding()
	{
		//implementar
		return false;
		
	}
	
	/**
	 * Generates 1 brick
	 * @param difficulty 
	 * @param re randomEnvironment to put the brick
	 */
	public void summonBricks(Double difficulty, RandomEnvironment re) {
		if(re.getBricksCooldown()!=0) {
			re.summonBricks(this.pos,1,difficulty);
			this.bricksAmount--;
		}
	}
	
}
