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
	
	
	public Building() {
		//por defecto armo edificio lvl 1
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
	public void restartSection(Difficulty d) {
		windows=WindowsGenerator.generateWindows(this.section, d);
	}
	public void restartLevel(Difficulty d) {
		this.section=Sections.FIRST;
		windows=WindowsGenerator.generateWindows(this.section, d);		
	}
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
