package sixesWildEntity;

import java.util.ArrayList;

public class Board {
	
	public static final String TAG = "Board";
	
	private static Board board;
	
	private Tile[][] map = new Tile[9][9] ;
	private Level level;
	
	//this attribute should not exit here!!! 
	//Selections are UI event, which is not the concern of entities
	//UI event will eventually changes entities
	//but entities should never keep track of any data of UI events
	//delete this after you read this comment
	//private ArrayList<Tile> selected;
	
	
	public static Board newInstance() {
		if(board == null) {
			board = new Board();
		}
		return board ;
	}
	
	public Board() {
		this.level = null;
	}
	
	private void populateBoard() throws Exception {
		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 9; j++) {
				if(level.getEnabledTiles()[i][j]) {
					map[i][j] = new Tile(generateSquare(), new Position(i, j)) ;
				} 
				else {
					map[i][j] = new Tile(new Position(i, j)) ;
				}
			}
		}
	}
	
	private Square generateSquare() {
		return this.level.generateSquare();
	}
	
	public void fall(Tile t){	
		int colAbove = t.getPos().col ;
		int rowAbove = t.getPos().row - 1;
		//System.out.println(colAbove + " " + rowAbove) ;
		if(rowAbove >= 0){			
			Tile aboveTile = map[colAbove][rowAbove] ;	
			t.setSquare(aboveTile.getSquare()) ;
			fall(aboveTile) ;	
		} else {
			t.setSquare(this.generateSquare()) ;			
		}
	}

	/**
	 * assume that tiles in the argument are empty
	 */
	public void fall(ArrayList<Tile> tiles) {
		int numbTiles = tiles.size() ;
		boolean swapped = true ;
		int j = 0 ;
		Tile tmp ;
		while(swapped){
			swapped = false;
			j++ ;
			for(int i = 0; i < numbTiles - j; i++){
				if(tiles.get(i).getPos().row > tiles.get(i+1).getPos().row){
					tmp = tiles.get(i) ;
					tiles.set(i, tiles.get(i+1)) ;
					tiles.set(i+1, tmp) ;
					swapped = true ;
					
				}
			}
		}
		
		for(Tile t : tiles) {
			fall(t);
		}		
	}
	
	public Level getLevel() {
		return level;
	}

	public void setLevel(Level level) {
		this.level = level;
		try {
			this.populateBoard();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Tile[][] getMap() {
		return map;
	}

	public void setMap(Tile[][] map) {
		this.map = map;
	}
	
	public Tile getTile(int col, int row) {
		try {
			return map[col][row] ;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public Square getSquare(int col, int row) {
		return getTile(col, row).getSquare();
	}
}
