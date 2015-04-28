package sixesWildEntity;

import org.json.JSONException;
import org.json.JSONObject;

public class Puzzle extends Level {
	int movesRemaining;
	
	public Puzzle(int number, int movesRemaining) {
		super(number);
		this.movesRemaining=movesRemaining;
	}
	
	public Puzzle(JSONObject json) throws JSONException {
		super(json);
		//add more later
		movesRemaining = json.getInt("movesRemaining");
	}
	
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
	
	@Override
	public JSONObject toJSON() throws JSONException {
		JSONObject json = super.toJSON();
		json.put("movesRemaining", movesRemaining);
		return json;
	}
	
	@Override
	public String getMovesRemainingString() {
		return String.valueOf(movesRemaining);
	}
	
	@Override
	public String getTimeRemainingString() {
		return "Unlimited";
	}
	
	@Override
	public void updateMovesLeft(int m){
		movesRemaining += m ;
	}
	
	@Override
	public boolean gameOver(){
		if(movesRemaining <= 0){
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
