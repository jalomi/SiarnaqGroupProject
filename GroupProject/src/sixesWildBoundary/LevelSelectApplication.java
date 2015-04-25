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
	private JLabel[] numberOfStar = new JLabel[16];
	
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
		
//		numberOfStar[0] = new JLabel("NumStars");
//		numberOfStar[0].setBounds(35, 165, 100, 21);
//		getContentPane().add(numberOfStar[0]);
//		
//		numberOfStar[1] = new JLabel("NumStars");
//		numberOfStar[1].setBounds(165, 165, 100, 21);
//		getContentPane().add(numberOfStar[1]);
//		
//		numberOfStar[2] = new JLabel("NumStars");
//		numberOfStar[2].setBounds(295, 165, 100, 21);
//		getContentPane().add(numberOfStar[2]);
		
//		JLabel lblNumstars4 = new JLabel("NumStars");
//		lblNumstars4.setBounds(430, 165, 100, 21);
//		getContentPane().add(lblNumstars4);
		
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
		
//		JLabel lblNumstars5 = new JLabel("NumStars");
//		lblNumstars5.setBounds(35, 330, 100, 21);
//		getContentPane().add(lblNumstars5);
		
//		JLabel lblNumstars6 = new JLabel("NumStars");
//		lblNumstars6.setBounds(165, 330, 100, 21);
//		getContentPane().add(lblNumstars6);
//		
//		JLabel lblNumstars7 = new JLabel("NumStars");
//		lblNumstars7.setBounds(295, 330, 100, 21);
//		getContentPane().add(lblNumstars7);
//		
//		JLabel lblNumstars8 = new JLabel("NumStars");
//		lblNumstars8.setBounds(430, 330, 100, 21);
//		getContentPane().add(lblNumstars8);
		
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
		
//		JLabel lblNumstars9 = new JLabel("NumStars");
//		lblNumstars9.setBounds(35, 495, 100, 21);
//		getContentPane().add(lblNumstars9);
//		
//		JLabel lblNumstars10 = new JLabel("NumStars");
//		lblNumstars10.setBounds(165, 495, 100, 21);
//		getContentPane().add(lblNumstars10);
//		
//		JLabel lblNumstars11 = new JLabel("NumStars");
//		lblNumstars11.setBounds(295, 495, 100, 21);
//		getContentPane().add(lblNumstars11);
//		
//		JLabel lblNumstars12 = new JLabel("NumStars");
//		lblNumstars12.setBounds(430, 495, 100, 21);
//		getContentPane().add(lblNumstars12);
		
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
		
//		JLabel lblNumstars13 = new JLabel("NumStars");
//		lblNumstars13.setBounds(35, 660, 100, 21);
//		getContentPane().add(lblNumstars13);
//		
//		JLabel lblNumstars14 = new JLabel("NumStars");
//		lblNumstars14.setBounds(165, 660, 100, 21);
//		getContentPane().add(lblNumstars14);
//		
//		JLabel lblNumstars15 = new JLabel("NumStars");
//		lblNumstars15.setBounds(295, 660, 100, 21);
//		getContentPane().add(lblNumstars15);
//		
//		JLabel lblNumstars16 = new JLabel("NumStars");
//		lblNumstars16.setBounds(430, 660, 100, 21);
//		getContentPane().add(lblNumstars16);
		
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
