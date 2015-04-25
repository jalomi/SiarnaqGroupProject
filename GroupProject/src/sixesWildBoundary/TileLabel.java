package sixesWildBoundary;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import sixesWildEntity.Tile;

public class TileLabel extends JLabel {
	
	public static final String TAG = "TileLabel";
	
	public static final int UNSELECTED = 1;
	public static final int SELECTED = 2;
	public static final int MARKED = 3;
	public static final int MARKED_SELECTED = 4;
	
	Tile model;
	Icon numberImage;
	
	TileLabel(String name, Tile tile) {
		super(name);
		this.model = tile;
		setIconUnselected();
	}
	
	public Tile getModel() {
		return model;
	}
	
	public void setModel(Tile t) {
		this.model = t;
	}
	
	public void refresh() {
		setRightIcon(1); //for now, need change later
	}
	
	public void setRightIcon(int state) {
		if(model.getSquare() == null){
			setIcon(null) ;
			return ;
		}
		
		switch(state) {
			case UNSELECTED:
				setIconUnselected();
				break;
			case SELECTED:
				setIconSelected();
				break;
			case MARKED:
				setIconMarked();
				break;
			case MARKED_SELECTED:
				setIconMarkerSelected();
				break;
		}
	}
	
	public void setIconUnselected() {
		
		if(!model.isEnabled()) {
			return;
		}
		
		int value = model.getSquare().getValue();
		int multi = model.getSquare().getMultiplier();
		
		if(value == 1 && multi == 1) {
			this.setIcon(new ImageIcon(SixesWildGamePanel.class.getResource("/tileIcons/1-1.png")));

		} else if(value == 1 && multi == 2) {
			this.setIcon(new ImageIcon(SixesWildGamePanel.class.getResource("/tileIcons/1-2.png")));
		
		} else if(value == 1 && multi == 3) {
			this.setIcon(new ImageIcon(SixesWildGamePanel.class.getResource("/tileIcons/1-3.png")));
		
		} else if(value == 2 && multi == 1) {
			this.setIcon(new ImageIcon(SixesWildGamePanel.class.getResource("/tileIcons/2-1.png")));
		
		} else if(value == 2 && multi == 2) {
			this.setIcon(new ImageIcon(SixesWildGamePanel.class.getResource("/tileIcons/2-2.png")));
		
		} else if(value == 2 && multi == 3) {
			this.setIcon(new ImageIcon(SixesWildGamePanel.class.getResource("/tileIcons/2-3.png")));
		
		} else if(value == 3 && multi == 1) {
			this.setIcon(new ImageIcon(SixesWildGamePanel.class.getResource("/tileIcons/3-1.png")));
		
		} else if(value == 3 && multi == 2) {
			this.setIcon(new ImageIcon(SixesWildGamePanel.class.getResource("/tileIcons/3-2.png")));
		
		} else if(value == 3 && multi == 3) {
			this.setIcon(new ImageIcon(SixesWildGamePanel.class.getResource("/tileIcons/3-3.png")));
		
		} else if(value == 4 && multi == 1) {
			this.setIcon(new ImageIcon(SixesWildGamePanel.class.getResource("/tileIcons/4-1.png")));
		
		} else if(value == 4 && multi == 2) {
			this.setIcon(new ImageIcon(SixesWildGamePanel.class.getResource("/tileIcons/4-2.png")));
		
		} else if(value == 4 && multi == 3) {
			this.setIcon(new ImageIcon(SixesWildGamePanel.class.getResource("/tileIcons/4-3.png")));
		
		} else if(value == 5 && multi == 1) {
			this.setIcon(new ImageIcon(SixesWildGamePanel.class.getResource("/tileIcons/5-1.png")));
		
		} else if(value == 5 && multi == 2) {
			this.setIcon(new ImageIcon(SixesWildGamePanel.class.getResource("/tileIcons/5-2.png")));
		
		} else if(value == 5 && multi == 3) {
			this.setIcon(new ImageIcon(SixesWildGamePanel.class.getResource("/tileIcons/5-3.png")));
		
		} else if(value == 6) {
			this.setIcon(new ImageIcon(SixesWildGamePanel.class.getResource("/tileIcons/6.png")));
		} 
	}
	
	public void setIconSelected() {
		this.setIcon(null);
	}
	
	public void setIconMarked() {
		
	}
	
	public void setIconMarkerSelected() {
		
	}
}
