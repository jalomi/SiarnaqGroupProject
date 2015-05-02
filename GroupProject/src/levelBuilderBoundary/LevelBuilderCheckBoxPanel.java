package levelBuilderBoundary;

import javax.swing.JPanel;
import javax.swing.JCheckBox;

public class LevelBuilderCheckBoxPanel extends JPanel {
	
	JCheckBox[] checkBox=new JCheckBox[9];

	/**
	 * Create the panel.
	 */
	public LevelBuilderCheckBoxPanel() {
		setBounds(0, 0, 460, 21);
		setLayout(null);
		
		checkBox[0] = new JCheckBox("");
		checkBox[0].setBounds(0, 0, 20, 21);
		add(checkBox[0]);
		
		checkBox[1] = new JCheckBox("");
		checkBox[1].setBounds(55, 0, 20, 21);
		add(checkBox[1]);
		
		checkBox[2] = new JCheckBox("");
		checkBox[2].setBounds(110, 0, 20, 21);
		add(checkBox[2]);
		
		checkBox[3]= new JCheckBox("");
		checkBox[3].setBounds(165, 0, 20, 21);
		add(checkBox[3]);
		
		checkBox[4] = new JCheckBox("");
		checkBox[4].setBounds(220, 0, 20, 21);
		add(checkBox[4]);
		
		checkBox[5] = new JCheckBox("");
		checkBox[5].setBounds(275, 0, 20, 21);
		add(checkBox[5]);
		
		checkBox[6] = new JCheckBox("");
		checkBox[6].setBounds(330, 0, 20, 21);
		add(checkBox[6]);
		
		checkBox[7] = new JCheckBox("");
		checkBox[7].setBounds(385, 0, 20, 21);
		add(checkBox[7]);
		
		checkBox[8] = new JCheckBox("");
		checkBox[8].setBounds(440, 0, 20, 21);
		add(checkBox[8]);

	}
	
	public JCheckBox getCheckBox(int i)
	{
		return checkBox[i];
	}
	
}
