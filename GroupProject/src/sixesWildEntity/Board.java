package sixesWildEntity;

import java.util.ArrayList;
import java.util.HashMap;

public class Board {
	
	public static final String TAG = "Board";
	
	private HashMap<Position, Tile> map = new HashMap<Position, Tile>();
	private Level level;
	
	//this attribute should not exit here!!!
	//Selections are UI event, which is not the concern of entities
	//UI event will eventually changes entities
	//but entities should never keep track of any data of UI events
	//delete this after you read this comment
	//private ArrayList<Tile> selected;
	
	public Board() {
		this.level = new Level(1);
		try {
			this.populateBoard();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Board(Level l) {
		this.level = l;
		try {
			this.populateBoard();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void populateBoard() throws Exception {
		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 9; j++) {
				if(level.getEnabledTiles().get(new Position(i, j))) {
					map.put(new Position(i, j), new Tile(generateSquare()));
				} 
				else {
					map.put(new Position(i, j), new Tile()) ;
				}
			}
		}
	}
	
	private Square generateSquare() {
		return this.level.generateSquare();
	}

	public HashMap<Position, Tile> getMap() {
		return map;
	}

	public void setMap(HashMap<Position, Tile> map) {
		this.map = map;
	}
	
	public Tile getTile(int col, int row) {
		try {
			return map.get(new Position(col, row)) ;
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
