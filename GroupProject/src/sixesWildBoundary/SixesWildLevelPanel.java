package sixesWildBoundary;

import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JButton;

import java.awt.Font;

import javax.swing.JLabel;

import sixesWildControllers.BacktoMainMenuController;
import sixesWildEntity.Level;
import sixesWildEntity.SixesWild;

public class SixesWildLevelPanel extends JPanel {
	private JButton backToMainManuButton;
	public JButton getBackToMainManuButton() {
		return backToMainManuButton;
	}

	public void setBackToMainManuButton(JButton backToMainManuButton) {
		this.backToMainManuButton = backToMainManuButton;
	}

	public Level getLevel() {
		return level;
	}

	public void setLevel(Level level) {
		this.level = level;
	}

	private Level level;
	
	/**
	 * Create the panel.
	 */
	public SixesWildLevelPanel(Level l) {
		level = l;
		
		setBounds(0, 0, 490, 135);
		setLayout(null);
		
		JTextArea txtrLevelNumberHere = new JTextArea();
		txtrLevelNumberHere.setEditable(false);
		txtrLevelNumberHere.setText("Level Number Here");
		txtrLevelNumberHere.setBounds(170, 0, 150, 27);
		add(txtrLevelNumberHere);
		
		backToMainManuButton = new JButton("Main Menu");
		backToMainManuButton.setBounds(0, 40, 100, 40);
		add(backToMainManuButton);
		
		JButton deleteSquareButton = new JButton("Delete Squares");
		deleteSquareButton.setBounds(0, 95, 100, 40);
		add(deleteSquareButton);
		
		JButton swapSquareButton = new JButton("Swap Squares");
		swapSquareButton.setBounds(115, 40, 100, 40);
		add(swapSquareButton);
		
		JButton resetBoardButton = new JButton("Reset Board");
		resetBoardButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		resetBoardButton.setBounds(115, 95, 100, 40);
		add(resetBoardButton);
		
		JLabel scoreLabel = new JLabel("Score");
		scoreLabel.setBounds(245, 40, 35, 21);
		add(scoreLabel);
		
		JLabel timeLeftLabel = new JLabel("Time Left");
		timeLeftLabel.setBounds(319, 40, 58, 21);
		add(timeLeftLabel);
		
		JLabel moveLeftLabel = new JLabel("Moves Left");
		timeLeftLabel.setBounds(408, 40, 66, 21);
		add(timeLeftLabel);
		
		JTextArea txtrScore = new JTextArea();
		txtrScore.setEditable(false);
		txtrScore.setText("Score");
		txtrScore.setBounds(245, 68, 57, 27);
		add(txtrScore);
		
		JTextArea txtrPts = new JTextArea();
		txtrPts.setEditable(false);
		txtrPts.setText("1* Pts");
		txtrPts.setBounds(245, 108, 60, 27);
		add(txtrPts);
		
		JTextArea txtrTime = new JTextArea();
		txtrTime.setEditable(false);
		txtrTime.setText("Time Rem");
		txtrTime.setBounds(319, 68, 72, 27);
		add(txtrTime);
		
		JTextArea txtrPts_1 = new JTextArea();
		txtrPts_1.setEditable(false);
		txtrPts_1.setText("2* Pts");
		txtrPts_1.setBounds(319, 108, 63, 27);
		add(txtrPts_1);
		
		JTextArea txtrPts_2 = new JTextArea();
		txtrPts_2.setEditable(false);
		txtrPts_2.setText("3* Pts");
		txtrPts_2.setBounds(396, 108, 62, 27);
		add(txtrPts_2);
		
		JTextArea txtrMoveRem = new JTextArea();
		txtrMoveRem.setEditable(false);
		txtrMoveRem.setText("Move Rem");
		txtrMoveRem.setBounds(408, 68, 80, 25);
		add(txtrMoveRem);
	}
	
	public void initControllers(SixesWildApplication app, SixesWild theGame) {
		this.backToMainManuButton.addActionListener(new BacktoMainMenuController(app));
	}
}
