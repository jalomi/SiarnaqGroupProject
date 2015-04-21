package sixesWildBoundary;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.border.EmptyBorder;

import sixesWildEntity.Board;
import sixesWildEntity.Level;
import sixesWildEntity.Tile;

public class SixesWildGamePanel extends JPanel {

	private Board board;
	JLabel[][] map = new JLabel[9][9] ;
 
	public SixesWildGamePanel(Level l) {
		this.board = new Board(l);//should change board to singleton later
		
		this.setSize(490, 490);
		this.setLayout(new GridLayout(9,9));
		this.setBorder(new EmptyBorder(10,10,10,10));
		
		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 9; j++) {
				this.initLabel(i, j);
			}
		}
		this.validate();
		this.setVisible(true);
	}
	
	private void initLabel(int col, int row) {
		map[col][row] = new JLabel("");

		Tile tile = board.getTile(col, row);
		if(tile.isEnabled() == false) {
			return;
		}
		
		tile.getSquare();
		int value = tile.getSquare().getValue();
		int multi = tile.getSquare().getMultiplier();
		
		if(value == 1 && multi == 1) {
			map[col][row].setIcon(new ImageIcon(SixesWildGamePanel.class.getResource("/tileIcons/1-1.png")));

		} else if(value == 1 && multi == 2) {
			map[col][row].setIcon(new ImageIcon(SixesWildGamePanel.class.getResource("/tileIcons/1-2.png")));
		
		} else if(value == 1 && multi == 3) {
			map[col][row].setIcon(new ImageIcon(SixesWildGamePanel.class.getResource("/tileIcons/1-3.png")));
		
		} else if(value == 2 && multi == 1) {
			map[col][row].setIcon(new ImageIcon(SixesWildGamePanel.class.getResource("/tileIcons/2-1.png")));
		
		} else if(value == 2 && multi == 2) {
			map[col][row].setIcon(new ImageIcon(SixesWildGamePanel.class.getResource("/tileIcons/2-2.png")));
		
		} else if(value == 2 && multi == 3) {
			map[col][row].setIcon(new ImageIcon(SixesWildGamePanel.class.getResource("/tileIcons/2-3.png")));
		
		} else if(value == 3 && multi == 1) {
			map[col][row].setIcon(new ImageIcon(SixesWildGamePanel.class.getResource("/tileIcons/3-1.png")));
		
		} else if(value == 3 && multi == 2) {
			map[col][row].setIcon(new ImageIcon(SixesWildGamePanel.class.getResource("/tileIcons/3-2.png")));
		
		} else if(value == 3 && multi == 3) {
			map[col][row].setIcon(new ImageIcon(SixesWildGamePanel.class.getResource("/tileIcons/3-3.png")));
		
		} else if(value == 4 && multi == 1) {
			map[col][row].setIcon(new ImageIcon(SixesWildGamePanel.class.getResource("/tileIcons/4-1.png")));
		
		} else if(value == 4 && multi == 2) {
			map[col][row].setIcon(new ImageIcon(SixesWildGamePanel.class.getResource("/tileIcons/4-2.png")));
		
		} else if(value == 4 && multi == 3) {
			map[col][row].setIcon(new ImageIcon(SixesWildGamePanel.class.getResource("/tileIcons/4-3.png")));
		
		} else if(value == 5 && multi == 1) {
			map[col][row].setIcon(new ImageIcon(SixesWildGamePanel.class.getResource("/tileIcons/5-1.png")));
		
		} else if(value == 5 && multi == 2) {
			map[col][row].setIcon(new ImageIcon(SixesWildGamePanel.class.getResource("/tileIcons/5-2.png")));
		
		} else if(value == 5 && multi == 3) {
			map[col][row].setIcon(new ImageIcon(SixesWildGamePanel.class.getResource("/tileIcons/5-3.png")));
		
		} else if(value == 6) {
			map[col][row].setIcon(new ImageIcon(SixesWildGamePanel.class.getResource("/tileIcons/6.png")));
		} 
		
		this.add(map[col][row]) ;
	}
}
