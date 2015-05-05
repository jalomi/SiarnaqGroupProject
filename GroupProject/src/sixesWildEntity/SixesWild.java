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
	 * updates the scores of the levels
	 */
	public void updateScores() {
		for(int i = 0; i < levels.size(); i++){
			board.getLevel().setHighestScore(levels.get(i).getHighestScore());
			board.getLevel().setStarNumber(levels.get(i).getStarNumber());
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
