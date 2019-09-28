package felix.game.utilities;

public class Position {
	
	Integer posX;
	Integer posY;
	
	public Position() {};
	
	public Position(Integer posX, Integer posY) {
		super();
		this.posX = posX;
		this.posY = posY;
	}
	
	
	
	
	
	public Integer getPosX() {
		return posX;
	}
	public void setPosX(Integer posX) {
		this.posX = posX;
	}
	public Integer getPosY() {
		return posY;
	}
	public void setPosY(Integer posY) {
		this.posY = posY;
	}
	
	public String toString() {
		return ("[" + Integer.toString(this.posX) + "] [" + Integer.toString(this.posY) + "]");
		
	}
	
	/**returns true if the given position matches the actual position */ 
	public boolean isColliding(Position posA) {
		if ((posA.posX == this.posX) && (posA.posY == this.posY) )
			return (true);
		else return (false);
	}
	
	

}
