package util;


public class Vector2D{
	double posx;
	double posy;
	
	public Vector2D() {};
	
	public Vector2D(int x, int y) {
		posx=x;
		posy=y;
	}

	public Vector2D(double x, double y) {
		posx=x;
		posy=y;
	}
	public Vector2D(Vector2D v2) {
		this(v2.getPosx(),v2.getPosy());
	}
	
//------------------------------------------//
	
	

	public int getPosx() {
		return (int) posx;
	}
	
	public void setPosx(int posx) {
		this.posx = posx;
	}
	
	public int getPosy() {
		return (int) posy;
	}
	
	public void setPosy(int posy) {
		this.posy = posy;
	}
	
//------------------------------------------//
	

	/** VectorA + VectorB 		*/
	public Vector2D add(Vector2D v1) {
		return (new Vector2D(posx + v1.posx, posy + v1.posy));
		
	}
	/** VectorA * a 			*/
	public Vector2D product(double mult) {		
		return new Vector2D(posx*mult, posy*mult);	
	}
	
	/**Multiplica de manera matematicamente ilegal <(X.a) , (Y.b) > */
	public Vector2D product(int a, int b) {
		
		return new Vector2D(posx*a, posy*b);
	}

	
	
	//------------------------------------------//
	
	public boolean equals(Object pos) {
		if (pos instanceof Vector2D) {
			Vector2D p = (Vector2D) pos;
			return ((this.posx == p.posx) && (this.posy == p.posy));			
		}
		else return false;
			
	};
	
	public boolean isEquals(Vector2D p)	{
		return (this.equals(p));
	}
	
	//------------------------------------------//
	
	public Direction getDirection() {
		if(posx==0) {
			if(posy==0) {
				return Direction.UNDIFINED;
			}
			else if(posy>0) {
				return Direction.UP;
			}
			else {
				return Direction.DOWN;
			}
		}
		else {
			if(posy==0) {
				if(posx>0) {
					return Direction.RIGHT;
				}
				else {
					return Direction.LEFT;
				}
			}
			else {
				return null;
			}
		}
	}
	
	public String toString() {
		return("X [" + this.posx + "]  |  Y [" + this.posy + "]");
	}
	
	
	
//	/**
//	 * 
//	 * @param v2
//	 * @return returns true if instance is bigger or equals to v2
//	 */
//	public int compareAllComponents(Vector2D v2) {
//		int x= v2.posx;
//		int y= v2.posy;
//		if(this.isEquals(v2)) {
//			return 0;
//		}
//		else {
//			if(posx>=x && posy>=y) {
//				return 1;
//			}
//			return -1;
//		}
//		
//	}
	
	/**
	 * 
	 * @return true if the integers of both vectors are the same
	 * this is done by casting each component to integer
	 */
	public boolean isColiding(Vector2D v) {
		return (((int)posx==(int)v.posx) && ((int)posy==(int)v.posy));
	}

}
