package sixesWildBoundary;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;

import sixesWildEntity.Board;
import sixesWildEntity.Level;
import sixesWildEntity.Tile;


@SuppressWarnings("serial")
public class SixesWildApplication extends JFrame {
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SixesWildApplication frame = new SixesWildApplication();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}  
		});
	}
	
	public static final String TAG = "BoardFrame";

	private SixesWildLevelPanel levelPane;
	private SixesWildGamePanel gamePane;
	

	/**
	 * Create the frame.
	 */
	public SixesWildApplication(/*Level level*/) {
		setTitle("Sixes Wild");
		
		gamePane = new SixesWildGamePanel();
		gamePane.setSize(490, 490);
		gamePane.setLocation(35, 180);
		levelPane = new SixesWildLevelPanel();
		levelPane.setLocation(35, 20);
		
		
		this.setSize(580, 730);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		getContentPane().setLayout(null);

		getContentPane().add(levelPane);
		getContentPane().add(gamePane);
		this.setVisible(true);
	}
}
