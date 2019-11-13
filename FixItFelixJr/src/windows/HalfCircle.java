package windows;

import exeptions.OutOfBoundsExeption;
import util.Direction;
import util.Vector2D;

class HalfCircle extends Window 
{
	
	HalfCircle(int panelsAmount, Vector2D pos,double dif)
	{
		super(panelsAmount, pos,dif,Window.HALFCIRCLE);
	}
	public void canIMove(Direction p) throws OutOfBoundsExeption
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
