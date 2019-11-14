package windows;

import java.util.Random;

import exeptions.CanIMoveExeption;
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
	
	public void canIMove(Direction d) throws CanIMoveExeption
	{
		if ( this.obstacles == null)
		{
			
		}
		else
		{
			switch(obstacles.length)
			{
				case(1): 
					{
						 obstacles[0].canIMove(d);
					}
				break;
				case(2):
				{
					
					 obstacles[0].canIMove(d);
					 obstacles[1].canIMove(d);
				}
				break;
			}
		}
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
		else 
		{
			return obstacles.length;
		}
	}
	
}
