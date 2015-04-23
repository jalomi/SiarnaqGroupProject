package sixesWildBoundary;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.border.EmptyBorder;

import sixesWildControllers.GamePanelController;
import sixesWildControllers.JLabelController;
import sixesWildEntity.Board;
import sixesWildEntity.Level;
import sixesWildEntity.Tile;

public class SixesWildGamePanel extends JPanel {

	private Board board;
	JLabel[][] map = new JLabel[9][9] ;
	JLabelController controller;
 
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
		controller = new JLabelController(this);
		this.setVisible(true);
	}
	
	void initControllers(GamePanelController c) {
		
		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 9; j++) {
				map[i][j].addMouseListener(controller);
				map[i][j].addMouseMotionListener(controller);
			}
		}
	}
	
	private void initLabel(int col, int row) {
		map[col][row] = new TileLabel("Label-Name", board.getTile(col, row));
		this.add(map[col][row]) ;
	}
}
