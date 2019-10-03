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
		birds.addFirst(bird);
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
		nicelanders.addFirst(nicelander);
		outOfBoundsNicelanders(nicelander);
		System.out.println("Summoning Nicelander Pos " + pos.toString());
	}
	
	/**If Nicelander is Out of time, it gets deleted */
	public void outOfTimeNicelander(Nicelander entity) {
		if ((entity.getScreenTime()==0)&&(entity.getCakeTime()==0))
			nicelanders.remove(entity);
	}
	
	
	
	
	
	
	
	
	//------------------------------------------//
	//	Collision
	//------------------------------------------//
	
	/** returns TRUE if Brick|Bird is colliding with the given Vector2D*/
	public boolean isCollidingBullet(Bullet entity, Vector2D pos) {
		return (entity.vector2D.equals(pos));
	}
	
	/**If Nicelander Screentime is cero, returns true.*/
	public boolean isCollidingCake(Nicelander entity, Vector2D pos) {
		if (entity.getScreenTime()==0) {
			return (entity.pos.equals(pos));
		} else return false;
	}
	
	
	
	
	
	
	
	
	//------------------------------------------//
	//	Movement
	//------------------------------------------//
	

	/**Moves the Brick|Bird on the current Direction */
	public void moveEntity (Bullet entity) {
		entity.move();
	}

	
	/**Verifies if Brick|Bird is OOB and calls the corresponding behaviour */
	public void outOfBoundsBullets(Bullet entity) {
		if (entity.detectOutOfBounds()) {
			if (entity instanceof Bird) {
				if(((Bird) entity).getDirection() == Direction.RIGHT) {
					((Bird) entity).setDirection(Direction.LEFT);
				}else ((Bird) entity).setDirection(Direction.RIGHT);
			} else
				if (entity instanceof Brick) {
					/** Since we add the bricks at first, we just
					 * destroy the last one because if will be the
					 * first brick to hit the OOB*/
					bricks.removeLast();				
				}		
		}
	}
	
	/**Verifies if Nicelander is OOB and calls the corresponding behaviour */
	public void outOfBoundsNicelanders(Nicelander nicelander) {
		if (nicelander.detectOutOfBounds()) {
			nicelanders.removeLast();
			/** Since we add the nicelanders at first, we just
			 * destroy the last one because if will be the
			 * first nicelander to hit the OOB*/
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	//------------------------------------------//
	//	Pseudo-Big Loop
	//------------------------------------------//
	
	/**Needs Felix Vector2D */
	public void pseudoBigLoop(Vector2D felixVector) {
		
		/** Birds Behaviour */
		for (Bird bird : birds) {
			moveEntity(bird);
			outOfBoundsBullets(bird);
			isCollidingBullet(bird, felixVector);
		}
				
		/**Bricks Behaviour */
		outOfBoundsBullets(bricks.peekLast()); //Only the last brick can be OOB
		for (Brick brick : bricks) {
			moveEntity(brick);
			isCollidingBullet(brick, felixVector);
		}	
		
		/**Nicelanders Behaviour */
		for (Nicelander nicelander : nicelanders) {
			outOfBoundsNicelanders(nicelander);
			outOfTimeNicelander(nicelander);
			isCollidingCake(nicelander, felixVector);
		}
		
		
	}
	
	
	
	
	
}
