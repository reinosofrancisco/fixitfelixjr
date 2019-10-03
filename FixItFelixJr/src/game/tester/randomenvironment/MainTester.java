package game.tester.randomenvironment;

import randomenvironment.*;
import util.Direction;
import util.Vector2D;

public class MainTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Vector2D pos = new Vector2D();
		pos.setPosx(1);
		pos.setPosy(2);
		
		RandomEnvironment leader = new RandomEnvironment();	
		leader.summonBirds(pos);
		
		Bird pajarito = new Bird(pos);
		pajarito.setDirection(Direction.RIGHT);
		
		System.out.println("D Pos X " + Direction.RIGHT.getUnitVector().getPosx() );
		System.out.println("D Pos Y " + Direction.RIGHT.getUnitVector().getPosy() );
		
		System.out.println("Dir Pos X UV " + pajarito.getDirection().getUnitVector().getPosx());
		
		int j;
		for (j = 0; j<15; j++) {
			pajarito.move();
			//leader.outOfBoundsBullets(pajarito); now its private
			System.out.println("X - " + pajarito.getVector2D().getPosx() + " | " + "Y - " + pajarito.getVector2D().getPosy());
			
			
		}
		
		
		
		
		
		
		/**********************/
		
		
		
		
		
		

	}

}
