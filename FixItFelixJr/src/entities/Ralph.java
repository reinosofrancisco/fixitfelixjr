package entities;

import game.Difficulty;
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
	private final Dimentions height= Dimentions.HEIGHT;
	private final Dimentions width= Dimentions.WIDTH;
	private int widthAct= 0;
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
	public int getWidthAct() {
		return widthAct;
	}
	public void setWidthAct(int widthAct) {
		this.widthAct = widthAct;
	}
	public boolean broke(Difficulty d)
	{
		//implementar
		return false;
		
	}
	private boolean changeMapFinal()
	{
		if(this.widthAct == this.width.getSize())
		{
			this.setMapFinal(true);
		}
		return true;
	}
	private boolean changeDir() 
	{
		if(this.widthAct == this.width.getSize())
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
			this.widthAct ++;
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
	public boolean isMapFinal() {
		return mapFinal;
	}
	public void setMapFinal(boolean mapFinal) {
		this.mapFinal = mapFinal;
	}
	public Dimentions getHeight() {
		return height;
	}
	public Dimentions getWidth() {
		return width;
	}
}
