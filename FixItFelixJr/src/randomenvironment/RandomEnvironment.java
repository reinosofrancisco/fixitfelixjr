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
	private int genericCD;
	
	private boolean birdCollision;
	private boolean brickCollision;
	private boolean CakeCollision;

	
	public RandomEnvironment() {
		this.genericCD = 20;
		this.birdsCooldown = 20;
		this.bricksCooldown = 20;
		this.nicelanderCooldown = 20;
	}
	
	
	
	
	
	//------------------------------------------//
	//	Setters & Getters
	//------------------------------------------//
	
	public int getBricksCooldown() {
		return bricksCooldown;
	}
	private void setBricksCooldown(int bricksCooldown) {
		this.bricksCooldown = bricksCooldown;
	}
	public int getNicelanderCooldown() {
		return nicelanderCooldown;
	}
	private void setNicelanderCooldown(int nicelanderCooldown) {
		this.nicelanderCooldown = nicelanderCooldown;
	}
	public int getBirdCooldown() {
		return birdsCooldown;
	}
	private void setBirdsCooldown(int birdsCooldown) {
		this.birdsCooldown = birdsCooldown;
	}
	
	/**For Nicelanders, this will set the amount of loop iterations that he will be alive.
	For Bricks, it will give a delay after spawning a certaing amount of bricks.
	For Birds, it will give a delay after spawning a bird*/
	
	public boolean isBirdCollision() {
		return birdCollision;
	}
	public boolean isBrickCollision() {
		return brickCollision;
	}
	public boolean isCakeCollision() {
		return CakeCollision;
	}
	//------------------------------------------//	
	
	
	
	
	
	
	
	//------------------------------------------//
	//	Summoning
	//------------------------------------------//
	
	/**Summons a Bird to a linkedList */
	public void summonBirds(Vector2D pos) {
		Bird bird = new Bird();
		bird.setVector2D(pos);
		bird.setDirection(Direction.RIGHT);
		birds.addFirst(bird);
		System.out.println("Summoning Bird Pos " + pos.toString());
		if (getBirdCooldown() == 0)
			setBirdsCooldown(genericCD); //in seconds
	}
	
	/**Summons an amount of 'Brick' to a linkedList */
	public void summonBricks(Vector2D pos, int bricksAmount) {
		int i;
		for( i = 0; i<bricksAmount; i++) {
			Brick brick = new Brick();
			brick.setVector2D(pos);
			bricks.addFirst(brick);		/**Always ADD FIRST */	
		}	
		System.out.println("Summoning " + bricksAmount + " Bricks ");	
		System.out.println("[Finished] Summoning Bricks on Pos " + pos.toString());
		if (getBricksCooldown() == 0)
			setBricksCooldown(genericCD);
	}
	
	/**Summons a Nicelander to a linkedList */
	public void summonNicelander(Vector2D pos) {
		Nicelander nicelander = new Nicelander();
		nicelander.setPos(pos);
		nicelanders.addFirst(nicelander);
		outOfBoundsNicelanders(nicelander);
		System.out.println("Summoning Nicelander Pos " + pos.toString());
		if (getNicelanderCooldown() == 0)
			setNicelanderCooldown(genericCD);
	}
	
	/**If Nicelander is Out of time, it gets deleted */
	private void outOfTimeNicelander(Nicelander entity) {
		if ((entity.getScreenTime()==0)&&(entity.getCakeTime()==0))
			nicelanders.remove(entity);
	}
	
	
	
	
	
	
	
	
	//------------------------------------------//
	//	Collision
	//------------------------------------------//
	
	/** returns TRUE if Brick|Bird is colliding with the given Vector2D*/
	private boolean isCollidingBullet(Bullet entity, Vector2D pos) {
		return (entity.vector2D.equals(pos));
	}
	
	/**If Nicelander Screentime is cero, returns true.*/
	private boolean isCollidingCake(Nicelander entity, Vector2D pos) {
		if (entity.getScreenTime()==0) {
			return (entity.pos.equals(pos));
		} else return false;
	}
	
	
	
	
	
	
	
	
	//------------------------------------------//
	//	Movement
	//------------------------------------------//
	

	/**Moves the Brick|Bird on the current Direction */
	private void moveEntity (Bullet entity) {
		entity.move();
		
		/**Codigo para testear */
		if (entity instanceof Bird)
			System.out.println("[BIRD] After moving i am in position  "  + entity.getVector2D().toString());
		if (entity instanceof Brick)
			System.out.println("[BRICK] After moving i am in position  "  + entity.getVector2D().toString());
	}

	
	
	/**Verifies if Nicelander is OOB and calls the corresponding behaviour */
	private void outOfBoundsNicelanders(Nicelander nicelander) {
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
	public void timerBehaviour() {
		if (this.birdsCooldown == 0)
			this.birdsCooldown = genericCD;
		if (this.bricksCooldown == 0)
			this.bricksCooldown = genericCD;
		if (this.nicelanderCooldown == 0)
			this.nicelanderCooldown = genericCD;	
		this.birdsCooldown--;
		System.out.println("Bird CD " + this.birdsCooldown);
		this.bricksCooldown--;
		this.nicelanderCooldown--;
	}
	public boolean outOftime() {
		return ((this.birdsCooldown == 0)&&(this.bricksCooldown == 0)&&(this.nicelanderCooldown == 0));
	}

	
	/**Needs Felix Vector2D.
	 * Moves the BIRDS|BRICKS|NICELANDERS one unity.
	 * Detects OutOfBounds.
	 * Detects collision updating the Booleans.
	 * */
	public void behaviour(Vector2D felixVector) {
		
		timerBehaviour();
		
		/** Birds Behaviour */	
		LinkedList<Bullet> deleteBullets = new LinkedList<>();
		this.birdCollision=false;
		for (Bird bird : birds) {
			moveEntity(bird);
			bird.behaviourOOB(deleteBullets);
			//outOfBoundsBullets(bird,deleteBullets);
			if (isCollidingBullet(bird, felixVector)) {
				deleteBullets.addFirst(bird);
				this.birdCollision=true;
			};
		}
		birds.removeAll(deleteBullets);
		deleteBullets.clear();
				
		/**Bricks Behaviour */		
		/**CAN I DELETE OBJECTS WHILE I AM IN THE FOR-EACH? nope.*/		
		
		this.brickCollision = false;
		for (Brick brick : bricks) {
			moveEntity(brick);
			brick.behaviourOOB(deleteBullets);
			if(isCollidingBullet(brick, felixVector)) {
				deleteBullets.addFirst(brick);
				this.brickCollision = true;
			};
		}	
		bricks.removeAll(deleteBullets);
		deleteBullets.clear();
		
		
		
		/**Nicelanders Behaviour */
		LinkedList<Nicelander> deleteNicelander = new LinkedList<>();
		this.CakeCollision = false;
		for (Nicelander nicelander : nicelanders) {
			outOfBoundsNicelanders(nicelander);
			outOfTimeNicelander(nicelander);
			if (isCollidingCake(nicelander, felixVector)) {
				deleteNicelander.addFirst(nicelander);
				this.CakeCollision = true;
			};
		nicelanders.removeAll(deleteNicelander);
		}
		deleteNicelander.clear();
		


		
		
	}
	
	
	
	
	
}
