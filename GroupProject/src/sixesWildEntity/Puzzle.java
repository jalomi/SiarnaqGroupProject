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
	
	public JSONObject toJSON() throws JSONException {
		JSONObject json = super.toJSON();
		json.put("movesRemaining", movesRemaining);
		return json;
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
	
	public boolean hasWon(){
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
				
				return true ;
			}
		}
		
		return false ;
	}
	
	
}
