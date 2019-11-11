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
//		
//		switch(ConfigurePanel.getInstance().getDificulty().getSelectedItem())
//		{
//			case("1"):
//			{
//				Difficulty.getInstance().setDifficulty(1);
//			}
//			break;
//			case("2"):
//			{
//				Difficulty.getInstance().setDifficulty(2);
//			}
//			break;
//			case("3"):
//			{
//				Difficulty.getInstance().setDifficulty(3);
//			}
//			break;
//			case("4"):
//			{
//				Difficulty.getInstance().setDifficulty(4);
//			}
//			break;
//			case("5"):
//			{
//				Difficulty.getInstance().setDifficulty(5);
//			}
//			break;
//			case("6"):
//			{
//				Difficulty.getInstance().setDifficulty(6);
//			}
//			break;
//			case("7"):
//			{
//				Difficulty.getInstance().setDifficulty(7);
//			}
//			break;
//			case("8"):
//			{
//				Difficulty.getInstance().setDifficulty(8);
//			}
//			break;
//			case("9"):
//			{
//				Difficulty.getInstance().setDifficulty(9);
//			}
//			break;
//			case("10"):
//			{
//				Difficulty.getInstance().setDifficulty(10);
//			}
//			break;
//		}
	}
	
}
