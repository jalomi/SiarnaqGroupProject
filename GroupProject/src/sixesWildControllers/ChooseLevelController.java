package sixesWildControllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import sixesWildBoundary.LevelSelectApplication;
import sixesWildBoundary.SixesWildApplication;
import sixesWildEntity.Board;
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
			
			/* Comments By Albert
			 * Let controller to set entity classes here,
			 * because boundaries don't have to know any entity class but (SixesWild theGame).
			 * Since SixesWild and Board are both singletons,
			 * we have the static access to them globally.
			 */
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
