package game;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collections;
import java.util.SortedSet;
import java.util.TreeSet;


public class HighScores {

	
	private SortedSet<Scores> scoreList = new TreeSet<Scores>();
	private static HighScores INSTANCE;
	private String usrPath=System.getProperty("user.home");
	
	
	@SuppressWarnings("unchecked")
	private HighScores() {
		ObjectInputStream input = null;
		
		try {
			// Asigno la Entrada, de donde voy a sacar los datos
			FileInputStream fi=new FileInputStream(new File(usrPath+"/HighScores.dat"));
			input = new ObjectInputStream(fi);
			
			// Saco el objeto que guarde anteriormente
			this.scoreList = (SortedSet<Scores>) input.readObject();
			
		} catch (FileNotFoundException ex) {
			System.out.println(ex.getMessage());
		} catch (IOException ex) {
			System.out.println(ex.getMessage());
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		} 
	}
	
	static {
		INSTANCE=new HighScores();
	}
	
	
	public static HighScores getInstance() {
		return INSTANCE;
	}

	public void add(String name, int puntos) {
		scoreList.add(new Scores(name, puntos));
		if (scoreList.size() > 5) {
			scoreList.remove(scoreList.first());
		}
	}

	public void printHightScores() {
		for (Scores scores : scoreList) {
			System.out.println("Score! --> " + scores);
		}
	}

	/** Saves scores to a binary file */
	public void savePersistentScore() {
		ObjectOutputStream output = null;
		try {
			// Asigno a salida donde voy a guardar los datos
			FileOutputStream fo=new FileOutputStream(new File(usrPath+"/HighScores.dat"));
			output = new ObjectOutputStream(fo);
			// Guardo los hightscores en el archivo (SortedSet implements Serializable)
			output.writeObject(scoreList);
		} catch (FileNotFoundException ex) {
			System.out.println(ex.getMessage());
		} catch (IOException ex) {
			System.out.println(ex.getMessage());
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

	public boolean isHighscore(int points) {
		if(!scoreList.isEmpty())
		{
			if(points > scoreList.first().getPoints() || scoreList.size()<5) {
				return true;
			}
		}
		else return true;
		return false;
	}

	public SortedSet<Scores> getScoreList() {
		SortedSet<Scores> ret = new TreeSet<Scores>(Collections.reverseOrder());
		ret.addAll(scoreList);
		return ret;
	}

	
	
}
