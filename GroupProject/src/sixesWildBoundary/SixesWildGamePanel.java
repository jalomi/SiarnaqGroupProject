package sixesWildBoundary;

import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import sixesWildControllers.TileLabelController;
import sixesWildEntity.Board;
import sixesWildEntity.SixesWild;

import javax.swing.UIManager;

/**
 * Panel that houses the game board for Sixes Wild
 * @author John
 *
 */
@SuppressWarnings("serial")
public class SixesWildGamePanel extends JPanel {
	/** TAG for the application */
	public static final String TAG = "SixesWildGamePanel";

	/** the game board entity */
	private Board board;
	
	/** the tile boundaries to be shown in the panel */
	TileLabel[][] map = new TileLabel[9][9] ;
	
	/** the controller for tileLabels */
	TileLabelController controller;
 
	/**
	 * Constructor
	 */
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
	}
	
	/**
	 * initialize all controllers for the game panel
	 * @param app
	 * @param model
	 */
	void initControllers(SixesWildApplication app, SixesWild model) {
		controller = new TileLabelController(app, model);
		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 9; j++) {
				map[i][j].addMouseListener(controller);
				map[i][j].addMouseMotionListener(controller);
			}
		}
	}
	
	/**
	 * initialize all of the label boundaries for the tiles
	 * @param col
	 * @param row
	 */
	private void initLabel(int col, int row) {
		map[col][row] = new TileLabel("", board.getTile(col, row));
		this.add(map[col][row]) ;
	}
	
	/**
	 * refresh the boundaries
	 */
	public void refreshBoard() {
		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 9; j++) {
				map[i][j].refresh();
			}
		}
	}
}
