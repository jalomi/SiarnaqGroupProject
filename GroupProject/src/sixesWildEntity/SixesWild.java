package sixesWildEntity;

import java.util.ArrayList;

import JSONSerializer.LevelJSONSerializer;

/**
 * Model for the Sixes Wild game
 * @author John
 *
 */
public class SixesWild {
	/** list of levels in the game */
	private ArrayList<Level> levels = new ArrayList<Level>();
	
	/** list of level names for the game */
	private ArrayList<String> levelNames = new ArrayList<String>(); 
	
	/** list of highscores for each level */
	private int[] highScore = new int[16] ;
	
	/** list of stars earned for the levels */
	private int[] starNum = new int[16] ;
	
	/** board being used */
	private Board board;
	
	/** singleton model */
	public static SixesWild theGame;
	
	/**
	 * if a SixesWild exists, use it.  If not, create one
	 * @return
	 */
	public static SixesWild newInstance() {
		if(theGame == null) {
			theGame = new SixesWild();
		}
		return theGame;
	}
	
	/**
	 * Constructor
	 */
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

	/**
	 * sets the board of the game
	 * @param board
	 */
	public void setBoard(Board board) {
		this.board = board;
	}

	/**
	 * gets the list of levels
	 * @return
	 */
	public ArrayList<Level> getLevels(){
		return levels;
	}
	
	/**
	 * gets the board
	 * @return
	 */
	public Board getBoard(){
		return board;
	}

	/**
	 * gets the board's current level
	 * @return
	 */
	public Level getLevel() {
		return board.getLevel();
	}

	/**
	 * get the number of stars earned for the level at this index
	 * @param i
	 * @return
	 */
	public int getStarNum(int i) {
		return starNum[i];
	}
	
	/**
	 * gets the highest score of the level at the index given
	 * @param i
	 * @return
	 */
	public int getHighScore(int i){
		return highScore[i] ;
	}
	
	/**
	 * sets the highest score of the level at the given index
	 * @param i
	 * @param s
	 */
	public void setHighScore(int i, int s){
		highScore[i] = s ;
	}

	/**
	 * updates the scores of the levels
	 */
	public void updateScores() {
		for(int i = 0; i < levels.size(); i++){
			board.getLevel().setHighestScore(levels.get(i).highestScore);
			board.getLevel().setStarNumber(levels.get(i).starNumber);
			//highScore[i] = levels.get(i).highestScore ;
			//starNum[i] = levels.get(i).starNumber ;
		}
	}

	/**
	 * gets the list of level names
	 * @return
	 */
	public ArrayList<String> getLevelNames() {
		return levelNames;
	}
	
}
