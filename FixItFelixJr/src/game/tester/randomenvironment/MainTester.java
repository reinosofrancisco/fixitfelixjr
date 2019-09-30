package game.tester.randomenvironment;

import felix.game.RandomEnvironment.*;
import felix.game.leaders.RandomEnvironment;
import felix.game.utilities.*;

public class MainTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Vector2D pos = new Vector2D();
		pos.setPosx(1);
		pos.setPosy(2);
		
		Bullet bird = new Bird();
		bird.setVector2D(pos);
		
		Vector2D a = bird.getVector2D();
		
		System.out.println("Vector2D X = " + a.getPosx());
		System.out.println("Vector2D Y = " + a.getPosy());
		
		
		RandomEnvironment leader = new RandomEnvironment();
		
		leader.summonBirds(pos);
		
		pos.setPosx(5);
	
		System.out.println("Detect Collision " + leader.detectBirdCollision(pos));
		
		Vector2D v = new Vector2D(1,1);
		Direction dir = Direction.DOWN;
		v = dir.getUnitVector();
		
		System.out.println(v.getPosx() + v.getPosy());
		

	}

}
