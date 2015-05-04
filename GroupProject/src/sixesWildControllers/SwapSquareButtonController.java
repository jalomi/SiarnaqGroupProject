package sixesWildControllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import sixesWildEntity.Board;

/**
 * Sets the next move to be a swap square move
 * @author John
 *
 */
public class SwapSquareButtonController implements ActionListener{
	/** TAG for the class */
	public static final String TAG = "SwapSquareButtonController" ;
	
	/** frame the controller is initiated in */
	JFrame current ;
	
	/** board entity */
	Board board ;
	
	/**
	 * Constructor
	 * @param c
	 * @param b
	 */
	public SwapSquareButtonController(JFrame c, Board b){
		this.current = c ;
		this.board = b ;
	}

	/**
	 * sets next move as a swap square move
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		process();
	}
	
	public void process()
	{
		System.out.println(TAG) ;
		
		if(board.getLevel().isSwapEnabled()){
			board.setSwapMove(true) ;
		}
		else{
			System.out.println(TAG + ": DISABLED") ;
		}
	}

}
