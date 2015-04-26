package sixesWildBoundary;

import javax.swing.JFrame ;
import javax.swing.JButton;

import javax.swing.JLabel;
import javax.swing.JTextArea;

import sixesWildControllers.BacktoMainMenuController;
import sixesWildControllers.ChooseLevelController;
import sixesWildEntity.SixesWild;

public class LevelSelectApplication extends JFrame {

	private JButton backToMainManuButton;
	private JButton[] levelButton = new JButton[16];
	private JLabel[] numStars = new JLabel[16];
	
	private SixesWild theGame;
	
	public LevelSelectApplication(SixesWild theGame) {
		
		System.out.println("LevelSelectApplication contructor");
		
		this.theGame = theGame;
		
		setResizable(false);
		setTitle("Level Select");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(5, 5, 580, 750);
		getContentPane().setLayout(null);
		
		backToMainManuButton = new JButton("Main Menu");
		backToMainManuButton.setBounds(430, 15, 100, 29);
		getContentPane().add(backToMainManuButton);
		
		//1 - 4
		levelButton[0] = new JButton("Puzzle 1");
		levelButton[0].setBounds(35, 55, 100, 100);
		getContentPane().add(levelButton[0]);
		
		levelButton[1] = new JButton("Lightning 1");
		levelButton[1].setBounds(165, 55, 100, 100);
		getContentPane().add(levelButton[1]);
		
		levelButton[2] = new JButton("Elim. 1");
		levelButton[2].setBounds(295, 55, 100, 100);
		getContentPane().add(levelButton[2]);
		
		levelButton[3] = new JButton("Release 1");
		levelButton[3].setBounds(430, 55, 100, 100);
		getContentPane().add(levelButton[3]);
		
		numStars[0] = new JLabel("0 Stars");
		numStars[0].setBounds(35, 165, 100, 21);
		getContentPane().add(numStars[0]);
		
		numStars[1] = new JLabel("0 Stars");
		numStars[1].setBounds(165, 165, 100, 21);
		getContentPane().add(numStars[1]);
		
		numStars[2] = new JLabel("0 Stars");
		numStars[2].setBounds(295, 165, 100, 21);
		getContentPane().add(numStars[2]);
		
		numStars[3] = new JLabel("0 Stars");
		numStars[3].setBounds(430, 165, 100, 21);
		getContentPane().add(numStars[3]);
		
		//5 - 8
		levelButton[4] = new JButton("Puzzle 2");
		levelButton[4].setBounds(35, 220, 100, 100);
		getContentPane().add(levelButton[4]);
		
		levelButton[5] = new JButton("Lightning 2");
		levelButton[5].setBounds(165, 220, 100, 100);
		getContentPane().add(levelButton[5]);
		
		levelButton[6] = new JButton("Elim. 2");
		levelButton[6].setBounds(295, 220, 100, 100);
		getContentPane().add(levelButton[6]);
		
		levelButton[7] = new JButton("Release 2");
		levelButton[7].setBounds(430, 220, 100, 100);
		getContentPane().add(levelButton[7]);
		
		numStars[4] = new JLabel("0 Stars");
		numStars[4].setBounds(35, 330, 100, 21);
		getContentPane().add(numStars[4]);
		
		numStars[5] = new JLabel("0 Stars");
		numStars[5].setBounds(165, 330, 100, 21);
		getContentPane().add(numStars[5]);
		
		numStars[6] = new JLabel("0 Stars");
		numStars[6].setBounds(295, 330, 100, 21);
		getContentPane().add(numStars[6]);
		
		numStars[7] = new JLabel("0 Stars");
		numStars[7].setBounds(430, 330, 100, 21);
		getContentPane().add(numStars[7]);
		
		levelButton[8] = new JButton("Puzzle 3");
		levelButton[8].setBounds(35, 385, 100, 100);
		getContentPane().add(levelButton[8]);
		
		levelButton[9] = new JButton("Lightning 3");
		levelButton[9].setBounds(165, 385, 100, 100);
		getContentPane().add(levelButton[9]);
		
		levelButton[10] = new JButton("Elim. 3");
		levelButton[10].setBounds(295, 385, 100, 100);
		getContentPane().add(levelButton[10]);
		
		levelButton[11] = new JButton("Release 3");
		levelButton[11].setBounds(430, 385, 100, 100);
		getContentPane().add(levelButton[11]);
		
		numStars[8] = new JLabel("0 Stars");
		numStars[8].setBounds(35, 495, 100, 21);
		getContentPane().add(numStars[8]);
		
		numStars[9] = new JLabel("0 Stars");
		numStars[9].setBounds(165, 495, 100, 21);
		getContentPane().add(numStars[9]);
		
		numStars[10] = new JLabel("0 Stars");
		numStars[10].setBounds(295, 495, 100, 21);
		getContentPane().add(numStars[10]);
		
		numStars[11] = new JLabel("0 Stars");
		numStars[11].setBounds(430, 495, 100, 21);
		getContentPane().add(numStars[11]);
		
		levelButton[12] = new JButton("Puzzle 4");
		levelButton[12].setBounds(35, 550, 100, 100);
		getContentPane().add(levelButton[12]);
		
		levelButton[13] = new JButton("Lightning 4");
		levelButton[13].setBounds(165, 550, 100, 100);
		getContentPane().add(levelButton[13]);
		
		levelButton[14] = new JButton("Elim. 4");
		levelButton[14].setBounds(295, 550, 100, 100);
		getContentPane().add(levelButton[14]);
		
		levelButton[15] = new JButton("Release 4");
		levelButton[15].setBounds(430, 550, 100, 100);
		getContentPane().add(levelButton[15]);
		
		numStars[12] = new JLabel("0 Stars");
		numStars[12].setBounds(35, 660, 100, 21);
		getContentPane().add(numStars[12]);
		
		numStars[13] = new JLabel("0 Stars");
		numStars[13].setBounds(165, 660, 100, 21);
		getContentPane().add(numStars[13]);
		
		numStars[14] = new JLabel("0 Stars");
		numStars[14].setBounds(295, 660, 100, 21);
		getContentPane().add(numStars[14]);
		
		numStars[15] = new JLabel("0 Stars");
		numStars[15].setBounds(430, 660, 100, 21);
		getContentPane().add(numStars[15]);
		
		JTextArea txtrPleaseSelectLevel = new JTextArea();
		txtrPleaseSelectLevel.setEditable(false);
		txtrPleaseSelectLevel.setText("Please Select Level");
		txtrPleaseSelectLevel.setBounds(35, 15, 360, 30);
		
		initControllers(theGame);
		
		
		getContentPane().add(txtrPleaseSelectLevel);
	}
	
	public void initControllers(SixesWild theGame) {
		backToMainManuButton.addActionListener(new BacktoMainMenuController(this));
		
		for(int i = 0; i < 16; i++) {
			levelButton[i].addActionListener(new ChooseLevelController(this, theGame, i));
		}
	}
}
