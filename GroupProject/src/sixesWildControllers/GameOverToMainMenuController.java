package sixesWildControllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import sixesWildBoundary.MainMenuApplication;
import sixesWildBoundary.SixesWildApplication;

/**
 * Returns to main menu from the game over pop-up
 * @author John
 *
 */
public class GameOverToMainMenuController implements ActionListener{
	/** TAG for the class */
	public static final String TAG = "GameOverToMainMenuController" ;
	
	/** frame the controller is intiated in */
	JFrame current ;
	
	/** the game's application */
	SixesWildApplication game ;
	
	/**
	 * Constructor
	 * @param c
	 * @param g
	 */
	public GameOverToMainMenuController(JFrame c, SixesWildApplication g){
		this.current = c ;
		this.game = g ;
	}	
	
	/**
	 * moves from the game over pop-up to the main menu and disposes
	 * both the pop-up and the game application
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println(TAG) ;
		
		current.setVisible(false) ;
		game.setVisible(false) ;
		MainMenuApplication main = new MainMenuApplication() ;
		main.setVisible(true) ;
		current.dispose() ;
		game. dispose() ;
	}
	
}
