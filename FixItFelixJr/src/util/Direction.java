package util;

public enum Direction 
{
	UP(new Vector2D(0,1)),
	DOWN(new Vector2D(0,-1)),
	LEFT(new Vector2D (-1,0)),
	RIGHT(new Vector2D(1,0)),
	UNDIFINED(new Vector2D(0,0));
	
	private Vector2D unitVector;
	
	Direction(Vector2D unitVector)
	{
		this.unitVector= unitVector;
	}
	public Vector2D getUnitVector() {
		return unitVector;
	}
	public void setUnitVector(Vector2D unitVector) {
		this.unitVector = unitVector;
	}
	
}
