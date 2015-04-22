package sixesWildMoves;

import java.util.ArrayList;
import java.util.Iterator;

import sixesWildEntity.Board;
import sixesWildEntity.SixesWild;
import sixesWildEntity.Tile;

public class NormalSelectionMove extends Move {
	ArrayList<Tile> tiles;
	
	public NormalSelectionMove(Board board, ArrayList<Tile> tiles) {
		super(board);
		this.tiles = tiles;
	}

	@Override
	public boolean isValid() {
		int sum=0;
		for(int i=0; i<tiles.size(); i++)
		{
			sum+=tiles.get(i).getSquare().getValue();
		}
		return sum==6;
	}

	@Override
	public boolean doMove() {
		if(!isValid()){
			return false ;
		}
		
		
		return true ;
	}

	@Override
	public int getScore() {
		// TODO Auto-generated method stub
		return 0;
	}

}
