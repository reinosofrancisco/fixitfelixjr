package game;

import java.util.List;

import building.Building;
import entities.Felix;
import entities.Ralph;
import randomenvironment.Bird;
import randomenvironment.Brick;
import util.Vector2D;
import windows.Window;

public class Map {
	
	private Ralph ralph;
	private Felix felix;
	private Building niceland;
	private List<Brick> brick;
	private List<Bird> bird;
	private Difficulty currentLevel;
	
	
	public static boolean inicializacion() {
		return true;
	}
	
	
	public static boolean dropCake(){
		return false;
		
	}
	public static boolean generateNicelander() {
		return false;
		
	}
	
	public static boolean generateLadrillo() {
		return false;
		
	}
	public static boolean generatePajaro() {
		return false;
		
	}
	
	public static Window[][] getWindows() {
		return null;
		
	}
	public static Window getWindow(Vector2D p) {
		return null;
		
	}
	
	public static boolean isSectionCompleted() {
		return false;
		
	}
	
	public static boolean levelUp() {
		return false;
		
	}
	
	public boolean update() {
		return false;
		
	}
	
	
	
	
}
