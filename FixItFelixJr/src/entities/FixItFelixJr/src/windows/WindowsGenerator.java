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
	/**
	 *  Se encarga de generar todas las ventanas de una seccion 
	 * @param sec Identifica a que seccion van a pertenecer esas ventanas
	 * @param d Segun la dificultad mas ventanas aparecen rotas
	 * @return retorna la matriz de ventanas ya creada
	 */
	public static Window[][] generateWindows(Sections sec,Difficulty d)
	{
			Random rand=new Random();
			Window[][] wind= new Window[Dimentions.RIGHT_LIMITS][Dimentions.UP_LIMITS];
			int f,c;
			double dif=d.getDifficulty();
			for(f=0;f<wind.length;f++)
			{
				for(c=0;c<wind[0].length-1; c++)
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
				wind[f][wind[f].length-1]=new RalphWindow();
			}
			if(sec == Sections.FIRST)
			{
				Vector2D pos= new Vector2D(Dimentions.RIGHT_LIMITS/2,1);
				wind[pos.getPosx()][pos.getPosy()]= new HalfCircle(4, pos,d.getDifficulty());
				Vector2D p= new Vector2D(Dimentions.RIGHT_LIMITS/2,2);
				wind[p.getPosx()][p.getPosy()]= new HalfCircle(8, p,d.getDifficulty());
			}
			
			return wind;
	}
}
