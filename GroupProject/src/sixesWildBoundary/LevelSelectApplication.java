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

public class LevelSelectApplication extends JFrame {

	private JButton backToMainManuButton;
	private JButton[] levelButton = new JButton[16];
	//private JLabel[] numStars = new JLabel[16];
	private ArrayList<JButton> levelButtons = new ArrayList<JButton>();
	private ArrayList<JLabel> numStars = new ArrayList<JLabel>();
	private ArrayList<JLabel> scores = new ArrayList<JLabel>();
	
	private SixesWild theGame;
	
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
		
//		//1 - 4
//		levelButton[0] = new JButton("Puzzle 1");
//		levelButton[0].setBounds(35, 55, 100, 100);
//		getContentPane().add(levelButton[0]);
//		
//		levelButton[1] = new JButton("Lightning 1");
//		levelButton[1].setBounds(165, 55, 100, 100);
//		getContentPane().add(levelButton[1]);
//		
//		levelButton[2] = new JButton("Elim. 1");
//		levelButton[2].setBounds(295, 55, 100, 100);
//		getContentPane().add(levelButton[2]);
//		
//		levelButton[3] = new JButton("Release 1");
//		levelButton[3].setBounds(430, 55, 100, 100);
//		getContentPane().add(levelButton[3]);
//		
//		numStars[0] = new JLabel(theGame.getStarNum(0) + " Stars Pts: " + theGame.getHighScore(0));
//		numStars[0].setBounds(35, 165, 100, 21);
//		getContentPane().add(numStars[0]);
//		
//		
//		if(theGame.getStarNum(0) == 0){
//			numStars[1] = new JLabel("LOCKED") ;
//		}
//		else{
//			numStars[1] = new JLabel(theGame.getStarNum(1) + " Stars Pts: " + theGame.getHighScore(1));
//		}
//		numStars[1].setBounds(165, 165, 100, 21);
//		getContentPane().add(numStars[1]);
//		
//		
//		if(theGame.getStarNum(1) == 0){
//			numStars[2] = new JLabel("LOCKED") ;
//		}
//		else{
//			numStars[2] = new JLabel(theGame.getStarNum(2) + " Stars Pts: " + theGame.getHighScore(2));
//		}
//		numStars[2].setBounds(295, 165, 100, 21);
//		getContentPane().add(numStars[2]);
//		
//		
//		if(theGame.getStarNum(2) == 0){
//			numStars[3] = new JLabel("LOCKED") ;
//		}
//		else{
//			numStars[3] = new JLabel(theGame.getStarNum(3) + " Stars Pts: " + theGame.getHighScore(3));
//		}
//		numStars[3].setBounds(430, 165, 100, 21);
//		getContentPane().add(numStars[3]);
//		
//		//5 - 8
//		levelButton[4] = new JButton("Puzzle 2");
//		levelButton[4].setBounds(35, 220, 100, 100);
//		getContentPane().add(levelButton[4]);
//		
//		levelButton[5] = new JButton("Lightning 2");
//		levelButton[5].setBounds(165, 220, 100, 100);
//		getContentPane().add(levelButton[5]);
//		
//		levelButton[6] = new JButton("Elim. 2");
//		levelButton[6].setBounds(295, 220, 100, 100);
//		getContentPane().add(levelButton[6]);
//		
//		levelButton[7] = new JButton("Release 2");
//		levelButton[7].setBounds(430, 220, 100, 100);
//		getContentPane().add(levelButton[7]);
//		
//		
//		if(theGame.getStarNum(3) == 0){
//			numStars[4] = new JLabel("LOCKED") ;
//		}
//		else{
//			numStars[4] = new JLabel(theGame.getStarNum(4) + " Stars Pts: " + theGame.getHighScore(4));
//		}
//		numStars[4].setBounds(35, 330, 100, 21);
//		getContentPane().add(numStars[4]);
//		
//		
//		if(theGame.getStarNum(4) == 0){
//			numStars[5] = new JLabel("LOCKED") ;
//		}
//		else{
//			numStars[5] = new JLabel(theGame.getStarNum(5) + " Stars Pts: " + theGame.getHighScore(5));
//		}
//		numStars[5].setBounds(165, 330, 100, 21);
//		getContentPane().add(numStars[5]);
//		
//		
//		if(theGame.getStarNum(5) == 0){
//			numStars[6] = new JLabel("LOCKED") ;
//		}
//		else{
//			numStars[6] = new JLabel(theGame.getStarNum(6) + " Stars Pts: " + theGame.getHighScore(6));
//		}
//		numStars[6].setBounds(295, 330, 100, 21);
//		getContentPane().add(numStars[6]);
//		
//		
//		if(theGame.getStarNum(6) == 0){
//			numStars[7] = new JLabel("LOCKED") ;
//		}
//		else{
//			numStars[7] = new JLabel(theGame.getStarNum(7) + " Stars Pts: " + theGame.getHighScore(7));
//		}
//		numStars[7].setBounds(430, 330, 100, 21);
//		getContentPane().add(numStars[7]);
//		
//		levelButton[8] = new JButton("Puzzle 3");
//		levelButton[8].setBounds(35, 385, 100, 100);
//		getContentPane().add(levelButton[8]);
//		
//		levelButton[9] = new JButton("Lightning 3");
//		levelButton[9].setBounds(165, 385, 100, 100);
//		getContentPane().add(levelButton[9]);
//		
//		levelButton[10] = new JButton("Elim. 3");
//		levelButton[10].setBounds(295, 385, 100, 100);
//		getContentPane().add(levelButton[10]);
//		
//		levelButton[11] = new JButton("Release 3");
//		levelButton[11].setBounds(430, 385, 100, 100);
//		getContentPane().add(levelButton[11]);
//		
//		
//		if(theGame.getStarNum(7) == 0){
//			numStars[8] = new JLabel("LOCKED") ;
//		}
//		else{
//			numStars[8] = new JLabel(theGame.getStarNum(8) + " Stars Pts: " + theGame.getHighScore(8));
//		}
//		numStars[8].setBounds(35, 495, 100, 21);
//		getContentPane().add(numStars[8]);
//		
//		
//		if(theGame.getStarNum(8) == 0){
//			numStars[9] = new JLabel("LOCKED") ;
//		}
//		else{
//			numStars[9] = new JLabel(theGame.getStarNum(9) + " Stars Pts: " + theGame.getHighScore(9));
//		}
//		numStars[9].setBounds(165, 495, 100, 21);
//		getContentPane().add(numStars[9]);
//		
//		
//		if(theGame.getStarNum(9) == 0){
//			numStars[10] = new JLabel("LOCKED") ;
//		}
//		else{
//			numStars[10] = new JLabel(theGame.getStarNum(10) + " Stars Pts: " + theGame.getHighScore(10));
//		}
//		numStars[10].setBounds(295, 495, 100, 21);
//		getContentPane().add(numStars[10]);
//		
//		
//		if(theGame.getStarNum(10) == 0){
//			numStars[11] = new JLabel("LOCKED") ;
//		}
//		else{
//			numStars[11] = new JLabel(theGame.getStarNum(11) + " Stars Pts: " + theGame.getHighScore(11));
//		}
//		numStars[11].setBounds(430, 495, 100, 21);
//		getContentPane().add(numStars[11]);
//		
//		levelButton[12] = new JButton("Puzzle 4");
//		levelButton[12].setBounds(35, 550, 100, 100);
//		getContentPane().add(levelButton[12]);
//		
//		levelButton[13] = new JButton("Lightning 4");
//		levelButton[13].setBounds(165, 550, 100, 100);
//		getContentPane().add(levelButton[13]);
//		
//		levelButton[14] = new JButton("Elim. 4");
//		levelButton[14].setBounds(295, 550, 100, 100);
//		getContentPane().add(levelButton[14]);
//		
//		levelButton[15] = new JButton("Release 4");
//		levelButton[15].setBounds(430, 550, 100, 100);
//		getContentPane().add(levelButton[15]);
//		
//		
//		if(theGame.getStarNum(11) == 0){
//			numStars[12] = new JLabel("LOCKED") ;
//		}
//		else{
//			numStars[12] = new JLabel(theGame.getStarNum(12) + " Stars Pts: " + theGame.getHighScore(12));
//		}
//		numStars[12].setBounds(35, 660, 100, 21);
//		getContentPane().add(numStars[12]);
//		
//		
//		if(theGame.getStarNum(12) == 0){
//			numStars[13] = new JLabel("LOCKED") ;
//		}
//		else{
//			numStars[13] = new JLabel(theGame.getStarNum(13) + " Stars Pts: " + theGame.getHighScore(13));
//		}		numStars[13].setBounds(165, 660, 100, 21);
//		getContentPane().add(numStars[13]);
//		
//		
//		if(theGame.getStarNum(13) == 0){
//			numStars[14] = new JLabel("LOCKED") ;
//		}
//		else{
//			numStars[14] = new JLabel(theGame.getStarNum(14) + " Stars Pts: " + theGame.getHighScore(14));
//		}		numStars[14].setBounds(295, 660, 100, 21);
//		getContentPane().add(numStars[14]);
//		
//		
//		if(theGame.getStarNum(14) == 0){
//			numStars[15] = new JLabel("LOCKED") ;
//		}
//		else{
//			numStars[15] = new JLabel(theGame.getStarNum(15) + " Stars Pts: " + theGame.getHighScore(15));
//		}		numStars[15].setBounds(430, 660, 100, 21);
//		getContentPane().add(numStars[15]);
		
		
		JTextArea txtrPleaseSelectLevel = new JTextArea();
		txtrPleaseSelectLevel.setBackground(UIManager.getColor("textHighlight"));
		txtrPleaseSelectLevel.setEditable(false);
		txtrPleaseSelectLevel.setText("Please Select Level");
		txtrPleaseSelectLevel.setBounds(35, 15, 360, 30);
		
		initControllers(theGame);
		
		
		getContentPane().add(txtrPleaseSelectLevel);
	}
	
	public void initControllers(SixesWild theGame) {
		backToMainManuButton.addActionListener(new BacktoMainMenuController(this));
		
		for(int i = 0; i < theGame.getLevels().size(); i++) {
			levelButtons.get(i).addActionListener(new ChooseLevelController(this, theGame, i));
		}
	}
}
