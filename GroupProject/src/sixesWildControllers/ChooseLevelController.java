package sixesWildControllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import sixesWildBoundary.LevelSelectApplication;
import sixesWildBoundary.SixesWildApplication;
import sixesWildEntity.Level;
import sixesWildEntity.SixesWild;

public class ChooseLevelController implements ActionListener {
	
	public static final String TAG = "ChooseLevelController";
	
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
		System.out.println(TAG);
		
		if(theGame.getLevels().size() > buttonIndex) {
			levelSelectApplication.dispose();
			Level levelClicked = theGame.getLevels().get(buttonIndex);
			SixesWildApplication newLevelToPlay = new SixesWildApplication(theGame, levelClicked);
			newLevelToPlay.setVisible(true);
		} else {
			System.err.println("We don't have level " + buttonIndex + " yet!");
		}

	}
	
	
}
