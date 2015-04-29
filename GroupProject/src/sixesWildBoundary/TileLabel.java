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
		if(model.getMarked()){
			setRightIcon(MARKED) ;
			return ;
		}
		
		setRightIcon(UNSELECTED); //for now, need change later
	}
	
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
		} 
	}
	
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
