package sixesWildEntity;

public class Lightning extends Level {
	int timeRemaining;
	
	public Lightning(int movesRemaining)
	{
		super();
		this.timeRemaining=movesRemaining;
	}
	
	public boolean hasWon()
	{
		return false;
	}
}
