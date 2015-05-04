package sixesWildMoves;

import sixesWildBoundary.GameOverApplication;
import sixesWildBoundary.SixesWildApplication;
import sixesWildControllers.GameOverToMainMenuController;
import sixesWildEntity.Board;
import sixesWildEntity.Lightning;
import sixesWildEntity.Tile;

/**
 * Removes a square from the board
 * @author John
 * @author Kyle
 *
 */
public class RemoveSquareMove implements IMove{
	/** The tile being removed */
	Tile tile;
	
	/** the board entity */
	Board board ;

	/**
	 * Constructor
	 * @param board
	 * @param t
	 */
	public RemoveSquareMove(Board board, Tile t) {
		this.board = board ;
		this.tile = t;
	} 

	/**
	 * Checks to see if the move is valid
	 */
	@Override
	public boolean isValid(SixesWildApplication theGame) {
		if(!tile.isEnabled()){
			return false ;
		}
		if(tile.getBucket()){
			return false ;
		}
		
		if(!board.getLevel().isRemoveEnabled()){
			return false ;
		}
		
		if(tile.getSquare().getValue() != 6){
			return true ;
		}
		
		return false;
	}

	/**
	 * Does the move
	 */
	@Override
	public boolean doMove(SixesWildApplication theGame) {
		if(isValid(theGame)){
			tile.setSquare(null) ;
			board.fall(tile) ;
			
			board.setRemoveMove(false) ;
			theGame.updateMovesLeft(-1) ;
			if(!(board.getLevel() instanceof Lightning)){
				if(board.getLevel().gameOver()){
					//close the frame and show level complete screen
					theGame.getModel().updateScores() ;
					GameOverApplication completeScreen = new GameOverApplication(board.getLevel().hasWon());
					if(board.getLevel().hasWon()){
						if(theGame.getModel().getLevels().size() > board.getLevel().getLevelNumber()){
							theGame.getModel().getLevels().get(board.getLevel().getLevelNumber()).setUnlocked(true) ;
						}
					}
					
					int lastScore = board.getLevel().getHighestScore();
					int thisScore = board.getCurrentScore();
					if(thisScore > lastScore){
						//update the high score
						board.getLevel().setHighestScore(thisScore);
					}
					theGame.setEnabled(false) ;
					completeScreen.setVisible(true);
					completeScreen.getMainMenuBtn().addActionListener(new GameOverToMainMenuController(completeScreen, theGame)) ;
				}
			}
			
			return true ;
		}
		return false ;
	}

}
