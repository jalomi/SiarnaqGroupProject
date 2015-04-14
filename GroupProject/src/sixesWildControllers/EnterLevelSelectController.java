package sixesWildControllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import sixesWildBoundary.LevelSelectFrame;
import sixesWildBoundary.MainMenuApplication;

public class EnterLevelSelectController implements ActionListener {
	MainMenuApplication m;
	
	public EnterLevelSelectController(MainMenuApplication menu)
	{
		this.m=menu;
	}
	
	public void actionPerformed(ActionEvent e)
	{
		m.setVisible(false);
		
		LevelSelectFrame l=new LevelSelectFrame();
		l.setVisible(true);
	}
}