package levelBuilderBoundary;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.UIManager;

import levelBuilderControllers.ExitController;
import levelBuilderControllers.PreviewController;
import levelBuilderControllers.Select1StarScoreController;
import levelBuilderControllers.Select2StarScoreController;
import levelBuilderControllers.Select3StarScoreController;
import levelBuilderControllers.SelectLevelNumberController;
import levelBuilderControllers.SelectMinutesController;
import levelBuilderControllers.SelectMoveNumberController;
import levelBuilderControllers.SelectSecondsController;
import levelBuilderControllers.UndoController;
import levelBuilderEntity.LevelBuilder;

public class LevelBuilderApplication extends JFrame {

	private JPanel contentPane;
	LevelBuilderGamePanel gamePanel ;
	LevelBuilderInputPanel inputPanel ;
	LevelBuilderCheckBoxPanel checkBoxPanel ;
	private JPanel panel;
	private LevelBuilder model=new LevelBuilder();
	
	public LevelBuilderGamePanel getGamePanel(){
		return gamePanel ;
	}
	
	public LevelBuilderInputPanel getInputPanel(){
		return inputPanel ;
	}
	
	public LevelBuilderCheckBoxPanel getCheckBoxPanel(){
		return checkBoxPanel ;
	}

//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					LevelBuilderApplication frame = new LevelBuilderApplication();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public LevelBuilderApplication() {
		setResizable(false);
		setTitle("Level Builder");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(5, 5, 950, 600);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("Panel.background"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		gamePanel = new LevelBuilderGamePanel();
		gamePanel.setBackground(UIManager.getColor("Panel.background"));
		gamePanel.setBounds(25, 15, 490, 490);
		contentPane.add(gamePanel);
		
		checkBoxPanel = new LevelBuilderCheckBoxPanel();
		checkBoxPanel.setBackground(UIManager.getColor("Panel.background"));
		checkBoxPanel.setBounds(40, 510, 460, 21);
		contentPane.add(checkBoxPanel);
		
		inputPanel = new LevelBuilderInputPanel();
		inputPanel.setBackground(UIManager.getColor("Panel.background"));
		inputPanel.setBounds(540, 15, 360, 510);
		contentPane.add(inputPanel);
		
		//controllers
		getPreviewBtn().addActionListener(new PreviewController(this)) ;
		getExitBtn().addActionListener(new ExitController(this)) ;
		getInputPanel().getUndoBtn().addActionListener(new UndoController(model, this));
		getInputPanel().getMaxMoves().addActionListener(new SelectMoveNumberController (model, this));
		getInputPanel().getScore1().addActionListener(new Select1StarScoreController (model, this));
		getInputPanel().getScore2().addActionListener(new Select2StarScoreController (model, this));
		getInputPanel().getScore3().addActionListener(new Select3StarScoreController (model, this));
		getInputPanel().getMinutes().addActionListener(new SelectMinutesController (model, this));
		getInputPanel().getSeconds().addActionListener(new SelectSecondsController (model, this));
		getInputPanel().getLevel().addActionListener(new SelectLevelNumberController (model, this));
	}
	
	private JButton getExitBtn() {
		return inputPanel.getExitBtn();
	}

	public JButton getPreviewBtn(){
		return inputPanel.getPreviewBtn() ;
	}
	
}
