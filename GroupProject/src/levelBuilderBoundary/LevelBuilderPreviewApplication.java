package levelBuilderBoundary;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.UIManager;

public class LevelBuilderPreviewApplication extends JFrame {

	private JPanel contentPane;
	private JButton backBtn ;
	LevelBuilderPreviewGamePanel gamePanel ;
	
	public LevelBuilderPreviewGamePanel getGamePanel(){
		return gamePanel ;
	}

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					LevelBuilderPreviewApplication frame = new LevelBuilderPreviewApplication();
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
	public LevelBuilderPreviewApplication() {
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

	public JButton getBackBtn() {
		return backBtn;
	}
}
