package sixesWildMoves;

import java.util.ArrayList;
import sixesWildEntity.Board;
import sixesWildEntity.Tile;

public class NormalSelectionMove extends Move {
	ArrayList<Tile> tiles;
	
	public NormalSelectionMove(Board board) {
		super(board);
		this.tiles = board.getSelected();
	}

	@Override
	public boolean isValid() {
		int sum = 0;
		for(int i = 0; i < tiles.size(); i++)
		{
			sum += tiles.get(i).getSquare().getValue();
		}
		return sum == 6;
	}

	@Override
	public boolean doMove() {
		if(!isValid()){
			return false ;
		}
		
		//TODO
		
		return true ;
	}

	@Override
	public int getScore() {
		// TODO Auto-generated method stub
		return 0;
	}

}
