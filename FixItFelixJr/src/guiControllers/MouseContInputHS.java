package guiControllers;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import game.Core;
import game.HighScores;
import game.Scores;
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
		if(name.length() <= 2 || name.contains(" ") || HighScores.getInstance().getScoreList().contains(new Scores(name, Core.getInstance().getPoints())))
		{
			JOptionPane.showConfirmDialog(new JButton(), "No es un nombre valido", "ERROR", JOptionPane.YES_OPTION, JOptionPane.WARNING_MESSAGE);		}
		else
		{
			if(name.length()>20)
			{
				name=name.substring(0, 20);
			}
			HighScores.getInstance().add(name, Core.getInstance().getPoints());
			Stats.incrementTimesNewHighscore();
			HighScoresPanel.getInstance().update();
			MainGameWindow.getInstance().changeRank();
		}
	}
	
}
