package windows;

class Panel {
	private final int life = 2;
	private int actualLife; // if actualLife =2, the panel are completely repeared
	private final int points = 100;
	protected PanelState state;

	Panel(int n) {
		actualLife=n;
		changeState();
		
	}
	
	
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



	int repair() {
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
 /**
  * Rompe un panel 
  * @return retorna true si puedo romper
  */
	boolean breakPanel() {
		if (this.state != PanelState.BROKEN) {
			this.setActualLife(this.getActualLife() - 1);
			this.changeState();
			return true;
		}
		return false;
	}
	/**
	 * cambia el estado del panel
	 */

	private void changeState() {
		switch (this.actualLife) {
		case (0): {
			this.setState(PanelState.BROKEN);
			break;
		}
		case (1): {
			this.setState(PanelState.ALMOSTBROKEN);
			break;
		}
		case (2): {
			this.setState(PanelState.HEALTHY);
			break;
		}
		default: System.out.println("WHOPS"); break;
		}
	}
}
