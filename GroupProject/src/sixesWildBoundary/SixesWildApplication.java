package sixesWildBoundary;

import javax.swing.JFrame;

import sixesWildControllers.GamePanelController;
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
	public SixesWildApplication(Level l) {
		setTitle("Sixes Wild");
		initModels();
		initBoundaries(l);
		initControllers();
	}
	
	public SixesWildLevelPanel getLevelPanel() {
		return levelPane;
	}
	
	/**
	 * This method should init including load levels from disk
	 * @author albert
	 * 
	 */
	private void initModels() {
		
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
		GamePanelController c = new GamePanelController(gamePane);
		//gamePane.addMouseListener(c);
		//gamePane.addMouseMotionListener(c);
		gamePane.initControllers(c);
	}
}
