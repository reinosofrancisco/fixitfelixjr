package windows;

import util.Direction;
import util.Vector2D;

class TwoPanels extends Window 
{
	private Obstacle[] obstacles;
	private final static int panelsAmount= 2;
	public TwoPanels(Vector2D pos)
	{
		super(panelsAmount, pos);
		this.generateObstacles();
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
	 private void generateObstacles()
	 {
		 int obs= (int) (Math.random()*2);
			switch(obs)
			{
				case(0):
				{
					this.obstacles= null;
				}
				case(1):
				{
					int ot= (int) (Math.random()*2);
					switch(ot)
					{
						case(0):
						{
							Obstacle[] o= new Obstacle[1];
							Obstacle m= new Molding();
							o[0]= m;
							this.obstacles= o;
						}
						case(1):
						{
							Obstacle[] o= new Obstacle[1];
							Obstacle fl= new FlowerPot();
							o[0]= fl;
							this.obstacles= o;
						}
					}
				}
				case(2):
				{
					Obstacle[] o= new Obstacle[2];
					Obstacle m= new Molding();
					o[0]= m;
					Obstacle fl= new FlowerPot();
					o[1]= fl;
					this.obstacles= o;
				}
			}
	 }
	
}
