package sixesWildControllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import sixesWildBoundary.LevelSelectApplication;
import sixesWildBoundary.MainMenuApplication;
import sixesWildBoundary.SixesWildApplication;
import sixesWildEntity.Level;
import sixesWildEntity.SixesWild;

public class ChooseLevelController implements ActionListener {
	//private MainMenuApplication main;
	private LevelSelectApplication levelSelectApplication;
	private SixesWild theGame;
	private int buttonIndex;
	
	public ChooseLevelController(LevelSelectApplication app, SixesWild game, int index)
	{
		this.levelSelectApplication = app;
		this.theGame = game;
		this.buttonIndex = index;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		levelSelectApplication.setVisible(false);
		
		Level levelClicked = theGame.getLevels().get(buttonIndex);
		SixesWildApplication newLevelToPlay = new SixesWildApplication(theGame, levelClicked);
		//level.getLevelPanel().getExitButton().addActionListener(new BacktoMainMenuController(main, level));
	}
	
	
}
