package randomenvironment;

import java.util.LinkedList;

import util.Direction;
import util.Vector2D;

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
			bricks.addFirst(brick);		/**Always ADD FIRST */
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
	
	/**returns TRUE if the bird is colliding with the given Vector2D */
	public boolean detectBirdCollision(Vector2D pos) {		
		/**For each... recorre toda la lista, remplazando el objeto actual en la variable declarada */
		for (Bird b : birds) {
			if (pos.equals(b.getVector2D()))
				return true;
		}
		return false;
	}
	
	/**returns TRUE if the brick is colliding with the given Vector2D */
	public boolean detectBrickCollision(Vector2D pos) {	
		for (Brick b : bricks) {
			if (pos.equals(b.getVector2D()))
				return true;
		}
		return false;
	}
	
	/**
	public boolean detectCollision(Bullet entity) {
		if (entity instanceof Bird) {
			return (detectBirdCollision(entity.getVector2D()));
		}
		if (entity instanceof Brick) {
			return(detectBrickCollision(entity.getVector2D()));
		}
		return (false); //Just in case
	}*/
	
	
	//------------------------------------------//
	//	Movement
	//------------------------------------------//
	

	/**Moves the Brick|Bird on the current Direction */
	public void moveEntity (Bullet entity) {
		entity.move();
	}
	
	public void OutOfBounds(Bullet entity) {
		if (entity.detectOutOfBounds()) {
			if (entity instanceof Bird) {
				if(((Bird) entity).getDirection() == Direction.RIGHT) {
					((Bird) entity).setDirection(Direction.LEFT);
				}else ((Bird) entity).setDirection(Direction.RIGHT);
			} else
				if (entity instanceof Brick) {
					/** Since we add the bricks at first, we just
					 * destroy the last one because if will be the
					 * first brick to hit the OUB*/
					bricks.removeLast();				
			}		
		}
	}
	
	
	
	
	
	
	
	
	
	
}
