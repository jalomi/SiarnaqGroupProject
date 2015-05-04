package levelBuilderControllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import levelBuilderBoundary.LevelBuilderApplication;

/**
 * Disposes of current frame and enables Level Builder app
 * @author Kyle
 *
 */
public class SavedScreenToLevelBuilderController implements ActionListener{
	LevelBuilderApplication app ;
	JFrame current ;
	
	/**
	 * Constructor
	 * @param app LevelBuilderApplication
	 * @param current JFrame
	 */
	public SavedScreenToLevelBuilderController(LevelBuilderApplication app, JFrame current){
		this.app = app ;
		this.current = current ;
	}
	/**
	 * Disposes of current frame and sets app to be enabled
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		process();
	}
	
	public void process()
	{
		current.setVisible(false) ;
		current.dispose() ;
		app.setEnabled(true) ;
		app.setVisible(true) ;
	}

}
