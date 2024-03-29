package building;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import entities.Felix;
import exceptions.CanIMoveExeption;
import game.Core;
import randomenvironment.Nicelander;
import util.Direction;
import util.Vector2D;
import windows.Window;
import windows.WindowsGenerator;

public class Building {

	private Sections section = Sections.FIRST;
	private Window[][] windows;
	private LinkedList<Nicelander> nicelanders = new LinkedList<>();

	private static Building instance;

	public static Building getInstance() {
		if (instance == null) {
			instance = new Building();
			instance.windows = WindowsGenerator.generateWindows();
		}
		return instance;
	}

	public Window[][] getWindows() {
		return windows;
	}

	public void setWindows(Window[][] windows) {
		this.windows = windows;
	}

	public Sections getSection() {
		return section;
	}

	public void setSection(Sections section) {
		this.section = section;
	}

	public LinkedList<Nicelander> getNicelanders() {
		return nicelanders;
	}

	/**
	 * Se pregunta si estando en la posicion actual me puedo mover a la posicion que
	 * quiero
	 * 
	 * @param posAct    representa la posicion actual
	 * @param posWanted representa la posicion a la que quiero ir
	 * @return retorna true si me puedo mover en la direccion que quiero
	 */
	public void canIMove(Vector2D posAct, Direction posWanted) throws CanIMoveExeption {
		int i = 0, j = 0, f = 0, c = 0;
		boolean found = false;
		while (i < windows.length && !found) {
			while (j < windows[0].length && !found) {
				if (windows[i][j].getPos().isEquals(posAct)) {
					f = i;
					c = j;
					found = true;
				}
				j++;
			}
			i++;
		}
		if (found) {
			windows[f][c].canIMove(posWanted);
		}
	}

	/**
	 * Busca una ventana donde se puede dejar una torta
	 * 
	 * @return devuelve la posicion de la ventana donde se puede generar la torta
	 */
	public Vector2D findCakeWindow() {
		int i = 0, j = 0;
		boolean stop = false;
		while (i != windows.length && !stop) {
			while (j != windows[i].length && !stop) {
				stop = windows[i][j].canIGenerateNicelander();
				j++;
			}
			i++;
		}
		return stop ? new Vector2D(i, j) : null;
	}

	/**
	 * Cambia la seccion actual por la siguiente	 * 
	 * 
	 * @return retorna true si estaba en la ultima seccion (o sea, hay que subir nivel)
	 */
	public void sectionUp() {
		switch (this.section) {
		case FIRST: {
			this.setSection(Sections.SECOND);
			break;
		}
		case SECOND: {
			this.setSection(Sections.THIRD);
			break;
		}
		case THIRD: {
			this.setSection(Sections.FIRST);
			Core.getInstance().levelUp();
		}
		default:
			break;
		}
	}

	/**
	 * Vuelve a comenzar la seccion actual
	 * 
	 * @param d Representa la dificultad actual, a mas dificultad mas ventanas rotas
	 */
	public void restartSection() {
		windows = WindowsGenerator.generateWindows();
	}

	/**
	 * Vuelve a comenzar el nivel actual
	 * 
	 * @param d Representa la dificultad actual, a mas dificultad mas ventanas rotas
	 */
	public void restartLevel() {
		this.section = Sections.FIRST;
		windows = WindowsGenerator.generateWindows();
	}

	/**
	 * Chequea si todas las ventanas de la seccion actual estan sanas
	 * 
	 * @return retorna true si todas las ventanas estan sanas
	 */
	private boolean isFixed() {
		for (int i = 0; i < windows.length; i++) {
			for (int j = 0; j < windows[i].length; j++) {
				if (!windows[i][j].isHealthy()) {
					return false;
				}
			}
		}
		return true;
	}

	public boolean isFirstSection() {
		return section == Sections.FIRST;
	}

	public void update() {

		// checks if levelup or sectionup. Es necesario hacerlo cada turno? O solo
		// cuando felix.fix.... (por eso lo movi ahi)
		Nicelander.update();
		if (Nicelander.getCooldown() == 0 && new Random().nextDouble() < .8) {
			Vector2D v = findCakeWindow();
			if (v != null) {
				nicelanders.add(new Nicelander(v));
			}
		}

		// update nicelanders
		List<Nicelander> rm = new LinkedList<Nicelander>();
		;
		for (Nicelander nicelander : nicelanders) {
			if (nicelander.updateInstance()) {
				rm.add(nicelander);
			}
		}
		removeNicelander(rm);
	}

	public void removeNicelander(List<Nicelander> rm) {
		nicelanders.removeAll(rm);
	}

	public void checkFixed() {
		// Entonces, solo se ejecuta esto cuando felix repara con martillo
		//Pregunta si esta arreglado el edificio. Entonces, si subo a la ultima seccion-->subo de nivel
		//De cualquier manera, debe regenerar ventanas y reposicionar a felix (ver implementacion)
		if(isFixed()) {
			sectionUp();
			windows = WindowsGenerator.generateWindows();
			Felix.getInstnance().restartPosition();
		}
		
	}

	/**
	 * Vuelve todas las Variables de instancia a su estado original, para poder volver a jugar
	 */
	public void restartGame() {
		removeNicelander(nicelanders);
		section= Sections.FIRST;
		windows= WindowsGenerator.generateWindows();	
	}

}

enum Sections {
	FIRST, SECOND, THIRD;

}
