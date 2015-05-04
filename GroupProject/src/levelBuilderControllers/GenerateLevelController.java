package levelBuilderControllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import levelBuilderBoundary.LevelBuilderApplication;
import levelBuilderBoundary.LevelBuilderSavedScreen;

/**
 * Causes saved level screen to appear and sets the button within it
 * to another controller.
 * @author Kyle
 *
 */
public class GenerateLevelController implements ActionListener{
	LevelBuilderApplication app ;
	
	/**
	 * Constructor
	 * @param app LevelBuilderApplication
	 */
	public GenerateLevelController(LevelBuilderApplication app){
		this.app = app ;
	}

	/**
	 * Disable the LevelBuilder Frame, display the level saved screen 
	 * and set its button to a controller
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		process();
	}
	
	public void process()
	{ 
		app.setEnabled(false) ;
		
		LevelBuilderSavedScreen p = new LevelBuilderSavedScreen() ;
		p.setVisible(true) ;
		
		p.getContinueBtn().addActionListener(new SavedScreenToLevelBuilderController(app, p)) ;
	}

}
