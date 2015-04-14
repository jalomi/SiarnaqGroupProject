package mainMenuGUI;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.Color;

public class SplashScreen extends JFrame{
	int duration;
	
	public SplashScreen() {
		setTitle("SplashScreen");
		
		JTextArea txtrTeamSiarnaqPresents = new JTextArea();
		txtrTeamSiarnaqPresents.setBackground(Color.WHITE);
		txtrTeamSiarnaqPresents.setEditable(false);
		txtrTeamSiarnaqPresents.setText("Team Siarnaq Presents");
		
		JTextArea txtrSixIsWild = new JTextArea();
		txtrSixIsWild.setText("Sixes Wild ");
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(198)
					.addComponent(txtrTeamSiarnaqPresents, GroupLayout.PREFERRED_SIZE, 156, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(96, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(238, Short.MAX_VALUE)
					.addComponent(txtrSixIsWild, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
					.addGap(132))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(96)
					.addComponent(txtrTeamSiarnaqPresents, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
					.addGap(55)
					.addComponent(txtrSixIsWild, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(77, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);
	}
}
