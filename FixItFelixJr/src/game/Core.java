package game;




import building.Building;
import entities.Felix;
import entities.Ralph;
import graphicInterface.GameWindow;
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
	private Scores[] highScores = new Scores[6];
	private Felix felix = Felix.getInstnance();
	private Ralph ralph = Ralph.getInstance();
	private RandomEnvironment re = RandomEnvironment.getInstance();
	private boolean isBucleOn = true;
	// La variable afuera para que sea reconocible por los metodos
	private int points=0;
	private GameWindow gameWin= new GameWindow();
	
	private Core() {
		
	}
	public static Core getInstance() {
		if (game==null) {
			game=new Core();
		}
		return game;
	}
	
	public static void main(String[] args) {
		
		
		int bucleFinish = 0;
		Core game = getInstance();
		while (game.isBucleOn) {
			System.out.println("Lap number= " + (bucleFinish+1));
			System.out.println("-");
			
			/** ------------------------------------------------------- */
			/** ------------------[ CODE ] ---------------------------- */
			/** ------------------------------------------------------- */
			
			game.niceland.update();
			game.ralph.update();
			game.felix.update();//TODO
			game.re.update();					
			//---------------
			
			bucleFinish++;
			

			System.out.println("--\n");
			pause(1000);
			
		}
	}
	public void birdHit() {
		restartSection(); //TODO
		System.out.println("Felix perdio progreso de seccion chocando con un pajaro, repite la seccion: "+ niceland.getSection());		
	}

	public void brickHit() {
		restartLevel(); //TODO
		System.out.println("Felix perdio una vida chocando con un ladrillo, ahora tiene: "+ felix.getLives());		
	}
	
	public void gameOver() {
		this.isBucleOn=false;
	}
	
	private static void levelUp() {
		game.difficulty.lvlUp();
		System.out.println("\n\n\nHas completado el nivel!!\n\n\n");
		pause(1000);
		if(game.difficulty.getLvl()==GameConstants.LEVEL_AMMOUNT) {
			//GANASTEEEE
		}		
		game.felix.restartPosition();
		game.niceland.levelUp();
		//niceland=new Building(difficulty);
	}


	private static void testerScores(Scores[] highScores) {
		for (int i = 0; i < highScores.length; i++) {
			highScores[i]= (new Scores("Fede("+i+")", i*100));
		}
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


	public static void pause(int ms) {
	    try {
	        Thread.sleep(ms);
	    } catch (InterruptedException e) {
	        System.err.format("IOException: %s%n", e);
	    }
	}

	
	// Para Comunicarse con los listeners, el key listener llama a estos metodos para indicar que hacer
	public boolean move(Direction d)
	{
		return felix.move(d);
	}
	public void fix()
	{
		points+=felix.fix();
	}
	/**AUTO GENERATED FOR KEYBOARD IMPUTS */
	
	
}
