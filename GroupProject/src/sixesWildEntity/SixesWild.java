package sixesWildEntity;

import java.util.ArrayList;

public class SixesWild {
	private ArrayList<Level> levels = new ArrayList<Level>();
	private int[] highScore = new int[16] ;
	private int[] starNum = new int[16] ;
	private Board board;
	public static SixesWild theGame;
	
	
	//CONSTRUCTORS
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
		levels.add(new Puzzle(1, 30));
		
		//add empty levels for testing
		for(int i = 0; i < 15; i++){
			levels.add(new Puzzle(i+1, 30)) ;
		}
		
		
		board = Board.newInstance();
		
		for(int i = 0; i < 16; i++){
			highScore[i] = 0 ;
			starNum[i] = levels.get(i).starNumber ;
		}
	}
	//END CONSTRUCTORS
	

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

	public Level getLevel() {
		return board.getLevel();
	}

	public int getStarNum(int i) {
		return starNum[i];
	}

	public void updateScores() {
		for(int i = 0; i < 16; i++){
			highScore[i] = levels.get(i).score ;
			starNum[i] = levels.get(i).starNumber ;
		}
	}
	
}
