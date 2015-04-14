package sixesWildBoundary;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.GridLayout;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;

import sixesWildEntity.Board;
import sixesWildEntity.Level;
import sixesWildEntity.Tile;


@SuppressWarnings("serial")
public class BoardFrame extends JFrame {
	
	public static final String TAG = "BoardFrame";

	private JPanel buttonPane;
	private JPanel boardPane;
	private JPanel infoPane;
	
	private JButton swapButton;
	private JButton removeButton;
	private JButton resetButton;
	private JButton backToMainManuButton;
	private JButton exitButton;
	
	private Board board;
	private Level level;
	
	private JTextField tfLevel;
	private JTextField tfMovesRemaining;
	private JTextField tfTimeRemaining;

	/**
	 * Create the frame.
	 */
	public BoardFrame(Level level) {
		
		this.initializeButtons();
		this.initializeButtonPane();
		this.initializeBoardPane();
		this.initializeInfoPane();
		
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(infoPane, GroupLayout.DEFAULT_SIZE, 676, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(boardPane, GroupLayout.PREFERRED_SIZE, 516, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(buttonPane, GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(infoPane, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(boardPane, GroupLayout.DEFAULT_SIZE, 510, Short.MAX_VALUE)
						.addComponent(buttonPane, GroupLayout.DEFAULT_SIZE, 510, Short.MAX_VALUE))
					.addContainerGap())
		);
		

		

		this.getContentPane().setLayout(groupLayout);
		this.setSize(700, 600);
		//this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	
	private void initializeButtons() {
		swapButton = new JButton("Swap");
		
		removeButton = new JButton("Remove");
		
		resetButton = new JButton("Reset");
		
		backToMainManuButton = new JButton("Main Manu");

		exitButton = new JButton("Exit");
		//exitButton.addActionListener(new ExitGameController(this));
	}
	
	private void initializeButtonPane() {
		buttonPane = new JPanel();
		buttonPane.setBorder(new EmptyBorder(10, 10, 10, 10));
		buttonPane.setLayout(new GridLayout(5,1));
		buttonPane.add(swapButton);
		buttonPane.add(removeButton);
		buttonPane.add(resetButton);
		buttonPane.add(backToMainManuButton);
		buttonPane.add(exitButton);
	}
	
	private void initializeBoardPane() {
		boardPane = new JPanel();
		boardPane.setLayout(new GridLayout(9,9));
		boardPane.setBorder(new EmptyBorder(10,10,10,10));
		
		level = Level.newInstance(1, 0.2, 0.1, 0.3, .15, 0.1, 0.15);
		board = new Board(level);
		
		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 9; j++) {
				/*
				 * Here is the place to add image
				 * 
				 * 
				 */
				Tile[][] map = board.getMap();
				//you may want to use if statement to decide which image to feed
				int value = map[i][j].getSqaure().getValue();
				JLabel b = new JLabel(String.valueOf(value));
				boardPane.add(b);
			}
		}
		boardPane.validate();
		boardPane.setVisible(true);
	}
	
	private void initializeInfoPane() {
		infoPane = new JPanel();
		infoPane.setBorder(new EmptyBorder(10,10,10,10));
		infoPane.setLayout(new GridLayout(1,3));
		
		tfLevel = new JTextField();
		tfLevel.setText("Level Number: ");
		infoPane.add(tfLevel);
		
		tfMovesRemaining = new JTextField();
		tfMovesRemaining.setText("Move: ");
		infoPane.add(tfMovesRemaining);
		
		tfTimeRemaining = new JTextField();
		tfTimeRemaining.setText("Time: ");
		infoPane.add(tfTimeRemaining);
	}
}
