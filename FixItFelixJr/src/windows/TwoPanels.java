package windows;

import util.Direction;
import util.Vector2D;

class TwoPanels extends Window 
{
	private Obstacle[] obstacles;
	private final static int panelsAmount= 2;
	public TwoPanels(int obstaclesAmount, Vector2D pos)
	{
		super(panelsAmount, pos);
		this.obstacles= new Obstacle[obstaclesAmount];
		
	}
	public boolean canIMove(Direction d)
	{
		if ( this.obstacles.length == 0)
		{
			return true;
		}
		else
		{
			switch(this.obstacles.length)
			{
				case(1): 
					{
						return obstacles[0].canIMove(d);
					}
				case(2):
				{
					boolean one, two; // Save the answer of the obstacles if i can move
					one= obstacles[0].canIMove(d);
					two= obstacles[1].canIMove(d);
					if(one == two)
					{
						return one;
					}
					else
					{
						if(one != two)
						{
							return one;
						}
						else return two;
					}
				}
			}
		}
		return false;
	}
	 public	boolean canIGenerateNicelander() 
	 {
		 if (this.panels[0].getState() == PanelState.BROKEN)
		 {
			 return true;
		 }
		 else return false;
	 }
	
}
