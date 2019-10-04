package building;



import util.Direction;
import util.Vector2D;
import windows.Window;
import windows.WindowsGenerator;

public class Building 
{
	private Window[][] windows;
	private Sections section=Sections.FIRST;
	//private LinkedList<NiceLanders> niceladers;
//	private static Building instance= new Building();
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
	/*LinkedList<NiceLanders> getNiceladers() {
		return niceladers;
	}
	void setNiceladers(LinkedList<NiceLanders> niceladers) {
		this.niceladers = niceladers;
	}
	*/
	public Building()
	{
		this.windows= new Window[5][3];
		this.section= Sections.FIRST;
		this.windows=WindowsGenerator.generateWindows(this);;
	}
//	public static Building getInstance()
//	{
//		return instance;
//				
//	}
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
}
