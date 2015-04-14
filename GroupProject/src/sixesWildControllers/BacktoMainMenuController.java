package sixesWildControllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import sixesWildBoundary.MainMenuApplication;

public class BacktoMainMenuController implements ActionListener {
	MainMenuApplication menu;
	JFrame current;
	
	public BacktoMainMenuController(MainMenuApplication menu, JFrame current)
	{
		this.menu=menu;
		this.current=current;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		current.setVisible(false);
		menu.setVisible(true);
	}
}
