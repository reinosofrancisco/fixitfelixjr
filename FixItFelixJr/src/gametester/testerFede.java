package gametester;

import java.util.Random;
import java.util.Scanner;

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
			
			moverFelix(f,w);
			moverFelix(f,w);
			moverFelix(f,w);
			moverFelix(f,w);
			moverFelix(f,w);
			moverFelix(f,w);
			moverFelix(f,w);
			moverFelix(f,w);
			moverFelix(f,w);
			moverFelix(f,w);
			moverFelix(f,w);
			moverFelix(f,w);
			moverFelix(f,w);
			moverFelix(f,w);
			moverFelix(f,w);
			moverFelix(f,w);
			moverFelix(f,w);
			moverFelix(f,w);
			moverFelix(f,w);
			moverFelix(f,w);
				
			
			
		}
	}

	private static void moverFelix(Felix f, Window[][] w) {
		Scanner sc=new Scanner(System.in);
		char act=sc.next().charAt(0);
		switch (act) {
		case 'w':
			System.out.println(f.move(Direction.UP, w));
			break;
		case 's':
			System.out.println(f.move(Direction.DOWN, w));
			break;
		case 'a':
			System.out.println(f.move(Direction.LEFT,w));
			break;
		case 'd':
			System.out.println(f.move(Direction.RIGHT,w));
			break;
		case 'f':
			System.out.println(f.fix(w));
		default:
			break;
		}
		// TODO Auto-generated method stub
		
	}
}
