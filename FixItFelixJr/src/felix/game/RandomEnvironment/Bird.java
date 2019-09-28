package felix.game.RandomEnvironment;

import felix.game.utilities.Position;

public class Bird extends Bullet {
	//locked to Left and Right (3 y 4)
	Integer direction;

	public Integer getDirection() {
		return direction;
	}

	public void setDirection(Integer direction) {
		this.direction = direction;
	}	
	
	public Bird() {}
	public Bird(Position pos) {
		this.setPosition(pos);
		
	}
	
	/**Moves the Bird one position to left / right 
	 * (3 LEFT -- 4 RIGHT)
	 * NO VERIFICA NADA*/
	public void move(int dir) {
		this.direction = dir;
		if (this.direction == 3)
			this.position.setPosX(this.position.getPosY() + 1);
		else
			this.position.setPosX(this.position.getPosY() - 1);
	}

}
