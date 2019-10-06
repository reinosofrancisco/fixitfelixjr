package randomenvironment;


import util.Direction;

public class Brick extends Bullet {
	
	private final Direction direction = Direction.DOWN;
	private double mult;

	public Brick() {
		mult=1;
	}
	public Brick(double m) {
		mult=m;
	}
	
	public Direction getDirection() {
		return direction;
	}
	
	public void setMult(double m) {
		mult=m;
	}
	
	/**Moves the Brick down 1 Vector2D in Y.	*/
	public boolean move() {
		this.vector2D = this.vector2D.add(Direction.DOWN.getUnitVector().product(mult*.2));
		return detectOutOfBounds();
		
	}
	
	
//	public void behaviourOOB(LinkedList<Bullet> deleteBullets){
//		if (this.detectOutOfBounds())
//			deleteBullets.addFirst(this);
//		
//	}
	
	
}


