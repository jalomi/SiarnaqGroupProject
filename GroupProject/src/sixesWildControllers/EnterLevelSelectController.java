package sixesWildControllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import sixesWildBoundary.LevelSelectApplication;
import sixesWildBoundary.MainMenuApplication;

/**
 * Controls movement from main menu to the level selection application
 * @author 
 *
 */
public class EnterLevelSelectController implements ActionListener {
	/** TAG for the class */
	public static final String TAG = "EnterLevelSelectController";
	
	/** the main menu the controller is initiated in */
	MainMenuApplication m;
	
	/**
	 * Constructor
	 * @param menu
	 */
	public EnterLevelSelectController(MainMenuApplication menu) {
		this.m = menu;
	}
	
	/**
	 * Moves from the main menu to the level selection
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println(TAG);
		
		m.dispose();
		LevelSelectApplication levelSelectApp = new LevelSelectApplication();
		levelSelectApp.setVisible(true);	
	}  
}
