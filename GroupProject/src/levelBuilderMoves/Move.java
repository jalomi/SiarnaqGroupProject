package levelBuilderMoves;

public abstract class Move {

	public abstract boolean isValid();
	public abstract boolean doMove();
	public abstract boolean undo();
}
