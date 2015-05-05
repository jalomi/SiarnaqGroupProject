package levelBuilderControllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import levelBuilderBoundary.LevelBuilderApplication;

/**
 * Controller that returns to Level Builder from Preview
 * @author Kevin
 *
 */
public class PreviewToLevelBuilderController implements ActionListener{
	
	/**
	 * the Level Builder application
	 */
	LevelBuilderApplication app ;
	
	/**
	 * the Preview application
	 */
	JFrame current ;
	
	/**
	 * Constructor
	 * Creates the controller based on the applications
	 * @param app
	 * @param current
	 */
	public PreviewToLevelBuilderController(LevelBuilderApplication app, JFrame current){
		this.app = app ;
		this.current = current ;
	}

	/**
	 * Handles press of back button
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		process();		
	}
	
	/**
	 * Goes back to Level Builder application
	 */
	public void process()
	{
		current.setVisible(false) ;
		current.dispose() ;
		app.setVisible(true) ;	
	}
}
