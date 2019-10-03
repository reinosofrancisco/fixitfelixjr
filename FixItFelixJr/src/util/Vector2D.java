package util;


public class Vector2D{
	int posx;
	int posy;
	
	public Vector2D() {};
	
	public Vector2D(int x, int y) {
		posx=x;
		posy=y;
	}

	public Vector2D(Vector2D v2) {
		this(v2.getPosx(),v2.getPosy());
	}
	
//------------------------------------------//
	
	
	public int getPosx() {
		return posx;
	}
	
	public void setPosx(int posx) {
		this.posx = posx;
	}
	
	public int getPosy() {
		return posy;
	}
	
	public void setPosy(int posy) {
		this.posy = posy;
	}
	
//------------------------------------------//
	

	/** VectorA + VectorB 		*/
	public Vector2D add(Vector2D v1) {
		return (new Vector2D(posx + v1.getPosx(), posy + v1.getPosy()));
		
	}
	/** VectorA * a 			*/
	public Vector2D product(int n) {		
		return new Vector2D(posx*n, posy*n);	
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
	
	
	

}
