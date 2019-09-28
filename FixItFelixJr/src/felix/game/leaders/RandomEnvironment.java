package felix.game.leaders;

import felix.game.RandomEnvironment.*;
import felix.game.utilities.*;

public class RandomEnvironment {
	Nicelander[] nicelanders;
	Bird[] birds = new Bird[200];
	Brick[] bricks = new Brick[200];
	
	int bricksCooldown;
	int nicelanderCooldown;



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
	
public void summonBirds(Position pos) {
	Bird bird = new Bird();
	bird.setPosition(pos);
	birds[0] = bird;
}

public void summonBricks(Position pos) {
	System.out.println("Summoning Bricks Pos " + pos.toString());
}

public void summonNicelander(Position pos) {
	System.out.println("Summoning Nicelander Pos " + pos.toString());
}

public static void updatePosition(Position pos) {
	
}



/**returns true if the birs is colliding with the given position */
public boolean detectBirdCollision(Position pos) {	
	int i = 0;
	while ((this.birds[i]!=null) && (pos.isColliding(birds[i].getPosition())==false)){
		i++;
	}
	if (this.birds[i]==null)
		return (false);
		else
			return (pos.isColliding(birds[i].getPosition()));
}

/**returns true if the brick is colliding with the given position */
public boolean detectBrickCollision(Position pos) {	
	int i = 0;
	while ((pos.equals(bricks[i].getPosition())==false) && (i<this.bricks.length)){
		i++;
	}
	return (pos.equals(bricks[i].getPosition())==false);
}









}
