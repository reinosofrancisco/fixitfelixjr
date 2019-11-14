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
	/** 
	 * VectorA * a 			
	 * @param mult es el escalar por el cual se multiplica al vector
	 * @return retorna el nuevo vector
	 */
	public Vector2D product(double mult) {		
		return new Vector2D(posx*mult, posy*mult);	
	}
	
	/**
	 *  Multiplica de manera matematicamente ilegal <(X.a) , (Y.b) > 
	 * @param a
	 * @param b
	 * @return retorna el nuevo vector
	 */
	public Vector2D product(int a, int b) {
		
		return new Vector2D(posx*a, posy*b);
	}

	
	
	//------------------------------------------//
	/** compara si 2 vectores son iguales
	 * @param pos 
	 * @return retorna true si 2 vectores son iguales
	 */
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
	/**
	 *  Te transforma el vector en una direccion
	 * @return retorana la direccion que corresponde con el vector
	 */
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
	
	/**
	 * Muesta en forma legible y "normal" la clase vector
	 */
	public String toString() {
		return("X [" + this.posx + "]  |  Y [" + this.posy + "]");
	}
	

	/**
	 * 
	 * @return true if the integers of both vectors are the same
	 * this is done by casting each component to integer
	 */
	/**
	 *  compara si 2 Vectores esta "Chocando"
	 * @param v 
	 * @return retorna verdadero si la posicion "mia" es igual a la del vector pasada por parametro
	 */
	public boolean isColiding(Vector2D v) {
		return (((int)posx==(int)v.posx) && ((int)posy==(int)v.posy));
	}

}
