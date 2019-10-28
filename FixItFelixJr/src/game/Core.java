package game;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;
import building.Building;
import entities.Felix;
import entities.Ralph;
import randomenvironment.*;
import util.Direction;
import util.GameConstants;
import util.Vector2D;


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
	
	private Core() {
		
	}
	public static Core getInstance() {
		if (game==null) {
			game=new Core();
		}
		return game;
	}
	
	
	
	
	public static void main(String[] args) {
		
		
		Scanner sc= new Scanner(System.in);
		int bucleFinish = 0;
		Core game = getInstance();
		
		
		
		int points=0;
		
		//instancia de edificio y nivel actual
//		Difficulty difficulty=Difficulty.getInstance();
//		Building niceland=Building.getInstance();
//		Scores[] highScores=new Scores[6];
//		Felix felix = Felix.getInstnance();
//		Ralph ralph = Ralph.getInstance();	
//		RandomEnvironment re = RandomEnvironment.getInstance();
		
		testerScores(game.highScores);
		
		
		/**MAP IS 5 OF ANCHO AND 3 OF ALTO AMIGO (SIN CONTAR LA POSICION 0,0 O LA FILA DE ARRIBA DE TO DO)*/
		
		
		while (game.isBucleOn) {
			System.out.println("Lap number= " + (bucleFinish+1));
			System.out.println("-");
//			System.out.println(" ");
			 
			/** ------------------------------------------------------- */
			/** ------------------[ CODE ] ---------------------------- */
			/** ------------------------------------------------------- */
			
			
			game.niceland.update();
			game.ralph.update();
			game.felix.update();//TODO
			game.re.update();
			
			
			//-----------------------------
//			generateTorta(niceland, re);
//			generateBircks(difficulty.getDifficulty(), re, ralph, niceland);			
			/**Updates the fields of RE that have booleans giving collision information */
//			re.behaviour(felix.getVector2D());
			/**After this point, the re class will have the updated Collision booleans  */			
//			ralph.move();			
//			generateRandomBehaviour(ralph);
//			//TODO arrreglar felix state
//			felixState=felix.update(re); // Updates the hammer and the invunerabilities//			
//			switch (felixState) {
//			case KILLEDBYBIRD:
//			{
//				restartSection(felix,niceland, difficulty, re);
//				System.out.println("Felix perdio progreso de seccion chocando con un pajaro, repite la seccion: "+ niceland.getSection());
//				break;
//			}
//			case KILLEDBYBRICK:
//			{
//				if(felix.getLives()!=0) {
//					restartLevel(felix,niceland, difficulty,re);
//				}
//				else {
//					isBucleOn=false;
//				}
//				System.out.println("Felix perdio una vida chocando con un ladrillo, ahora tiene: "+ felix.getLives());
//				break;
//			}
//			default:
//				break;
//			}	
			//--------------------------------
			if(bucleFinish < 4)
			{
				Direction d=  Direction.UP;
				game.felix.move(d);
				points+=game.felix.fix();
				points+=game.felix.fix();
				points+=game.felix.fix();
				points+=game.felix.fix();
			}
			else
			{
				if(bucleFinish < 7)
				{
					Direction d= Direction.UP;
					game.felix.move(d);
				}
				else
				{
					if( bucleFinish < 10 )
					{
						Direction d= Direction.UP;
						game.felix.move(d);
					}
				}
			}
						
			//---------------
			
			bucleFinish++;
			if (bucleFinish == 10) 
			{				
				game.isBucleOn = false;
			}

			System.out.println("--\n");
		}
		System.out.println("Has perdido. Ingrese nombre: ");
		game.highScores[5]=new Scores(sc.next(),points);
		
		Arrays.sort(game.highScores,Collections.reverseOrder());
		
		System.out.println("\n \n \n \n  \t  GAME OVER!" + " \nHigscores: ");
		for (int i = 0; i < game.highScores.length-1; i++) {
			System.out.println("\n" + game.highScores[i]);
		}
		sc.close();
	}
			
			/*char act = getAction(sc);

			switch (act) {
			case 'w':
				felix.move(Direction.UP, niceland.getWindows());
				break;
			case 's':
				felix.move(Direction.DOWN, niceland.getWindows());
				break;
			case 'a':
				felix.move(Direction.LEFT, niceland.getWindows());
				break;
			case 'd':
				felix.move(Direction.RIGHT, niceland.getWindows());
				break;
			case 'f':
				points+=felix.fix(niceland.getWindows());
				if(niceland.isFixed()) {
					if(niceland.getSection()==Sections.THIRD) {
						levelUp(felix,niceland,re,difficulty);				
					}
					else {
						niceland.sectionUp();
					}
				}
			default:
				break;
			}
			*/
			
			
			/** ------------------------------------------------------- */
			/** ------------------[END OF CODE ] ---------------------- */
			/** ------------------------------------------------------- */

			/** -------------- DELAY -------------- */
//			pause(250); // ms
			/** -------------- DELAY -------------- */

//


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




	
	

	/**Spawns BRICKS. The probability relies on the Difficulty  */
//	private static void generateBircks(Double difficulty, RandomEnvironment re, Ralph ralph, Building niceland) {
//		double num = new Random().nextDouble();
//		if(num<=difficulty*.2) {
//			ralph.summonBricks(difficulty,re);
//			ralph.breakBuilding(difficulty, niceland.getWindows());
//		}
//	}
//	private static void generateTorta(Building niceland, RandomEnvironment re) {
//		Vector2D posTorta=niceland.findCakeWindow();
//		if(posTorta!=null) {
//			if(new Random().nextDouble()<.8 && re.getNicelanderCooldown()==0) {
//				re.summonNicelander(posTorta);
//			}
//		}
//	}

	/**Usefull Code*/
	
	/**Pauses the program for x [ms] */
	public static void pause(int ms) {
	    try {
	        Thread.sleep(ms);
	    } catch (InterruptedException e) {
	        System.err.format("IOException: %s%n", e);
	    }
	}


	/**AUTO GENERATED FOR KEYBOARD IMPUTS */
	
	
}
