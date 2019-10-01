package windows;

import util.Direction;

public abstract class  Obstacle 
{
	protected Direction dir;
	Obstacle(Direction dir)
	{
		this.dir= dir;
	}
	public boolean canIMove(Direction d)
	{
		
		if(dir.getUnitVector() == d.getUnitVector())
		{
			return false;
		}
		else return true;
	}
}
