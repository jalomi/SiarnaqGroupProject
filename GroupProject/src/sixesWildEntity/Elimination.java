package sixesWildEntity;

public class Elimination extends Level {
	int movesRemaining;
	
	public Elimination(int levelNumber, int movesRemaining)
	{
		super(levelNumber);
		this.movesRemaining=movesRemaining;
	}
	
	public boolean hasWon()
	{
		return false;
	}
}
