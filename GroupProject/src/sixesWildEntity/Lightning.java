package sixesWildEntity;

public class Lightning extends Level {
	int timeRemaining;
	
	public Lightning(int number, int movesRemaining)
	{
		super(number);
		this.timeRemaining=movesRemaining;
	}
	
	public boolean hasWon()
	{
		return false;
	}
}
