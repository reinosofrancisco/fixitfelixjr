package windows;

import util.Vector2D;

class WthLeaves extends Window 
{
	private boolean isClosed;
	private ObsWindowLeaves state;

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
	 public boolean canIMove(Vector2D p)
	 {
		 if(this.isClosed)
		 {
			 return false;
		 }
		 else
		 {
			 Vector2D der= new Vector2D(1,0);
			 Vector2D izq= new Vector2D(-1,0);
			 if(this.state == ObsWindowLeaves.RIGHT)
			 {
				 if(der.compareTo(p) == 0)
				 {
					 return false;
				 }
				 else return true;
			 }
			 else
			 {
				 if(this.state == ObsWindowLeaves.LEFT)
				 {
					 if(izq.compareTo(p) == 0)
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