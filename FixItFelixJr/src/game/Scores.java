package game;

public class Scores implements Comparable<Scores>{
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
	
	public int compareTo(Scores s) {
		
		
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
	}
