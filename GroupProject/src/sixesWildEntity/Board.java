package sixesWildEntity;

import java.util.ArrayList;

/**
 * holds all the tiles for a sixes wild game
 * @author John
 *
 */
public class Board {
	/** TAG for the class */
	public static final String TAG = "Board";
	
	/** the board singleton */
	private static Board board;
	
	/** the tiles in the board */
	private Tile[][] map = new Tile[9][9] ;
	
	/** the level that the board is currently playing */
	private Level level;
	
	/** flag to say next move is a remove move */
	boolean removeMove;
	
	/** flag to say next move is a swap move */
	boolean swapMove;
	
	/** current game score */
	int currentScore;
	
	/** current moves remaining */
	int currentMoves;
	
	/** current time remaining */
	int currentTime;
	
	/**
	 * check to see if a board has been created yet and if not, creates a new board
	 * @return
	 */
	public static Board newInstance() {
		if(board == null) {
			board = new Board();
		}
		return board ;
	}
	
	/**
	 * Constructor
	 */
	public Board() {
		this.level = null;
		removeMove = false ;
		swapMove = false ;
	}
	
	/**
	 * fills board with tiles
	 * @throws Exception
	 */
	public void populateBoard() throws Exception {
		boolean sixAdded[] = new boolean[9] ;
		for(int i = 0; i < 9; i++){
			sixAdded[i] = false ;
		}
		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 9; j++) {
				if(level.getEnabledTiles()[i][j]) {
					if(level.getLevelType().equals("Release")){
						if(level.getBuckets()[i] && !sixAdded[i]){
							System.out.println("Putting six in column " + i) ;
							map[i][j] = new Tile(new Square(6, 1), new Position(i, j)) ;
							sixAdded[i] = true ;
						}
						else if(level.getBuckets()[i] && j == 8){
							map[i][j] = new Tile(new Position(i, j), true) ; //this is a bucket
						}
						else{
							Square genSquare = generateSquare() ;
							while(level.getBuckets()[i] && genSquare.getValue() == 6){
								genSquare = generateSquare() ;
							}
							map[i][j] = new Tile(genSquare, new Position(i, j)) ;
						}
					}
					else map[i][j] = new Tile(generateSquare(), new Position(i, j)) ;
				} 
				else {
					map[i][j] = new Tile(new Position(i, j)) ;
				}
			}
		}
		

	}
	
	/**
	 * creates a square 
	 * @return
	 */
	public Square generateSquare() {
		return this.level.generateSquare();
	}
	
	/**
	 * imitates gravity by making tiles fall
	 * @param t
	 */
	public void fall(Tile t){	
		int colAbove = t.getPos().col ;
		int rowAbove = t.getPos().row - 1;
		int colBelow = t.getPos().col ;
		int rowBelow = t.getPos().row + 1 ;
		//System.out.println(colAbove + " " + rowAbove) ;
		if(rowAbove >= 0){			
			Tile aboveTile = map[colAbove][rowAbove] ;
			
			while(aboveTile.getSquare() == null){
				rowAbove-- ;
				
				if(rowAbove < 0){
					t.setSquare(this.generateSquare()) ;
					return ;
				}
				
				aboveTile = map[colAbove][rowAbove] ;
			}			
			
			t.setSquare(aboveTile.getSquare()) ;
			fall(aboveTile) ;	
			if(t.getPos().row < 8){
				while(rowBelow < 8 && map[colBelow][rowBelow].getSquare() == null){
					rowBelow++ ;
				}
				Tile belowTile = map[colBelow][rowBelow] ;
				if(belowTile.getSquare() != null && belowTile.getSquare().getValue() == 7){
					if(rowBelow > 8){
						return ;
					}
					else {
						belowTile = map[colBelow][rowBelow] ;
						if(belowTile.getBucket() && t.getSquare().getValue() == 6){
							belowTile.setSquare(t.getSquare()) ;
							fall(t) ;
						}
						rowBelow++ ;
					}
				}
			}
		} else {
			t.setSquare(this.generateSquare()) ;			
		}
	}

	/**
	 * imitates gravity by making tiles above the selected tiles fall
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
	
	/**
	 * gets the current level
	 * @return
	 */
	public Level getLevel() {
		return level;
	}

	/**
	 * sets the current level
	 * @param level
	 */
	public void setLevel(Level level) {
		this.level = level;
		this.currentMoves = level.getMovesRemaining();
		this.currentTime = level.getTimeRemaining();
		this.currentScore = 0;
		try {
			this.populateBoard();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * gets the current map of tiles
	 * @return
	 */
	public Tile[][] getMap() {
		return map;
	}
	
	/**
	 * gets the tile at the coordinate
	 * @param col
	 * @param row
	 * @return
	 */
	public Tile getTile(int col, int row) {
		try {
			return map[col][row] ;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * gets the square at the coordinate
	 * @param col
	 * @param row
	 * @return
	 */
	public Square getSquare(int col, int row) {
		return getTile(col, row).getSquare();
	}

	/**
	 * sets the next move to be a remove move
	 * @param b
	 */
	public void setRemoveMove(boolean b) {
		removeMove = b ;
	}
	
	/**
	 * gets the flag for the next move to be a remove move
	 * @return
	 */
	public boolean getRemoveMove() {
		return removeMove;
	}

	/**
	 * sets the next move to be a swap move
	 * @param b
	 */
	public void setSwapMove(boolean b) {
		swapMove = b ;
	}
	
	/**
	 * gets the flag for the next move to be a swap move
	 * @return
	 */
	public boolean getSwapMove(){
		return swapMove ;
	}
	 
	/**
	 * checks to see if all tiles are marked in elimination
	 * @return
	 */
	public boolean allTilesMarked(){
		for(int i = 0; i < 9; i++){
			for(int j = 0; j < 9; j++){
				if(this.map[i][j].isEnabled()){
					if(!this.map[i][j].getMarked()){
						return false;
					}
				}
			}
		}
		System.out.println("All Marked") ;
		return true ;
	}

	/**
	 * gets the current score
	 * @return
	 */
	public int getCurrentScore() {
		return currentScore;
	}

	/**
	 * gets the current moves remaining
	 * @return
	 */
	public int getCurrentMoves() {
		return currentMoves;
	}

	/**
	 * gets the current time remaining
	 * @return
	 */
	public int getCurrentTime() {
		return currentTime;
	}

	/**
	 * sets the current score
	 * @param currentScore
	 */
	public void setCurrentScore(int currentScore) {
		this.currentScore = currentScore;
	}

	/**
	 * sets the current moves remaining
	 * @param currentMoves
	 */
	public void setCurrentMoves(int currentMoves) {
		this.currentMoves = currentMoves;
	}

	/**
	 * sets the current time remaining
	 * @param currentTime
	 */
	public void setCurrentTime(int currentTime) {
		this.currentTime = currentTime;
	}
	
}
