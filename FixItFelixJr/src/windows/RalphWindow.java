package windows;

import exeptions.OutOfBoundsExeption;
import util.Direction;

public class RalphWindow extends Window {

	@Override
	public void canIMove(Direction p) throws OutOfBoundsExeption {
		throw new OutOfBoundsExeption();
	}

	@Override
	public boolean canIGenerateNicelander() {
		return false;
	}

	@Override
	public int getObstacles() {
		return 0;
	}
	
	
	

}
