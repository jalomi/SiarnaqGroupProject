package levelBuilderBoundary;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.JTextArea;

import levelBuilderControllers.SavingLoadingLevelController;
import levelBuilderEntity.LevelBuilder;

/**
 * The panel with all the buttons, textfields, and other input components
 * needed to create a level
 * @author John
 *
 */
@SuppressWarnings("serial")
public class LevelBuilderInputPanel extends JPanel {
	/** text input for the level number */
	private JTextField txtLevelNumber;
	
	/** text input for the number of moves */
	private JTextField txtEnterMaxMoves;
	
	/** text input for the number of seconds */
	private JTextField txtEnterMaxSeconds;
	
	/** text input for the score to get 1 star */
	private JTextField txtEnterScore;
	
	/** text input for the score to get 2 stars */
	private JTextField txtEnterScore_1;
	
	/** text input for the score to get 3 stars */
	private JTextField txtEnterScore_2;
	
	/** text input for the percent for a 1 tile */
	private JTextField txtEnterPercentFor;
	
	/** text input for the percent for a 2 tile */
	private JTextField txtEnterPercentFor_1;
	
	/** text input for the percent for a 3 tile */
	private JTextField txtEnterPercentFor_2;
	
	/** text input for the percent for a 4 tile */
	private JTextField txtEnterPercentFor_3;
	
	/** text input for the percent for a 5 tile */
	private JTextField txtEnterPercentFor_4;
	
	/** text display for the percent for a 6 tile */
	private JTextArea txtEnterPercentFor_5;
	
	/** text input for the percent for a 2x tile */
	private JTextField txtEnterPercentFor_6;
	
	/** text input for the percent for a 3x tile */
	private JTextField txtEnterPercentFor_7;
	
	/** text display for the percent of a 1x tile */
	private JTextArea txtrPercentForx;
	
	/** button to generate and save the level */
	private JButton generateLevelBtn ;
	
	/** button to preview the level */
	private JButton previewBtn ;
	
	/** button to exit the program */
	private JButton exitBtn ;
	
	/** button to undo last move */
	private JButton undoBtn;
	
	/** button to redo last undone move */
	private JButton redoBtn;
	
	/** combo box to choose level type */
	private JComboBox<String> comboBox;
	
	/** check box to set reset move allow */
	private JCheckBox chckbxNewCheckBox;
	
	/** check box to set swap move allow */
	private JCheckBox chckbxNewCheckBox_1;
	
	/** check box to set remove move allow */
	private JCheckBox chckbxNewCheckBox_2;
	
	/** combo box to choose previously made levels */
	JComboBox<String> choosingLevelBox;

	/**
	 * Create the panel.
	 */
	public LevelBuilderInputPanel() {
		setBounds(0, 0, 360, 510);
		setLayout(null);
		
		txtLevelNumber = new JTextField();
		txtLevelNumber.setText("Level Number");
		txtLevelNumber.setBounds(0, 0, 150, 27);
		add(txtLevelNumber);
		txtLevelNumber.setColumns(10);
		txtLevelNumber.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {
				if (txtLevelNumber.getText().equals("Level Number")) {
					txtLevelNumber.setText("");
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				
			}
		});
		
		
		comboBox = new JComboBox<String>();
		comboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"Puzzle", "Lightning", "Elimination", "Release"}));
		comboBox.setBounds(0, 35, 150, 24);
		add(comboBox);
		
		txtEnterMaxMoves = new JTextField();
		txtEnterMaxMoves.setText("Enter Max Moves");
		txtEnterMaxMoves.setBounds(0, 70, 150, 27);
		add(txtEnterMaxMoves);
		txtEnterMaxMoves.setColumns(10);
		txtEnterMaxMoves.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {
				if (txtEnterMaxMoves.getText().equals("Enter Max Moves")) {
					txtEnterMaxMoves.setText("");
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				
			}
		});
		txtEnterMaxSeconds = new JTextField();
		txtEnterMaxSeconds.setText("Enter Max Seconds");
		txtEnterMaxSeconds.setBounds(0, 140, 150, 27);
		add(txtEnterMaxSeconds);
		txtEnterMaxSeconds.setColumns(10);
		txtEnterMaxSeconds.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {
				if (txtEnterMaxSeconds.getText().equals("Enter Max Seconds")) {
					txtEnterMaxSeconds.setText("");
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				
			}
		});
		chckbxNewCheckBox = new JCheckBox("Allow Reset Board");
		chckbxNewCheckBox.setBounds(0, 178, 150, 25);
		add(chckbxNewCheckBox);
		
		chckbxNewCheckBox_1 = new JCheckBox("Allow Swap Tile");
		chckbxNewCheckBox_1.setBounds(0, 212, 150, 25);
		add(chckbxNewCheckBox_1);
		
		chckbxNewCheckBox_2 = new JCheckBox("Allow Remove Tile");
		chckbxNewCheckBox_2.setBounds(0, 246, 150, 25);
		add(chckbxNewCheckBox_2);
		
		txtEnterScore = new JTextField();
		txtEnterScore.setText("Enter 1* Score");
		txtEnterScore.setBounds(0, 292, 150, 27);
		add(txtEnterScore);
		txtEnterScore.setColumns(10);
		txtEnterScore.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {
				if (txtEnterScore.getText().equals("Enter 1* Score")) {
					txtEnterScore.setText("");
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				
			}
		});
		
		txtEnterScore_1 = new JTextField();
		txtEnterScore_1.setText("Enter 2* Score");
		txtEnterScore_1.setBounds(0, 327, 150, 27);
		add(txtEnterScore_1);
		txtEnterScore_1.setColumns(10);
		txtEnterScore_1.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {
				if (txtEnterScore_1.getText().equals("Enter 2* Score")) {
					txtEnterScore_1.setText("");
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				
			}
		});
		
		txtEnterScore_2 = new JTextField();
		txtEnterScore_2.setText("Enter 3* Score");
		txtEnterScore_2.setBounds(0, 362, 150, 27);
		add(txtEnterScore_2);
		txtEnterScore_2.setColumns(10);
		txtEnterScore_2.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {
				if (txtEnterScore_2.getText().equals("Enter 3* Score")) {
					txtEnterScore_2.setText("");
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				
			}
		});
		
		generateLevelBtn = new JButton("Generate Level");
		generateLevelBtn.setBounds(0, 415, 150, 40);
		generateLevelBtn.addActionListener(
				new SavingLoadingLevelController(LevelBuilderApplication.getModel()));
		add(generateLevelBtn);
		
		exitBtn = new JButton("Exit");
		exitBtn.setBounds(0, 470, 150, 40);
		add(exitBtn);
		
		txtEnterPercentFor = new JTextField();
		txtEnterPercentFor.setText("Enter Percent for 1s");
		txtEnterPercentFor.setBounds(210, 0, 150, 27);
		add(txtEnterPercentFor);
		txtEnterPercentFor.setColumns(10);
		txtEnterPercentFor.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {
				if (txtEnterPercentFor.getText().equals("Enter Percent for 1s")) {
					txtEnterPercentFor.setText("");
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				
			}
		});
		
		txtEnterPercentFor_1 = new JTextField();
		txtEnterPercentFor_1.setText("Enter Percent for 2s");
		txtEnterPercentFor_1.setBounds(210, 35, 150, 27);
		add(txtEnterPercentFor_1);
		txtEnterPercentFor_1.setColumns(10);
		txtEnterPercentFor_1.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {
				if (txtEnterPercentFor_1.getText().equals("Enter Percent for 2s")) {
					txtEnterPercentFor_1.setText("");
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				
			}
		});
		
		txtEnterPercentFor_2 = new JTextField();
		txtEnterPercentFor_2.setText("Enter Percent for 3s");
		txtEnterPercentFor_2.setBounds(210, 70, 150, 27);
		add(txtEnterPercentFor_2);
		txtEnterPercentFor_2.setColumns(10);
		txtEnterPercentFor_2.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {
				if (txtEnterPercentFor_2.getText().equals("Enter Percent for 3s")) {
					txtEnterPercentFor_2.setText("");
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				
			}
		});
		
		txtEnterPercentFor_3 = new JTextField();
		txtEnterPercentFor_3.setText("Enter Percent for 4s");
		txtEnterPercentFor_3.setBounds(210, 105, 150, 27);
		add(txtEnterPercentFor_3);
		txtEnterPercentFor_3.setColumns(10);
		txtEnterPercentFor_3.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {
				if (txtEnterPercentFor_3.getText().equals("Enter Percent for 4s")) {
					txtEnterPercentFor_3.setText("");
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				
			}
		});
		
		txtEnterPercentFor_4 = new JTextField();
		txtEnterPercentFor_4.setText("Enter Percent for 5s");
		txtEnterPercentFor_4.setBounds(210, 140, 150, 27);
		add(txtEnterPercentFor_4);
		txtEnterPercentFor_4.setColumns(10);
		txtEnterPercentFor_4.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {
				if (txtEnterPercentFor_4.getText().equals("Enter Percent for 5s")) {
					txtEnterPercentFor_4.setText("");
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				
			}
		});
		
		txtEnterPercentFor_5 = new JTextArea();
		txtEnterPercentFor_5.setText("Percent for 6s");
		txtEnterPercentFor_5.setBounds(210, 175, 150, 27);
		add(txtEnterPercentFor_5);
		txtEnterPercentFor_5.setColumns(10);

		
		txtrPercentForx = new JTextArea();
		txtrPercentForx.setEditable(false);
		txtrPercentForx.setText("Percent for 1x");
		txtrPercentForx.setBounds(210, 257, 150, 27);
		add(txtrPercentForx);
		
		txtEnterPercentFor_6 = new JTextField();
		txtEnterPercentFor_6.setText("Enter Percent for 2x");
		txtEnterPercentFor_6.setBounds(210, 292, 150, 27);
		add(txtEnterPercentFor_6);
		txtEnterPercentFor_6.setColumns(10);
		txtEnterPercentFor_6.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {
				if (txtEnterPercentFor_6.getText().equals("Enter Percent for 2x")) {
					txtEnterPercentFor_6.setText("");
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				
			}
		});
		
		txtEnterPercentFor_7 = new JTextField();
		txtEnterPercentFor_7.setText("Enter Percent for 3x");
		txtEnterPercentFor_7.setBounds(210, 327, 150, 27);
		add(txtEnterPercentFor_7);
		txtEnterPercentFor_7.setColumns(10);
		txtEnterPercentFor_7.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {
				if (txtEnterPercentFor_7.getText().equals("Enter Percent for 3x")) {
					txtEnterPercentFor_7.setText("");
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				
			}
		});
		
		previewBtn = new JButton("Preview");
		previewBtn.setBounds(210, 415, 150, 40);
		add(previewBtn);
		
		undoBtn = new JButton("Undo");
		undoBtn.setBounds(210, 470, 65, 40);
		add(undoBtn);
		
		redoBtn = new JButton("Redo");
		redoBtn.setBounds(295, 470, 65, 40);
		add(redoBtn);
		
		//this view should be dynamically loaded in the run time
		//change later
		DefaultComboBoxModel<String> m = new DefaultComboBoxModel<String>();
		m.addElement("New Level");
		for(String s: LevelBuilder.getLevelList()) {
			m.addElement(s);
		}
		choosingLevelBox = new JComboBox<String>(m);
		choosingLevelBox.setBounds(210, 363, 150, 40);
		add(choosingLevelBox);
	}

	/**
	 * gets the undo button
	 * @return
	 */
	public JButton getUndoBtn(){
		return undoBtn;
	}
	
	/**
	 * gets the redo button
	 * @return
	 */
	public JButton getRedoBtn(){
		return redoBtn;
	}
	
	/**
	 * gets the preview button
	 * @return
	 */
	public JButton getPreviewBtn() {
		return previewBtn;
	}

	/**
	 * gets the exit button
	 * @return
	 */
	public JButton getExitBtn() {
		return exitBtn;
	}
	
	/**
	 * gets the max moves text field
	 * @return
	 */
	public JTextField getMaxMoves(){
		return txtEnterMaxMoves;
	}
	
	/**
	 * gets the 1 star score text field 
	 * @return
	 */
	public JTextField getScore1(){
		return txtEnterScore;
	}

	/**
	 * gets the 2 star score text field
	 * @return
	 */
	public JTextField getScore2() {
		return txtEnterScore_1;
	}

	/**
	 * gets the 3 star score text field
	 * @return
	 */
	public JTextField getScore3() {
		return txtEnterScore_2;
	}

	/**
	 * gets the seconds left text field
	 * @return
	 */
	public JTextField getSeconds() {
		return txtEnterMaxSeconds;
	}

	/**
	 * gets the level number text field
	 * @return
	 */
	public JTextField getLevel() {
		return txtLevelNumber;
	}
	
	/**
	 * gets the generate level button
	 * @return
	 */
	public JButton getGenerateLevelBtn(){
		return generateLevelBtn ;
	}
	
	/**
	 * get the percent for a 1
	 * @return
	 */
	public JTextField getPercent1(){
		return txtEnterPercentFor;
	}
	
	/**
	 * get the percent for a 2
	 * @return
	 */
	public JTextField getPercent2(){
		return txtEnterPercentFor_1;
	}
	
	/**
	 * get the percent for a 3
	 * @return
	 */
	public JTextField getPercent3(){
		return txtEnterPercentFor_2;
	}
	
	/**
	 * get the percent for a 4
	 * @return
	 */
	public JTextField getPercent4(){
		return txtEnterPercentFor_3;
	}
	
	/**
	 * get the percent for a 5
	 * @return
	 */
	public JTextField getPercent5(){
		return txtEnterPercentFor_4;
	}
	
	/** 
	 * get the percent for a 6
	 * @return
	 */
	public JTextArea getPercent6(){
		return txtEnterPercentFor_5;
	}
	
	/**
	 * get percent for a 2x
	 * @return
	 */
	public JTextField getPercentx2(){
		return txtEnterPercentFor_6;
	}
	
	/**
	 * get percent for a 3x
	 * @return
	 */
	public JTextField getPercentx3(){
		return txtEnterPercentFor_7;
	}

	/**
	 * get percent for a 1x
	 * @return
	 */
	public JTextArea getPercentx1() {
		return txtrPercentForx;
	}
	
	/**
	 * get the level type combo box
	 * @return
	 */
	public JComboBox<String> getType(){
		return comboBox;
	}
	
	/**
	 * get the choosing level combo box
	 */
	public JComboBox<String> getChoosingLevel(){
		return choosingLevelBox;
	}
	
	/**
	 * get reset enabled check box
	 * @return
	 */
	public JCheckBox getResetEnabled(){
		return chckbxNewCheckBox;
	}
	
	/**
	 * get swap enabled check box
	 * @return
	 */
	public JCheckBox getSwapEnabled(){
		return chckbxNewCheckBox_1;
	}
	
	/**
	 * get remove enabled check box
	 * @return
	 */
	public JCheckBox getRemoveEnabled(){
		return chckbxNewCheckBox_2;
	}
}
