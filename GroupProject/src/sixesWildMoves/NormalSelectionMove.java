package sixesWildMoves;

import java.util.ArrayList;

import sixesWildBoundary.GameOverApplication;
import sixesWildBoundary.SixesWildApplication;
import sixesWildControllers.GameOverToMainMenuController;
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
			if(!t.isEnabled()){
				return false ;
			}
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
				t.setSquare(null) ; //#1
				if(board.getLevel().getLevelType().equals("Elimination")){
					t.setMarked(true) ;
				}
			}
			 
			score += tileNum * 10 * mult ;

			board.fall(tiles);
			theGame.updateScore(score);
			theGame.updateMovesLeft(-1) ;
			 
			if(board.getLevel().gameOver()){
				//close the frame and show level complete screen
				theGame.getModel().updateScores() ;
				GameOverApplication completeScreen = new GameOverApplication(board.getLevel().hasWon());
				if(board.getLevel().hasWon()){
					if(theGame.getModel().getLevels().size() > board.getLevel().getLevelNumber()){
						theGame.getModel().getLevels().get(board.getLevel().getLevelNumber()).setUnlocked(true) ;
					}
				}
				
				//old //int lastScore = theGame.getModel().getHighScore(board.getLevel().getLevelNumber() - 1) ;
				int lastScore = board.getLevel().getHighestScore();
				//old //int thisScore = board.getLevel().getScore() ;
				int thisScore = board.getCurrentScore();
				if(thisScore > lastScore){
					//update the high score
					//old //theGame.getModel().setHighScore(board.getLevel().getLevelNumber(), thisScore) ;
					board.getLevel().setHighestScore(thisScore);
				}
				theGame.setEnabled(false) ;
				completeScreen.setVisible(true);
				completeScreen.getMainMenuBtn().addActionListener(new GameOverToMainMenuController(completeScreen, theGame)) ;
			}
			
			return true;
		}
		return false;
	}

}
