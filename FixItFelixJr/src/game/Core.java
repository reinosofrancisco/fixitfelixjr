package game;




import java.util.LinkedList;
import java.util.List;

import building.Building;
import entities.Felix;
import entities.Ralph;
import randomenvironment.*;
import util.Direction;
import util.GameConstants;


public class Core {
	
	/**
	 * El core basicamente es el juego en si, hace el loop principal(anda hasta el game over),
	 * se encarga de mandar mensajes a todos los objetos de que hay hacer, a su vez maneja el nivel y la dificultad actual, Por ende, tiene instancias de todas las clases que necesita el juego para funcionar, junto con informacion para instanciarlas, En cada vuelta del loop, actualiza las posiciones de los objetos instanciados, se fija si se pueden generar tortas y/o ladrillos, chequea las colisiones entre objetos, y si las hay actua en consecuiencia, Toda la logica que se encarga de arreglar ventanas, subir de seccion/ nivel, y sumar puntos esta implementada, dado que en el recorrido preestablecido nunca se repara fue borrada.
	 */
	
	
	private static Core game;
	private Difficulty difficulty = Difficulty.getInstance();
	private Building niceland = Building.getInstance();
	private Felix felix = Felix.getInstnance();
	private Ralph ralph = Ralph.getInstance();
	private RandomEnvironment re = RandomEnvironment.getInstance();
	private HighScores highscores = HighScores.getInstance();
	private boolean playing = true;
	private int points=0;
	private boolean newHighscore=false;
	private PlayerAction nextAction=PlayerAction.NONE;
	private List<GameEvent> events;
	
	
	//PREGUNTAR
	
	private Core() {
		
	}
	
	public static Core getInstance() {
		if (game==null) {
			game=new Core();
		}
		return game;
	}
	
	public void update() {
		System.out.println("-");
		
		events=new LinkedList<GameEvent>(); //restart the events list
		
		playerAction();
		game.niceland.update();
		game.ralph.update();
		game.felix.update();//TODO
		game.re.update();	
		nextAction=PlayerAction.NONE;
		
		//---------------		
		
		System.out.println("--\n");
	}
	
	
	
	
	
	
	
	
	public void birdHit() {
		restartSection();//TODO
		if(felix.getLives() == 0)
		{
			gameOver(false);
		}
		System.out.println("Felix perdio progreso de seccion chocando con un pajaro, repite la seccion: "+ niceland.getSection());		
	}

	public void brickHit() {
		restartLevel(); //TODO
		if(felix.getLives() == 0)
		{
			gameOver(false);
		}
		System.out.println("Felix perdio una vida chocando con un ladrillo, ahora tiene: "+ felix.getLives());		
	}
	
	public void gameOver(boolean b) {
		this.playing=false;
		if(b && highscores.isHighscore(points)) {
			newHighscore=true;
		}
	}
	
	private void levelUp() {
		game.difficulty.lvlUp();
		System.out.println("\n\n\nHas completado el nivel!!\n\n\n");
		pause(1000);
		if(game.difficulty.getLvl()>=GameConstants.LEVEL_AMMOUNT) {
			gameOver(true);
		}		
		game.felix.restartPosition();
		game.niceland.levelUp();
		//niceland=new Building(difficulty);
	}


	private static void restartLevel() {
		game.felix.restartPosition();
		game.re.restartEntities();
		game.niceland.restartLevel();
		
	}


	private static void restartSection() {
		game.felix.restartPosition();
		game.niceland.restartSection();
		game.re.restartEntities();
	}

	public void restartGame() {
		game = new Core();
	
		
	}
	


	public boolean isNewHighscore() {
		//TODO
		//se comunica con highscores para saber si hubo un nuevo highscore
		return newHighscore;
		
	}
	
	// Para Comunicarse con los listeners, el key listener llama a estos metodos para indicar que hacer
	
	
	public void moveUp() {
		// TODO Auto-generated method stub
		nextAction=PlayerAction.MOVE_UP;
		
	}
	public void moveDown() {
		// TODO Auto-generated method stub
		nextAction=PlayerAction.MOVE_DOWN;
		
	}
	public void moveRight() {
		// TODO Auto-generated method stub
		nextAction=PlayerAction.MOVE_RIGHT;
	}
	public void moveLeft() {
		// TODO Auto-generated method stub
		nextAction=PlayerAction.MOVE_LEFT;
	}
	
	
	public void fix()
	{
		nextAction=PlayerAction.FIX;
	}
	/**AUTO GENERATED FOR KEYBOARD INPUTS */
	
	public boolean isPlaying() {
		return playing;
	}
	
	
	/** FOR CALLING THE METHODS ACCORDING TO nextAction **/
	private void playerAction() {
		switch (nextAction) {
		case FIX:
			points+=felix.fix();
			if(niceland.isFixed()) {
				levelUp();
			}
			break;
		case MOVE_DOWN:
			felix.move(Direction.DOWN);
			break;
		case MOVE_UP:
			felix.move(Direction.UP);
			break;
		case MOVE_LEFT:
			felix.move(Direction.LEFT);
			break;
		case MOVE_RIGHT:
			felix.move(Direction.RIGHT);
			break;
		default:
			break;
		}
		
	}
	

public static void pause(int ms) {
	try {
		Thread.sleep(ms);
	} catch (InterruptedException e) {
		System.err.format("IOException: %s%n", e);
	}
}


public int getPoints() {
	return points;
}

enum PlayerAction{
	NONE,
	MOVE_LEFT,
	MOVE_UP,
	MOVE_RIGHT,
	MOVE_DOWN,
	FIX;	
}
}