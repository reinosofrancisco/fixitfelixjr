package gametester;

import java.util.Random;

import building.Building;
import building.Sections;
import entities.Felix;
import game.Difficulty;
import util.Dimentions;
import util.Direction;
import util.Vector2D;
import windows.Window;
import windows.WindowsGenerator;

public class testerFede {
	
	
	public static void main(String[] args) {
		
		Building b=new Building();
		Vector2D v=new Vector2D(3,6);
		Felix f=new Felix(new Vector2D(1,1),3,0,1);
		
		System.out.println(Dimentions.isInsideMap(v)+ " " + (new Random()).nextInt());
		for (int i = 0; i < 100; i++) {
			
			Window[][] w=WindowsGenerator.generateWindows(Sections.FIRST,new Difficulty(0));
			System.out.println(" \n" + f.move(Direction.RIGHT, w));
			System.out.println(" \n" + f.move(Direction.RIGHT, w));
			System.out.println(" \n" + f.move(Direction.RIGHT, w));
			System.out.println(" \n" + f.move(Direction.RIGHT, w));
			System.out.println(" \n" + f.move(Direction.RIGHT, w));
			System.out.println(" \n" + f.move(Direction.RIGHT, w));
			System.out.println(" \n" + f.move(Direction.RIGHT, w));
			System.out.println(" \n" + f.move(Direction.RIGHT, w));
			
		}
		
	}

}
