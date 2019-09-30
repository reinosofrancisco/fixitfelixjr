package windows;

import felix.game.utilities.Vector2D;

class Obstacle 
{
	protected Vector2D pos;
	Obstacle(Vector2D pos)
	{
		this.pos= pos;
	}
	boolean canIMove(Vector2D p)
	{
		if (this.pos.compareTo(p) == 0)
		{
			return false;
		}
		return true;
	}
}
