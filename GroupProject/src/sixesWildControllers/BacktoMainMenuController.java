package sixesWildControllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import sixesWildBoundary.MainMenuApplication;

/**
 * Returns from current frame to the main menu application
 * @author 
 *
 */
public class BacktoMainMenuController implements ActionListener {
	/** TAG for the class */
	public static final String TAG = "BacktoMainMenuController";
	
	/** frame that the controller is initiated in */
	JFrame current;
	
	/**
	 * Constructor
	 * @param current
	 */
	public BacktoMainMenuController(JFrame current)
	{
		this.current=current;
	}

	/**
	 * close the current frame and open the main menu
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println(TAG);
		
		current.setVisible(false);
		MainMenuApplication main = new MainMenuApplication();
		main.setVisible(true);
		current.dispose() ;
	}
}
