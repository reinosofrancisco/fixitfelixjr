package game.main.core;

import java.util.Random;

import entities.Felix;
import entities.Ralph;
import game.Difficulty;
import randomenvironment.RandomEnvironment;
import util.Dimentions;
import util.Direction;
import util.Vector2D;

public class Core {
	
	public static void main(String[] args) {
		
		RandomEnvironment re = new RandomEnvironment();
		Felix felix = new Felix();
		
		Vector2D randomV = new Vector2D(3,3);
		Ralph ralph = new Ralph(randomV, Direction.LEFT, 5);
		
		
		
		
		boolean isBucleOn = true;
		int bucleFinish = 0;
		while (isBucleOn) {
			System.out.println("Lap number= " + (bucleFinish+1));
			System.out.println("-");
			System.out.println(" ");
			 
			re = generateRandomSpawns(Difficulty.ONE.getDifficulty(), re, ralph);
			/**Updates the fields of RE that have booleans giving collision information */
			re.behaviour(felix.getVector2D());
			
			
			
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


	/**Spawns BIRDS|BRICKS|NICELANDERS. The probability relies on the Difficulty  */
	private static RandomEnvironment generateRandomSpawns(Double difficulty, RandomEnvironment re, Ralph ralph) {
		/**Falta implementar que la probabilidad de spawneo sea dada
		 * por la clase Difficulty */
		
		/**El vector vRand tiene una posicion DENTRO del mapa */
		Vector2D vRand = new Vector2D((obtenerRandom(Dimentions.WIDTH.getSize())), (obtenerRandom(Dimentions.HEIGHT.getSize())));

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
	
}
