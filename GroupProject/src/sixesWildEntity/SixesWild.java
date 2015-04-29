package sixesWildEntity;

import java.io.IOException;
import java.util.ArrayList;

import org.json.JSONException;

import JSONSerializer.LevelJSONSerializer;

public class SixesWild {
	private ArrayList<Level> levels = new ArrayList<Level>();
	private ArrayList<String> levelNames = new ArrayList<String>(); 
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
		LevelJSONSerializer json = new LevelJSONSerializer("Level List.json");
		try {
			levelNames = json.loadLevelList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		for(String s : levelNames) {
			LevelJSONSerializer l = new LevelJSONSerializer(s);
			try {
				levels.add(l.loadSingleLevel(s.substring(0, 1)));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		board = Board.newInstance();
		
		levels.get(0).setUnlocked(true) ;
		
		for(int i = 0; i < levelNames.size(); i++){
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
	
	public int getHighScore(int i){
		return highScore[i] ;
	}
	
	public void setHighScore(int i, int s){
		highScore[i] = s ;
	}

	public void updateScores() {
		for(int i = 0; i < levels.size(); i++){
			highScore[i] = levels.get(i).score ;
			starNum[i] = levels.get(i).starNumber ;
		}
	}
	
}
