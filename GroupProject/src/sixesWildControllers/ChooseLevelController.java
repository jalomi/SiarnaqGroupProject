package sixesWildControllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import sixesWildBoundary.LevelSelectApplication;
import sixesWildBoundary.MainMenuApplication;
import sixesWildBoundary.SixesWildApplication;

public class ChooseLevelController implements ActionListener {
	private MainMenuApplication main;
	private LevelSelectApplication lvls;
	
	public ChooseLevelController(MainMenuApplication m, LevelSelectApplication l)
	{
		this.main=m;
		this.lvls=l;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		lvls.setVisible(false);
		
		SixesWildApplication level=new SixesWildApplication();
		
		level.getLevelPanel().getExitButton().addActionListener(new BacktoMainMenuController(main, level));
	}
	
	
}
