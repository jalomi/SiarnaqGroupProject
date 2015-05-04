package sixesWildEntity;

/**
 * Part of the game board that houses a square
 * @author John
 *
 */
public class Tile {
	/** TAG for the class */
	public static final String TAG = "Tile";
	
	/** the square in the tile */
	private Square square;
	
	/** position of the tile */
	private Position pos;
	
	/** flag to tell if marked in elimination mode */
	private boolean marked;
	
	/** flag to tell if selected */
	private boolean selected;
	
	/** flag to tell if tile is enabled */
	private boolean enabled;
	
	/** flag to tell if this tile is a bucket in release */
	private boolean bucket ;
	
	/**
	 * Constructor
	 * @param p
	 */
	public Tile(Position p) {
		enabled = false;
		marked = false;
		selected = false;
		bucket = false ;
		square = null;
		pos = p;
	}
	
	/**
	 * Constructor for a bucket tile
	 * @param p
	 * @param bkt
	 */
	public Tile(Position p, boolean bkt){
		System.out.println("Bucket Tile Made") ;
		enabled = true ;
		marked = false ;
		selected = false ;
		bucket = bkt ;
		square = new Square(7, 1) ;
		pos = p ;
	}
	
	/**
	 * Constructor for a position
	 * @param s
	 * @param p
	 */
	public Tile(Square s, Position p) {
		enabled = true;
		marked = false;
		selected = false;
		bucket = false ;
		square = s;
		pos = p;
	}

	/**
	 * gets the position of the tile
	 * @return
	 */
	public Position getPos() {
		return pos;
	}

	/**
	 * sets the position of the tile
	 * @param pos
	 */
	public void setPos(Position pos) {
		this.pos = pos;
	}

	/**
	 * sets the square of the tile 
	 * @param square
	 */
	public void setSquare(Square square) {
		this.square = square;
	}

	/**
	 * check if tile is marked
	 * @return
	 */
	public boolean isMarked() {
		return marked;
	}

	/**
	 * set tile as marked or unmarked
	 * @param marked
	 */
	public void setMarked(boolean marked) {
		this.marked = marked;
	}

	/**
	 * check if tile is selected
	 * @return
	 */
	public boolean isSelected() {
		return selected;
	}

	/**
	 * set tile as selected or deselected
	 * @param selected
	 */
	public void setSelected(boolean selected) {
		this.selected = selected;
	}

	/**
	 * check to see if the tile is enabled
	 * @return
	 */
	public boolean isEnabled() {
		return enabled;
	}

	/**
	 * sets tile as enabled or disabled
	 * @param enabled
	 */
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	/**
	 * gets the square of the tile
	 * @return
	 */
	public Square getSquare() {
		return square;
	}
	
	/** 
	 * checks tho see if tile is marked
	 * @return
	 */
	public boolean getMarked(){
		return this.marked ;
	}
	
	/**
	 * checks to see if tile is a bucket
	 * @return
	 */
	public boolean getBucket(){
		return bucket ;
	}
	
	/**
	 * sets tile to be a bucket
	 * @param b
	 */
	public void setBucket(boolean b){
		bucket = b ;
	}
}
