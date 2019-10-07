package building;



import game.Difficulty;
import util.Direction;
import util.Vector2D;
import windows.Window;
import windows.WindowsGenerator;

public class Building 
{
	private Sections section;
	private Window[][] windows;
	
	/**
	 * Por defecto se inicializa edificion con dificultad 1
	 */
	public Building() {
		this(new Difficulty());
	}
	public Building(Difficulty d) {
		this.section=Sections.FIRST;
		windows=WindowsGenerator.generateWindows(section,d);
	}
	
	
	
	public Window[][] getWindows() {
		return windows;
	}
	
	 public void setWindows(Window[][] windows) {
		this.windows = windows;
	}
	 
	public Sections getSection() {
		return section;
	}
	
	public void setSection(Sections section) {
		this.section = section;
	}
	
	/**
	 * Se pregunta si estando en la posicion actual me puedo mover a la posicion que quiero
	 * @param posAct representa la posicion actual
	 * @param posWanted representa la posicion a la que quiero ir
	 * @return retorna true si me puedo mover en la direccion que quiero
	 */
	public boolean canIMove(Vector2D posAct, Direction posWanted)
	{
		int i=0, j=0, f=0,c=0;
		boolean found= false;
		while(i< windows.length && !found)
		{
			while(j<windows[0].length && !found)
			{
				if(windows[i][j].getPos().isEquals(posAct))
				{
					f=i;
					c=j;
					found= true;
				}
				j++;
			}
			i++;
		}
		if(found)
		{
			return windows[f][c].canIMove(posWanted);
		}
		return false;
	}
	/**
	 * Busca una ventana donde se puede dejar una torta
	 * @return devuelve la posicion de la ventana donde se puede generar la torta
	 */
	public Vector2D findCakeWindow() {
		int i=0,j=0;
		boolean stop=false;
		while(i!=windows.length && !stop) {
			while(j!=windows[i].length && !stop) {
				stop=windows[i][j].canIGenerateNicelander();
				j++;
			}
			i++;
			}
		return stop ? new Vector2D(i,j):null;
		}
	/**
	 * Cambia la seccion actual por la siguiente
	 * @return retorna true si pudo cambiarla
	 */
	public boolean sectionUp()
	{
		switch(this.section)
		{
			case FIRST:
			{
				this.setSection(Sections.SECOND);
				return true;
			}
			case SECOND:
			{
				this.setSection(Sections.THIRD);
				return true;
			}
			case THIRD:
			{
				this.setSection(Sections.FIRST);
				return true;
			}
			default: return false;
		}
	}
	/**
	 * Vuelve a comenzar la seccion actual
	 * @param d Representa la dificultad actual, a mas dificultad mas ventanas rotas
	 */
	public void restartSection(Difficulty d) {
		windows=WindowsGenerator.generateWindows(this.section, d);
	}
	/**
	 * Vuelve a comenzar el nivel actual
	 * @param d Representa la dificultad actual, a mas dificultad mas ventanas rotas
	 */
	public void restartLevel(Difficulty d) {
		this.section=Sections.FIRST;
		windows=WindowsGenerator.generateWindows(this.section, d);		
	}
	/**
	 * Chequea si todas las ventanas de la seccion actual estan sanas
	 * @return retorna true si todas las ventanas estan sanas
	 */
	public boolean isFixed() {
		for (int i = 0; i < windows.length; i++) {
			for (int j = 0; j < windows[i].length; j++) {
				if(!windows[i][j].isHealthy()) {
					return false;
				}
			}
		}
		return true;
	}
	
	
	
	
	
}
