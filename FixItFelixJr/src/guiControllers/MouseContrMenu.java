package guiControllers;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import graphicInterface.WindowController;

public class MouseContrMenu extends MouseAdapter {

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		super.mouseClicked(e);
		WindowController.getInstance().changeMenu();
	}

	
	
}