package sixesWildBoundary;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import sixesWildEntity.Tile;

/**
 * The boundary for each tile
 * @author Kyle
 * 
 *
 */
@SuppressWarnings("serial")
public class TileLabel extends JLabel {
	/** TAG for the application */
	public static final String TAG = "TileLabel";
	
	/** constant representing an unselected tile */
	public static final int UNSELECTED = 1;
	
	/** constant representing a selected tile */
	public static final int SELECTED = 2;
	
	/** constant representing a marded tile */
	public static final int MARKED = 3;
	
	/** the tile model */
	Tile model;
	
	/** the image for the tile */
	Icon numberImage;
	
	/**
	 * Constructor
	 * @param name
	 * @param tile
	 */
	TileLabel(String name, Tile tile) {
		super(name);
		this.model = tile;
		setIconUnselected();
	}
	
	/**
	 * gets the model
	 * @return Tile
	 */
	public Tile getModel() {
		return model;
	}
	
	/**
	 * set the tile for the TileLabel
	 * @param t
	 */
	public void setModel(Tile t) {
		this.model = t;
	}
	
	/**
	 * refreshes the icon
	 */
	public void refresh() {
		if(model.getMarked()){
			setRightIcon(MARKED) ;
			return ;
		}
		
		setRightIcon(UNSELECTED); //for now, need change later
	}
	
	/**
	 * sets the right icon state
	 * @param state
	 */
	public void setRightIcon(int state) {
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
		}
	}
	
	/**
	 * assignes icon images for unselected tile
	 */
	public void setIconUnselected() {
		if(!model.isEnabled()) {
			this.setIcon(new ImageIcon(SixesWildGamePanel.class.getResource("/tileIcons/disabled.png"))) ;
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
		} else if(value == 7){
			this.setIcon(new ImageIcon(SixesWildGamePanel.class.getResource("/tileIcons/bucket.png"))) ;
		}
	}
	
	/**
	 * assignes tile icon for selected tile
	 */
	public void setIconSelected() {
		if(!model.isEnabled()) {
			this.setIcon(new ImageIcon(SixesWildGamePanel.class.getResource("/tileIcons/disabled-sel.png"))) ;
			return;
		}
		
		int value = model.getSquare().getValue();
		int multi = model.getSquare().getMultiplier();
		
		if(value == 1 && multi == 1) {
			this.setIcon(new ImageIcon(SixesWildGamePanel.class.getResource("/tileIcons/1-1-sel.png")));

		} else if(value == 1 && multi == 2) {
			this.setIcon(new ImageIcon(SixesWildGamePanel.class.getResource("/tileIcons/1-2-sel.png")));
		
		} else if(value == 1 && multi == 3) {
			this.setIcon(new ImageIcon(SixesWildGamePanel.class.getResource("/tileIcons/1-3-sel.png")));
		
		} else if(value == 2 && multi == 1) {
			this.setIcon(new ImageIcon(SixesWildGamePanel.class.getResource("/tileIcons/2-1-sel.png")));
		
		} else if(value == 2 && multi == 2) {
			this.setIcon(new ImageIcon(SixesWildGamePanel.class.getResource("/tileIcons/2-2-sel.png")));
		
		} else if(value == 2 && multi == 3) {
			this.setIcon(new ImageIcon(SixesWildGamePanel.class.getResource("/tileIcons/2-3-sel.png")));
		
		} else if(value == 3 && multi == 1) {
			this.setIcon(new ImageIcon(SixesWildGamePanel.class.getResource("/tileIcons/3-1-sel.png")));
		
		} else if(value == 3 && multi == 2) {
			this.setIcon(new ImageIcon(SixesWildGamePanel.class.getResource("/tileIcons/3-2-sel.png")));
		
		} else if(value == 3 && multi == 3) {
			this.setIcon(new ImageIcon(SixesWildGamePanel.class.getResource("/tileIcons/3-3-sel.png")));
		
		} else if(value == 4 && multi == 1) {
			this.setIcon(new ImageIcon(SixesWildGamePanel.class.getResource("/tileIcons/4-1-sel.png")));
		
		} else if(value == 4 && multi == 2) {
			this.setIcon(new ImageIcon(SixesWildGamePanel.class.getResource("/tileIcons/4-2-sel.png")));
		
		} else if(value == 4 && multi == 3) {
			this.setIcon(new ImageIcon(SixesWildGamePanel.class.getResource("/tileIcons/4-3-sel.png")));
		
		} else if(value == 5 && multi == 1) {
			this.setIcon(new ImageIcon(SixesWildGamePanel.class.getResource("/tileIcons/5-1-sel.png")));
		
		} else if(value == 5 && multi == 2) {
			this.setIcon(new ImageIcon(SixesWildGamePanel.class.getResource("/tileIcons/5-2-sel.png")));
		
		} else if(value == 5 && multi == 3) {
			this.setIcon(new ImageIcon(SixesWildGamePanel.class.getResource("/tileIcons/5-3-sel.png")));
		
		} else if(value == 6) {
			this.setIcon(new ImageIcon(SixesWildGamePanel.class.getResource("/tileIcons/6-sel.png")));
		} 
	}
	
	/**
	 * assigns tile image for marked tile
	 */
	public void setIconMarked() {
		if(!model.isEnabled()) {
			this.setIcon(new ImageIcon(SixesWildGamePanel.class.getResource("/tileIcons/disabled.png"))) ;
			return;
		}
		
		int value = model.getSquare().getValue();
		int multi = model.getSquare().getMultiplier();
		
		if(value == 1 && multi == 1) {
			this.setIcon(new ImageIcon(SixesWildGamePanel.class.getResource("/tileIcons/1-1-mar.png")));

		} else if(value == 1 && multi == 2) {
			this.setIcon(new ImageIcon(SixesWildGamePanel.class.getResource("/tileIcons/1-2-mar.png")));
		
		} else if(value == 1 && multi == 3) {
			this.setIcon(new ImageIcon(SixesWildGamePanel.class.getResource("/tileIcons/1-3-mar.png")));
		
		} else if(value == 2 && multi == 1) {
			this.setIcon(new ImageIcon(SixesWildGamePanel.class.getResource("/tileIcons/2-1-mar.png")));
		
		} else if(value == 2 && multi == 2) {
			this.setIcon(new ImageIcon(SixesWildGamePanel.class.getResource("/tileIcons/2-2-mar.png")));
		
		} else if(value == 2 && multi == 3) {
			this.setIcon(new ImageIcon(SixesWildGamePanel.class.getResource("/tileIcons/2-3-mar.png")));
		
		} else if(value == 3 && multi == 1) {
			this.setIcon(new ImageIcon(SixesWildGamePanel.class.getResource("/tileIcons/3-1-mar.png")));
		
		} else if(value == 3 && multi == 2) {
			this.setIcon(new ImageIcon(SixesWildGamePanel.class.getResource("/tileIcons/3-2-mar.png")));
		
		} else if(value == 3 && multi == 3) {
			this.setIcon(new ImageIcon(SixesWildGamePanel.class.getResource("/tileIcons/3-3-mar.png")));
		
		} else if(value == 4 && multi == 1) {
			this.setIcon(new ImageIcon(SixesWildGamePanel.class.getResource("/tileIcons/4-1-mar.png")));
		
		} else if(value == 4 && multi == 2) {
			this.setIcon(new ImageIcon(SixesWildGamePanel.class.getResource("/tileIcons/4-2-mar.png")));
		
		} else if(value == 4 && multi == 3) {
			this.setIcon(new ImageIcon(SixesWildGamePanel.class.getResource("/tileIcons/4-3-mar.png")));
		
		} else if(value == 5 && multi == 1) {
			this.setIcon(new ImageIcon(SixesWildGamePanel.class.getResource("/tileIcons/5-1-mar.png")));
		
		} else if(value == 5 && multi == 2) {
			this.setIcon(new ImageIcon(SixesWildGamePanel.class.getResource("/tileIcons/5-2-mar.png")));
		
		} else if(value == 5 && multi == 3) {
			this.setIcon(new ImageIcon(SixesWildGamePanel.class.getResource("/tileIcons/5-3-mar.png")));
		
		} else if(value == 6) {
			this.setIcon(new ImageIcon(SixesWildGamePanel.class.getResource("/tileIcons/6-mar.png")));
		} 
	}

}
