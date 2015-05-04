package levelBuilderBoundary;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.SwingConstants;
import javax.swing.JButton;

/**
 * Tells the user that the level has been saved
 * @author John <- Why you on here brah? I literally wrote this whole thing in a few minutes lol
 * @author Kyle 
 *
 */
@SuppressWarnings("serial")
public class LevelBuilderSavedScreen extends JFrame {
	/** button to go back to the level builder */
	private JButton btnContinue ;
	
	/**
	 * Constructor
	 */
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
	
	/**
	 * gets the return to level builder button
	 * @return
	 */
	public JButton getContinueBtn() {
		return btnContinue ;
	}
}
