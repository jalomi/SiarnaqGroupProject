package sixesWildEntity;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Lightning game mode
 * @author John
 * @author Xuanzhe 
 *
 */
public class Lightning extends Level {
	/** time left */
	int timeRemaining;
	
	/**
	 * Constructor
	 * @param number
	 * @param timeRemaining
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
	public Lightning(int number, int timeRemaining, 
			  double p1, double p2, double p3, double p4, double p5, double p6,
			  double m1, double m2, double m3,
			  int first, int second, int third,
			  boolean unlocked, boolean swap, boolean reset, boolean remove,
			  boolean[][] enabledTiles) throws Exception {
		super(number, p1, p2, p3, p4, p5, p6, m1, m2, m3, first, second, third,
				unlocked, swap, reset, remove, enabledTiles);
		this.timeRemaining = timeRemaining;
	}
	
	/**
	 * JSON loading
	 * @param json
	 * @throws JSONException
	 */
	public Lightning(JSONObject json) throws JSONException {
		super(json);
		timeRemaining = json.getInt("timeRemaining");
	}
	
	/**
	 * makes a JSONObject based on this object
	 */
	@Override
	public JSONObject toJSON() throws JSONException {
        JSONObject json = super.toJSON();
        json.put("timeRemaining", timeRemaining);
		return json;
	}

	/**
	 * gets the moves left as a string
	 */
	@Override
	public String getMovesRemainingString() {
		return "Unlimited";
	}
	
	/**
	 * gets time left as a string
	 */
	@Override
	public String getTimeRemainingString() {
		return Integer.toString(timeRemaining);
	}
	
	/**
	 * update the moves left
	 */
	@Override
	public void updateMovesLeft(int m){
		
	}
	
	/**
	 * check to see if the game is over
	 */
	@Override
	public boolean gameOver(){
		//old //timeRemaining <= 0
		Board board = Board.newInstance();
		if(board.getCurrentTime() <= 0){
			LTimer t = LTimer.getInstance();
			t.cancel();
			return true ;
		}
		return false ;
	}

	/**
	 * updates the time left
	 */
	@Override
	public void updateTimeLeft(int t) {
		Board board = Board.newInstance();
		int currentTime = board.getCurrentTime();
		board.setCurrentTime(currentTime + t); 
		//old //timeRemaining += t ;
	}

	/**
	 * gets the moves left
	 */
	@Override
	public int getMovesRemaining() {
		return 0;
	}

	/**
	 * gets the time left
	 */
	@Override
	public int getTimeRemaining() {
		return timeRemaining;
	}
	
	/**
	 * gets the type of the level
	 */
	@Override
	public String getLevelType() {
		return "Lightning";
	}
	
	/**
	 * checks to see if the game has been won
	 */
	@Override
	public boolean hasWon() {
		Board board = Board.newInstance();
		if(board.currentScore >= highestScore) {
			highestScore = board.currentScore;
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
		
		return board.currentScore >= oneStarScore;
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
