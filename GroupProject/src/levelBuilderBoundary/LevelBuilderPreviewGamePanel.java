package levelBuilderBoundary;

import java.awt.GridLayout;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.json.JSONException;

import levelBuilderEntity.LevelBuilder;

public class LevelBuilderPreviewGamePanel extends JPanel {
	
	private LevelBuilder board;
	JLabel[][] map = new JLabel[9][9] ;

	/**
	 * Create the panel.
	 * @throws JSONException 
	 * @throws IOException 
	 */
	public LevelBuilderPreviewGamePanel() throws IOException, JSONException {
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
	
	private void initLabel(int col, int row) throws IOException, JSONException {
		//Maybe want to change this later
		//make LevelBuilder static
		board = new LevelBuilder() ;
		map[col][row] = new JLabel("");
		
		boolean tile = board.getTileActiveAt(col, row);
		if(tile == false) {
			return;
		}
		
		int value = randValue();
		int multi = randMultiplier();
		
		if(value == 1 && multi == 1) {
			map[col][row].setIcon(new ImageIcon(LevelBuilderPreviewGamePanel.class.getResource("/tileIcons/1-1.png")));

		} else if(value == 1 && multi == 2) {
			map[col][row].setIcon(new ImageIcon(LevelBuilderPreviewGamePanel.class.getResource("/tileIcons/1-2.png")));
		
		} else if(value == 1 && multi == 3) {
			map[col][row].setIcon(new ImageIcon(LevelBuilderPreviewGamePanel.class.getResource("/tileIcons/1-3.png")));
		
		} else if(value == 2 && multi == 1) {
			map[col][row].setIcon(new ImageIcon(LevelBuilderPreviewGamePanel.class.getResource("/tileIcons/2-1.png")));
		
		} else if(value == 2 && multi == 2) {
			map[col][row].setIcon(new ImageIcon(LevelBuilderPreviewGamePanel.class.getResource("/tileIcons/2-2.png")));
		
		} else if(value == 2 && multi == 3) {
			map[col][row].setIcon(new ImageIcon(LevelBuilderPreviewGamePanel.class.getResource("/tileIcons/2-3.png")));
		
		} else if(value == 3 && multi == 1) {
			map[col][row].setIcon(new ImageIcon(LevelBuilderPreviewGamePanel.class.getResource("/tileIcons/3-1.png")));
		
		} else if(value == 3 && multi == 2) {
			map[col][row].setIcon(new ImageIcon(LevelBuilderPreviewGamePanel.class.getResource("/tileIcons/3-2.png")));
		
		} else if(value == 3 && multi == 3) {
			map[col][row].setIcon(new ImageIcon(LevelBuilderPreviewGamePanel.class.getResource("/tileIcons/3-3.png")));
		
		} else if(value == 4 && multi == 1) {
			map[col][row].setIcon(new ImageIcon(LevelBuilderPreviewGamePanel.class.getResource("/tileIcons/4-1.png")));
		
		} else if(value == 4 && multi == 2) {
			map[col][row].setIcon(new ImageIcon(LevelBuilderPreviewGamePanel.class.getResource("/tileIcons/4-2.png")));
		
		} else if(value == 4 && multi == 3) {
			map[col][row].setIcon(new ImageIcon(LevelBuilderPreviewGamePanel.class.getResource("/tileIcons/4-3.png")));
		
		} else if(value == 5 && multi == 1) {
			map[col][row].setIcon(new ImageIcon(LevelBuilderPreviewGamePanel.class.getResource("/tileIcons/5-1.png")));
		
		} else if(value == 5 && multi == 2) {
			map[col][row].setIcon(new ImageIcon(LevelBuilderPreviewGamePanel.class.getResource("/tileIcons/5-2.png")));
		
		} else if(value == 5 && multi == 3) {
			map[col][row].setIcon(new ImageIcon(LevelBuilderPreviewGamePanel.class.getResource("/tileIcons/5-3.png")));
		
		} else if(value == 6) {
			map[col][row].setIcon(new ImageIcon(LevelBuilderPreviewGamePanel.class.getResource("/tileIcons/6.png")));
		} 
		
		this.add(map[col][row]) ;
	}

	private int randMultiplier() {
		double random = Math.random() ;
		if(random <= board.getPercentM(0)) {
			return 1;
		} else if(random <= board.getPercentM(0) + board.getPercentM(1)) {
			return 2;
		} else {
			return 3;
		}	
	}

	private int randValue() {
		double random = Math.random();
		if(random <= board.getPercent(0)) {
			return 1;
		} else if(random <= board.getPercent(0) + board.getPercent(1)) {
			return 2;
		} else if(random <= board.getPercent(0) + board.getPercent(1) + board.getPercent(2)) {
			return 3;
		} else if(random <= board.getPercent(0) + board.getPercent(1) + board.getPercent(2) + board.getPercent(3)) {
			return 4;
		} else if(random <= board.getPercent(0) + board.getPercent(1) + board.getPercent(2) + board.getPercent(3) + board.getPercent(4)) {
			return 5;
		} else {
			return 6;
		}
	}

}
