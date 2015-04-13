package sixesWild;

public class Lightning extends Level {
	int movesRemaining;
	
	public Lightning(int movesRemaining)
	{
		super();
		this.movesRemaining=movesRemaining;
	}
	
	public boolean hasWon()
	{
		return false;
	}
}
