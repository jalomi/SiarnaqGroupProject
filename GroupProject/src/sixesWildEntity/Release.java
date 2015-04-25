package sixesWildEntity;

public class Release extends Level {
	int movesRemaining;
	
	public Release(int number, int movesRemaining) {
		super(number);
		this.movesRemaining=movesRemaining;
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
}
