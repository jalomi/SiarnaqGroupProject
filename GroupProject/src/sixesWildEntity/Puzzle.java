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
}
