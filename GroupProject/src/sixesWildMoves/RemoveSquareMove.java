package sixesWildMoves;

import sixesWildEntity.Board;
import sixesWildEntity.Square;

public class RemoveSquareMove extends Move{
	Square square;

	public RemoveSquareMove(Board board, Square s) {
		super(board);
		this.square=square;
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
