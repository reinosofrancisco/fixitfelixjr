package randomenvironment;

import java.util.LinkedList;

import util.Dimentions;
import util.Vector2D;

public class RandomEnvironment {
	
	LinkedList<Nicelander> nicelanders = new LinkedList<>();
	LinkedList<Bird> birds = new LinkedList<>();
	LinkedList<Brick> bricks = new LinkedList<>();
	
	//Avoids multiple instances of Objects at the same time
	int bricksCooldown;
	int nicelanderCooldown;
	private int genericCD;
	
	private boolean birdCollision;
	private boolean brickCollision;
	private boolean CakeCollision;

	
	public RandomEnvironment() {
		this.genericCD = 20;
		this.bricksCooldown = 1;
		this.nicelanderCooldown = 0;
		
		birds.addFirst(new Bird(new Vector2D(Dimentions.RIGHT_LIMITS,Dimentions.UP_LIMITS)));
		birds.addFirst(new Bird(new Vector2D(Dimentions.LEFT_LIMITS,Dimentions.UP_LIMITS-1)));
		
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
	
//	/**Summons a Bird to a linkedList */
//	public void summonBirds(Vector2D pos) {
//		Bird bird = new Bird();
//		bird.setVector2D(pos);
//		bird.setDirection(Direction.RIGHT);
//		birds.addFirst(bird);
//		System.out.println("Summoning Bird Pos " + pos.toString());
//		if (getBirdCooldown() == 0)
//			setBirdsCooldown(genericCD); //in seconds
//	}
	
	/**Summons an amount of 'Brick' to a linkedList */
	public void summonBricks(Vector2D pos, int bricksAmount,double dif) {
		int i;
		for( i = 0; i<bricksAmount; i++) {
			Brick brick = new Brick(dif);
			brick.setVector2D(pos);
			bricks.addFirst(brick);		/**Always ADD FIRST */	
		}	
		System.out.println("Summoning " + bricksAmount + " Bricks on " + pos.toString());	
		setBricksCooldown(genericCD);
	}
	
	/**Summons a Nicelander to a linkedList */
	public void summonNicelander(Vector2D pos) {
		Nicelander nicelander = new Nicelander(pos,30,15);
		nicelander.setPos(pos);
		nicelanders.addFirst(nicelander);
		System.out.println("Summoning Nicelander Pos:  " + pos.toString());
	}
	
	/**If Nicelander is Out of time, it gets deleted */
	private void outOfTimeNicelander(Nicelander entity) {
		if ((entity.getScreenTime()==0)&&(entity.getCakeTime()==0))
			nicelanders.remove(entity);
	}
	
	
	
	
	
	
	
	
	//------------------------------------------//
	//	Collision
	//------------------------------------------//
	
	
	
	
	
	//------------------------------------------//
	//	Movement
	//------------------------------------------//
	

//	/**Moves the Brick|Bird on the current Direction */
//	private void moveEntity (Bullet entity) {
//		entity.move();
//		
//		/**Only for Testing */
//		if (entity instanceof Bird)
//		if (entity instanceof Brick)
//	}
	

	
	//------------------------------------------//
	//	ONE - LAP OF THE LOOP
	//------------------------------------------//
	
	public void reduceCooldowns() {
		this.bricksCooldown--;
		this.nicelanderCooldown--;
	}
	

	
	/**Needs Felix Vector2D.
	 * Moves the BIRDS|BRICKS one unity.
	 * Detects OutOfBounds.
	 * Detects collision updating the Booleans.
	 * */
	public void behaviour(Vector2D felixVector) {
		
		reduceCooldowns();
		
		LinkedList<Bullet> deleteBullets = new LinkedList<>();
		
		
		/** Birds Behaviour */	
		this.birdCollision=false;
		for (Bird bird : birds) {
//			moveEntity(bird);
			bird.move();
			System.out.println("[BIRD] After moving i am in position  "  + bird.getVector2D().toString());
			if (bird.isColliding(felixVector)) {
				deleteBullets.addFirst(bird);
				this.birdCollision=true;
			};
		}
		birds.removeAll(deleteBullets);
		deleteBullets.clear();
		
		
		/**Bricks Behaviour */		
		this.brickCollision = false;
		for (Brick brick : bricks) {			
			//if i collide with felix or get out of the map after moving
			if(brick.isColliding(felixVector)) {
				this.brickCollision = true;
			}
			if(brick.move()) {
				deleteBullets.addFirst(brick);
			}
			System.out.println("[BRICK] After moving i am in position  "  + brick.getVector2D().toString());				
		}	
		bricks.removeAll(deleteBullets);
		deleteBullets.clear();
		
		
		/**Nicelanders Behaviour */
		LinkedList<Nicelander> deleteNicelander = new LinkedList<>();
		this.CakeCollision = false;
		for (Nicelander nicelander : nicelanders) {
			outOfTimeNicelander(nicelander);
			if (nicelander.isColliding(felixVector)) {
				deleteNicelander.addFirst(nicelander);
				this.CakeCollision = true;
			};
		}
		nicelanders.removeAll(deleteNicelander);
		deleteNicelander.clear();
		


		
		
	}





	public void restartEntities() {
		
		nicelanders = new LinkedList<>();
		birds = new LinkedList<>();
		bricks = new LinkedList<>();
		
		birds.addFirst(new Bird(new Vector2D(Dimentions.RIGHT_LIMITS,Dimentions.UP_LIMITS)));
		birds.addFirst(new Bird(new Vector2D(Dimentions.LEFT_LIMITS,Dimentions.UP_LIMITS-1)));
		
	}
	
	
//UNUSED	
//	public boolean outOftime() {
//		return ((this.birdsCooldown == 0)&&(this.bricksCooldown == 0)&&(this.nicelanderCooldown == 0));
//	}
	
	
}
