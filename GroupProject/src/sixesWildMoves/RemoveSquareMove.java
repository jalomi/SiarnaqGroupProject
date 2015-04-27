package sixesWildMoves;

import sixesWildBoundary.SixesWildApplication;
import sixesWildEntity.Board;
import sixesWildEntity.Square;
import sixesWildEntity.Tile;

public class RemoveSquareMove implements IMove{
	Tile tile;
	Board board ;

	public RemoveSquareMove(Board board, Tile t) {
		this.board = board ;
		this.tile = t;
	}

	@Override
	public boolean isValid(SixesWildApplication theGame) {
		if(tile.getSquare().getValue() != 6){
			return true ;
		}
		
		return false;
	}

	@Override
	public boolean doMove(SixesWildApplication theGame) {
		if(isValid(theGame)){
			tile.setSquare(null) ;
			board.fall(tile) ;
			
			board.setRemoveMove(false) ;
			theGame.updateMovesLeft(-1) ;
			
			return true ;
		}
		return false ;
	}

	@Override
	public void undoMove(SixesWildApplication theGame) {
		// TODO Auto-generated method stub
		
	}
}
