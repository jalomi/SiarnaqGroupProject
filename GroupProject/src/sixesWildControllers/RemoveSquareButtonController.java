package sixesWildControllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import sixesWildEntity.Board;

public class RemoveSquareButtonController implements ActionListener {
	public static final String TAG = "RemoveSquareButtonController" ;
	
	JFrame current ;
	Board board ;
	
	public RemoveSquareButtonController(JFrame current, Board b){
		this.current = current ;
		this.board = b ;
	}
	
	@Override
	public void actionPerformed(ActionEvent e){
		System.out.println(TAG) ;
		
		if(board.getLevel().isRemoveEnabled()){
			board.setRemoveMove(true);	
		}
		else{
			System.out.println(TAG + ": DISABLED") ;
		}
	}
	
}
