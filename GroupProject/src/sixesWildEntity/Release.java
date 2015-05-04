package sixesWildEntity;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Release game mode
 * @author Kyle
 * @author John
 *
 */
public class Release extends Level {
	/** moves left */
	int movesRemaining;
	
	/** buckets for the 6s to fall into */
	boolean[] buckets = new boolean[9];
	
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
	 * @param buckets
	 * @throws Exception
	 */
	public Release(int number, int movesRemaining, 
			  double p1, double p2, double p3, double p4, double p5, double p6,
			  double m1, double m2, double m3,
			  int first, int second, int third,
			  boolean unlocked, boolean swap, boolean reset, boolean remove,
			  boolean[][] enabledTiles, boolean[] buckets) throws Exception {
		super(number, p1, p2, p3, p4, p5, p6, m1, m2, m3, first, second, third,
				unlocked, swap, reset, remove, enabledTiles);
		this.movesRemaining = movesRemaining;
		this.buckets = buckets ;
		
	}
	
	/**
	 * loading with JSON
	 * @param json
	 * @throws JSONException
	 */
	public Release(JSONObject json) throws JSONException {
		super(json);
		movesRemaining = json.getInt("movesRemaining") ;
        for(int i = 0; i < 9; i++){
	        buckets[i] = json.getJSONArray("buckets").getBoolean(i);
        }
	}

	/**
	 * makes a JSONObject out of this object
	 */
	@Override
	public JSONObject toJSON() throws JSONException{
		JSONObject json = super.toJSON() ;
		json.put("movesRemaining", movesRemaining) ;
        json.put("buckets", buckets); //!
		return json ;
	}
	
	/**
	 * get moves left as a string
	 */
	@Override
	public String getMovesRemainingString() {
		return String.valueOf(movesRemaining);
	}
	
	/**
	 * get time left as a string
	 */
	@Override
	public String getTimeRemainingString() {
		return "Unlimited";
	}
	
	/**
	 * get moves left
	 */
	@Override
	public void updateMovesLeft(int m){
		movesRemaining += m ;
	}
	
	/**
	 * check to see if the game is over
	 */
	@Override
	public boolean gameOver(){
		boolean allBucketFull = true ;
		Board board = Board.newInstance() ;
		
		for(int i = 0; i < 9; i++){
			if(buckets[i]){
				if(board.getSquare(i, 8).getValue() != 6){
					allBucketFull = false ;
					break ;
				}
			}
		}

		if(allBucketFull){
			updateScore(20*board.getCurrentMoves()) ;		//Do we want this?	
			return true ;
		}
	
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
	 * get the moves left
	 */
	@Override
	public int getMovesRemaining() {
		return movesRemaining;
	}

	/**
	 * get the time left
	 */
	@Override
	public int getTimeRemaining() {
		return 0;
	}
	
	/**
	 * get the type of level
	 */
	public String getLevelType() {
		return "Release";
	}
	
	/**
	 * see if player has won the game
	 */
	@Override
	public boolean hasWon() {
		boolean allBucketFull = true ;
		Board board = Board.newInstance() ;
		
		for(int i = 0; i < 9; i++){
			if(buckets[i]){
				if(board.getSquare(i, 8) != null){
					if(board.getSquare(i, 8).getValue() != 6){
					allBucketFull = false ;
					}
				}
			}
		}
		
		if(board.currentScore > highestScore) {
			highestScore = board.currentScore;
		}
		if(highestScore >= threeStarScore){
			starNumber = 3 ;
		}
		else if(highestScore >= twoStarScore){
			starNumber = 2 ;
		}
		else if(highestScore >= oneStarScore) {
			starNumber = 1 ;
		}	
		
		return allBucketFull;
	}
	
	/**
	 * get the buckets
	 */
	@Override
	public boolean[] getBuckets(){
		return buckets;
	}
}
