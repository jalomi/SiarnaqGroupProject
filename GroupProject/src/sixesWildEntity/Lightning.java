package sixesWildEntity;

import org.json.JSONException;
import org.json.JSONObject;

public class Lightning extends Level {
	int timeRemaining;
	//a real countdown timer should be implemented later
	//check out Scanner, Timer, and TimerTask
	
	public Lightning(int number, int time) {
		super(number);
		this.timeRemaining = time;
		this.unlocked = false ;
	}
	
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
	
	public Lightning(JSONObject json) throws JSONException {
		super(json);
	}

	@Override
	public String getMovesRemainingString() {
		return "Unlimited";
	}
	
	@Override
	public String getTimeRemainingString() {
		return Integer.toString(timeRemaining);
	}
	
	@Override
	public void updateMovesLeft(int m){
		
	}
	
	@Override
	public boolean gameOver(){
		if(timeRemaining <= 0){
			if(score >= oneStarScore){
				if(score >= threeStarScore){
					starNumber = 3 ;
				}
				else if(score >= twoStarScore){
					starNumber = 2 ;
				}
				else{
					starNumber = 1 ;
				}			
			}
			
			return true ;
		}
		
		return false ;
	}
	
}
