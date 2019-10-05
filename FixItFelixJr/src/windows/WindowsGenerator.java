package windows;

import java.util.Random;

import building.Sections;
import game.Difficulty;
import util.Dimentions;
import util.Vector2D;

public class WindowsGenerator 
{
	public WindowsGenerator()
	{
		
	}
	public static Window[][] generateWindows(Sections sec,Difficulty d)
	{
			Random rand=new Random();
			Window[][] wind= new Window[Dimentions.RIGHT_LIMITS][Dimentions.UP_LIMITS];
			int f,c;
			double dif=d.getDifficulty();
			for(f=0;f<wind.length;f++)
			{
				for(c=0;c<wind[0].length; c++)
				{
					Vector2D pos= new Vector2D(f,c);
					switch(rand.nextInt(2))
					{
						case(0): // generate Two Panels windows
						{
							wind[f][c]= new TwoPanels(pos,dif);
							break;
						}
						case(1): //generete WithLeaves windows
						{
							wind[f][c]= new WithLeaves(pos,dif);
							break;
						}
						default: throw new Error("WINDOW RANDOM GENERATOR BROKEN"); //Shouldn't get here
					}
					pos.setPosx(pos.getPosx() +1);
				}
			}
			if(sec == Sections.FIRST)
			{
				Vector2D pos= new Vector2D(1,4);
				wind[1][4]= new HalfCircle(4, pos);
				Vector2D p= new Vector2D(2,4);
				wind[2][4]= new HalfCircle(8, p);
			}
			
			return wind;
	}
}
