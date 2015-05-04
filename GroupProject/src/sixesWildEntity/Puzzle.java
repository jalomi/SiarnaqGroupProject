package sixesWildEntity;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Puzzle game mode
 * @author John
 *
 */
public class Puzzle extends Level {
	/** moves left */
	int movesRemaining;
	
	/**
	 * JSON loading
	 * @param json
	 * @throws JSONException
	 */
	public Puzzle(JSONObject json) throws JSONException {
		super(json);
		//add more later
		movesRemaining = json.getInt("movesRemaining");
	}
	
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
	public Puzzle(int number, int movesRemaining, 
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
	 * makes a JSONObject out of this object
	 */
	@Override
	public JSONObject toJSON() throws JSONException {
		JSONObject json = super.toJSON();
		json.put("movesRemaining", movesRemaining);
		return json;
	}
	
	/**
	 * gets the moves left as a string
	 */
	@Override
	public String getMovesRemainingString() {
		return String.valueOf(movesRemaining);
	}
	
	/**
	 * gets the time left as a string
	 */
	@Override
	public String getTimeRemainingString() {
		return "Unlimited";
	}
	
	/**
	 * gets the moves left
	 */
	@Override
	public void updateMovesLeft(int m){
		movesRemaining += m ;
	}
	
	/**
	 * checks to see if the game is over
	 */
	@Override
	public boolean gameOver(){
		Board board = Board.newInstance();
		System.out.println(TAG + " Puzzle moves: " + board.getCurrentMoves());
		System.out.println(TAG + " Puzzle score: " + board.getCurrentScore());
		if(board.getCurrentMoves() <= 0){
			return true ;
		}
		return false ;
	}

	/**
	 * update the time left
	 */
	@Override
	public void updateTimeLeft(int t) {
		
	}

	/**
	 * gets the moves left
	 */
	@Override
	public int getMovesRemaining() {
		return movesRemaining;
	}

	/**
	 * gets the time left
	 */
	@Override
	public int getTimeRemaining() {
		return 0;
	}
	
	/**
	 * gets the level type
	 */
	@Override
	public String getLevelType() {
		return "Puzzle";
	}
	
	/**
	 * checks to see if the user has won the game
	 */
	@Override
	public boolean hasWon() {
		Board board = Board.newInstance();
		
		if(board.getCurrentScore() > highestScore) {
			highestScore = board.getCurrentScore();
		}
		
		if(highestScore >= threeStarScore){
			starNumber = 3 ;
		}
		else if(highestScore >= twoStarScore){
			starNumber = 2 ;
		}
		else if(highestScore >= oneStarScore) {
			starNumber = 1 ;
			System.out.println("111: " + board.getLevel().getStarNumber());
		}			
		
		return board.getCurrentScore() >= oneStarScore;
	}
	
	/**
	 * gets buckets
	 * not used in this game mode
	 */
	@Override
	public boolean[] getBuckets(){
		boolean[] b={false, false, false, false, false, false, false, false, false};
		return b;
	}
}
