package sixesWildMoves;

import sixesWildEntity.Board;
import sixesWildEntity.Square;

public class SwapSquareMove extends Move{
	Square s1;
	Square s2;
	
	public SwapSquareMove(Board board, Square s1, Square s2) {
		super(board);
		this.s1=s1;
		this.s2=s2;
	}

	@Override
	public boolean isValid() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean doMove() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getScore() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
}
