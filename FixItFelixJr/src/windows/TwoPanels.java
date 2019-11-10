package windows;

import java.util.Random;

import util.Direction;
import util.GameConstants;
import util.Vector2D;

class TwoPanels extends Window 
{
	private Obstacle[] obstacles;
	//private int panelsAmount= 2;
	public TwoPanels(Vector2D pos,double mult)
	{
		super(GameConstants.PANEL_TWO_AMMOUNT, pos,mult,Window.TWOPANELS);
		this.generateObstacles(mult);
	}
	
	public boolean canIMove(Direction d)
	{
		if ( this.obstacles == null)
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
	 /**
	  * Genera los obstaculos que va a tener cada ventana de este tipo
	  * @param mult representa la dificultad a mayor dificultad mas obstaculos
	  */
	 private void generateObstacles(double mult)
	 {
		 double obs= new Random().nextDouble();
		if (obs <= baseProb * mult) {
			obs = new Random().nextInt(3);
			switch ((int)obs) {
			case 0: {
				Obstacle[] o = new Obstacle[1];
				Obstacle m = new Molding();
				o[0] = m;
				this.obstacles = o;
				break;
			}
			case 1: {
				Obstacle[] o = new Obstacle[1];
				Obstacle fl = new FlowerPot();
				o[0] = fl;
				this.obstacles = o;
				break;
			}
			case 2: {
				Obstacle[] o = new Obstacle[2];
				Obstacle m = new Molding();
				o[0] = m;
				Obstacle fl = new FlowerPot();
				o[1] = fl;
				this.obstacles = o;
				break;
			}
			default:
				break;
			}
		} else {
			this.obstacles = null;
		}
		 
		 
		 //-----OLD GENERATOR-------//
//			switch(obs)
//			{
//				case(0):
//				{
//					this.obstacles= null;
//				}
//				case(1):
//				{
//					int ot= (int) (Math.random()*2);
//					switch(ot)
//					{
//						case(0):
//						{
//							Obstacle[] o= new Obstacle[1];
//							Obstacle m= new Molding();
//							o[0]= m;
//							this.obstacles= o;
//						}
//						case(1):
//						{
//							Obstacle[] o= new Obstacle[1];
//							Obstacle fl= new FlowerPot();
//							o[0]= fl;
//							this.obstacles= o;
//						}
//					}
//				}
//				case(2):
//				{
//					Obstacle[] o= new Obstacle[2];
//					Obstacle m= new Molding();
//					o[0]= m;
//					Obstacle fl= new FlowerPot();
//					o[1]= fl;
//					this.obstacles= o;
//				}
//			}
	 //--------------------------------//
	 
	 
	 
	 }

	@Override
	public int getObstacles() {
		if(obstacles==null) {
			return 0;
		}
		else {
			if(!canIMove(Direction.DOWN)) {
				if(!canIMove(Direction.UP)) {
					return 3;
				}
				else {
					return 2;
				}
			}
			else {
				return 1;			
			}
		}
	}
	
}
