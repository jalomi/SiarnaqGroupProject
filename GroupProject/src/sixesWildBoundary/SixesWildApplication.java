package sixesWildBoundary;

import javax.swing.JFrame;

import sixesWildEntity.Board;
import sixesWildEntity.Level;
import sixesWildEntity.SixesWild;


@SuppressWarnings("serial")
public class SixesWildApplication extends JFrame {
	
	public static final String TAG = "SixesWildApplication";

	//Models
	private SixesWild model;
	
	//Boundaries
	private SixesWildLevelPanel levelPane;
	private SixesWildGamePanel gamePane;
	

	/**
	 * Create the frame.
	 */
	public SixesWildApplication(SixesWild game, Level l) {
		setTitle("Sixes Wild");
		initModels(game);
		initBoundaries(l);
		initControllers();
	}
	
	public SixesWildLevelPanel getLevelPanel() {
		return levelPane;
	}
	
	public SixesWildGamePanel getGamePanel() {
		return gamePane;
	}
	
	
	public SixesWild getModel() {
		return model;
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
		model = game;
		model.setBoard(Board.newInstance());
	}
	
	private void initBoundaries(Level l) {
		gamePane = new SixesWildGamePanel(l);
		gamePane.setSize(490, 490);
		gamePane.setLocation(35, 180);
		levelPane = new SixesWildLevelPanel(l);
		levelPane.setLocation(35, 20);
		
		setBounds(5, 5, 580, 750);
		this.setResizable(false);
		getContentPane().setLayout(null);

		getContentPane().add(levelPane);
		getContentPane().add(gamePane);
		this.setVisible(true);
	}
	
	private void initControllers() {
		gamePane.initControllers(this, model);
		levelPane.initControllers(this, model);
	}
}
