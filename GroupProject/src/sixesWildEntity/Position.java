package sixesWildEntity;

public class Position {
	
	public static final String TAG = "Position";
	
	int col ;
	int row ;
	
	public Position(int c, int r) throws Exception{
		if(c >= 9 || c < 0 || r >= 9 || r < 0) {
			throw new Exception(TAG + " :: constructor out of bound " + c + "," + r);
		}
		this.col = c ;
		this.row = r ;
	}
	
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
