package sixesWildGUI;

import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.Font;

public class SixesWildLevelPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public SixesWildLevelPanel() {
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
	}

}
