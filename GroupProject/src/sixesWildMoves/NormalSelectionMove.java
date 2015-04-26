package sixesWildMoves;

import java.util.ArrayList;

import sixesWildBoundary.MainMenuApplication;
import sixesWildBoundary.SixesWildApplication;
import sixesWildEntity.Board;
import sixesWildEntity.Tile;

public class NormalSelectionMove implements IMove{
	
	public static final String TAG = "NormalSelectionMove";
	
	ArrayList<Tile> tiles = new ArrayList<Tile>();
	Board board;
	int sum = 0;
	int mult = 1 ;
	int tileNum = 0 ;
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
			mult *= t.getSquare().getMultiplier();
			tileNum++ ;
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
				//remove the square data from tile since we already get the score
				t.setSquare(null); //#1
			}
			
			score += tileNum * 10 * mult ;

			board.fall(tiles);
			theGame.updateScore(score);
			theGame.updateMovesLeft(-1) ;
			
			if(board.getLevel().hasWon()){
				//close the frame and return to level select
				theGame.setVisible(false) ;
				theGame.getModel().updateScores() ;
				MainMenuApplication main = new MainMenuApplication();
				main.setVisible(true);
			}
			
			return true;
		}
		return false;
	}

	@Override
	public void undoMove(SixesWildApplication theGame) {
		// TODO Auto-generated method stub
		
	}

}
