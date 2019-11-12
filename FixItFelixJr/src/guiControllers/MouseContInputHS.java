package guiControllers;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import game.Core;
import game.HighScores;
import game.Stats;
import graphicInterface.HighScoresPanel;
import graphicInterface.InputScorePanel;
import graphicInterface.MainGameWindow;

public class MouseContInputHS extends MouseAdapter 
{

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		super.mouseClicked(e);
		String name=InputScorePanel.getInstance().getArea1().getText();
		HighScores.getInstance().add(name, Core.getInstance().getPoints());
		Stats.incrementTimesNewHighscore();
		HighScoresPanel.getInstance().update();
		MainGameWindow.getInstance().changeRank();
	}
	
}
