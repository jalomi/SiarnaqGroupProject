package sixesWildMoves;

import java.util.ArrayList;

import sixesWildBoundary.SixesWildApplication;
import sixesWildEntity.Board;
import sixesWildEntity.Tile;

public class NormalSelectionMove implements IMove{
	
	public static final String TAG = "NormalSelectionMove";
	
	ArrayList<Tile> tiles = new ArrayList<Tile>();
	Board board;
	int sum = 0;
	int score = 0;
	
	public NormalSelectionMove(ArrayList<Tile> selectedTiles, Board board) {
		this.tiles = selectedTiles;
		this.board = board;
	}

	@Override
	public boolean isValid(SixesWildApplication theGame) {
		if(tiles.size() <= 1){
			return false ;
		}
		
		for(Tile t : tiles) {
			sum += t.getSquare().getValue();
		}
		System.out.println(TAG + "sum:" + sum);
		
		if(sum == 6) {
			return true;
		}
		
		return false;
	}

	@Override
	public boolean doMove(SixesWildApplication theGame) {
		if(isValid(theGame)) {
			//update the score
			for(Tile t : tiles) {
				score += t.getSquare().getValue() * t.getSquare().getMultiplier();
				//remove the square data from tile since we already get the score
				t.setSquare(null); //#1
			}
			
			//ALbert
			//it might be a good idea to implement #1 in Board class instead of in this Move class
			//I will leave this for you to discuss
			//board.removeSquares(tiles);
			board.fall(tiles);
			theGame.updateScore(score);
			return true;
		}
		return false;
	}

	@Override
	public void undoMove(SixesWildApplication theGame) {
		// TODO Auto-generated method stub
		
	}

}
