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
	
	
	
	protected static final double baseProb= 0.2;
	
	public Window ()
	{
		
	}
	public Window (int panelsSize, Vector2D pos, double dif)
	{
		panels= new Panel[panelsSize];
		Random r=new Random();
		for (int i = 0; i < panels.length; i++) {
			double num=r.nextDouble();
			if(num<baseProb*dif) {
				panels[i]=new Panel(r.nextInt(2));
			}
			else {
				panels[i]=new Panel(r.nextInt(2)+1);
			}
						
			
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
	/**
	 * Chequea si la ventana se encuentra sana o no.
	 * @return retorna true si la ventana esta completamente sana, es decir los paneles estan todos sanos.
	 */
	public boolean isHealthy()
	{
		int i;
		if(panels!=null) {
			for (i=0; i< panels.length; i++)
			{
				if(panels[i].getState() != PanelState.HEALTHY)
				{
					return false;
				}
				
			}
		}
		return true;
	}
	/**
	 * Chequea si me puedo mover
	 * @param p indica en la direccion en la que me quiero mover
	 * @return retorna true si efectivamente me puedo mover
	 */
	public abstract boolean canIMove(Direction p);
	/**
	 * chequea si en la ventana actual puede aparecer un nicelander
	 * @return retorna true si puede aparecer uno
	 */
	public abstract boolean canIGenerateNicelander();
	/**
	 *  repara un panel de la ventana en cuestion, comienza por el de mas abajo(la pos 0 del arreglo) y va "subiendo"
	 * @return returna la cantidad de puntos de arreglar una ventana si fue totalmente arreglada
	 */
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
	/**
	 * rompe un panel que no este totalmente roto
	 * @return retorna verdadero si pudo romper un panel
	 */
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
	
