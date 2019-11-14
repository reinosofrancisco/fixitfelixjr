package windows;

import exeptions.CanIMoveExeption;
import util.Direction;

public class RalphWindow extends Window {

	@Override
	public void canIMove(Direction p) throws CanIMoveExeption {
		throw new CanIMoveExeption();
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
