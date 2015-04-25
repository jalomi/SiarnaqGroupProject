package sixesWildBoundary;

import javax.swing.JFrame;

import sixesWildEntity.Board;
import sixesWildEntity.Level;
import sixesWildEntity.SixesWild;


@SuppressWarnings("serial")
public class SixesWildApplication extends JFrame {
	
	public static final String TAG = "SixesWildApplication";
	
	//Boundaries
	private SixesWildLevelPanel levelPane;
	private SixesWildGamePanel gamePane;
	
	//Models
	private SixesWild theGame;
	
	/**
	 * Create the frame.
	 */
	public SixesWildApplication(SixesWild game) {
		setTitle("Sixes Wild");
		initModels(game);
		initBoundaries();
		initControllers();
	}
	
	public SixesWildLevelPanel getLevelPanel() {
		return levelPane;
	}
	
	public SixesWildGamePanel getGamePanel() {
		return gamePane;
	}
	
	
	public SixesWild getModel() {
		return theGame;
	}
	
	public void updateScore(int score) {
		//we should have some function like this one
		//SixesWild.updateScore(score);
	}
	
	/**
	 * This method should init including load levels from disk
	 * @author albert
	 * 
	 */
	private void initModels(SixesWild game) {
		theGame = game;
		theGame.setBoard(Board.newInstance());
	}
	
	private void initBoundaries() {
		gamePane = new SixesWildGamePanel();
		gamePane.setSize(490, 490);
		gamePane.setLocation(35, 180);
		levelPane = new SixesWildLevelPanel();
		levelPane.setLocation(35, 20);
		
		setBounds(5, 5, 580, 750);
		this.setResizable(false);
		getContentPane().setLayout(null);

		getContentPane().add(levelPane);
		getContentPane().add(gamePane);
		this.setVisible(true);
	}
	
	private void initControllers() {
		gamePane.initControllers(this, theGame);
		levelPane.initControllers(this, theGame);
	}
}
