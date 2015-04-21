package sixesWildEntity;

public class Board {
	
	public static final String TAG = "Board";
	
	private Tile[][] map = new Tile[9][9];
	private Level level;
	
	public Board() {
		this.level = new Level(1);
		this.populateBoard();
	}
	
	public Board(Level l) {
		this.level = l;
		this.populateBoard();
	}
	
	private void populateBoard() {
		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 9; j++) {
				if(level.getEnabledTiles()[i][j]) {
					map[i][j] = new Tile(generateSquare());
				} 
				else {
					map[i][j] = new Tile();
				}
			}
		}
	}
	
	private Square generateSquare() {
		return this.level.generateSquare();
	}

	public Tile[][] getMap() {
		return map;
	}

	public void setMap(Tile[][] map) {
		this.map = map;
	}
	
	public Tile getTile(int col, int row) {
		return map[col][row];
	}
	
	public Square getSquare(int col, int row) {
		return getTile(col, row).getSquare();
	}
}
