package sixesWildEntity;

import org.json.JSONException;
import org.json.JSONObject;

public class Elimination extends Level {
	int movesRemaining;
	
	/**
	 * This constructor is only for testing!
	 */
	public Elimination(int levelNumber, int movesRemaining) {
		super(levelNumber);
		this.movesRemaining = movesRemaining;
	}
	
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

	public Elimination(JSONObject json) throws JSONException {
		super(json);
		//add more later
	}

	public String getMovesRemainingString() {
		return String.valueOf(movesRemaining);
	}
	
	public String getTimeRemainingString() {
		return "Unlimited";
	}
	
	public void updateMovesLeft(int m){
		movesRemaining += m ;
	}
	
	public boolean gameOver(){
//		if(movesRemaining == 0){
//			if(score >= oneStarScore){
//				if(score >= threeStarScore){
//					starNumber = 3 ;
//				}
//				else if(score >= twoStarScore){
//					starNumber = 2 ;
//				}
//				else{
//					starNumber = 1 ;
//				}			
//			}
//
//		return true ;
//		}
//		
//		return false ;
		return false ;
	}
	
}
