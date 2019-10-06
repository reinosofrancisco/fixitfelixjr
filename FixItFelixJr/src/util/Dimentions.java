package util;


public class Dimentions{
	
	
	/**		1 2 3				1  2  3  4  5
	 * 	5	O O O			 1  0  0  0  0  0
	 * 	4	O O O			 2  0  0  0  0  0
	 * 	3	O O O			 3  0  0  0  0  0
	 * 	2	O O O
	 * 	1	O O O
	 * 	y/x	1 2 3
	 */
	
	
	static final public int UP_LIMITS = 4;		/**Height of the Building */
	static final public int RIGHT_LIMITS = 5;	/**Width of the Building*/
	
	/**Should be left in 1 for maintaining the coherence */
	static final public int DOWN_LIMITS = 1;
	static final public int LEFT_LIMITS = 1;
	
//	private static Vector2D getDownLeftCorner() {
//		return new Vector2D(LEFT_LIMITS,DOWN_LIMITS);
//	}
//	private static Vector2D getUpperRightCorner() {
//		return new Vector2D(RIGHT_LIMITS,UP_LIMITS);
//	}
	
	public static boolean isInsideMap(Vector2D pos) {
		if(pos.getPosx()>=LEFT_LIMITS && pos.getPosx()<=RIGHT_LIMITS && pos.getPosy()>=DOWN_LIMITS && pos.getPosy()<=UP_LIMITS) {
			return true;
		}
		return false;		
		
//		
//		if(pos.compareAllComponents(getDownLeftCorner())!=-1 &&
//		getUpperRightCorner().compareAllComponents(pos)!=1) {
//			return true;
//		}
		
	}
	
}