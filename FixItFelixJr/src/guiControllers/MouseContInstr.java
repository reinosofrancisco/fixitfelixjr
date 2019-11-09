package guiControllers;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import graphicInterface.MainGameWindow;

public class MouseContInstr extends MouseAdapter{

	@Override
	public void mouseClicked(MouseEvent e) {
		super.mouseClicked(e);
		MainGameWindow.getInstance().changeInstr();
	}
	
	
}
