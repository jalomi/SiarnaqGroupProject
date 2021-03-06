package sixesWildMoves;

import java.util.ArrayList;

import sixesWildBoundary.GameOverApplication;
import sixesWildBoundary.SixesWildApplication;
import sixesWildControllers.GameOverToMainMenuController;
import sixesWildEntity.Board;
import sixesWildEntity.Lightning;
import sixesWildEntity.Square;

import java.util.Random ;

/**
 * Shuffles all the non-6 tiles on the board
 * @author John
 * @author Kyle
 *
 */
public class ResetBoardMove implements IMove{
	/** the board entity */
	Board board ;
	
	/**
	 * Constructor
	 * @param board
	 */
	public ResetBoardMove(Board board) {
		this.board = board;
	}

	/**
	 * checks to see if the move is valid
	 */
	@Override
	public boolean isValid(SixesWildApplication theGame) {
		if(!board.getLevel().isResetEnabled()){
			return false ;
		}
		
		return true ;
	}

	/**
	 * does the move
	 */
	@Override
	public boolean doMove(SixesWildApplication theGame) {
		if(!isValid(theGame)){
			return false ;
		}
		
		int squaresAdded = 0 ; //counts numb of squares added to list for later use in removing from list
		ArrayList<Square> boardSquares = new ArrayList<Square>() ;
		Random randNum = new Random() ;
		int random ;
		
		for(int i = 0; i < 9; i++){
			for(int j = 0; j < 9; j++){
				if(board.getMap()[i][j].getSquare() != null && board.getMap()[i][j].getSquare().getValue() != 6 && !(board.getMap()[i][j].getBucket())){
					boardSquares.add(board.getMap()[i][j].getSquare()) ;
					squaresAdded++ ;
				}
			}
		}
		 
		for(int i = 0; i < 9; i++){
			for(int j = 0; j < 9; j++){
				if(board.getMap()[i][j].getSquare() != null && board.getMap()[i][j].getSquare().getValue() != 6 && !(board.getMap()[i][j].getBucket())){
					random = randNum.nextInt(squaresAdded) ;
					board.getMap()[i][j].setSquare(boardSquares.get(random)) ;
					boardSquares.remove(random) ;
					squaresAdded-- ;
				}
			}
		}
		
		theGame.updateMovesLeft(-1) ;
		
		if(!(board.getLevel() instanceof Lightning)){
			if(board.getLevel().gameOver()){
				//close the frame and show level complete screen
				theGame.getModel().updateScores() ;
				Board b = Board.newInstance();
				if(b.equals(board)) {
					System.out.println("Same object again");
				}
				System.out.println("Reset : Star: " + board.getLevel().getStarNumber());
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
		}
		
		return true ;
	}

}
