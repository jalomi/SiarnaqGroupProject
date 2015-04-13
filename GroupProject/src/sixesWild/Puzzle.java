package sixesWild;

public class Puzzle extends Level {
	int movesRemaining;
	
	public Puzzle(int movesRemaining)
	{
		super();
		this.movesRemaining=movesRemaining;
	}
	
	public boolean hasWon()
	{
		return false;
	}
}
