package sixesWildEntity;

public class Elimination extends Level {
	int movesRemaining;
	
	public Elimination(int levelNumber, int movesRemaining) {
		super(levelNumber);
		this.movesRemaining=movesRemaining;
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
