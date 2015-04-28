package levelBuilderBoundary;

import javax.swing.JPanel;
import javax.swing.JCheckBox;

public class LevelBuilderCheckBoxPanel extends JPanel {
	
	JCheckBox checkBox_0;
	JCheckBox checkBox_1;
	JCheckBox checkBox_2;
	JCheckBox checkBox_3;
	JCheckBox checkBox_4;
	JCheckBox checkBox_5;
	JCheckBox checkBox_6;
	JCheckBox checkBox_7;
	JCheckBox checkBox_8;

	/**
	 * Create the panel.
	 */
	public LevelBuilderCheckBoxPanel() {
		setBounds(0, 0, 460, 21);
		setLayout(null);
		
		checkBox_0 = new JCheckBox("");
		checkBox_0.setBounds(0, 0, 20, 21);
		add(checkBox_0);
		
		checkBox_1 = new JCheckBox("");
		checkBox_1.setBounds(55, 0, 20, 21);
		add(checkBox_1);
		
		checkBox_2 = new JCheckBox("");
		checkBox_2.setBounds(110, 0, 20, 21);
		add(checkBox_2);
		
		checkBox_3 = new JCheckBox("");
		checkBox_3.setBounds(165, 0, 20, 21);
		add(checkBox_3);
		
		checkBox_4 = new JCheckBox("");
		checkBox_4.setBounds(220, 0, 20, 21);
		add(checkBox_4);
		
		checkBox_5 = new JCheckBox("");
		checkBox_5.setBounds(275, 0, 20, 21);
		add(checkBox_5);
		
		checkBox_6 = new JCheckBox("");
		checkBox_6.setBounds(330, 0, 20, 21);
		add(checkBox_6);
		
		checkBox_7 = new JCheckBox("");
		checkBox_7.setBounds(385, 0, 20, 21);
		add(checkBox_7);
		
		checkBox_8 = new JCheckBox("");
		checkBox_8.setBounds(440, 0, 20, 21);
		add(checkBox_8);

	}
	
	public JCheckBox getCheckBox1()
	{
		return checkBox_0;
	}
	
	public JCheckBox getCheckBox2()
	{
		return checkBox_1;
	}
	
	public JCheckBox getCheckBox3()
	{
		return checkBox_2;
	}
	
	public JCheckBox getCheckBox4()
	{
		return checkBox_3;
	}
	
	public JCheckBox getCheckBox5()
	{
		return checkBox_4;
	}
	
	public JCheckBox getCheckBox6()
	{
		return checkBox_5;
	}
	
	public JCheckBox getCheckBox7()
	{
		return checkBox_6;
	}
	
	public JCheckBox getCheckBox8()
	{
		return checkBox_7;
	}
	
	public JCheckBox getCheckBox9()
	{
		return checkBox_8;
	}
}
