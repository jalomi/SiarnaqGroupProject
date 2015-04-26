package sixesWildEntity;

import java.sql.Time;

import org.json.JSONException;
import org.json.JSONObject;

public class Lightning extends Level {
	int timeRemaining;
	//a real countdown timer should be implemented later
	//check out Scanner, Timer, and TimerTask
	
	public Lightning(int number, int movesRemaining) {
		super(number);
		this.timeRemaining = movesRemaining;
	}
	
	public Lightning(JSONObject json) throws JSONException {
		super(json);
	}

	public boolean hasWon() {
		return false;
	}
	
	public String getMovesRemainingString() {
		return "Unlimited";
	}
	
	public String getTimeRemainingString() {
		return Integer.toString(timeRemaining);
	}
	
	public void updateMovesLeft(int m){
		
	}
}
