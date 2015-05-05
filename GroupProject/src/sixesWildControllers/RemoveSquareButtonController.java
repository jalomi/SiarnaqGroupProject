package sixesWildControllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import sixesWildBoundary.SixesWildApplication;
import sixesWildEntity.Board;

/**
 * Controls button to set next move as a remove square move
 * @author John
 *
 */
public class RemoveSquareButtonController implements ActionListener {
	/** TAG for the class */
	public static final String TAG = "RemoveSquareButtonController" ;
	
	/** Application the controller is initiated in */
	SixesWildApplication current ;
	
	/** the board model */
	Board board ;
	
	/**
	 * Constructor
	 * @param current
	 * @param b
	 */
	public RemoveSquareButtonController(SixesWildApplication current, Board b){
		this.current = current ;
		this.board = b ;
	}
	
	/**
	 * Handles press of remove square button
	 */
	@Override
	public void actionPerformed(ActionEvent e){
		process();
	}

	/**
	 * Sets the next move as a remove square move
	 */
	public void process() {
		// TODO Auto-generated method stub
		System.out.println(TAG) ;
		
		if(board.getLevel().isRemoveEnabled()){
			board.setRemoveMove(true);	
		}
		else{
			System.out.println(TAG + ": DISABLED") ;
		}
	}
	
}
