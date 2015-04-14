package sixesWildControllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import sixesWildBoundary.LevelSelectApplication;
import sixesWildBoundary.MainMenuApplication;
import sixesWildBoundary.SixesWildApplication;
import sixesWildEntity.Level;

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
		
		//change new Level to be the actual level
		SixesWildApplication level=new SixesWildApplication(new Level());
		
		level.getLevelPanel().getExitButton().addActionListener(new BacktoMainMenuController(main, level));
	}
	
	
}
