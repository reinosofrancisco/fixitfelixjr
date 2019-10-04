package windows;

import building.Building;
import building.Sections;
import util.Vector2D;

public class WindowsGenerator 
{
	public WindowsGenerator()
	{
		
	}
	public static Window[][] generateWindows(Building niceland)
	{
			int rand=0;
			Window[][] wind= new Window[3][5];
			int f,c;
			for(f=0;f<wind.length;f++)
			{
				for(c=0;c<wind[0].length; c++)
				{
					Vector2D pos= new Vector2D(f,c);
					rand= (int) (Math.random()*2);
					switch(rand)
					{
						case(0): // generate Two Panels windows
						{
							wind[f][c]= new TwoPanels(pos);
							break;
						}
						case(1): //generete WithLeaves windows
						{
							wind[f][c]= new WithLeaves(pos);
							break;
						}
						default: break;
					}
					pos.setPosx(pos.getPosx() +1);
				}
			}
			System.out.println("pt");
			if(niceland.getSection() == Sections.FIRST)
			{
				Vector2D pos= new Vector2D(1,4);
				wind[1][2]= new HalfCircle(4, pos);
				Vector2D p= new Vector2D(2,4);
				wind[2][2]= new HalfCircle(8, p);
			}
			
			return wind;
	}
}
