package sixesWildEntity;

public class Tile {
	private Square sqaure;
	private boolean marked;
	private boolean selected;
	private boolean enabled;
	
	public Tile() {
		enabled = true;
		marked = false;
		selected = false;
		sqaure = null;
	}
	
	public Tile(Square s) {
		enabled = true;
		marked = false;
		selected = false;
		sqaure = s;
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

	public Square getSqaure() {
		return sqaure;
	}

	public void setSqaure(Square sqaure) {
		this.sqaure = sqaure;
	}
}
