package sixesWildEntity;

public class Board {
	
	public static final String TAG = "Board";
	
	private Tile[][] map = new Tile[9][9];
	
	Board() {
		
	}
	
	public Board(Level l) {
		populateBoard(l);
	}
	
	private void populateBoard(Level l) {
		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 9; j++) {
				map[i][j] = new Tile(generateSquare(l));
			}
		}
	}
	
	private Square generateSquare(Level l) {
		return null;
		//return l.generateSquare();
	}

	public Tile[][] getMap() {
		return map;
	}

	public void setMap(Tile[][] map) {
		this.map = map;
	}
}
