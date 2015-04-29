package sixesWildControllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import sixesWildBoundary.MainMenuApplication;
import sixesWildBoundary.SixesWildApplication;

public class GameOverToMainMenuController implements ActionListener{
	public static final String TAG = "GameOverToMainMenuController" ;
	
	JFrame current ;
	SixesWildApplication game ;
	
	public GameOverToMainMenuController(JFrame c, SixesWildApplication g){
		this.current = c ;
		this.game = g ;
	}	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println(TAG) ;
		
		current.setVisible(false) ;
		game.setVisible(false) ;
		MainMenuApplication main = new MainMenuApplication() ;
		main.setVisible(true) ;
		current.dispose() ;
		game. dispose() ;
	}
	
}
