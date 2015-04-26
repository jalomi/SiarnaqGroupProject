package levelBuilderBoundary;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;

public class LevelBuilderSavedScreen extends JFrame {
	
	private JButton btnContinue ;
	
	public LevelBuilderSavedScreen() {
		getContentPane().setLayout(null);
		setBounds(300, 200, 350, 200);
		
		JLabel lblLevelSaved = new JLabel("Level Saved!");
		lblLevelSaved.setHorizontalAlignment(SwingConstants.CENTER);
		lblLevelSaved.setFont(new Font("Tahoma", Font.PLAIN, 28));
		lblLevelSaved.setBounds(10, 11, 314, 82);
		getContentPane().add(lblLevelSaved);
		
		btnContinue = new JButton("Continue");
		btnContinue.setBounds(120, 110, 89, 23);
		getContentPane().add(btnContinue);
	}
	
	public JButton getContinueBtn() {
		return btnContinue ;
	}
}
