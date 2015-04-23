package sixesWildBoundary;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import sixesWildEntity.Tile;

public class TileLabel extends JLabel {
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
