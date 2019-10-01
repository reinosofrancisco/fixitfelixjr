package windows;

import util.Direction;

class FlowerPot extends Obstacle 
{
	private static Direction dir= Direction.DOWN;
	FlowerPot()
	{
		super(dir);
	}
}
