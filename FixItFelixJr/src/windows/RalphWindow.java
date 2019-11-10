package windows;

import util.Direction;

public class RalphWindow extends Window {

	@Override
	public boolean canIMove(Direction p) {
		return false;
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
