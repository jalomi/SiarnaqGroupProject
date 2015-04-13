package sixesWild;

public class Elimination extends Level {
	int movesRemaining;
	
	public Elimination(int movesRemaining)
	{
		super();
		this.movesRemaining=movesRemaining;
	}
	
	public boolean hasWon()
	{
		return false;
	}
}
