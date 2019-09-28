package game.tester.randomenvironment;

import felix.game.RandomEnvironment.*;
import felix.game.leaders.RandomEnvironment;
import felix.game.utilities.Position;

public class MainTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Position pos = new Position();
		pos.setPosX(1);
		pos.setPosY(2);
		
		Bullet bird = new Bird();
		bird.setPosition(pos);
		
		Position a = bird.getPosition();
		
		System.out.println("Position X = " + a.getPosX());
		System.out.println("Position Y = " + a.getPosY());
		
		
		RandomEnvironment leader = new RandomEnvironment();
		
		leader.summonBirds(pos);
		
		pos.setPosX(5);
	
		System.out.println("Detect Collision " + leader.detectBirdCollision(pos));
		
		
		

	}

}
