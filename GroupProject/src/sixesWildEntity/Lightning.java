package sixesWildEntity;

import java.sql.Time;

public class Lightning extends Level {
	int timeRemaining;
	//a real countdown timer should be implemented later
	//check out Scanner, Timer, and TimerTask
	
	public Lightning(int number, int movesRemaining) {
		super(number);
		this.timeRemaining=movesRemaining;
	}
	
	public boolean hasWon() {
		return false;
	}
	
	public String getMovesRemainingString() {
		return "Unlimited";
	}
	
	public String getTimeRemainingString() {
		return "Unlimited";
	}
}
