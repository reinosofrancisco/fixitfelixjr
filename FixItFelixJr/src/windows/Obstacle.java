package windows;

import exceptions.CanIMoveExeption;
import util.Direction;

public abstract class  Obstacle 
{
	protected Direction dir;
	Obstacle(Direction dir)
	{
		this.dir= dir;
	}
	/**
	 * Chequea si me puedo mover en una direccion deseada
	 * @param d es la direccion en la que me quiero mover
	 * @return retorna true si me puedo mover en la direccion indicada por el parametro
	 */
	public void canIMove(Direction d) throws CanIMoveExeption
	{
		
		if(dir.getUnitVector().equals(d.getUnitVector()))
		{
			throw new CanIMoveExeption();
		}
	}
}
