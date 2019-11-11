package game;

import java.io.Serializable;

public class Scores implements Comparable<Scores>,Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private int points;
	
	public String getName() {
		return name;
	}

	public int getPoints() {
		return points;
	}

	public Scores(String n, int p) {
		name=n;
		points=p;
	}
	
	public String toString() {
		String s="Nombre: "+name + "---> " + points + " puntos";
		return s;
	}
	
	
	//"mal implementado" para guardar scores iguales
	public int compareTo(Scores s) {
		if (s.points < points) {
			return 1;
		} else {
			return -1;
		}
	}
}
