package windows;

class Panel {
	private final int life = 2;
	private int actualLife; // if actualLife =2, the panel are completely repeared

	public int getActualLife() {
		return actualLife;
	}

	public void setActualLife(int actualLife) {
		this.actualLife = actualLife;
	}

	public PanelState getState() {
		return state;
	}

	public void setState(PanelState state) {
		this.state = state;
	}

	public int getPoints() {
		return points;
	}

	private final int points = 100;
	protected PanelState state;

	Panel() {

	}

	int repear() {
		PanelState aux = PanelState.HEALTHY;
		if (this.state != aux) {
			this.setActualLife(this.getActualLife() + 1);
			this.changeState();
			if (this.getActualLife() == this.life) {
				return this.points;
			}
		}
		return 0;
	}

	boolean breakPanel() {
		if (this.state != PanelState.BROKEN) {
			this.setActualLife(this.getActualLife() - 1);
			this.changeState();
			return true;
		}
		return false;
	}

	private void changeState() {
		switch (this.actualLife) {
		case (0): {
			this.setState(PanelState.BROKEN);
		}
		case (1): {
			this.setState(PanelState.ALMOSTBROKEN);
		}
		case (2): {
			this.setState(PanelState.HEALTHY);
		}
		}
	}
}
