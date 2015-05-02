package sixesWildBoundary;

import javax.swing.JFrame;

import sixesWildControllers.GameOverToMainMenuController;
import sixesWildEntity.Board;
import sixesWildEntity.LTimer;
import sixesWildEntity.Lightning;
import sixesWildEntity.SixesWild;

import java.util.TimerTask;

import javax.swing.UIManager;

/**
 * The Sixes Wild game
 * This is the frame that holds the actual game
 * @author John
 *
 */
@SuppressWarnings("serial")
public class SixesWildApplication extends JFrame {
	/** TAG for the application */
	public static final String TAG = "SixesWildApplication";
	
	/** Sixes wild app used for the timer in Lightning */
	private SixesWildApplication app ;
	
	/** panel that holds level info and buttons */
	private SixesWildLevelPanel levelPane;
	
	/** panel that holds the game board */
	private SixesWildGamePanel gamePane;
	
	/** the Sixes Wild model */
	private SixesWild theGame;
	
	/**
	 * Constructor
	 * Creates the application based on the model
	 * @param game
	 */
	public SixesWildApplication(SixesWild game) {
		getContentPane().setBackground(UIManager.getColor("textHighlight"));
		setTitle("Sixes Wild");
		initModels(game);
		initBoundaries();
		initControllers();
		
		app = this ;
	}
	
	/**
	 * gets the level panel
	 * @return
	 */
	public SixesWildLevelPanel getLevelPanel() {
		return levelPane;
	}
	
	/**
	 * gets the game panel
	 * @return
	 */
	public SixesWildGamePanel getGamePanel() {
		return gamePane;
	}
	
	/**
	 * gets the model
	 * @return
	 */
	public SixesWild getModel() {
		return theGame;
	}
	
	/**
	 * updates the score of the game
	 * @param score
	 */
	public void updateScore(int score) {
		//we should have some function like this one
		//SixesWild.updateScore(score);
		//old //theGame.getLevel().updateScore(score) ;
		int currentScore = theGame.getBoard().getCurrentScore();
		theGame.getBoard().setCurrentScore(currentScore + score);
	}
	
	/**
	 * updates the moves left of the game
	 * @param i
	 */
	public void updateMovesLeft(int i) {
		//old theGame.getLevel().updateMovesLeft(i) ;
		int currentMoves = theGame.getBoard().getCurrentMoves();
		if(theGame.getBoard().getLevel() instanceof Lightning) {
		} else {
			theGame.getBoard().setCurrentMoves(currentMoves + i);
		}
	}
	
	
	/**
	 * initializes the models of the game
	 * @param game
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
							GameOverApplication completeScreen = new GameOverApplication(theGame.getBoard().getLevel().hasWon());
							if(theGame.getBoard().getLevel().hasWon()){
								if(theGame.getLevels().size() > theGame.getBoard().getLevel().getLevelNumber()){
									theGame.getLevels().get(theGame.getBoard().getLevel().getLevelNumber()).setUnlocked(true) ;
								}
							} 
							//old //int lastScore = theGame.getHighScore(theGame.getBoard().getLevel().getLevelNumber() - 1) ;
							int lastScore = theGame.getBoard().getLevel().getHighestScore();
							//old //int thisScore = theGame.getBoard().getLevel().getScore() ;
							int thisScore = theGame.getBoard().getCurrentScore();
							if(thisScore > lastScore){
								//update the high score
								//theGame.setHighScore(theGame.getBoard().getLevel().getLevelNumber(), thisScore) ;
								theGame.getBoard().getLevel().setHighestScore(thisScore);
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
	
	/**
	 * initializes the panels of the game
	 */
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
	
	/**
	 * initializes the controllers of the game
	 */
	private void initControllers() {
		gamePane.initControllers(this, theGame);
		levelPane.initControllers(this, theGame);
	}

		
}
