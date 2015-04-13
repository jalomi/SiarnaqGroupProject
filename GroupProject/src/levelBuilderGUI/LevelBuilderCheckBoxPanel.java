package levelBuilderGUI;

import javax.swing.JPanel;
import javax.swing.JCheckBox;

public class LevelBuilderCheckBoxPanel extends JPanel {
	
	JCheckBox boxes[] ;

	/**
	 * Create the panel.
	 */
	public LevelBuilderCheckBoxPanel() {
		setBounds(0, 0, 460, 21);
		setLayout(null);
		
		JCheckBox checkBox_0 = new JCheckBox("");
		checkBox_0.setBounds(0, 0, 20, 21);
		add(checkBox_0);
		
		JCheckBox checkBox_1 = new JCheckBox("");
		checkBox_1.setBounds(55, 0, 20, 21);
		add(checkBox_1);
		
		JCheckBox checkBox_2 = new JCheckBox("");
		checkBox_2.setBounds(110, 0, 20, 21);
		add(checkBox_2);
		
		JCheckBox checkBox_3 = new JCheckBox("");
		checkBox_3.setBounds(165, 0, 20, 21);
		add(checkBox_3);
		
		JCheckBox checkBox_4 = new JCheckBox("");
		checkBox_4.setBounds(220, 0, 20, 21);
		add(checkBox_4);
		
		JCheckBox checkBox_5 = new JCheckBox("");
		checkBox_5.setBounds(275, 0, 20, 21);
		add(checkBox_5);
		
		JCheckBox checkBox_6 = new JCheckBox("");
		checkBox_6.setBounds(330, 0, 20, 21);
		add(checkBox_6);
		
		JCheckBox checkBox_7 = new JCheckBox("");
		checkBox_7.setBounds(385, 0, 20, 21);
		add(checkBox_7);
		
		JCheckBox checkBox_8 = new JCheckBox("");
		checkBox_8.setBounds(440, 0, 20, 21);
		add(checkBox_8);

	}
}
