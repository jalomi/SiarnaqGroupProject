package sixesWildBoundary;

import javax.swing.JFrame;

import sixesWildEntity.Level;

import java.awt.EventQueue;


@SuppressWarnings("serial")
public class SixesWildApplication extends JFrame {
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SixesWildApplication frame = new SixesWildApplication(new Level());
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
	public SixesWildApplication(Level level) {
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
