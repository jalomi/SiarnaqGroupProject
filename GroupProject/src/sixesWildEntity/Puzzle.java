package sixesWildEntity;

public class Puzzle extends Level {
	int movesRemaining;
	
	public Puzzle(int number, int movesRemaining)
	{
		super(number);
		this.movesRemaining=movesRemaining;
	}
	
	public boolean hasWon()
	{
		return false;
	}
	
	public String getMovesRemainingString() {
		return String.valueOf(movesRemaining);
	}
	
	public String getTimeRemainingString() {
		return "Unlimited";
	}
}
