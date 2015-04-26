package sixesWildBoundary;

import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JButton;

import java.awt.Font;

import javax.swing.JLabel;

import sixesWildControllers.BacktoMainMenuController;
import sixesWildEntity.Board;
import sixesWildEntity.Level;
import sixesWildEntity.SixesWild;

public class SixesWildLevelPanel extends JPanel {
	public static final String TAG = "SixesWildLevelPanel";
	
	/* Boundaries */
	JButton backToMainManuButton;
	JButton deleteSquareButton;
	JButton swapSquareButton;
	JButton resetBoardButton;
	
	JTextArea textScore;
	JTextArea text1stStarScore;
	JTextArea text2ndStarScore;
	JTextArea text3rdStarScore;
	
	JTextArea textTime;
	JTextArea textMoveRem;
	
	/* Entities */
	private Level level;
	
	/**
	 * SixesWildLevelPanel should always be created after SixesWildGamePanel,
	 * because it uses GamePane's (Board board) to set its (Level level).
	 */
	public SixesWildLevelPanel() {
		level = Board.newInstance().getLevel();
		if(level == null) {
			System.err.println(TAG + " current board has null level inside! Error!");
		}
		
		setBounds(0, 0, 490, 135);
		setLayout(null);
		
		initBoundaries();
	}
	
	public void initBoundaries() {
		JTextArea txtrLevelNumberHere = new JTextArea();
		txtrLevelNumberHere.setEditable(false);
		txtrLevelNumberHere.setText("Level Number Here");
		txtrLevelNumberHere.setBounds(170, 0, 150, 27);
		add(txtrLevelNumberHere);
		
		backToMainManuButton = new JButton("Main Menu");
		backToMainManuButton.setBounds(0, 40, 100, 40);
		add(backToMainManuButton);
		
		deleteSquareButton = new JButton("Delete Squares");
		deleteSquareButton.setBounds(0, 95, 100, 40);
		add(deleteSquareButton);
		
		swapSquareButton = new JButton("Swap Squares");
		swapSquareButton.setBounds(115, 40, 100, 40);
		add(swapSquareButton);
		
		resetBoardButton = new JButton("Reset Board");
		resetBoardButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		resetBoardButton.setBounds(115, 95, 100, 40);
		add(resetBoardButton);
		
		JLabel scoreLabel = new JLabel("0");
		scoreLabel.setBounds(245, 40, 50, 21);
		add(scoreLabel);
		
		JLabel timeLeftLabel = new JLabel("Time Left");
		timeLeftLabel.setBounds(319, 40, 80, 21);
		add(timeLeftLabel);
		
		JLabel moveLeftLabel = new JLabel("Moves Left");
		moveLeftLabel.setBounds(408, 40, 80, 21);
		add(moveLeftLabel);
		
		textScore = new JTextArea();
		textScore.setEditable(false);
		textScore.setText("Score");
		textScore.setBounds(245, 68, 57, 27);
		add(textScore);
		
		text1stStarScore = new JTextArea();
		text1stStarScore.setEditable(false);
		text1stStarScore.setText(String.valueOf(level.getFirstStarScore()));
		text1stStarScore.setBounds(245, 108, 60, 27);
		add(text1stStarScore);
		
		text2ndStarScore = new JTextArea();
		text2ndStarScore.setEditable(false);
		text2ndStarScore.setText(String.valueOf(level.getSecondStarScore()));
		text2ndStarScore.setBounds(319, 108, 63, 27);
		add(text2ndStarScore);
		
		text3rdStarScore = new JTextArea();
		text3rdStarScore.setEditable(false);
		text3rdStarScore.setText(String.valueOf(level.getThirdStarScore()));
		text3rdStarScore.setBounds(396, 108, 62, 27);
		add(text3rdStarScore);
		
		textTime = new JTextArea();
		textTime.setEditable(false);
		textTime.setText(level.getTimeRemainingString());
		textTime.setBounds(319, 68, 72, 27);
		add(textTime);
		
		textMoveRem = new JTextArea();
		textMoveRem.setEditable(false);
		textMoveRem.setText(level.getMovesRemainingString());
		textMoveRem.setBounds(408, 68, 80, 25);
		add(textMoveRem);
	}
	
	public void initControllers(SixesWildApplication app, SixesWild theGame) {
		this.backToMainManuButton.addActionListener(new BacktoMainMenuController(app));
	}
	
	public void refresh() {
		textScore.setText(Integer.toString(level.getScore())) ;
		textTime.setText(level.getTimeRemainingString()) ;
		textMoveRem.setText(level.getMovesRemainingString()) ;		
	}
	
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
}
