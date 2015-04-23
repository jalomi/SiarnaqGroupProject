package sixesWildEntity;

import java.util.ArrayList;
import java.util.Iterator;

import sixesWildBoundary.SixesWildApplication;

public class SixesWild {
	private ArrayList<Level> levels;
	private Board board;
	
	public SixesWild(){
		//get levels from JSON
		//TODO
	}
	

	public void setLevels(ArrayList<Level> levels) {
		this.levels = levels;
	}


	public void setBoard(Board board) {
		this.board = board;
	}


	public ArrayList<Level> getLevels(){
		return levels;
	}
	
	public Board getBoard(){
		return board;
	}
	
}
