package sixesWildMoves;

import sixesWildBoundary.SixesWildApplication;
import sixesWildEntity.Board;
import sixesWildEntity.Square;

public class SwapSquareMove implements IMove{
	Square s1;
	Square s2;
	
	public SwapSquareMove(Board board, Square s1, Square s2) {
		this.s1 = s1;
		this.s2 = s2;
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
