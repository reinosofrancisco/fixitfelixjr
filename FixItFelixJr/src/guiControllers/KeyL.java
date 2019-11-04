package guiControllers;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import game.Core;
import graphicInterface.GraphicFelix;
import util.Direction;


public class KeyL extends KeyAdapter{
	
	public void keyPressed(KeyEvent e)
	{
		switch (e.getKeyCode()) 
		{
			case(KeyEvent.VK_SPACE):
			{
				GraphicFelix.getInstance().changeImgFix();
				Core.getInstance().fix();
			}
			break;
			case(KeyEvent.VK_UP):
			case(KeyEvent.VK_W):
			{
				Core.getInstance().move(Direction.UP);
			}
			break;
			case(KeyEvent.VK_DOWN):
			case(KeyEvent.VK_S):
			{
				Core.getInstance().move(Direction.DOWN);
			}
			break;
			case(KeyEvent.VK_RIGHT):
			case(KeyEvent.VK_D):
			{
				if(Core.getInstance().move(Direction.RIGHT))
				{
					GraphicFelix.getInstance().changeImgMove(Direction.RIGHT);
				}
			}
			break;
			case(KeyEvent.VK_LEFT):
			case(KeyEvent.VK_A):
			{
				if(Core.getInstance().move(Direction.LEFT))
				{
					GraphicFelix.getInstance().changeImgMove(Direction.LEFT);
				}
			}
			break;
			case(KeyEvent.VK_ESCAPE):
			{
				Core.getInstance().gameOver(false);
			}
			break;
			default: GraphicFelix.getInstance().changeImgMove(Direction.UNDIFINED);
		}
	}

}
