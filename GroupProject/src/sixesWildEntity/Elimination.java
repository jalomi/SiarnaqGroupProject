package sixesWildEntity;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Elimination game mode
 * @author John
 *
 */
public class Elimination extends Level {
	/** the number of moves left */
	int movesRemaining;
	
	/**
	 * Constructor
	 * @param number
	 * @param movesRemaining
	 * @param p1
	 * @param p2
	 * @param p3
	 * @param p4
	 * @param p5
	 * @param p6
	 * @param m1
	 * @param m2
	 * @param m3
	 * @param first
	 * @param second
	 * @param third
	 * @param unlocked
	 * @param swap
	 * @param reset
	 * @param remove
	 * @param enabledTiles
	 * @throws Exception
	 */
	public Elimination(int number, int movesRemaining, 
			  double p1, double p2, double p3, double p4, double p5, double p6,
			  double m1, double m2, double m3,
			  int first, int second, int third,
			  boolean unlocked, boolean swap, boolean reset, boolean remove,
			  boolean[][] enabledTiles) throws Exception {
		super(number, p1, p2, p3, p4, p5, p6, m1, m2, m3, first, second, third,
				unlocked, swap, reset, remove, enabledTiles);
		this.movesRemaining = movesRemaining;
	}

	/**
	 * constructor for JSON loading
	 * @param json
	 * @throws JSONException
	 */
	public Elimination(JSONObject json) throws JSONException {
		super(json);
		//add more later
		movesRemaining = json.getInt("movesRemaining");
	}
	
	/**
	 * makes a JSONObject out of this object
	 */
	@Override
	public JSONObject toJSON() throws JSONException {
		JSONObject json = super.toJSON();
		json.put("movesRemaining", movesRemaining);
		return json;
	}

	/**
	 * gets the number of moves left as a string
	 */
	@Override
	public String getMovesRemainingString() {
		return String.valueOf(movesRemaining);
	}
	
	/**
	 * gets the number of moves left
	 */
	@Override
	public int getMovesRemaining() {
		return movesRemaining;
	}
	
	/**
	 * gets the time left as a string
	 */
	@Override
	public String getTimeRemainingString() {
		return "Unlimited";
	}
	
	/**
	 * gets the level type
	 */
	@Override
	public String getLevelType(){
		return "Elimination" ;
	}
	
	/**
	 * checks to see if the game is over
	 */
	@Override
	public boolean gameOver(){ 
		Board board = Board.newInstance();
		if(board.allTilesMarked()){
			updateScore(20*movesRemaining) ;
			return true ;
		}		
		if(board.getCurrentMoves() <= 0){
			return true ;
		}
		return false ;
	}

	/**
	 * updates the time left
	 * not used in this game mode
	 */
	@Override
	public void updateTimeLeft(int t) {
		
	}

	/**
	 * gets the time remaining
	 */
	@Override
	public int getTimeRemaining() {
		return 0;
	}
	
	/**
	 * checks to see if the level has been won
	 */
	@Override
	public boolean hasWon() {
		Board board = Board.newInstance();
		
		if(board.allTilesMarked()){
			if(board.getCurrentScore() > highestScore) {
				highestScore = board.getCurrentScore();
			}
			
			if(highestScore >= threeStarScore){
				starNumber = 3 ;
			}
			else if(highestScore >= twoStarScore){
				starNumber = 2 ;
			}
			else if(highestScore >= oneStarScore){
				starNumber = 1 ;
			}	
		}	
		return board.allTilesMarked() && highestScore >= oneStarScore;
	}
	
	/**
	 * gets the buckets
	 * not used in this game mode
	 */
	@Override
	public boolean[] getBuckets(){
		boolean[] b={false, false, false, false, false, false, false, false, false};
		return b;
	}
	
	/**
	 * updates the number of moves left
	 */
	@Override
	public void updateMovesLeft(int m) {
		movesRemaining += m ;
	}
}
