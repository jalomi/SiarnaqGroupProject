package sixesWildMoves;

import sixesWildBoundary.SixesWildApplication;

/**
 * Interface for moves
 * @author 
 *
 */
public interface IMove {
	/**
	 * Checks to see if the move is valid
	 * @param theGame
	 * @return
	 */
	public boolean isValid(SixesWildApplication theGame);
	
	/**
	 * Performs the move
	 * @param theGame
	 * @return
	 */
	public boolean doMove(SixesWildApplication theGame);
}
