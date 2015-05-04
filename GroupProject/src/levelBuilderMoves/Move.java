package levelBuilderMoves;

/**
 * Abstract class which holds what methods each move needs to override.
 * @author 
 *
 */
public abstract class Move {

	/**
	 * Abstract method which checks validity of move.
	 * Needs to be overridden.
	 * @return
	 */
	public abstract boolean isValid();
	
	/**
	 * Abstract method which does the move.
	 * Needs to be overridden.
	 * @return
	 */
	public abstract boolean doMove();
	
	/**
	 * Abstract method which undoes the move.
	 * Needs to be overridden.
	 * @return
	 */
	public abstract boolean undo();
}
