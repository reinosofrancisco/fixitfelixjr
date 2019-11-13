package windows;

import java.util.Random;

import exeptions.OutOfBoundsExeption;
import util.Direction;
import util.Vector2D;

class WithLeaves extends Window 
{
	private boolean isClosed;
	private ObsWindowLeaves state;
	
	
	WithLeaves(Vector2D pos,double dif)
	{
		super(0,pos,dif,Window.WITHLEAVES);
		this.generateObstacles(dif);
	}
	
	 boolean isClosed() {
		return isClosed;
	}

	 void setClosed(boolean isClosed) {
		this.isClosed = isClosed;
	}

	 ObsWindowLeaves getObsIzq_Der() {
		return state;
	}

	 void setObsIzq_Der(ObsWindowLeaves state) {
		this.state = state;
	}
	 public void  canIMove(Direction p) throws OutOfBoundsExeption
	 {
		 if(this.isClosed)
		 {
			 
		 }
		 else
		 {
			Direction der= Direction.RIGHT;
			Direction izq= Direction.LEFT;
			 if(this.state == ObsWindowLeaves.RIGHT)
			 {
				 if(der.getUnitVector() == p.getUnitVector())
				 {
					 throw new OutOfBoundsExeption();
				 }
			 }
			 else
			 {
				 if(this.state == ObsWindowLeaves.LEFT)
				 {
					 if(izq.getUnitVector()== p.getUnitVector())
					 {
						 throw new OutOfBoundsExeption();
					 }
				 }
			 }
			 
		 }
	
	 }
	 public boolean canIGenerateNicelander() 
	 {
		 return false;
	 }
	 /**
	  * Genera los obstaculos que va a tener cada ventana de este tipo
	  * @param dif representa la dificultad a mayor dificultad mas obstaculos
	  */
	 private void generateObstacles(double dif)
	 {
		 
		 double num= new Random().nextDouble();
		 
		 if(num<= baseProb*dif) {
			 num=new Random().nextInt(2);
			 switch ((int)num) {
			case 0:
			{
				this.state= ObsWindowLeaves.RIGHT;
				this.isClosed= false;
				break;
			}
			case 1:
			{
				this.state= ObsWindowLeaves.LEFT;
				this.isClosed= false;
				break;
			}
			case 2:
			{
				System.out.println("oh no exeption");
				break;
			}
			default:
				break;
			}
		 }
		 else {
			 this.isClosed=true;
		 }
		 
		 
		 
		 
		 
//		 //TODO USE DIF
//			switch(isClose)
//			{
//				case(0):
//				{
//					this.isClosed= true;
//				}
//				case(1):
//				{
//					int rol= (int) (Math.random()*2);
//					switch(rol)
//					{
//						case(0):
//						{
//							this.state= ObsWindowLeaves.RIGHT;
//							this.isClosed= false;
//						}
//						case(1):
//						{
//							this.state= ObsWindowLeaves.LEFT;
//							this.isClosed= false;
//						}
//						case(2):
//						{
//							this.state= ObsWindowLeaves.NONE;
//							this.isClosed= false;
//						}
//					}
//				}
//			}
	 }
	 @Override
	 public int repair() {
		 return 0;
	 }

	@Override
	public int getObstacles() {
		if (isClosed) {
			return 0;
		}
		else {
			if(state==ObsWindowLeaves.LEFT) {
				return 1;
			}
			else {
				return 2;
			}
		}
	}
}


//idea para mejorar la comparacion: que el obsWindowLeaves sea una direccion y directamente comparas direcciones
//o sea, que esta clase en lugar de un obstaculo tiene una direccion.
enum ObsWindowLeaves
{
	RIGHT,LEFT;
}