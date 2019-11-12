package game;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Stats {
	
	
	
	private static int timesExecuted;
	private static int timesPressedPlay;
	private static int timesNewHighscore;
	
	
	private Stats() {
		
	}
	
	static {
		//cada vez que abra el juego, se leen los datos de archivo
		readFile();
		timesExecuted++;
	}
	
	
	
	
	private static void readFile() {
		ObjectInputStream input;
		try
		{
			FileInputStream fi=new FileInputStream(new File("src/data/stats/stats.dat"));
			input = new ObjectInputStream(fi);
			Stats.timesExecuted= (Integer) input.readObject();
			Stats.timesPressedPlay= (Integer) input.readObject();
			Stats.timesNewHighscore= (Integer) input.readObject();
			
		}
		catch(FileNotFoundException e)
		{
			System.out.println("Error al abrir el archivo");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/** Saves stats to a binary file */
	public static void savePersistentScore() {
		ObjectOutputStream output = null;
		try {
			FileOutputStream fo=new FileOutputStream(new File("src/data/stats/stats.dat"));
			output = new ObjectOutputStream(fo);
			output.writeObject(timesNewHighscore);
			output.writeObject(timesPressedPlay);
			output.writeObject(timesExecuted);
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
	
	
	public static int getTimesExecuted() {
		return timesExecuted;
	}
	
	public static int getTimesPressedPlay() {
		return timesPressedPlay;
	}
	
	public static int getTimesNewHighscore() {
		return timesNewHighscore;
	}
	
	
	
	public static void incrementTimesExecuted() {
		timesExecuted++;
	}
	
	public static void incrementTimesPressedPlay() {
		timesPressedPlay++;
	}
	
	public static void incrementTimesNewHighscore() {
		timesNewHighscore++;
	}
	

}
