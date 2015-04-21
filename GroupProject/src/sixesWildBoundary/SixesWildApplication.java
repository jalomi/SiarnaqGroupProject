package sixesWildBoundary;

import javax.swing.JFrame;

import sixesWildEntity.Level;


@SuppressWarnings("serial")
public class SixesWildApplication extends JFrame {
	
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					SixesWildApplication frame = new SixesWildApplication(new Level());
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}  
//		});
//	}

	
	public static final String TAG = "BoardFrame";

	private SixesWildLevelPanel levelPane;
	private SixesWildGamePanel gamePane;
	

	/**
	 * Create the frame.
	 */
	public SixesWildApplication(Level l) {
		setTitle("Sixes Wild");
		
		gamePane = new SixesWildGamePanel(l);
		gamePane.setSize(490, 490);
		gamePane.setLocation(35, 180);
		levelPane = new SixesWildLevelPanel(l);
		levelPane.setLocation(35, 20);
		
		setBounds(5, 5, 580, 750);
		this.setResizable(false);
		getContentPane().setLayout(null);

		getContentPane().add(levelPane);
		getContentPane().add(gamePane);
		this.setVisible(true);
	}
	
	public SixesWildLevelPanel getLevelPanel()
	{
		return levelPane;
	}
}
