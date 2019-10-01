package windows;

import util.Direction;

class WithLeaves extends Window 
{
	private boolean isClosed;
	private ObsWindowLeaves state;
	WithLeaves()
	{
		
	}
	WithLeaves(boolean isClosed, ObsWindowLeaves state)
	{
		this.isClosed= isClosed;
		this.state= state;
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
	
}
enum ObsWindowLeaves
{
	RIGHT,LEFT;
}