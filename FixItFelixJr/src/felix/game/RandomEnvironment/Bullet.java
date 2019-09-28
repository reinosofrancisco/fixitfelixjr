package felix.game.RandomEnvironment;

import felix.game.utilities.Position;

public abstract class Bullet {
	
	Position position;
	

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		Position pos = new Position();
		this.position = pos;
		this.position.setPosX(position.getPosX());
		this.position.setPosY(position.getPosY());
	}
	
}
