package guiControllers;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import graphicInterface.MainGameWindow;

public class MouseContRank extends MouseAdapter{

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		super.mouseClicked(e);
		MainGameWindow.getInstance().changeRank();
	}

	
}
