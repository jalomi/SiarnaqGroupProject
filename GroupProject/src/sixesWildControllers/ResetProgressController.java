package sixesWildControllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import sixesWildEntity.Level;
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
	 * Handles press of reset progress button
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		process();
	}
	
	/**
	 * Resets the level progress
	 */
	public void process()
	{
		SixesWild sw  = SixesWild.newInstance();
		//TODO clear progress for the levels
		sw.getLevels().get(0).setHighestScore(0);
		sw.getLevels().get(0).setStarNumber(0);
		for(int i = 1; i < sw.getLevels().size(); i++) {
			Level l = sw.getLevels().get(i);
			l.setHighestScore(0);
			l.setStarNumber(0);
			l.setUnlocked(false);
		}
	}

}
