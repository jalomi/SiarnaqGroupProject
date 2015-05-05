package sixesWildBoundary;

import java.util.ArrayList;

import javax.swing.JFrame ;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextArea;

import sixesWildControllers.BacktoMainMenuController;
import sixesWildControllers.ChooseLevelController;
import sixesWildEntity.Level;
import sixesWildEntity.SixesWild;

import javax.swing.UIManager;

import java.awt.Font;

/**
 * Frame that lets users select what level they want to play
 * Will show high score of each level and the stars earned
 * @author John
 * @author Kyle
 *
 */
@SuppressWarnings("serial")
public class LevelSelectApplication extends JFrame {
	
	/** button to return to main menu */
	private JButton backToMainManuButton;
	
	/** list of buttons to select levels */
	private ArrayList<JButton> levelButtons = new ArrayList<JButton>();
	
	/** list of star vales earned for each level */
	private ArrayList<JLabel> numStars = new ArrayList<JLabel>();
	
	/** list of high scores for each level */
	private ArrayList<JLabel> scores = new ArrayList<JLabel>();
	
	/** the SixesWild model */
	private SixesWild theGame;
	
	/**
	 * Constructor
	 */
	public LevelSelectApplication() {
		getContentPane().setBackground(UIManager.getColor("textHighlight"));
		
		System.out.println("LevelSelectApplication contructor");
		
		this.theGame = SixesWild.newInstance();
		
		setResizable(false);
		setTitle("Level Select");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(5, 5, 580, 750);
		getContentPane().setLayout(null);
		
		backToMainManuButton = new JButton("Main Menu");
		backToMainManuButton.setBounds(430, 15, 100, 29);
		getContentPane().add(backToMainManuButton);
		
		int size = theGame.getLevels().size();
		for(int i = 0; i < size; i++) {
			Level l = theGame.getLevels().get(i);
			String levelName = l.getLevelType() + " " + l.getLevelNumber();
			JButton b = new JButton(levelName);
			b.setFont(new Font("Tahoma", Font.PLAIN, 11));
			b.setBounds(35 + (i%4)*130, 55 + (i/4)*160, 100, 100);
			levelButtons.add(b);
			getContentPane().add(b);
			
			String starUnlocked;
			if(l.getUnlocked()) {
				starUnlocked = "      " + l.getStarNumber() + " Star";
			} else {
				starUnlocked = "      Locked";
			}
			JLabel label = new JLabel(starUnlocked);
			JLabel highestScore = new JLabel("    Highest: " + l.getHighestScore());
			label.setBounds(35 + (i%4)*130, 165 + (i/4)*160, 100, 21);
			highestScore.setBounds(35 + (i%4)*130, 185 + (i/4)*160, 100, 21);
			numStars.add(label);
			scores.add(highestScore);
			getContentPane().add(label);
			getContentPane().add(highestScore);	
		}	
		
		JTextArea txtrPleaseSelectLevel = new JTextArea();
		txtrPleaseSelectLevel.setFont(new Font("Monospaced", Font.BOLD, 17));
		txtrPleaseSelectLevel.setBackground(UIManager.getColor("textHighlight"));
		txtrPleaseSelectLevel.setEditable(false);
		txtrPleaseSelectLevel.setText("Please Select Level");
		txtrPleaseSelectLevel.setBounds(35, 15, 360, 30);
		
		initControllers(theGame);
		
		
		getContentPane().add(txtrPleaseSelectLevel);
	}
	
	/**
	 * Initializes all controllers for the buttons on the screen
	 * @param theGame
	 */
	public void initControllers(SixesWild theGame) {
		backToMainManuButton.addActionListener(new BacktoMainMenuController(this));
		
		for(int i = 0; i < theGame.getLevels().size(); i++) {
			levelButtons.get(i).addActionListener(new ChooseLevelController(this, theGame, i));
		}
	}
}
