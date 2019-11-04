package game;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.SortedSet;
import java.util.TreeSet;

public class HighScores {

	
	private SortedSet<Scores> scoreList = new TreeSet<Scores>();
	private static HighScores INSTANCE;
	@SuppressWarnings("unchecked")
	private HighScores() {
		ObjectInputStream imput = null;

		try {
			// Asigno la Entrada, de donde voy a sacar los datos
			imput = new ObjectInputStream(new FileInputStream(
					"C:\\Users\\jeron\\Documents\\GitHub\\fixitfelixjr\\FixItFelixJr\\src\\game\\Archivos\\HighScore.dat"));
			// Saco el objeto que guarde anteriormente
			this.scoreList = (SortedSet<Scores>) imput.readObject();
		} catch (FileNotFoundException ex) {
			System.out.println(ex.getMessage());
		} catch (IOException ex) {
			System.out.println(ex.getMessage());
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		} finally {
			// TODO
			/**
			 * Luego de un error, se ejecutara el codigo que esta en el Finally. Luego, el
			 * programa SIGUE.
			 */
		}

	}
	
	public static HighScores getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new HighScores();
		}
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
			output = new ObjectOutputStream(new FileOutputStream(
					"C:\\Users\\jeron\\Documents\\GitHub\\fixitfelixjr\\FixItFelixJr\\src\\game\\Archivos\\HighScore.dat"));
			// Guardo los hightscores en el archivo (SortedSet implements Serializable)
			output.writeObject(scoreList);
		} catch (FileNotFoundException ex) {
			System.out.println(ex.getMessage());
		} catch (IOException ex) {
			System.out.println(ex.getMessage());
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		} finally {// TODO }
			/**
			 * Luego de un error, se ejecutara el codigo que esta en el Finally. Luego, el
			 * programa SIGUE.
			 */
		}
	}

	public boolean isHighscore(int points) {
		if(points>scoreList.first().getPoints()) {
			return true;
		}
		return false;
	}
	
	
}
