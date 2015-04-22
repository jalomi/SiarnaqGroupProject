package sixesWildMoves;

import java.util.ArrayList;

import sixesWildEntity.Board;
import sixesWildEntity.Square;

public class ResetBoardMove extends Move{
	ArrayList<Square> squares;
	
	public ResetBoardMove(Board board, ArrayList<Square> squares) {
		super(board);
		this.squares = squares;
	}

	@Override
	public boolean isValid() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean doMove() {
		if(!isValid()){
			return false ;
		}
		
		
		return true ;
	}

	@Override
	public int getScore() {
		// TODO Auto-generated method stub
		return 0;
	}

}
