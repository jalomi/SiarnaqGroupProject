package sixesWildMoves;

import java.util.ArrayList;

import sixesWildEntity.Board;
import sixesWildEntity.Tile;

public class NormalSelectionMove extends Move {
	ArrayList<Tile> tiles;
	
	public NormalSelectionMove(Board board, ArrayList<Tile> tiles) {
		super(board);
		this.tiles = tiles;
	}

	@Override
	public boolean isValid() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean doMove() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getScore() {
		// TODO Auto-generated method stub
		return 0;
	}

}
