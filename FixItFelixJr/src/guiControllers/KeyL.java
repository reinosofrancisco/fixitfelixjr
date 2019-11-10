package guiControllers;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import game.Core;

public class KeyL extends KeyAdapter {

	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
		case (KeyEvent.VK_SPACE): {
			System.out.println("ESPACIO");
			Core.getInstance().fix();
		}
			break;
		case (KeyEvent.VK_UP):
		case (KeyEvent.VK_W): {
			System.out.println("ARRIBA");
			Core.getInstance().moveUp();
		}
			break;
		case (KeyEvent.VK_DOWN):
		case (KeyEvent.VK_S): {
			System.out.println("DOWN");
			Core.getInstance().moveDown();
		}
			break;
		case (KeyEvent.VK_RIGHT):
		case (KeyEvent.VK_D): {
			System.out.println("RIGHT");
			Core.getInstance().moveRight();
		}
			break;
		case (KeyEvent.VK_LEFT):
		case (KeyEvent.VK_A): {
			System.out.println("IZQUIERDA");

			Core.getInstance().moveLeft();
		}
			break;
		case (KeyEvent.VK_ESCAPE): {
			System.out.println("ESCAPE");
			Core.getInstance().gameOver(false);
		}
			break;
		default:
		}
	}

}
