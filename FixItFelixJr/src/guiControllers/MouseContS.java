package guiControllers;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import game.Difficulty;
import graphicInterface.ConfigurePanel;

public class MouseContS extends MouseAdapter
{

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		super.mouseClicked(e);
		
		
		int d= Integer.parseInt(ConfigurePanel.getInstance().getDificulty().getSelectedItem());
		Difficulty.getInstance().setDifficulty(d);
	}
	
}
