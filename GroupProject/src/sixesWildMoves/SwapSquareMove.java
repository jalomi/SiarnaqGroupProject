package sixesWildMoves;

import sixesWildBoundary.GameOverApplication;
import sixesWildBoundary.SixesWildApplication;
import sixesWildControllers.GameOverToMainMenuController;
import sixesWildEntity.Board;
import sixesWildEntity.Square;
import sixesWildEntity.Tile;

/**
 * Swaps two squares
 * @author John
 *
 */
public class SwapSquareMove implements IMove{
	/** 1st tile to be swapped */
	Tile t1;
	
	/** 2nd tile to be swapped */
	Tile t2;
	
	/** the board entity */
	Board board ;
	
	/**
	 * Constructor
	 * @param board
	 * @param t1
	 * @param t2
	 */
	public SwapSquareMove(Board board, Tile t1, Tile t2) {
		this.t1 = t1;
		this.t2 = t2;
		this.board = board ;
	}

	/**
	 * checks to see that the move is valid
	 */
	@Override
	public boolean isValid(SixesWildApplication theGame) {
		if(!t1.isEnabled() || !t2.isEnabled()){
			return false ;
		}
		if(t1.getBucket() || t2.getBucket()){
			return false ;
		}
		if(!board.getLevel().isSwapEnabled()){
			return false ;
		}
		
		if(t1.getSquare().getValue() != 6 && t2.getSquare().getValue() != 6){
			return true ;
		}
		
		return false;
	}

	/**
	 * executes the move
	 */
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
			
			return true ;
		}
		return false;
	}

}
