package sixesWildBoundary;

import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;

public class Z_SixesWildLevelPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public Z_SixesWildLevelPanel() {
		setBounds(0, 0, 490, 135);
		setLayout(null);
		
		JTextArea txtrLevelNumberHere = new JTextArea();
		txtrLevelNumberHere.setEditable(false);
		txtrLevelNumberHere.setText("Level Number Here");
		txtrLevelNumberHere.setBounds(170, 0, 150, 27);
		add(txtrLevelNumberHere);
		
		JButton btnNewButton = new JButton("Exit Game");
		btnNewButton.setBounds(0, 40, 100, 40);
		add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Delete Tile");
		btnNewButton_1.setBounds(0, 95, 100, 40);
		add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Swap Tiles");
		btnNewButton_2.setBounds(115, 40, 100, 40);
		add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Reset Board");
		btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton_3.setBounds(115, 95, 100, 40);
		add(btnNewButton_3);
		
		JLabel lblNewLabel = new JLabel("Score");
		lblNewLabel.setBounds(245, 40, 35, 21);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Time Left");
		lblNewLabel_1.setBounds(319, 40, 58, 21);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Moves Left");
		lblNewLabel_2.setBounds(408, 40, 66, 21);
		add(lblNewLabel_2);
		
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
		txtrPts_2.setText("3* Pts");
		txtrPts_2.setBounds(396, 108, 62, 27);
		add(txtrPts_2);
		
		JTextArea txtrMoveRem = new JTextArea();
		txtrMoveRem.setText("Move Rem");
		txtrMoveRem.setBounds(408, 68, 80, 25);
		add(txtrMoveRem);
	}
}
