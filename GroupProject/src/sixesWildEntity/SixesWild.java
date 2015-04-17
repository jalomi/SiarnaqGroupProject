package sixesWildEntity;

import java.util.ArrayList;
import java.util.Iterator;

public class SixesWild implements Iterable<Level>{
	private ArrayList<Level> levels;
	private Board thePlayBoard;
	
	public SixesWild(ArrayList<Level> l, Board b)
	{
		this.levels=l;
		this.thePlayBoard=b;
	}

	@Override
	public Iterator<Level> iterator() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public ArrayList<Level> getLevels()
	{
		return levels;
	}
	
	public Board getBoard()
	{
		return thePlayBoard;
	}
	
}
