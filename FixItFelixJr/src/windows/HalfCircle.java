package windows;

import exceptions.CanIMoveExeption;
import util.Direction;
import util.Vector2D;

class HalfCircle extends Window 
{
	
	HalfCircle(int panelsAmount, Vector2D pos,double dif)
	{
		super(panelsAmount, pos,dif,Window.HALFCIRCLE);
	}
	public void canIMove(Direction p) throws CanIMoveExeption
	{
		
	}
	public boolean canIGenerateNicelander()
	{
		return false;
	}
	@Override
	public int getObstacles() {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
