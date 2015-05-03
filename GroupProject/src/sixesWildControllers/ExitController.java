package sixesWildControllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

/**
 * exits the application
 * @author 
 *
 */
public class ExitController implements ActionListener {
	/** current frame that the controller is initiated in */
	JFrame frame;

	/**
	 * Constructor
	 * @param frame
	 */
	public ExitController(JFrame frame){
		this.frame=frame;
	}
	
	/**
	 * close the current frame
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		process();
	}
	
	public void process()
	{
		if(frame!=null)
			frame.dispose();
	}
}