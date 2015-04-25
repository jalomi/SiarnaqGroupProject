package sixesWildEntity;

import java.util.ArrayList;

public class SixesWild {
	private ArrayList<Level> levels = new ArrayList<Level>();
	
	private Board board;
	public static SixesWild theGame;
	
	
	public static SixesWild newInstance() {
		if(theGame == null) {
			theGame = new SixesWild();
		}
		return theGame;
	}
	
	public SixesWild(){
		//should load levels from disk by using LevelJSONSerializer
		//since LevelBuilder is not ready
		//make a default list of levels of size 1
		levels.add(new Level(1));
		board = Board.newInstance();
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
