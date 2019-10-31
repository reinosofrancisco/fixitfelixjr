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
//<<<<<<< HEAD
	private SortedSet<Scores> lovelyScores = new TreeSet<Scores>();
//=======
private SortedSet<Scores> s = new TreeSet<Scores>();
//>>>>>>> c6a401f0bb8f0a08d3740cd3939686258fdb8294
	
	public SortedSet<Scores> getLovelyScores() {
	return lovelyScores;
}

public void setLovelyScores(SortedSet<Scores> lovelyScores) {
	this.lovelyScores = lovelyScores;
}

public SortedSet<Scores> getS() {
	return s;
}

public void setS(SortedSet<Scores> s) {
	this.s = s;
}

	private static HighScores INSTANCE;
	
	@SuppressWarnings("unchecked")
	private HighScores() {
		ObjectInputStream imput = null;
		
		try {	
			//Asigno la Entrada, de donde voy a sacar los datos
			 imput = new ObjectInputStream(new FileInputStream("C:\\Users\\jeron\\Documents\\GitHub\\fixitfelixjr\\FixItFelixJr\\src\\game\\Archivos\\HighScore.dat"));	
			 //Saco el objeto que guarde anteriormente
			 this.lovelyScores = (SortedSet<Scores>) imput.readObject();			
		} 
		catch (FileNotFoundException ex) {
			System.out.println(ex.getMessage());
		}catch (IOException ex) {
			System.out.println(ex.getMessage());
		}catch (Exception ex) {
			System.out.println(ex.getMessage());
		} finally {//TODO }
			/**Luego de un error, se ejecutara el codigo que esta en el Finally. Luego, el programa SIGUE. */
		}
		
	}
	
	public static HighScores getInstance() {
		if(INSTANCE==null) {
			INSTANCE= new HighScores();
		}
		return INSTANCE;
	}
	
	public void add(String name, int puntos) {
		lovelyScores.add(new Scores(name, puntos));
		if(lovelyScores.size()>5) {
			lovelyScores.remove(lovelyScores.first());
		}
	}
	
	public void printHightScores() {
		for (Scores scores : lovelyScores) {
			System.out.println("Score! --> " + scores);
		}
	}
	
	/**Saves scores to a binary file */
	public void savePersistentScore() {
		ObjectOutputStream output = null;	
		try {	
			//Asigno a salida donde voy a guardar los datos
			output = new ObjectOutputStream(new FileOutputStream("C:\\Users\\jeron\\Documents\\GitHub\\fixitfelixjr\\FixItFelixJr\\src\\game\\Archivos\\HighScore.dat"));
			//Guardo los hightscores en el archivo (SortedSet implements Serializable)
			output.writeObject(lovelyScores);
		} 
		catch (FileNotFoundException ex) {
			System.out.println(ex.getMessage());
		}catch (IOException ex) {
			System.out.println(ex.getMessage());
		}catch (Exception ex) {
			System.out.println(ex.getMessage());
		} finally {//TODO }
			/**Luego de un error, se ejecutara el codigo que esta en el Finally. Luego, el programa SIGUE. */
		}
	}
}
