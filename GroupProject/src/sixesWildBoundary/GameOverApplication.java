package sixesWildBoundary;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;

public class GameOverApplication extends JFrame {

	JButton btnMainMenu ; 


	
	public GameOverApplication(boolean hasWon) {
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
		getContentPane().add(lblNewLabel);
		

		btnMainMenu = new JButton("Main Menu");
		btnMainMenu.setBounds(120, 127, 89, 23);
		getContentPane().add(btnMainMenu);
	}
	
	public JButton getMainMenuBtn(){
		return btnMainMenu ;
	}
}
