package sixesWildControllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import levelSelectGUI.LevelSelectApplication;
import mainMenuGUI.MainMenuApplication;

public class EnterLevelSelectController implements ActionListener {
	MainMenuApplication m;
	
	public EnterLevelSelectController(MainMenuApplication menu)
	{
		this.m=menu;
	}
	
	public void actionPerformed(ActionEvent e)
	{
		m.setVisible(false);
		
		LevelSelectApplication l=new LevelSelectApplication();
		l.setVisible(true);
	}
}