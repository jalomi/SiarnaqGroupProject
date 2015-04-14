package sixesWildEntity;

public class Tile {
	Square square;
	boolean marked;
	boolean selected;
	Position psn;
	
	public Tile(Position psn)
	{
		this.psn=psn;
		marked=false;
		selected=false;
	}
}
