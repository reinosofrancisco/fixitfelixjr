package felix.game.RandomEnvironment;

public class Brick extends Bullet {
	//Locked to Down
	private final Integer direction = 2;

	public Integer getDirection() {
		return direction;
	}
	
	/**Moves the Brick down 1 position in Y.
	 * NO VERIFICA NADA*/
	public void move() {
		this.position.setPosY(this.position.getPosY() - 1);
	}

	
	
	
}


