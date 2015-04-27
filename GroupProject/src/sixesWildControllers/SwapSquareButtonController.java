package sixesWildControllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import sixesWildEntity.Board;

public class SwapSquareButtonController implements ActionListener{
	public static final String TAG = "SwapSquareButtonController" ;
	
	JFrame current ;
	Board board ;
	
	public SwapSquareButtonController(JFrame c, Board b){
		this.current = c ;
		this.board = b ;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println(TAG) ;
		
		board.setSwapMove(true) ;
	}

}
