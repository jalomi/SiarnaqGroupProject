package sixesWildMoves;

import sixesWildBoundary.SixesWildApplication;
import sixesWildEntity.Board;
import sixesWildEntity.Square;
import sixesWildEntity.Tile;

public class SwapSquareMove implements IMove{
	Tile t1;
	Tile t2;
	Board board ;
	
	public SwapSquareMove(Board board, Tile t1, Tile t2) {
		this.t1 = t1;
		this.t2 = t2;
		this.board = board ;
	}

	@Override
	public boolean isValid(SixesWildApplication theGame) {
		if(t1.getSquare().getValue() != 6 && t2.getSquare().getValue() != 6){
			return true ;
		}
		
		return false;
	}

	@Override
	public boolean doMove(SixesWildApplication theGame) {
		if(isValid(theGame)){
			Square s1 = t1.getSquare() ;
			Square s2 = t2.getSquare() ;
			
			Square temp = new Square(s1.getValue(), s1.getMultiplier()) ;
			t1.setSquare(s2) ;
			t2.setSquare(temp) ;
			
			board.setSwapMove(false) ;
			theGame.updateMovesLeft(-1) ;
			
			return true ;
		}
		return false;
	}

	
	@Override
	public void undoMove(SixesWildApplication theGame) {
		// TODO Auto-generated method stub
		
	}


	
	
}
