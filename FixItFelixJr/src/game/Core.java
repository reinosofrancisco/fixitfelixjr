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
import util.Vector2D;


public class Core {
	

	
	public static void main(String[] args) {
		
		//instancia de edificio y nivel actual
		Difficulty difficulty=new Difficulty();
		Building niceland=new Building(difficulty);
		Scores[] highScores=new Scores[6];
		testerScores(highScores);
		Scanner sc= new Scanner(System.in);
		
		//----
		int felixLifes = 3;
		int felixHammerCD = 1;
		int inmuneStatus = 1;
		int initBricksAmmount = 10;
		Vector2D initVectFelix = new Vector2D(1,1);
		Vector2D initVectRalph = new Vector2D(2,4);
		int points=0;
		
		/**MAP IS 5 OF ANCHO AND 3 OF ALTO AMIGO (SIN CONTAR LA POSICION 0,0 O LA FILA DE ARRIBA DE TODO)*/
		RandomEnvironment re = new RandomEnvironment();
		Felix felix = new Felix(initVectFelix,felixLifes,inmuneStatus,felixHammerCD);
		FelixState felixState=FelixState.DEFAULT;
		Ralph ralph = new Ralph(initVectRalph, Direction.RIGHT, initBricksAmmount);	
		
		
		boolean isBucleOn = true;
		int bucleFinish = 0;
		while (isBucleOn) {
			System.out.println("Lap number= " + (bucleFinish+1));
			System.out.println("-");
//			System.out.println(" ");
			 
			/** ------------------------------------------------------- */
			/** ------------------[ CODE ] ---------------------------- */
			/** ------------------------------------------------------- */
			
			generateTorta(niceland, re);
			generateBircks(difficulty.getDifficulty(), re, ralph);
			if (ralph.getBricksAmount() != 0) {
				ralph.breakBuilding(); //Breaking animation
			}
			/**Updates the fields of RE that have booleans giving collision information */
			re.behaviour(felix.getVector2D());
			/**After this point, the re class will have the updated Collision booleans  */
			
			ralph.move();
			
			
			
			
			
			
//			generateRandomBehaviour(ralph);
			
			

			
			felixState=felix.update(re); // Updates the hammer and the invunerabilities
			
			switch (felixState) {
			case KILLEDBYBIRD:
			{
				restartSection(felix,niceland, difficulty, re);
				System.out.println("Felix perdio progreso de seccion chocando con un pajaro, repite la seccion: "+ niceland.getSection());
				break;
			}
			case KILLEDBYBRICK:
			{
				if(felix.getLives()!=0) {
					restartLevel(felix,niceland, difficulty,re);
				}
				else {
					isBucleOn=false;
				}
				System.out.println("Felix perdio una vida chocando con un ladrillo, ahora tiene solo: "+ felix.getLives());
				break;
			}
			default:
				break;
			}
			if(bucleFinish < 4)
			{
				Direction d=  Direction.RIGHT;
				felix.move(d, niceland.getWindows());
			}
			else
			{
				if(bucleFinish < 7)
				{
					Direction d= Direction.UP;
					felix.move(d, niceland.getWindows());
				}
				else
				{
					if( bucleFinish < 10 )
					{
						Direction d= Direction.LEFT;
						felix.move(d, niceland.getWindows());
					}
				}
			}
			
			bucleFinish++;
			if (bucleFinish == 10) 
			{				
				isBucleOn = false;
			}

			System.out.println("--\n");
		}
		System.out.println("Has perdido. Ingrese nombre: ");
		highScores[5]=new Scores(sc.next(),points);
		
		Arrays.sort(highScores,Collections.reverseOrder());
		
		System.out.println("\n \n \n \n  \t  GAME OVER!" + " \nHigscores: ");
		for (int i = 0; i < highScores.length-1; i++) {
			System.out.println("\n" + highScores[i]);
		}
		
		

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



	private static void levelUp(Felix felix, Building niceland, RandomEnvironment re, Difficulty difficulty) {
		System.out.println("\n\n\nHas completado el nivel!!\n\n\n");
		pause(1000);
		felix.restartPosition();
		difficulty.setLvl(difficulty.getLvl()+1);
		niceland=new Building(difficulty);
	}


	private static void testerScores(Scores[] highScores) {
		for (int i = 0; i < highScores.length; i++) {
			highScores[i]= (new Scores("Fede("+i+")", i*100));
		}
		
	}


	private static void restartLevel(Felix felix, Building niceland,Difficulty d, RandomEnvironment re) {
		felix.restartPosition();
		felix.setCantVidas(felix.getLives()-1);
		re.restartEntities();
		niceland.restartLevel(d);
		
	}


	private static void restartSection(Felix felix, Building niceland,Difficulty d,RandomEnvironment re) {
		felix.restartPosition();
		niceland.restartSection(d);
		re.restartEntities();
		
	}




	
	

	/**Spawns BRICKS. The probability relies on the Difficulty  */
	private static void generateBircks(Double difficulty, RandomEnvironment re, Ralph ralph) {
		double num = new Random().nextDouble();
		if(num<=difficulty*.2) {
			ralph.summonBricks(difficulty,re);
		}
	}
	private static void generateTorta(Building niceland, RandomEnvironment re) {
		Vector2D posTorta=niceland.findCakeWindow();
		if(posTorta!=null) {
			if(new Random().nextDouble()<.8 && re.getNicelanderCooldown()==0) {
				re.summonNicelander(posTorta);
			}
		}
	}

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
