package sixesWildBoundary;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import sixesWildControllers.EnterLevelSelectController;
import sixesWildControllers.ExitController;

import javax.swing.UIManager;
/**
 * The main menu of Sixes Wild
 * Can either quit the application or move to a level selectin screen
 * @author John
 *
 */
@SuppressWarnings("serial")
public class MainMenuApplication extends JFrame {

	/** Panel for the frame */
	private JPanel contentPane;
	
	/** Button to go to the level select application */
	private JButton levelSelectButton;
	
	/** Button to exit application */
	private JButton quitButton;
	
	/** label to show the game's title */
	private JLabel lblSixesWild;

	/**
	 * Constructor
	 * Create the frame.
	 */
	public MainMenuApplication() {
		setResizable(false);
		setTitle("Sixes Wild");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(5, 5, 580, 750);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("textHighlight"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		levelSelectButton = new JButton("Level Select");
		levelSelectButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		levelSelectButton.setBounds(100, 400, 150, 75);
		levelSelectButton.addActionListener(new EnterLevelSelectController(this));
		contentPane.add(levelSelectButton);

		quitButton = new JButton("Quit Game");
		quitButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		quitButton.setBounds(330, 400, 150, 75);
		quitButton.addActionListener(new ExitController(this));
		contentPane.add(quitButton);

		lblSixesWild = new JLabel("Sixes Wild");
		lblSixesWild.setFont(new Font("Matura MT Script Capitals", Font.PLAIN, 56));
		lblSixesWild.setBounds(135, 100, 305, 200);
		contentPane.add(lblSixesWild);
	}
}
