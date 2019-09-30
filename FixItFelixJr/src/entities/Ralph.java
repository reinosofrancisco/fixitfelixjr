package entities;

import util.Direction;
import util.Vector2D;

public class Ralph 
{
	private Vector2D pos;
	private Direction dir= Direction.RIGHT;
	private float velocity=1;
	private int bricksAmount;
	private boolean mapFinal= false;
	private final int height=3;
	private final int width= 5;
	public Ralph(Vector2D pos, Direction dir, int bricksAmount)
	{
		this.pos= pos;
		this.dir= dir;
		this.bricksAmount= bricksAmount;
	}
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
	public boolean broke(Dificulty d)
	{
		
	}
	public boolean move()
	{
		if(!this.mapFinal)
		{
			pos.setPosx(pos.add(dir.getUnitVector()).getPosx());
		}
		else 
		{
			
		}
		
	}
}
