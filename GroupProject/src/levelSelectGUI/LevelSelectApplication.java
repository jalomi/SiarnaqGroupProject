package levelSelectGUI;

import javax.swing.JFrame ;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class LevelSelectApplication extends JFrame {
	public LevelSelectApplication() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 580, 750);
		getContentPane().setLayout(null);
		
		JButton btnMainMenu = new JButton("Main Menu");
		btnMainMenu.setBounds(430, 15, 100, 29);
		getContentPane().add(btnMainMenu);
		
		JButton btnNewButton = new JButton("Level 1");
		btnNewButton.setBounds(35, 55, 100, 100);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Level 2");
		btnNewButton_1.setBounds(165, 55, 100, 100);
		getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Level 3");
		btnNewButton_2.setBounds(295, 55, 100, 100);
		getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Level 4");
		btnNewButton_3.setBounds(430, 55, 100, 100);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		getContentPane().add(btnNewButton_3);
		
		JLabel lblNumstars = new JLabel("NumStars");
		lblNumstars.setBounds(35, 165, 100, 21);
		getContentPane().add(lblNumstars);
		
		JLabel lblNumstars_1 = new JLabel("NumStars");
		lblNumstars_1.setBounds(165, 165, 100, 21);
		getContentPane().add(lblNumstars_1);
		
		JLabel lblNumstars_2 = new JLabel("NumStars");
		lblNumstars_2.setBounds(295, 165, 100, 21);
		getContentPane().add(lblNumstars_2);
		
		JButton btnLevel = new JButton("Level 5");
		btnLevel.setBounds(35, 220, 100, 100);
		getContentPane().add(btnLevel);
		
		JButton btnLevel_1 = new JButton("Level 6");
		btnLevel_1.setBounds(165, 220, 100, 100);
		getContentPane().add(btnLevel_1);
		
		JLabel lblNewLabel = new JLabel("NumStars");
		lblNewLabel.setBounds(430, 165, 100, 21);
		getContentPane().add(lblNewLabel);
		
		JButton btnNewButton_4 = new JButton("Level 7");
		btnNewButton_4.setBounds(295, 220, 100, 100);
		getContentPane().add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("Level 8");
		btnNewButton_5.setBounds(430, 220, 100, 100);
		getContentPane().add(btnNewButton_5);
		
		JLabel lblNewLabel_1 = new JLabel("NumStars");
		lblNewLabel_1.setBounds(35, 330, 100, 21);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("NumStars");
		lblNewLabel_2.setBounds(165, 330, 100, 21);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("NumStars");
		lblNewLabel_3.setBounds(295, 330, 100, 21);
		getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("NumStars");
		lblNewLabel_4.setBounds(430, 330, 100, 21);
		getContentPane().add(lblNewLabel_4);
		
		JButton btnNewButton_6 = new JButton("Level 9");
		btnNewButton_6.setBounds(35, 385, 100, 100);
		getContentPane().add(btnNewButton_6);
		
		JButton btnNewButton_7 = new JButton("Level 10");
		btnNewButton_7.setBounds(165, 385, 100, 100);
		getContentPane().add(btnNewButton_7);
		
		JButton btnNewButton_8 = new JButton("Level 11");
		btnNewButton_8.setBounds(295, 385, 100, 100);
		getContentPane().add(btnNewButton_8);
		
		JButton btnNewButton_9 = new JButton("Level 12");
		btnNewButton_9.setBounds(430, 385, 100, 100);
		getContentPane().add(btnNewButton_9);
		
		JLabel lblNewLabel_5 = new JLabel("NumStars");
		lblNewLabel_5.setBounds(35, 495, 100, 21);
		getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("NumStars");
		lblNewLabel_6.setBounds(165, 495, 100, 21);
		getContentPane().add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("NumStars");
		lblNewLabel_7.setBounds(295, 495, 100, 21);
		getContentPane().add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("NumStars");
		lblNewLabel_8.setBounds(430, 495, 100, 21);
		getContentPane().add(lblNewLabel_8);
		
		JButton btnNewButton_10 = new JButton("Level 13");
		btnNewButton_10.setBounds(35, 550, 100, 100);
		getContentPane().add(btnNewButton_10);
		
		JButton btnNewButton_11 = new JButton("Level 14");
		btnNewButton_11.setBounds(165, 550, 100, 100);
		getContentPane().add(btnNewButton_11);
		
		JButton btnNewButton_12 = new JButton("Level 15");
		btnNewButton_12.setBounds(295, 550, 100, 100);
		getContentPane().add(btnNewButton_12);
		
		JButton btnNewButton_13 = new JButton("Level 16");
		btnNewButton_13.setBounds(430, 550, 100, 100);
		getContentPane().add(btnNewButton_13);
		
		JLabel lblNewLabel_9 = new JLabel("NumStars");
		lblNewLabel_9.setBounds(35, 660, 100, 21);
		getContentPane().add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("NumStars");
		lblNewLabel_10.setBounds(165, 660, 100, 21);
		getContentPane().add(lblNewLabel_10);
		
		JLabel lblNewLabel_11 = new JLabel("NumStars");
		lblNewLabel_11.setBounds(295, 660, 100, 21);
		getContentPane().add(lblNewLabel_11);
		
		JLabel lblNewLabel_12 = new JLabel("NumStars");
		lblNewLabel_12.setBounds(430, 660, 100, 21);
		getContentPane().add(lblNewLabel_12);
		
		JTextArea txtrPleaseSelectLevel = new JTextArea();
		txtrPleaseSelectLevel.setText("Please Select Level");
		txtrPleaseSelectLevel.setBounds(35, 15, 360, 30);
		getContentPane().add(txtrPleaseSelectLevel);
	}
}
