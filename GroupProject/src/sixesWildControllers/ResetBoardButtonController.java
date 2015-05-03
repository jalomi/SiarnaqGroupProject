package sixesWildControllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import sixesWildBoundary.SixesWildApplication;
import sixesWildEntity.Board;
import sixesWildMoves.IMove;
import sixesWildMoves.ResetBoardMove;

/**
 * Shuffles the board
 * @author John
 *
 */
public class ResetBoardButtonController implements ActionListener{
	/** TAG for the class */
	public static final String TAG = "ResetBoardButtonController" ;
	
	/** frame that this is called in */
	SixesWildApplication app ;
	
	/** The board entity */
	Board board ;
	
	/**
	 * Constructor
	 * @param app
	 * @param b
	 */
	public ResetBoardButtonController(SixesWildApplication app, Board b){
		this.board = b ;
		this.app = app ;
	}
	
	/**
	 * Shuffles the board except for 6s
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		System.out.println(TAG) ;
		
		if(board.getLevel().isResetEnabled()){
			IMove m = new ResetBoardMove(board) ;
			
			if(m.doMove(app)){
				app.getGamePanel().refreshBoard();
				app.getLevelPanel().refresh();
				System.out.println(TAG + "RemoveSquareMove suceeded");
			} else {
				System.out.println(TAG + "RemoveSquareMove failed");
			}
		}
		else{
			System.out.println(TAG + ": DISABLED") ;
		}
	}

}
