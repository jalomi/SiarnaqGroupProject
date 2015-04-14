package levelBuilderBoundary;

import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class LevelBuilderPreviewGamePanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public LevelBuilderPreviewGamePanel(/*Level level*/) {
		
		this.setSize(490, 490);
		
		//this.level = level;
		
		this.setLayout(new GridLayout(9,9));
		this.setBorder(new EmptyBorder(10,10,10,10));
		
		
		//unused for group phase1		
		//this.level = Level.newInstance(1, 0.2, 0.1, 0.3, .15, 0.1, 0.15);
		//this.board = new Board(level);
		
		//TEMPORARY for group phase1
		JLabel[][] map = new JLabel[9][9] ;
		
		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 9; j++) {
				//TEMPORARY for group phase1
				
				//you may want to use if statement to decide which image to feed
				//int value = map[i][j].getSqaure().getValue();
				//JLabel b = new JLabel("Test");
				//this.add(b);
				
				map[i][j] = new JLabel("") ;
				map[i][j].setIcon(new ImageIcon(LevelBuilderPreviewGamePanel.class.getResource("/tileIcons/1-1.png")));
				this.add(map[i][j]) ;
			}
		}
		this.validate();
		this.setVisible(true);
	}

}
