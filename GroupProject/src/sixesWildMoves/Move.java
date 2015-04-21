package sixesWildMoves;

import sixesWildEntity.Board;
import sixesWildEntity.SixesWild;

public abstract class Move {
	Board thePlayBoard;
	
	public Move(Board board)
	{
		this.thePlayBoard=board;
	}
	
	public abstract boolean isValid();
	public abstract boolean doMove();
	public abstract int getScore();
}
