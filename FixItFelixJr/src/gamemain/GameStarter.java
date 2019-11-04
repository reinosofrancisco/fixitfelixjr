package gamemain;

import game.Core;
import graphicInterface.GameWindow;
import graphicInterface.WindowController;

public class GameStarter implements Runnable {
	
	
	@Override
	public void run() {
		Core c = Core.getInstance();
		while(c.isPlaying()) {
			c.update();
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
		}
		
		if(c.isNewHighscore()) {
			//WindowController.getInstance().changeInputHighscore()	
			//hubo un highscore: pedir nombre y vainas. Luego guardarlo
		}
		else {
			//me voy al menu
//			WindowController.getInstance().changeMenu();
		}
		
	}

}
