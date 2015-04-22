package sixesWildEntity;

import java.util.ArrayList;
import java.util.HashMap;

public class Board {
	
	public static final String TAG = "Board";
	
	private HashMap<Integer, Tile> map = new HashMap<Integer, Tile>() ;
	private Level level;
	private ArrayList<Tile> selected ;
	
	public Board() {
		this.level = new Level(1);
		this.populateBoard();
		this.selected = new ArrayList<Tile>() ;
	}
	
	public Board(Level l) {
		this.level = l;
		this.populateBoard();
	}
	
	private void populateBoard() {
		for(int i = 11; i <= 99; i++) {
			if(i % 10 != 0) {
				if(level.getEnabledTiles().get(i)) {
					map.put(i, new Tile(generateSquare()));
				} 
				else {
					map.put(i, new Tile()) ;
				}
			}
		}
	}
	
	private Square generateSquare() {
		return this.level.generateSquare();
	}

	public HashMap<Integer, Tile> getMap() {
		return map;
	}

	public void setMap(HashMap<Integer, Tile> map) {
		this.map = map;
	}
	
	public Tile getTile(int col, int row) {
		int key = col*10+row ;
		return map.get(key) ;
	}
	
	public Square getSquare(int col, int row) {
		return getTile(col, row).getSquare();
	}

	public ArrayList<Tile> getSelected() {
		return selected;
	}
}
