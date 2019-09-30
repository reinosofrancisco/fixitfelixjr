package windows;

import felix.game.utilities.Vector2D;

class TwoPanels extends Window 
{
	private Obstacle[] obstacles;
	private final static int panelsAmount= 2;
	public TwoPanels(int obstaclesAmount, Vector2D pos)
	{
		super(panelsAmount, pos);
		this.obstacles= new Obstacle[obstaclesAmount];
		
	}
	public boolean canIMove(Vector2D p)
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
						return obstacles[0].canIMove(p);
					}
				case(2):
				{
					boolean one, two; // Save the answer of the obstacles if i can move
					one= obstacles[0].canIMove(p);
					two= obstacles[1].canIMove(p);
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
