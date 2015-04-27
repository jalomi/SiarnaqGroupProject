package sixesWildControllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import sixesWildBoundary.SixesWildApplication;
import sixesWildEntity.Board;
import sixesWildMoves.IMove;
import sixesWildMoves.RemoveSquareMove;
import sixesWildMoves.ResetBoardMove;

public class ResetBoardButtonController implements ActionListener{
	public static final String TAG = "ResetBoardButtonController" ;
	
	JFrame current ;
	Board board ;
	SixesWildApplication app ;
	
	public ResetBoardButtonController(JFrame c, Board b, SixesWildApplication app){
		this.current = c ;
		this.board = b ;
		this.app = app ;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		System.out.println(TAG) ;
		
		IMove m = new ResetBoardMove(board) ;
		
		if(m.doMove(app)){
			app.getGamePanel().refreshBoard();
			app.getLevelPanel().refresh();
			System.out.println(TAG + "RemoveSquareMove suceeded");
		} else {
			System.out.println(TAG + "RemoveSquareMove failed");
		}
	}

}
