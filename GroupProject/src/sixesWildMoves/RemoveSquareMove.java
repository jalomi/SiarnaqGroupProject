package sixesWildMoves;

import sixesWildBoundary.GameOverApplication;
import sixesWildBoundary.SixesWildApplication;
import sixesWildControllers.GameOverToMainMenuController;
import sixesWildEntity.Board;
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
		if(!tile.isEnabled()){
			return false ;
		}
		
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
		return false ;
	}

}
