package sixesWildEntity;

/**
 * Position on a board
 * @author 
 *
 */
public class Position {
	/** TAG for this class */
	public static final String TAG = "Position";
	
	/** column */
	int col ;
	
	/** row */
	int row ;
	
	/**
	 * Constructor
	 * @param c
	 * @param r
	 */
	public Position(int c, int r) {
		if(c >= 9 || c < 0 || r >= 9 || r < 0) {
			System.out.println("Invalid Position") ;
		}
		else{
			this.col = c ;
			this.row = r ;
		}
	}
	
	/**
	 * checks to see if two positions are equal
	 */
	@Override
	public boolean equals(Object o) {
		
		if(o == null) return false;
		
		if(o instanceof Position) {
			Position p = (Position) o;
			if(col == p.col && row == p.row) {
				return true;
			}
		}
		
		return false;
	}
	
	/**
	 * makes a hash code
	 */
	@Override
	public int hashCode() {
		//multiplying by 9 or bigger guarantees the hash code to be unique in each position;
		return (17 * col) + row;
	}
	
	@Override
	public String toString() {
		return new String(col + "," + row);
	}

}
