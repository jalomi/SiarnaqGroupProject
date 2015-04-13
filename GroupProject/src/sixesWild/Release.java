package sixesWild;

public class Release extends Level {
	int movesRemaining;
	
	public Release(int movesRemaining)
	{
		super();
		this.movesRemaining=movesRemaining;
	}
	
	public boolean hasWon()
	{
		return false;
	}
}
