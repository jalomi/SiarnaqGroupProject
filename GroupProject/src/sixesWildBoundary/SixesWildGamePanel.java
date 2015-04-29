package sixesWildBoundary;

import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import sixesWildControllers.TileLabelController;
import sixesWildEntity.Board;
import sixesWildEntity.SixesWild;
import javax.swing.UIManager;

public class SixesWildGamePanel extends JPanel {
	
	public static final String TAG = "SixesWildGamePanel";

	private Board board;
	TileLabel[][] map = new TileLabel[9][9] ;
	TileLabelController controller;
 
	public SixesWildGamePanel() {
		setBackground(UIManager.getColor("textHighlight"));
		
		
		this.board = Board.newInstance();
		
		this.setSize(490, 490);
		this.setLayout(new GridLayout(9,9));
		this.setBorder(new EmptyBorder(10,10,10,10));
		
		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 9; j++) {
				this.initLabel(j, i);
			}
		}
		this.validate();
		
		this.setVisible(true);
		
//		System.out.println("gamePane 0 0	" + map[0][0].getModel().getSquare().getValue());
//		System.out.println("gamePane 0 1	" + map[0][1].getModel().getSquare().getValue());
//		System.out.println("First: (0,0):  " + board.getSquare(0,0).getValue() + 
//				"   (0,1): " + board.getSquare(0,1).getValue()) ;

	}
	
	void initControllers(SixesWildApplication app, SixesWild model) {
		controller = new TileLabelController(app, model);
		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 9; j++) {
				map[i][j].addMouseListener(controller);
				map[i][j].addMouseMotionListener(controller);
			}
		}
	}
	
	private void initLabel(int col, int row) {
		map[col][row] = new TileLabel("", board.getTile(col, row));
		this.add(map[col][row]) ;
	}
	
	public void refreshBoard() {
		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 9; j++) {
				map[i][j].refresh();
			}
		}
	}
}
