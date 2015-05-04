package levelBuilderBoundary;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import java.awt.Color;
import java.io.IOException;

import javax.swing.UIManager;

import org.json.JSONException;

/**
 * Displays a preview of what the level would look like based on the
 * current parameters
 * @author John
 * @author Kevin
 */
@SuppressWarnings("serial")
public class LevelBuilderPreviewApplication extends JFrame {
	/** Panel for the application */
	private JPanel contentPane;
	
	/** button to go back to the level builder */
	private JButton backBtn ;
	
	/** panel to hold the game tiles */
	LevelBuilderPreviewGamePanel gamePanel ;

	/**
	 * Constructor
	 * Create the frame.
	 * @throws JSONException 
	 * @throws IOException 
	 */
	public LevelBuilderPreviewApplication() throws IOException, JSONException {
		setResizable(false);
		setTitle("Preview");
		setBackground(new Color(238, 238, 238));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(5, 5, 580, 650);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("Panel.background"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		backBtn = new JButton("Back");
		backBtn.setBounds(35, 30, 117, 29);
		contentPane.add(backBtn);
		
		gamePanel = new LevelBuilderPreviewGamePanel();
		gamePanel.setBackground(UIManager.getColor("Panel.background"));
		gamePanel.setBounds(35, 85, 490, 490);
		contentPane.add(gamePanel);		
	}

	/**
	 * gets the back button
	 * @return
	 */
	public JButton getBackBtn() {
		return backBtn;
	}
	
	/**
	 * gets the game panel
	 * @return
	 */
	public LevelBuilderPreviewGamePanel getGamePanel(){
		return gamePanel ;
	}
}
