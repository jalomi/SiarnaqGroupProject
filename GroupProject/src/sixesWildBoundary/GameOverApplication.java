package sixesWildBoundary;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.UIManager;

/**
 * Frame that displays when a SixesWild level is complete.
 * Will tell user if the level was won or lost.
 * @author Kyle
 *
 */
@SuppressWarnings("serial")
public class GameOverApplication extends JFrame {

	/** Button to return to the main menu */
	JButton btnMainMenu ; 


	/**
	 * Constructor.
	 * Changes message based on result of level (win/loss)
	 * @param hasWon
	 */
	public GameOverApplication(boolean hasWon) {
		getContentPane().setBackground(UIManager.getColor("textHighlight"));
		setTitle("Game Over!");
		getContentPane().setLayout(null);
		setBounds(300, 200, 300, 150);
		
		JLabel lblNewLabel = null ;
		if(hasWon){
			lblNewLabel = new JLabel("You Won!");
		}
		else{ 
			lblNewLabel = new JLabel("You Lost!") ;
		}
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(65, 13, 150, 25);
		lblNewLabel.setBackground(UIManager.getColor("textHighlight"));
		getContentPane().add(lblNewLabel);
		

		btnMainMenu = new JButton("Main Menu");
		btnMainMenu.setBounds(65, 60, 150, 25);
		getContentPane().add(btnMainMenu);
	}
	
	/**
	 * gets The main menu button
	 * @return
	 */
	public JButton getMainMenuBtn(){
		return btnMainMenu ;
	}
}
