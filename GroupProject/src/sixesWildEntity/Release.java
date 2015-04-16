package sixesWildEntity;

public class Release extends Level {
	int movesRemaining;
	
	public Release(int number, int movesRemaining)
	{
		super(number);
		this.movesRemaining=movesRemaining;
	}
	
	public boolean hasWon()
	{
		return false;
	}
}
