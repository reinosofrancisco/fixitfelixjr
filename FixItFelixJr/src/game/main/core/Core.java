package game.main.core;


import java.util.LinkedList;
import java.util.Random;
import entities.Felix;
import entities.Ralph;
import game.Difficulty;
import randomenvironment.*;
import util.Dimentions;
import util.Direction;
import util.Vector2D;
import windows.*;


public class Core {
	

	
	public static void main(String[] args) {
		
		/**CHEQUEANDO EL KEY LISTENER */
		
		
		
		
		
		/**CHEQUEANDO EL KEY LISTENER */
		
		int felixLifes = 3;
		int felixHammerCD = 1;
		int inmuneStatus = 1;
		int initBricksAmmount = 5;
		Vector2D initVectFelix = new Vector2D(2,2);
		Vector2D initVectRalph = new Vector2D(2,5);
		
		/**MAP IS 3 OF ANCHO AND 5 OF ALTO AMIGO (SIN CONTAR LA POSICION 0,0)*/
		
		LinkedList<Window> windows = new LinkedList<>();
		generateRandomWindows(windows);
		RandomEnvironment re = new RandomEnvironment();
		Felix felix = new Felix(initVectFelix,felixLifes,inmuneStatus,felixHammerCD);	
		Ralph ralph = new Ralph(initVectRalph, Direction.RIGHT, initBricksAmmount);	
		
		
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
			
			//Probando a felix
			//felix.move(Direction.UP);
			felix.move(Direction.UP);
			felix.update(re);	//Updates the hammer and the invulnerability
			
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

	
	private static void generateRandomBehaviour (Ralph ralph) {
		switch(getRandomNumber(1)) {
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
		Vector2D vRand = new Vector2D((getRandomNumber(Dimentions.WIDTH)), (getRandomNumber(Dimentions.HEIGHT)));

		switch(getRandomNumber(2)) {
			/** BIRDS */
			case 0: 
				if (re.getBirdCooldown()>10)
					re.summonBirds(vRand);
				break;
				
			/** BRICKS */
			case 1:
				if(re.getBricksCooldown() > 10)
					re.summonBricks(ralph.getPos(), ralph.deleteBricks(getRandomNumber(ralph.getBricksAmount())));
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
	
	/**No implementado, genero siempre la misma ventana */
	private static void generateRandomWindows(LinkedList<Window> ws) {
		int i;
		Vector2D initVect = new Vector2D(1,1);
		for(i=0 ; i<((Dimentions.HEIGHT)*(Dimentions.WIDTH)); i++) {
			Window w = new TwoPanels(0,initVect); //No obstaculos
			ws.add(w);
			if (initVect.getPosx() == 5) {
				initVect.add(Direction.UP.getUnitVector());
				initVect.setPosx(0);
			}
	
			
			
		}
		
	}
	
	
	
	
	
	/**Usefull Code*/
	
	private static int getRandomNumber (Integer maxValue) {
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
