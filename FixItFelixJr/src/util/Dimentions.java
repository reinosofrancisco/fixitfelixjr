package util;


public class Dimentions{
	
	
	static final public int UP_LIMITS = GameConstants.MAP_UP_LIMITS;		/**Height of the Building */
	static final public int RIGHT_LIMITS = GameConstants.MAP_RIGHT_LIMITS;	/**Width of the Building*/
	
	/**Should be left in 1 for maintaining the coherence */
	static final public int DOWN_LIMITS = GameConstants.MAP_DOWN_LIMITS;
	static final public int LEFT_LIMITS = GameConstants.MAP_LEFT_LIMITS;
	
	/**
	 * Chequea si estoy dentro del mapa
	 * @param  pregunto si pos esta dentro del mapa
	 * @return retorna true, si pos esta dentro del mapa
	 */
	public static boolean isInsideMap(Vector2D pos) {
		if(pos.getPosx()>=LEFT_LIMITS && pos.getPosx()<=RIGHT_LIMITS && pos.getPosy()>=DOWN_LIMITS && pos.getPosy()<=UP_LIMITS) {
			return true;
		}
		return false;		
	}
	
}