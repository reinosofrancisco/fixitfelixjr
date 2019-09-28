package windows;

import util.Vector2D;

class HalfCircle extends Window 
{
	HalfCircle(int panelsAmount, Vector2D pos)
	{
		super(panelsAmount, pos);
	}
	public boolean canIMove(Vector2D p)
	{
		return true;
	}
	public boolean canIGenerateNicelander()
	{
		return false;
	}
	
}
