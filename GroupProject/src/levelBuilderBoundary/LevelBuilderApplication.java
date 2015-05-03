package levelBuilderBoundary;

import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.border.EmptyBorder;
import javax.swing.UIManager;

import org.json.JSONException;

import levelBuilderControllers.ActivateBucketforSixesController;
import levelBuilderControllers.ActivateSpecialMoveController;
import levelBuilderControllers.ChoosingLevelController;
import levelBuilderControllers.ExitController;
import levelBuilderControllers.GenerateLevelController;
import levelBuilderControllers.PreviewController;
import levelBuilderControllers.RedoController;
import levelBuilderControllers.SelectStarScoreController;
import levelBuilderControllers.SelectLevelNumberController;
import levelBuilderControllers.SelectLevelTypeController;
import levelBuilderControllers.SelectMoveNumberController;
import levelBuilderControllers.SelectMultiplierPercentController;
import levelBuilderControllers.SelectSecondsController;
import levelBuilderControllers.SelectSquarePercentController;
import levelBuilderControllers.SelectTilesController;
import levelBuilderControllers.UndoController;
import levelBuilderEntity.LevelBuilder;

/**
 * Application for the Level Builder program
 * @author John
 *
 */
@SuppressWarnings("serial")
public class LevelBuilderApplication extends JFrame {
	/** the level builder model */
	public static LevelBuilder model;

	/** the main panel */
	private JPanel contentPane;
	
	/** the panel for the tile enable/disable option */
	LevelBuilderGamePanel gamePanel ;
	
	/** the panel for inputs like buttons, checkboxes, and textfields */
	LevelBuilderInputPanel inputPanel ;
	
	/** the panel for checkboxes related to the Release mode */
	LevelBuilderCheckBoxPanel checkBoxPanel ;

	/**
	 * Constructor
	 * Create the frame.
	 * @throws JSONException 
	 * @throws IOException 
	 */
	public LevelBuilderApplication() throws IOException, JSONException {
		model= LevelBuilder.newInstance();
		
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
		inputPanel.getPercent6().setEditable(false);
		inputPanel.setBackground(UIManager.getColor("Panel.background"));
		inputPanel.setBounds(540, 15, 360, 510);
		contentPane.add(inputPanel);
		
		//controllers
		getGenerateBtn().addActionListener(new GenerateLevelController(this)) ;
		if(model.getLevelNumber()<1){
		getGenerateBtn().setEnabled(false);//the generate level button is disabled at first.
		}
		getPreviewBtn().addActionListener(new PreviewController(this));
		if(model.getLevelNumber()<1){
		getPreviewBtn().setEnabled(false);//the preview button is disabled at first.
		}
		getExitBtn().addActionListener(new ExitController(this)) ;
		getInputPanel().getUndoBtn().addActionListener(new UndoController(model, this));
		getInputPanel().getRedoBtn().addActionListener(new RedoController(model, this));
		getInputPanel().getMaxMoves().addActionListener(new SelectMoveNumberController (model, this));
		getInputPanel().getScore1().addActionListener(new SelectStarScoreController (model, this, 0));
		getInputPanel().getScore2().addActionListener(new SelectStarScoreController (model, this, 1));
		getInputPanel().getScore3().addActionListener(new SelectStarScoreController (model, this, 2));
		getInputPanel().getSeconds().addActionListener(new SelectSecondsController (model, this));
		getInputPanel().getLevel().addActionListener(new SelectLevelNumberController (model, this));
		getInputPanel().getPercent1().addActionListener(new SelectSquarePercentController(model, this, 0));
		getInputPanel().getPercent2().addActionListener(new SelectSquarePercentController(model, this, 1));
		getInputPanel().getPercent3().addActionListener(new SelectSquarePercentController(model, this, 2));
		getInputPanel().getPercent4().addActionListener(new SelectSquarePercentController(model, this, 3));
		getInputPanel().getPercent5().addActionListener(new SelectSquarePercentController(model, this, 4));
		getInputPanel().getPercentx2().addActionListener(new SelectMultiplierPercentController(model, this, 1));
		getInputPanel().getPercentx3().addActionListener(new SelectMultiplierPercentController(model, this, 2));
		getInputPanel().getType().addActionListener(new SelectLevelTypeController(model, this));
		getInputPanel().getSwapEnabled().addActionListener(new ActivateSpecialMoveController(model, this, 2));
		getInputPanel().getResetEnabled().addActionListener(new ActivateSpecialMoveController(model, this, 1));
		getInputPanel().getRemoveEnabled().addActionListener(new ActivateSpecialMoveController(model, this, 3));
		getInputPanel().choosingLevelBox.addActionListener(new ChoosingLevelController(this));
		for(int i=0;i<9;i++){
			for(int j=0;j<9;j++){
				gamePanel.getTile(i, j).addActionListener(new SelectTilesController(model, this, getTiles(i,j),i, j));
			}
		}
		for(int i=0; i<9; i++){
			getCheckBoxPanel().getCheckBox(i).addActionListener(new ActivateBucketforSixesController(model, this, i));
			getCheckBoxPanel().getCheckBox(i).setEnabled(false);
		}
	}
	
	/**
	 * gets the button to exit
	 * @return
	 */
	private JButton getExitBtn() {
		return inputPanel.getExitBtn();
	}
	
	/**
	 * get the button to preview the level
	 * @return
	 */
	public JButton getPreviewBtn(){
		return inputPanel.getPreviewBtn() ;
	}
	
	/**
	 * get the button to generate and save the level
	 * @return
	 */
	public JButton getGenerateBtn(){
		return inputPanel.getGenerateLevelBtn() ;
	}

	/**
	 * gets the toggle button for the game panel at a certain coordinate
	 * @param x
	 * @param y
	 * @return
	 */
	public JToggleButton getTiles(int x, int y){
		return gamePanel.getTile(x,y);
	}
	
	/**
	 * gets the level builder model
	 * @return
	 */
	public static LevelBuilder getModel() {
		return model;
	}

	/**
	 * sets the level builder model
	 * @param model
	 */
	public static void setModel(LevelBuilder model) {
		LevelBuilderApplication.model = model;
	}

	/**
	 * gets the game panel
	 * @return
	 */
	public LevelBuilderGamePanel getGamePanel(){
		return gamePanel ;
	}
	
	/**
	 * gets the input panel
	 * @return
	 */
	public LevelBuilderInputPanel getInputPanel(){
		return inputPanel ;
	}
	
	/**
	 * gets the check box panel
	 * @return
	 */
	public LevelBuilderCheckBoxPanel getCheckBoxPanel(){
		return checkBoxPanel ;
	}
	
}
