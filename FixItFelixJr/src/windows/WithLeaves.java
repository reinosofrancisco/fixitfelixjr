package windows;

import util.Direction;
import util.Vector2D;

class WithLeaves extends Window 
{
	private boolean isClosed;
	private ObsWindowLeaves state;
	WithLeaves(Vector2D pos)
	{
		super(0,pos);
		this.generateObstacles();
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
	 public boolean canIMove(Direction p)
	 {
		 if(this.isClosed)
		 {
			 return false;
		 }
		 else
		 {
			Direction der= Direction.RIGHT;
			Direction izq= Direction.LEFT;
			 if(this.state == ObsWindowLeaves.RIGHT)
			 {
				 if(der.getUnitVector() == p.getUnitVector())
				 {
					 return false;
				 }
				 else return true;
			 }
			 else
			 {
				 if(this.state == ObsWindowLeaves.LEFT)
				 {
					 if(izq.getUnitVector()== p.getUnitVector())
					 {
						 return false;
					 }
					 else return true;
				 }
			 }
			 
		 }
		 return true;
	 }
	 public boolean canIGenerateNicelander() 
	 {
		 return false;
	 }
	 private void generateObstacles()
	 {
			int isClose= (int) Math.random();
			switch(isClose)
			{
				case(0):
				{
					this.isClosed= true;
				}
				case(1):
				{
					int rol= (int) (Math.random()*2);
					switch(rol)
					{
						case(0):
						{
							this.state= ObsWindowLeaves.RIGHT;
							this.isClosed= false;
						}
						case(1):
						{
							this.state= ObsWindowLeaves.LEFT;
							this.isClosed= false;
						}
						case(2):
						{
							this.state= ObsWindowLeaves.NONE;
							this.isClosed= false;
						}
					}
				}
			}
	 }
}
enum ObsWindowLeaves
{
	RIGHT,LEFT, NONE;
}