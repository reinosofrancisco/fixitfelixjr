package windows;

import java.util.Random;

import util.Direction;
import util.Vector2D;

public abstract class Window 
{
	private final int points= 500;
	protected Vector2D pos;
	protected Panel[] panels; // the first panel is the one on the left bottom
	private boolean beenFixed=false;
	
	
	
	protected static final double baseProb= 0.3;
	
	public Window ()
	{
		
	}
	public Window (int panelsSize, Vector2D pos)
	{
		panels= new Panel[panelsSize];
		for (int i = 0; i < panels.length; i++) {
			panels[i]=new Panel(new Random().nextInt(3));
		}
		this.pos= pos;
	}
	public Vector2D getPos() {
		return pos;
	}
	public void setPos(Vector2D pos) {
		this.pos = pos;
	}
	public Panel[] getPanels() {
		return panels;
	}
	public void setPanels(Panel[] panels) {
		this.panels = panels;
	}
	public boolean isHealthy()
	{
		int i;
		for (i=0; i< panels.length; i++)
		{
				if(panels[i].getState() != PanelState.HEALTHY)
				{
					return false;
				}
				
		}
		return true;
	}
	public abstract boolean canIMove(Direction p);
	public abstract boolean canIGenerateNicelander();
	public int repaired()
	{
		int dev=0, i=0;
		boolean yet= false; // this boolean says if i repaired a panel previously
		while (i < panels.length && !yet)
		{
			if(panels[i].getState() != PanelState.HEALTHY)
			{
				dev= panels[i].repear();
				yet= true;
			}
			i++;
		}
		if(this.isHealthy() && !beenFixed)
		{
			beenFixed=true;
			return this.points;
		}
		else
			{
				return dev;
			}
	}
	public boolean breakWindow()
	{
			boolean yet= false; // this boolean says if i broken a panel previously
			int i=0;
			while (i< panels.length && !yet)
			{
				if (panels[i].getState() != PanelState.BROKEN)
				{
					panels[i].breakPanel();
					yet=true;
				}
				i++;
			}
			return yet;
	}
	
	
	
	
	
}
	
