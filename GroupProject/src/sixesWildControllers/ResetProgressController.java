package sixesWildControllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import sixesWildEntity.SixesWild;

/**
 * Will reset the progress of the levels
 * @author John
 *
 */
public class ResetProgressController implements ActionListener{
	/** the frame that initiated the controller */
	JFrame frame ;
	
	/**
	 * Constructor
	 * @param f
	 */
	public  ResetProgressController(JFrame f){
		this.frame = f ;
	}
	
	/**
	 * Resets the level progress
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		SixesWild sw  = SixesWild.newInstance();
		//TODO clear progress for the levels
	}

}
