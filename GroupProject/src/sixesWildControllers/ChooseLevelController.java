package sixesWildControllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import sixesWildBoundary.LevelSelectApplication;
import sixesWildBoundary.SixesWildApplication;
import sixesWildEntity.Board;
import sixesWildEntity.Level;
import sixesWildEntity.SixesWild;

/**
 * Controls movement from level selection application to a level
 * @author John
 * @author Xuanzhe 
 *
 */
public class ChooseLevelController implements ActionListener {
	/** TAG for the class */
	public static final String TAG = "ChooseLevelController";
	
	/** the application */
	private LevelSelectApplication levelSelectApplication;
	
	/** the model */
	private SixesWild theGame;
	
	/** the button number that corresponds with the level number */
	private int buttonIndex;
	
	/**
	 * Constructor
	 * @param app
	 * @param game
	 * @param index
	 */
	public ChooseLevelController(LevelSelectApplication app, SixesWild game, int index)
	{
		this.levelSelectApplication = app;
		this.theGame = game;
		this.buttonIndex = index;
	}

	/**
	 * open the level if it exists
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println(TAG);
		
		if(theGame.getLevels().size() > buttonIndex) {
			Level levelClicked = theGame.getLevels().get(buttonIndex);
			if(theGame.getLevels().get(buttonIndex).getUnlocked() == true){
				levelSelectApplication.dispose();
				Board.newInstance().setLevel(levelClicked);
				SixesWildApplication newLevelToPlay = new SixesWildApplication(theGame);
				newLevelToPlay.setVisible(true);	
			}
		} else {
			System.err.println("We don't have level " + (buttonIndex + 1) + " yet!");
		}

	}
	
	
}
