package game;

public class Scores implements Comparable{
	private String nombre;
	private int puntos;
	
	public Scores(String n, int p) {
		nombre=n;
		puntos=p;
	}
	
	public String toString() {
		String s="Nombre: "+nombre + "---> " + puntos + " puntos";
		return s;
	}
	
	public int compareTo(Object s) {
		
		if((s instanceof Scores)) {
			if(((Scores) s).puntos<puntos) {
				return 1;
			}
			else {
				if(((Scores) s).puntos==puntos) {
					return 0;
				}
				else {
					return -1;
				}
			}
		}
		else {
			throw new Error("ERRROR AL COMPARAR; NO SON DE LA MISMA CLASE");
			
		}
			
			
		
	}
	

}
