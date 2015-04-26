package sixesWildEntity;

import org.json.JSONException;
import org.json.JSONObject;

public class Elimination extends Level {
	int movesRemaining;
	
	public Elimination(int levelNumber, int movesRemaining) {
		super(levelNumber);
		this.movesRemaining=movesRemaining;
	}
	
	public Elimination(JSONObject json) throws JSONException {
		super(json);
		//add more later
	}

	public boolean hasWon() {
		return false;
	}
	
	public String getMovesRemainingString() {
		return String.valueOf(movesRemaining);
	}
	
	public String getTimeRemainingString() {
		return "No Time";
	}
	
	public void updateMovesLeft(int m){
		movesRemaining += m ;
	}
	
}
