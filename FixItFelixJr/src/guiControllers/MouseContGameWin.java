package guiControllers;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Timer;
import java.util.TimerTask;

import game.Core;
import gamemain.GameStarter;
import graphicInterface.GamePanel;
import graphicInterface.MainGameWindow;

public class MouseContGameWin extends MouseAdapter
{

	@Override
	public void mouseClicked(MouseEvent e) {
		super.mouseClicked(e);
		MainGameWindow.getInstance().changeGameWin(); //cambio a la GameWindow
		Core.getInstance().restartGame(); //reinicio juego
		Timer t = new Timer();
		TimerTask tt=new TimerTask() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				Core c= Core.getInstance();
				MainGameWindow graphics = MainGameWindow.getInstance();
				c.update();
				graphics.update();
				if(!c.isPlaying()){
					if(c.isNewHighscore()) {
						MainGameWindow.getInstance().changeInputScore();
						//hubo un highscore: pedir nombre y vainas. Luego guardarlo
					}
					else {
						//me voy al menu
						MainGameWindow.getInstance().changeMenu();
					}
					t.cancel();
				}
			}
		};
		t.schedule(tt, 0,300);
	}
}