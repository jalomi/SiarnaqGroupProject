package levelBuilderBoundary;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.text.JTextComponent;

import levelBuilderEntity.LevelBuilder;


public class LevelBuilderInputPanel extends JPanel {
	private JTextField txtLevelNumber;
	private JTextField txtEnterMaxMoves;
	private JTextField txtEnterMaxMinutes;
	private JTextField txtEnterMaxSeconds;
	private JTextField txtEnterScore;
	private JTextField txtEnterScore_1;
	private JTextField txtEnterScore_2;
	private JTextField txtEnterPercentFor;
	private JTextField txtEnterPercentFor_1;
	private JTextField txtEnterPercentFor_2;
	private JTextField txtEnterPercentFor_3;
	private JTextField txtEnterPercentFor_4;
	private JTextField txtEnterPercentFor_5;
	private JTextField txtEnterPercentFor_6;
	private JTextField txtEnterPercentFor_7;
	private JButton previewBtn ;
	private JButton exitBtn ;

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
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Puzzle", "Lightning", "Elimination", "Release"}));
		comboBox.setBounds(0, 35, 150, 24);
		add(comboBox);
		
		txtEnterMaxMoves = new JTextField();
		txtEnterMaxMoves.setText("Enter Max Moves");
		txtEnterMaxMoves.setBounds(0, 70, 150, 27);
		add(txtEnterMaxMoves);
		txtEnterMaxMoves.setColumns(10);
		
		txtEnterMaxMinutes = new JTextField();
		txtEnterMaxMinutes.setText("Enter Max Minutes");
		txtEnterMaxMinutes.setBounds(0, 105, 150, 27);
		add(txtEnterMaxMinutes);
		txtEnterMaxMinutes.setColumns(10);
		
		txtEnterMaxSeconds = new JTextField();
		txtEnterMaxSeconds.setText("Enter Max Seconds");
		txtEnterMaxSeconds.setBounds(0, 140, 150, 27);
		add(txtEnterMaxSeconds);
		txtEnterMaxSeconds.setColumns(10);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Allow Reset Board");
		chckbxNewCheckBox.setBounds(0, 178, 150, 25);
		add(chckbxNewCheckBox);
		
		JCheckBox chckbxNewCheckBox_1 = new JCheckBox("Allow Swap Tile");
		chckbxNewCheckBox_1.setBounds(0, 212, 150, 25);
		add(chckbxNewCheckBox_1);
		
		JCheckBox chckbxNewCheckBox_2 = new JCheckBox("Allow Remove Tile");
		chckbxNewCheckBox_2.setBounds(0, 246, 150, 25);
		add(chckbxNewCheckBox_2);
		
		txtEnterScore = new JTextField();
		txtEnterScore.setText("Enter 1* Score");
		txtEnterScore.setBounds(0, 292, 150, 27);
		add(txtEnterScore);
		txtEnterScore.setColumns(10);
		
		txtEnterScore_1 = new JTextField();
		txtEnterScore_1.setText("Enter 2* Score");
		txtEnterScore_1.setBounds(0, 327, 150, 27);
		add(txtEnterScore_1);
		txtEnterScore_1.setColumns(10);
		
		txtEnterScore_2 = new JTextField();
		txtEnterScore_2.setText("Enter 3* Score");
		txtEnterScore_2.setBounds(0, 362, 150, 27);
		add(txtEnterScore_2);
		txtEnterScore_2.setColumns(10);
		
		JButton btnNewButton = new JButton("Generate Level");
		btnNewButton.setBounds(0, 415, 150, 40);
		add(btnNewButton);
		
		exitBtn = new JButton("Exit");
		exitBtn.setBounds(0, 470, 150, 40);
		add(exitBtn);
		
		txtEnterPercentFor = new JTextField();
		txtEnterPercentFor.setText("Enter Percent for 1s");
		txtEnterPercentFor.setBounds(210, 0, 150, 27);
		add(txtEnterPercentFor);
		txtEnterPercentFor.setColumns(10);
		
		txtEnterPercentFor_1 = new JTextField();
		txtEnterPercentFor_1.setText("Enter Percent for 2s");
		txtEnterPercentFor_1.setBounds(210, 35, 150, 27);
		add(txtEnterPercentFor_1);
		txtEnterPercentFor_1.setColumns(10);
		
		txtEnterPercentFor_2 = new JTextField();
		txtEnterPercentFor_2.setText("Enter Percent for 3s");
		txtEnterPercentFor_2.setBounds(210, 70, 150, 27);
		add(txtEnterPercentFor_2);
		txtEnterPercentFor_2.setColumns(10);
		
		txtEnterPercentFor_3 = new JTextField();
		txtEnterPercentFor_3.setText("Enter Percent for 4s");
		txtEnterPercentFor_3.setBounds(210, 105, 150, 27);
		add(txtEnterPercentFor_3);
		txtEnterPercentFor_3.setColumns(10);
		
		txtEnterPercentFor_4 = new JTextField();
		txtEnterPercentFor_4.setText("Enter Percent for 5s");
		txtEnterPercentFor_4.setBounds(210, 140, 150, 27);
		add(txtEnterPercentFor_4);
		txtEnterPercentFor_4.setColumns(10);
		
		txtEnterPercentFor_5 = new JTextField();
		txtEnterPercentFor_5.setText("Enter Percent for 6s");
		txtEnterPercentFor_5.setBounds(210, 175, 150, 27);
		add(txtEnterPercentFor_5);
		txtEnterPercentFor_5.setColumns(10);
		
		JTextArea txtrTotalPercent = new JTextArea();
		txtrTotalPercent.setText("Total Percent");
		txtrTotalPercent.setEditable(false);
		txtrTotalPercent.setBounds(210, 210, 150, 27);
		add(txtrTotalPercent);
		
		JTextArea txtrPercentForx = new JTextArea();
		txtrPercentForx.setEditable(false);
		txtrPercentForx.setText("Percent for 1x");
		txtrPercentForx.setBounds(210, 257, 150, 27);
		add(txtrPercentForx);
		
		txtEnterPercentFor_6 = new JTextField();
		txtEnterPercentFor_6.setText("Enter Percent for 2x");
		txtEnterPercentFor_6.setBounds(210, 292, 150, 27);
		add(txtEnterPercentFor_6);
		txtEnterPercentFor_6.setColumns(10);
		
		txtEnterPercentFor_7 = new JTextField();
		txtEnterPercentFor_7.setText("Enter Percent for 3x");
		txtEnterPercentFor_7.setBounds(210, 327, 150, 27);
		add(txtEnterPercentFor_7);
		txtEnterPercentFor_7.setColumns(10);
		
		previewBtn = new JButton("Preview");
		previewBtn.setBounds(210, 415, 150, 40);
		add(previewBtn);
		
		JButton btnNewButton_3 = new JButton("Undo");
		btnNewButton_3.setBounds(210, 470, 65, 40);
		add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Redo");
		btnNewButton_4.setBounds(295, 470, 65, 40);
		add(btnNewButton_4);
		
		JButton btnNewButton_1 = new JButton("Edit Level");
		btnNewButton_1.setBounds(210, 363, 150, 40);
		add(btnNewButton_1);
	}

	public JButton getPreviewBtn() {
		return previewBtn;
	}

	public JButton getExitBtn() {
		return exitBtn;
	}
	
	public JTextField getMaxMoves()
	{
		return txtEnterMaxMoves;
	}
	
	public JTextField getScore1()
	{
		return txtEnterScore;
	}

	public JTextField getScore2() {
		// TODO Auto-generated method stub
		return txtEnterScore_1;
	}

	public JTextField getScore3() {
		// TODO Auto-generated method stub
		return txtEnterScore_2;
	}
	
	public JTextField getMinutes(){
		return txtEnterMaxMinutes;
	}

	public JTextField getSeconds() {
		// TODO Auto-generated method stub
		return txtEnterMaxSeconds;
	}

	public JTextField getLevel() {
		// TODO Auto-generated method stub
		return txtLevelNumber;
	}
}
