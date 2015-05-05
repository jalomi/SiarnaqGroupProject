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
	 * Handles press of back to menu button
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		process();
	}

	/**
	 * Closes the current frame and opens the main menu
	 */
	public void process() {
		// TODO Auto-generated method stub
		System.out.println(TAG);
		
		current.setVisible(false);
		MainMenuApplication main = new MainMenuApplication();
		main.setVisible(true);
		current.dispose() ;
	}
}
