package guiControllers;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import gamemain.GameStarter;
import graphicInterface.WindowController;

public class MouseContGameWin extends MouseAdapter
{

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		super.mouseClicked(e);
		WindowController.getInstance().changeGameWin();
		//TODO THREAD CORE START (GAMESTARTER) (use Core.restart() )
		
	}
	
}
