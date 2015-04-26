package sixesWildMoves;

import java.util.ArrayList;

import sixesWildBoundary.SixesWildApplication;
import sixesWildEntity.Board;
import sixesWildEntity.Square;

public class ResetBoardMove implements IMove{
	ArrayList<Square> squares;
	
	public ResetBoardMove(Board board, ArrayList<Square> squares) {
		this.squares = squares;
	}

	@Override
	public boolean isValid(SixesWildApplication theGame) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean doMove(SixesWildApplication theGame) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void undoMove(SixesWildApplication theGame) {
		// TODO Auto-generated method stub
		
	}



}
