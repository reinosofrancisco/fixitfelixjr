package windows;

import util.Direction;
import util.Vector2D;

class HalfCircle extends Window 
{
	HalfCircle(int panelsAmount, Vector2D pos)
	{
		super(panelsAmount, pos);
	}
	public boolean canIMove(Direction p)
	{
		return true;
	}
	public boolean canIGenerateNicelander()
	{
		return false;
	}
	
}
