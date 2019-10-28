package gametester;

import java.util.Random;
import java.util.Scanner;

import building.Building;
import entities.Felix;
import util.Dimentions;
import util.Direction;
import util.Vector2D;
import windows.Window;
import windows.WindowsGenerator;

public class testerFede {
	
	
	public static void main(String[] args) {
		
		Building b=new Building();
		Vector2D v=new Vector2D(3,6);
		Felix f= Felix.getInstnance();
		
		System.out.println(Dimentions.isInsideMap(v)+ " " + (new Random()).nextInt());
		for (int i = 0; i < 100; i++) {
			
			Window[][] w=WindowsGenerator.generateWindows();
			
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
			System.out.println(f.move(Direction.UP));
			break;
		case 's':
			System.out.println(f.move(Direction.DOWN));
			break;
		case 'a':
			System.out.println(f.move(Direction.LEFT));
			break;
		case 'd':
			System.out.println(f.move(Direction.RIGHT));
			break;
		case 'f':
			System.out.println(f.fix(w));
		default:
			break;
		}
		// TODO Auto-generated method stub
		
	}
}
