package sixesWildMoves;

import sixesWildBoundary.SixesWildApplication;

public interface IMove {
	public boolean isValid(SixesWildApplication theGame);
	public boolean doMove(SixesWildApplication theGame);
	public void undoMove(SixesWildApplication theGame);
}
