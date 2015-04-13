package sixesWildGUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.UIManager;

public class SixesWildApplication extends JFrame {

	private JPanel contentPane;
	SixesWildGamePanel gamePanel ;
	SixesWildLevelPanel levelPanel ;

	/**
	 * Launch the application.
	 */
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
	

	/**
	 * Create the frame.
	 */
	public SixesWildApplication() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 580, 750);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		gamePanel = new SixesWildGamePanel();
		gamePanel.setBackground(UIManager.getColor("Panel.background"));
		gamePanel.setBounds(35, 180, 490, 490);
		contentPane.add(gamePanel);
		
		levelPanel = new SixesWildLevelPanel();
		levelPanel.setBackground(UIManager.getColor("Panel.background"));
		levelPanel.setBounds(35, 20, 490, 135);
		contentPane.add(levelPanel);
	}

}
