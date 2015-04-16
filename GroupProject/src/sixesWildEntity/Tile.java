package sixesWildEntity;

public class Tile {
	private Square square;
	private boolean marked;
	private boolean selected;
	private boolean enabled;
	
	//this constructor should not be called
	public Tile() {
		enabled = false;
		marked = false;
		selected = false;
		square = null;
	}
	
	public Tile(Square s) {
		enabled = true;
		marked = false;
		selected = false;
		square = s;
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

	public void setSqaure(Square sqaure) {
		this.square = sqaure;
	}
}
