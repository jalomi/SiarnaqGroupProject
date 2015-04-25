package sixesWildControllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import sixesWildBoundary.MainMenuApplication;

public class BacktoMainMenuController implements ActionListener {
	
	public static final String TAG = "BacktoMainMenuController";
	
	JFrame current;
	
	public BacktoMainMenuController(JFrame current)
	{
		this.current=current;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println(TAG);
		
		current.setVisible(false);
		MainMenuApplication main = new MainMenuApplication();
		main.setVisible(true);
	}
}
