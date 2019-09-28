package util;

/*
 * La clase del vector se utiliza para todo lo relacionado con el posicionamiento y movimiento
 * de las entidades
 * 
 * This class is used for every entity ingame which moves or has a determinated position
 */

public class Vector2D  implements Comparable<Vector2D>{
	/*
	 * I use a vectorial notation for position and movement
	 * Uso notacion "vectorial" para movimiento y posicion
	 */
	int posx;
	int posy;
	
	
	/*
	 * initialices vector assigning the first parameter to x and the second one to y
	 * inicializa el vector asignando el primer parametro para x y el segundo para y
	 */
	public Vector2D(int x, int y) {
		posx=x;
		posy=y;
	}
	/*
	 * getters && setters
	 */
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
	
	
	/*
	 * Some functions I need the vectors to have
	 * Algunas funciones que necesito que los vectores tengan 
	 * 
	 */
	/*
	 * 
	 * retorna un vector es la suma de this con el vector recibido por parametro
	 * returns a vector which is the sum of this and the vector recived by parametert
	 */
	public Vector2D add(Vector2D v1) {
		
		return new Vector2D(posx+v1.getPosx(),posy+v1.getPosy());
		
	}
	/*
	 * 
	 * returns the resultant vector from multiplicating both components with the scalar ammount recived by parameter
	 * retorna el vector resultante de multiplicar cada componente del vector this por la cantidad escalar recibida por parametro 
	 */
	
	public Vector2D product(int n) {
		
		return new Vector2D(posx*n, posy*n);
		
		
	}
	
	/*
	 * 
	 * 
	 * returns a vector which is the multiplication of the first component of .this vector with the first parameter
	 * and the second component of .this vector with the second parameter recived
	 * 
	 * retorna un vector que se define como la multiplicacion del primer componente por el primer parametro
	 * y el segundo componente por el segundo parametro
	 */
	
	public Vector2D product(int a, int b) {
		
		return new Vector2D(posx*a, posy*b);
	}
	public int compareTo(Vector2D p)
	{
		if((this.posx == p.posx) && (this.posy == p.posy))
				{
					 return 0;
				}
		else return 1;
	}
	
	

}
