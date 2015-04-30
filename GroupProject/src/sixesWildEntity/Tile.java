package sixesWildEntity;

public class Tile {
	public static final String TAG = "Tile";
	
	private Square square;
	private Position pos;
	private boolean marked;
	private boolean selected;
	private boolean enabled;
	private boolean bucket ;
	
	public Tile(Position p) {
		enabled = false;
		marked = false;
		selected = false;
		bucket = false ;
		square = null;
		pos = p;
	}
	
	public Tile(Square s, Position p) {
		enabled = true;
		marked = false;
		selected = false;
		bucket = false ;
		square = s;
		pos = p;
	}

	public Position getPos() {
		return pos;
	}

	public void setPos(Position pos) {
		this.pos = pos;
	}

	public void setSquare(Square square) {
		this.square = square;
	}

	public boolean isMarked() {
		return marked;
	}

	public void setMarked(boolean marked) {
		this.marked = marked;
	}

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public Square getSquare() {
		return square;
	}
	
	public boolean getMarked(){
		return this.marked ;
	}
	
	public boolean getBucket(){
		return bucket ;
	}
	
	public void setBucket(boolean b){
		bucket = b ;
	}
}
