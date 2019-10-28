package game;

import java.util.SortedSet;
import java.util.TreeSet;

public class HighScores {
private SortedSet<Scores> s = new TreeSet<Scores>();
	
	private static HighScores INSTANCE;
	
	private HighScores() {
		
	}
	
	public static HighScores getInstance() {
		if(INSTANCE==null) {
			INSTANCE= new HighScores();
		}
		return INSTANCE;
	}
	
	public void add(String name, int puntos) {
		s.add(new Scores(name, puntos));
		if(s.size()>5) {
			s.remove(s.first());
		}
	}
}
