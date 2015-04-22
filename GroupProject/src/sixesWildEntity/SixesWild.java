package sixesWildEntity;

import java.util.ArrayList;
import java.util.Iterator;

import sixesWildBoundary.SixesWildApplication;

public class SixesWild implements Iterable<Level>{
	private ArrayList<Level> levels;
	private Board board;
	private SixesWildApplication app ;
	
	public SixesWild(ArrayList<Level> l, Board b)
	{
		this.levels = l;
		this.board = b;
	}

	@Override
	public Iterator<Level> iterator() {
		// TODO Auto-generated method stub
		
		//don't know if this is how we should do it:
		//SixesWildApplication app = new SixesWildApplication(Level) ;
		
		return null;
	}
	
	
	public void intialize(){
		//initialize the game
		initializeModel() ;
		initializeView() ;
		initializeControllers() ;
	}
	
	
	private void initializeModel() {
		// TODO Auto-generated method stub
		
	}
	
	private void initializeView() {
		// TODO Auto-generated method stub
		
	}

	private void initializeControllers() {
		// TODO Auto-generated method stub
		
	}

	public ArrayList<Level> getLevels(){
		return levels;
	}
	
	public Board getBoard(){
		return board;
	}
	
}
