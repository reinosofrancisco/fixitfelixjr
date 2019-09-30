package felix.game.leaders;

import java.util.LinkedList;

import felix.game.RandomEnvironment.*;
import felix.game.utilities.*;

public class RandomEnvironment {
	
	LinkedList<Nicelander> nicelanders = new LinkedList<>();
	LinkedList<Bird> birds = new LinkedList<>();
	LinkedList<Brick> bricks = new LinkedList<>();
	
	//Avoids multiple instances of Objects at the same time
	int bricksCooldown;
	int nicelanderCooldown; 
	int birdsCooldown;

	
	
	//------------------------------------------//
	//	Setters & Getters
	//------------------------------------------//
	public int getBricksCooldown() {
		return bricksCooldown;
	}
	public void setBricksCooldown(int bricksCooldown) {
		this.bricksCooldown = bricksCooldown;
	}
	public int getNicelanderCooldown() {
		return nicelanderCooldown;
	}
	public void setNicelanderCooldown(int nicelanderCooldown) {
		this.nicelanderCooldown = nicelanderCooldown;
	}
	//------------------------------------------//	
	
	
	
	
	
	//------------------------------------------//
	//	Summoning
	//------------------------------------------//
	
	/**Summons a Bird to a linkedList */
	public void summonBirds(Vector2D pos) {
		Bird bird = new Bird();
		bird.setVector2D(pos);
		birds.add(bird);
	}
	/**Summons an amount of 'Brick' to a linkedList */
	public void summonBricks(Vector2D pos, int bricksAmount) {
		int i;
		for( i = 0; i<bricksAmount; i++) {
			Brick brick = new Brick();
			brick.setVector2D(pos);
			bricks.add(brick);
			System.out.println("Summoning the Brick number " + i);		
		}	
		System.out.println("[Finished] Summoning Bricks on Pos " + pos.toString());
	}
	/**Summons a Nicelander to a linkedList */
	public void summonNicelander(Vector2D pos) {
		Nicelander nicelander = new Nicelander();
		nicelander.setPos(pos);
		nicelanders.add(nicelander);
		System.out.println("Summoning Nicelander Pos " + pos.toString());
	}
	
	
	
	
	
	//------------------------------------------//
	//	Collision
	//------------------------------------------//
	
	/**returns true if the bird is colliding with the given Vector2D */
	public boolean detectBirdCollision(Vector2D pos) {		
		/**For each... recorre toda la lista, remplazando el objeto actual en la variable declarada */
		for (Bird b : birds) {
			if (pos.equals(b.getVector2D()))
				return true;
		}
		return false;
	}
	
	/**returns true if the brick is colliding with the given Vector2D */
	public boolean detectBrickCollision(Vector2D pos) {	
		for (Brick b : bricks) {
			if (pos.equals(b.getVector2D()))
				return true;
		}
		return false;
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
