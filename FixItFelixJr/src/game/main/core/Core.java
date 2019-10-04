package game.main.core;

import java.util.Random;
import java.util.Scanner;

import building.Building;
import entities.Felix;
import entities.Ralph;
import game.Difficulty;
import randomenvironment.*;
import util.Dimentions;
import util.Direction;
import util.Vector2D;


public class Core {
	

	
	public static void main(String[] args) {
		
		/**CHEQUEANDO EL KEY LISTENER */
		
		
		
		
		
		/**CHEQUEANDO EL KEY LISTENER */
		
		Building niceland=new Building();
		
		int felixLifes = 3;
		int felixHammerCD = 1;
		int inmuneStatus = 1;
		int initBricksAmmount = 5;
		Vector2D initVectFelix = new Vector2D(2,2);
		Vector2D initVectRalph = new Vector2D(2,5);
		
		/**MAP IS 3 OF ANCHO AND 5 OF ALTO AMIGO (SIN CONTAR LA POSICION 0,0)*/
		RandomEnvironment re = new RandomEnvironment();
		Felix felix = new Felix(initVectFelix,felixLifes,inmuneStatus,felixHammerCD);	
		Ralph ralph = new Ralph(initVectRalph, Direction.RIGHT, initBricksAmmount);	
		
		Scanner sc=new Scanner(System.in);
		
		
		
		
		boolean isBucleOn = true;
		int bucleFinish = 0;
		while (isBucleOn) {
			System.out.println("Lap number= " + (bucleFinish+1));
			System.out.println("-");
			System.out.println(" ");
			 
			/** ------------------------------------------------------- */
			/** ------------------[ CODE ] ---------------------------- */
			/** ------------------------------------------------------- */
			
			
			re = generateRandomSpawns(Difficulty.ONE.getDifficulty(), re, ralph);
			if (ralph.getBricksAmount() != 0) {
				ralph.breakBuilding(); //Breaking animation
			}
			/**Updates the fields of RE that have booleans giving collision information */
			re.behaviour(felix.getVector2D());
			/**After this point, the re class will have the updated Collision booleans  */
			
			/**
			deberia haber un Switch que verifique que tecla presiono el jugador.
			Si fue la barra espaciadora llama a felix.fix(); //este metodo buscara la ventana y actualizara su estado 
			si fue arriba, abajo, izq o derecha, llamada a 
				felix.isColliding(re);
				felix.updateAll(/**Direccion a moverse);
				felix.update();
				felix.
				
				*/

			generateRandomBehaviour(ralph);
			
			
								
			char act = getAction(sc);
			
			
			switch (act) {
			case 'w':
				felix.move(Direction.UP,niceland.getWindows());
				break;
			case 's':
				felix.move(Direction.DOWN,niceland.getWindows());
				break;
			case 'a':
				felix.move(Direction.LEFT,niceland.getWindows());
				break;
			case 'd':
				felix.move(Direction.RIGHT,niceland.getWindows());
				break;
			case 'f':
				felix.fix();
			default:
				break;
			}			
			
			//Probando a felix
			//felix.move(Direction.UP);
			felix.update(re);	//Updates the hammer and the invulnerabilitys
			
			//felix.fix(); //cant use because i still dont have the Windows
			
			
			
			
			
			
			
			
			
			/** ------------------------------------------------------- */
			/** ------------------[END OF CODE ] ---------------------- */
			/** ------------------------------------------------------- */				
			
			/** -------------- DELAY --------------*/
			pause(250); //ms
			/** -------------- DELAY --------------*/
			

			bucleFinish++;
			if (bucleFinish == 30) {
				isBucleOn = false;
			}
			
			System.out.println("\n \n \n");
		}
		

	}

	
	private static char getAction(Scanner sc) {
		System.out.println("\n HOLA! PRESIONE UNA TECLA Y APRETE ENTER"
				+ "\n Valores posibles:"
				+ "\n w: Mover arriba"
				+ "\n s: Mover abajo"
				+ "\n a: Mover izquierda"
				+ "\n d: Mover derecha)"
				+ "\n f: Arreglar"
				+ "\n cualquier otra tecla: nada");
		return sc.next().charAt(0);
		
	}


	private static void generateRandomBehaviour (Ralph ralph) {
		switch(obtenerRandom(1)) {
			case 0: ralph.move(Direction.RIGHT); break;
			case 1:	ralph.move(Direction.LEFT); break;
			default: System.out.println("This is not supposed to happen! :( ");
		
		}
		
		
		
		
	}
	
	

	/**Spawns BIRDS|BRICKS|NICELANDERS. The probability relies on the Difficulty  */
	private static RandomEnvironment generateRandomSpawns(Double difficulty, RandomEnvironment re, Ralph ralph) {
		/**Falta implementar que la probabilidad de spawneo sea dada
		 * por la clase Difficulty */
		
		/**El vector vRand tiene una posicion DENTRO del mapa */
		Vector2D vRand = new Vector2D((obtenerRandom(Dimentions.WIDTH)), (obtenerRandom(Dimentions.HEIGHT)));

		switch(obtenerRandom(2)) {
			/** BIRDS */
			case 0: 
				if (re.getBirdCooldown()>10)
					re.summonBirds(vRand);
				break;
				
			/** BRICKS */
			case 1:
				if(re.getBricksCooldown() > 10)
					re.summonBricks(ralph.getPos(), ralph.deleteBricks(obtenerRandom(ralph.getBricksAmount())));
				/**Genera un random con la cant de ladrillos de ralph. Luego elimina esa cantidad
				 * de ladrillos y los retorna como int para summonearlos */
				break;
			
			/** NICELANDERS */	
			case 2:
				if(re.getNicelanderCooldown() > 10)
					re.summonNicelander(vRand);	
				break;
		}
	
		return(re);
	}
	
	
	
	
	
	
	/**Usefull Code*/
	
	private static int obtenerRandom (Integer maxValue) {
		if (maxValue > 0) {
			return (new Random().nextInt(maxValue));
			}else return (0);
	}
	
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
