package util;


public class Dimentions{
	
	
	/**		1 2 3
	 * 	5	O O O
	 * 	4	O O O
	 * 	3	O O O
	 * 	2	O O O
	 * 	1	O O O
	 * 	y/x	1 2 3
	 */
	
	
	static final public int UP_LIMITS = 5;		/**Height of the Building */
	static final public int RIGHT_LIMITS = 3;	/**Width of the Building*/
	
	/**Should be left in 1 for maintaining the coherence */
	static final public int DOWN_LIMITS = 1;
	static final public int LEFT_LIMITS = 1;
	
	private static Vector2D getDownLeftCorner() {
		return new Vector2D(LEFT_LIMITS,DOWN_LIMITS);
	}
	private static Vector2D getUpperRightCorner() {
		return new Vector2D(RIGHT_LIMITS,UP_LIMITS);
	}
	
	public static boolean isInsideMap(Vector2D pos) {
		if(pos.compareAllComponents(getDownLeftCorner()) &&
		getUpperRightCorner().compareAllComponents(pos)) {
			return true;
		}
		return false;		
		
	}
	
}