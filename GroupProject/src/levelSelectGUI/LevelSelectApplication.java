package levelSelectGUI;

import javax.swing.JFrame ;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class LevelSelectApplication extends JFrame {
	private JTextField txtPleaseSelectLevel;
	public LevelSelectApplication() {
		getContentPane().setLayout(null);
		
		txtPleaseSelectLevel = new JTextField();
		txtPleaseSelectLevel.setText("Please Select Level");
		txtPleaseSelectLevel.setBounds(45, 35, 360, 29);
		getContentPane().add(txtPleaseSelectLevel);
		txtPleaseSelectLevel.setColumns(10);
		
		JButton btnMainMenu = new JButton("Main Menu");
		btnMainMenu.setBounds(440, 35, 100, 29);
		getContentPane().add(btnMainMenu);
		
		JButton btnNewButton = new JButton("Level 1");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(45, 75, 100, 100);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Level 2");
		btnNewButton_1.setBounds(175, 75, 100, 100);
		getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Level 3");
		btnNewButton_2.setBounds(305, 75, 100, 100);
		getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Level 4");
		btnNewButton_3.setBounds(440, 75, 100, 100);
		getContentPane().add(btnNewButton_3);
		
		JLabel lblNumstars = new JLabel("NumStars");
		lblNumstars.setBounds(45, 185, 100, 21);
		getContentPane().add(lblNumstars);
		
		JLabel lblNumstars_1 = new JLabel("NumStars");
		lblNumstars_1.setBounds(175, 185, 100, 21);
		getContentPane().add(lblNumstars_1);
		
		JLabel lblNumstars_2 = new JLabel("NumStars");
		lblNumstars_2.setBounds(305, 185, 100, 21);
		getContentPane().add(lblNumstars_2);
		
		JButton btnLevel = new JButton("Level 5");
		btnLevel.setBounds(46, 287, 100, 100);
		getContentPane().add(btnLevel);
		
		JButton btnLevel_1 = new JButton("Level 6");
		btnLevel_1.setBounds(218, 242, 100, 100);
		getContentPane().add(btnLevel_1);
	}
}
