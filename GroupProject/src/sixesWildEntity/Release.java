package sixesWildEntity;

import org.json.JSONException;
import org.json.JSONObject;

public class Release extends Level {
	int movesRemaining;
	
	public Release(int number, int movesRemaining) {
		super(number);
		this.movesRemaining=movesRemaining;
	}
	
	public Release(JSONObject json) throws JSONException {
		super(json);
		//
	}

	public boolean hasWon() {
		return false;
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
	
}
