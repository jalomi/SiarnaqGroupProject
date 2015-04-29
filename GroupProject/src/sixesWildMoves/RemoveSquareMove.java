package sixesWildMoves;

import sixesWildBoundary.GameOverApplication;
import sixesWildBoundary.SixesWildApplication;
import sixesWildControllers.BacktoMainMenuController;
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
				theGame.setVisible(false) ;
				theGame.getModel().updateScores() ;
				GameOverApplication completeScreen = new GameOverApplication(board.getLevel().getStarNumber() != 0);
				if(board.getLevel().getStarNumber() > 0){
					theGame.getModel().getLevels().get(board.getLevel().getLevelNumber()).setUnlocked(true) ;
				}
				completeScreen.setVisible(true);
				completeScreen.getMainMenuBtn().addActionListener(new BacktoMainMenuController(completeScreen)) ;
			}
			
			return true ;
		}
		return false ;
	}

}
