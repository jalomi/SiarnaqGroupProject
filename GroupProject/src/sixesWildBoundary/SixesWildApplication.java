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
	public SixesWildApplication() {
		setTitle("Sixes Wild");
		initModels();
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
	private void initModels() {
		model = new SixesWild();
		model.setBoard(Board.newInstance(new Level(1)));
	}
	
	private void initBoundaries() {
		gamePane = new SixesWildGamePanel(model.getBoard().getLevel());
		gamePane.setSize(490, 490);
		gamePane.setLocation(35, 180);
		levelPane = new SixesWildLevelPanel(model.getBoard().getLevel());
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
	}
}
