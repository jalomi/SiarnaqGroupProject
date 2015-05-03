package levelBuilderBoundary;

import java.awt.GridLayout;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.json.JSONException;

import levelBuilderEntity.LevelBuilder;

@SuppressWarnings("serial")
public class LevelBuilderPreviewGamePanel extends JPanel {
	
	private LevelBuilder board;
	JLabel[][] map = new JLabel[9][9] ;
	int hasSix;//a counter just for release mode

	/**
	 * Create the panel.
	 * @throws JSONException 
	 * @throws IOException 
	 */
	public LevelBuilderPreviewGamePanel() throws IOException, JSONException {
		this.hasSix = 0;
		this.setSize(490, 490);
		this.setLayout(new GridLayout(9,9));
		this.setBorder(new EmptyBorder(10,10,10,10));
		this.board = LevelBuilder.newInstance();
		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 9; j++) {
				this.initLabel(j, i);
			}
		}
		this.validate();
		this.setVisible(true);
						
	}
	
	private void initLabel(int col, int row) throws IOException, JSONException {
		//Maybe want to change this later
		//make LevelBuilder static
		map[col][row] = new JLabel("");
		System.out.println("tile x: "+col+" y: "+row+" isActivate: "+ board.getTileActiveAt(col, row));
		boolean tile = board.getTileActiveAt(col, row);
		if(tile == false) {
			if(row==hasSix){
				hasSix++;
			}
			this.add(map[col][row]);
			return;
		}
		boolean bucket = board.getBucketEnabled(col);
		if(bucket&&row==8){
			map[col][row].setIcon(new ImageIcon(LevelBuilderPreviewGamePanel.class.getResource("/tileIcons/bucket.png")));
			this.add(map[col][row]);
			return;
		}
		if(bucket&&row==hasSix){
			map[col][row].setIcon(new ImageIcon(LevelBuilderPreviewGamePanel.class.getResource("/tileIcons/6.png")));
			this.add(map[col][row]);
			return;
		}
		int value = randValue();
		int multi = randMultiplier();
		if(bucket){	
			while(value==6){
				value = randValue();
			}
		}
		System.out.println("tile at x:"+col+" y: "+row+" tile isactive:"+tile+" tile value: "+ value+" tile multiplier: "+multi);
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
		//System.out.println("percentM(0): "+board.getPercentM(0)+"percentM(1)"+board.getPercentM(1));
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
		System.out.println("percent(0): "+board.getPercent(0)+" percent(1): "+board.getPercent(1)+" percent(2): "+board.getPercent(2));
		System.out.println("percent(3): "+board.getPercent(3)+" percent(4): "+board.getPercent(4)+" percent(5): "+board.getPercent(5));
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
