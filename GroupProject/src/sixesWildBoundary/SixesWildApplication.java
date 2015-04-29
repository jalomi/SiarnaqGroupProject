package sixesWildBoundary;

import javax.swing.JFrame;

import sixesWildControllers.GameOverToMainMenuController;
import sixesWildEntity.Board;
import sixesWildEntity.LTimer;
import sixesWildEntity.Lightning;
import sixesWildEntity.SixesWild;

import java.util.TimerTask;

import javax.swing.UIManager;


@SuppressWarnings("serial")
public class SixesWildApplication extends JFrame {
	
	public static final String TAG = "SixesWildApplication";
	
	private SixesWildApplication app ;
	
	//Boundaries
	private SixesWildLevelPanel levelPane;
	private SixesWildGamePanel gamePane;
	
	//Models
	private SixesWild theGame;
	
	/**
	 * Create the frame.
	 */
	public SixesWildApplication(SixesWild game) {
		getContentPane().setBackground(UIManager.getColor("textHighlight"));
		setTitle("Sixes Wild");
		initModels(game);
		initBoundaries();
		initControllers();
		
		app = this ;
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
		theGame.getLevel().updateScore(score) ;
	}
	
	public void updateMovesLeft(int i) {
		theGame.getLevel().updateMovesLeft(i) ;
	}
	
	
	/**
	 * This method should init including load levels from disk
	 * @author albert
	 * 
	 */
	private void initModels(SixesWild game) {
		theGame = game;
		theGame.setBoard(Board.newInstance());
		
		if(theGame.getBoard().getLevel() instanceof Lightning){
			LTimer t = LTimer.getInstance();
						
			TimerTask task = new TimerTask() {
				
				@Override
				public void run() {
					theGame.getBoard().getLevel().updateTimeLeft(-1) ;
					
					int val = Integer.valueOf(levelPane.getTextTime().getText());
					val -= 1;
					
					if(val <= 0){
						if(theGame.getBoard().getLevel().gameOver()){
							//close the frame and show level complete screen
							theGame.updateScores() ;
							GameOverApplication completeScreen = new GameOverApplication(theGame.getBoard().getLevel().getStarNumber() != 0);
							if(theGame.getBoard().getLevel().getStarNumber() > 0){
								if(theGame.getLevels().size() > theGame.getBoard().getLevel().getLevelNumber()){
									theGame.getLevels().get(theGame.getBoard().getLevel().getLevelNumber()).setUnlocked(true) ;
								}
							}
							int lastScore = theGame.getHighScore(theGame.getBoard().getLevel().getLevelNumber() - 1) ;
							int thisScore = theGame.getBoard().getLevel().getScore() ;
							if(thisScore > lastScore){
								//update the high score
								theGame.setHighScore(theGame.getBoard().getLevel().getLevelNumber(), thisScore) ;
							}
							completeScreen.setVisible(true);
							completeScreen.getMainMenuBtn().addActionListener(new GameOverToMainMenuController(completeScreen, app)) ;
						}
					}
					
					levelPane.getTextTime().setText("" + val);
					System.out.println("TIMER: " + val) ;
				}
				
			};
			
			t.schedule(task, 1000);
		}
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
