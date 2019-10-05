package entities;

import util.Dimentions;
import util.Direction;
import util.Vector2D;

public class Ralph 
{
	private Vector2D pos;
	private Direction dir= Direction.RIGHT;
	private float velocity=1;
	private int bricksAmount;
	private boolean mapFinal= false;
	private final int UP_LIMITS= Dimentions.UP_LIMITS;
	private final int RIGHT_LIMITS= Dimentions.RIGHT_LIMITS;
	private int RIGHT_LIMITSAct= 0;
	
	public Ralph() {
	}
	
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
	public int getRIGHT_LIMITSAct() {
		return RIGHT_LIMITSAct;
	}
	public void setRIGHT_LIMITSAct(int RIGHT_LIMITSAct) {
		this.RIGHT_LIMITSAct = RIGHT_LIMITSAct;
	}
	public boolean breakBuilding()
	{
		//implementar
		return false;
		
	}
	private boolean changeMapFinal()
	{
		if(this.RIGHT_LIMITSAct == this.RIGHT_LIMITS)
		{
			this.setMapFinal(true);
		}
		return true;
	}
	private boolean changeDir() 
	{
		if(this.RIGHT_LIMITSAct == this.RIGHT_LIMITS)
		{
			switch(this.dir)
			{
				case RIGHT:
				{
					this.setDir(Direction.LEFT);
					this.setMapFinal(false);
					return true;
				}
				case LEFT:
				{
					this.setDir(Direction.RIGHT);
					this.setMapFinal(false);
					return true;
				}
				default: return false;
			}
		}
		return false;
	}
	public boolean move()
	{
		if(!this.mapFinal)
		{
			pos.setPosx(pos.add(dir.getUnitVector()).getPosx());
			this.RIGHT_LIMITSAct ++;
			this.changeMapFinal();
			return true;
		}
		else 
		{
			this.changeDir();
			this.move();
		}
		return false;
		
	}
	
	public void move(Direction dir) {
		if (!isOutOfBounds(this.pos.add(dir.getUnitVector()))) {
			this.pos = this.pos.add(dir.getUnitVector());
			System.out.println("[RALPH] I moved to pos " + this.pos.toString());
		}
	}
	
	private boolean isOutOfBounds(Vector2D pos) {
		return !(((pos.getPosx()>0)&&(pos.getPosx()<Dimentions.RIGHT_LIMITS)
				&&((pos.getPosy()>0)&&(pos.getPosy()<Dimentions.UP_LIMITS))));
	}
	
	public boolean isMapFinal() {
		return mapFinal;
	}
	public void setMapFinal(boolean mapFinal) {
		this.mapFinal = mapFinal;
	}
	public int getUP_LIMITS() {
		return this.UP_LIMITS;
	}
	public int getRIGHT_LIMITS() {
		return this.RIGHT_LIMITS;
	}
	
	/**Deletes an amount of bricks, and deletes them */
	public int deleteBricks(int amount) {
		this.bricksAmount = this.bricksAmount - amount;
		return (amount);
	}
	
}
