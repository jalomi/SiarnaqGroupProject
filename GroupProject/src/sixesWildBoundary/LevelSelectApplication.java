package sixesWildBoundary;

import javax.swing.JFrame ;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextPane;

public class LevelSelectApplication extends JFrame {
	public LevelSelectApplication() {
		setTitle("Level Select");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 580, 750);
		getContentPane().setLayout(null);
		
		JButton btnMainMenu = new JButton("Main Menu");
		btnMainMenu.setBounds(430, 15, 100, 29);
		getContentPane().add(btnMainMenu);
		
		JButton levelBottun1 = new JButton("Level 1");
		levelBottun1.setBounds(35, 55, 100, 100);
		levelBottun1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		getContentPane().add(levelBottun1);
		
		JButton levelButton2 = new JButton("Level 2");
		levelButton2.setBounds(165, 55, 100, 100);
		getContentPane().add(levelButton2);
		
		JButton levelBottum3 = new JButton("Level 3");
		levelBottum3.setBounds(295, 55, 100, 100);
		getContentPane().add(levelBottum3);
		
		JButton levelButton4 = new JButton("Level 4");
		levelButton4.setBounds(430, 55, 100, 100);
		levelButton4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		getContentPane().add(levelButton4);
		
		JLabel lblNumstars1 = new JLabel("NumStars");
		lblNumstars1.setBounds(35, 165, 100, 21);
		getContentPane().add(lblNumstars1);
		
		JLabel lblNumstars2 = new JLabel("NumStars");
		lblNumstars2.setBounds(165, 165, 100, 21);
		getContentPane().add(lblNumstars2);
		
		JLabel lblNumstars3 = new JLabel("NumStars");
		lblNumstars3.setBounds(295, 165, 100, 21);
		getContentPane().add(lblNumstars3);
		
		JButton levelButton5 = new JButton("Level 5");
		levelButton5.setBounds(35, 220, 100, 100);
		getContentPane().add(levelButton5);
		
		JButton levelButton6 = new JButton("Level 6");
		levelButton6.setBounds(165, 220, 100, 100);
		getContentPane().add(levelButton6);
		
		JLabel lblNumstars4 = new JLabel("NumStars");
		lblNumstars4.setBounds(430, 165, 100, 21);
		getContentPane().add(lblNumstars4);
		
		JButton levelButton7 = new JButton("Level 7");
		levelButton7.setBounds(295, 220, 100, 100);
		getContentPane().add(levelButton7);
		
		JButton levelButton8 = new JButton("Level 8");
		levelButton8.setBounds(430, 220, 100, 100);
		getContentPane().add(levelButton8);
		
		JLabel lblNumstars5 = new JLabel("NumStars");
		lblNumstars5.setBounds(35, 330, 100, 21);
		getContentPane().add(lblNumstars5);
		
		JLabel lblNumstars6 = new JLabel("NumStars");
		lblNumstars6.setBounds(165, 330, 100, 21);
		getContentPane().add(lblNumstars6);
		
		JLabel lblNumstars7 = new JLabel("NumStars");
		lblNumstars7.setBounds(295, 330, 100, 21);
		getContentPane().add(lblNumstars7);
		
		JLabel lblNumstars8 = new JLabel("NumStars");
		lblNumstars8.setBounds(430, 330, 100, 21);
		getContentPane().add(lblNumstars8);
		
		JButton levelButton9 = new JButton("Level 9");
		levelButton9.setBounds(35, 385, 100, 100);
		getContentPane().add(levelButton9);
		
		JButton levelButton10 = new JButton("Level 10");
		levelButton10.setBounds(165, 385, 100, 100);
		getContentPane().add(levelButton10);
		
		JButton levelButton11 = new JButton("Level 11");
		levelButton11.setBounds(295, 385, 100, 100);
		getContentPane().add(levelButton11);
		
		JButton levelButton12 = new JButton("Level 12");
		levelButton12.setBounds(430, 385, 100, 100);
		getContentPane().add(levelButton12);
		
		JLabel lblNumstars9 = new JLabel("NumStars");
		lblNumstars9.setBounds(35, 495, 100, 21);
		getContentPane().add(lblNumstars9);
		
		JLabel lblNumstars10 = new JLabel("NumStars");
		lblNumstars10.setBounds(165, 495, 100, 21);
		getContentPane().add(lblNumstars10);
		
		JLabel lblNumstars11 = new JLabel("NumStars");
		lblNumstars11.setBounds(295, 495, 100, 21);
		getContentPane().add(lblNumstars11);
		
		JLabel lblNumstars12 = new JLabel("NumStars");
		lblNumstars12.setBounds(430, 495, 100, 21);
		getContentPane().add(lblNumstars12);
		
		JButton levelButton13 = new JButton("Level 13");
		levelButton13.setBounds(35, 550, 100, 100);
		getContentPane().add(levelButton13);
		
		JButton Levelbutton14 = new JButton("Level 14");
		Levelbutton14.setBounds(165, 550, 100, 100);
		getContentPane().add(Levelbutton14);
		
		JButton levelButton15 = new JButton("Level 15");
		levelButton15.setBounds(295, 550, 100, 100);
		getContentPane().add(levelButton15);
		
		JButton levelButton16 = new JButton("Level 16");
		levelButton16.setBounds(430, 550, 100, 100);
		getContentPane().add(levelButton16);
		
		JLabel lblNumstars13 = new JLabel("NumStars");
		lblNumstars13.setBounds(35, 660, 100, 21);
		getContentPane().add(lblNumstars13);
		
		JLabel lblNumstars14 = new JLabel("NumStars");
		lblNumstars14.setBounds(165, 660, 100, 21);
		getContentPane().add(lblNumstars14);
		
		JLabel lblNumstars15 = new JLabel("NumStars");
		lblNumstars15.setBounds(295, 660, 100, 21);
		getContentPane().add(lblNumstars15);
		
		JLabel lblNumstars16 = new JLabel("NumStars");
		lblNumstars16.setBounds(430, 660, 100, 21);
		getContentPane().add(lblNumstars16);
		
		JTextArea txtrPleaseSelectLevel = new JTextArea();
		txtrPleaseSelectLevel.setEditable(false);
		txtrPleaseSelectLevel.setText("Please Select Level");
		txtrPleaseSelectLevel.setBounds(35, 15, 360, 30);
		getContentPane().add(txtrPleaseSelectLevel);
	}
}
