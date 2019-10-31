package guiControllers;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import graphicInterface.WindowController;

public class MouseContInstr extends MouseAdapter{

	@Override
	public void mouseClicked(MouseEvent e) {
		super.mouseClicked(e);
		WindowController.getInstance().changeInstr();
	}
	
	
}
