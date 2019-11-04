package game;

public class Scores implements Comparable<Scores>{
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
	
	public int compareTo(Scores s) {
		
		
			if(((Scores) s).points<points) {
				return 1;
			}
			else {
				if(((Scores) s).points==points) {
					return 0;
				}
				else {
					return -1;
				}
			}
		}
	}
