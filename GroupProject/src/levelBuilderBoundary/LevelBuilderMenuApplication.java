package levelBuilderBoundary;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import sixesWildBoundary.MainMenuApplication;

import java.awt.EventQueue;
import java.awt.Font;

public class LevelBuilderMenuApplication extends JFrame {
	private JButton btnCreateLevel;
	private JButton btnEditLevel;
	private JButton btnQuitBuilder;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LevelBuilderMenuApplication frame = new LevelBuilderMenuApplication();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}  
		});
	}
	
	public LevelBuilderMenuApplication()
	{
		getContentPane().setLayout(null);
		
		JLabel lblLevelBuilder = new JLabel("Level Builder");
		lblLevelBuilder.setFont(new Font("Matura MT Script Capitals", Font.PLAIN, 24));
		lblLevelBuilder.setHorizontalAlignment(SwingConstants.CENTER);
		lblLevelBuilder.setBounds(135, 40, 188, 44);
		getContentPane().add(lblLevelBuilder);
		
		btnCreateLevel = new JButton("Create Level");
		btnCreateLevel.setBounds(87, 121, 117, 29);
		getContentPane().add(btnCreateLevel);
		
		btnEditLevel = new JButton("Edit Level");
		btnEditLevel.setBounds(257, 121, 117, 29);
		getContentPane().add(btnEditLevel);
		
		btnQuitBuilder = new JButton("Quit Builder");
		btnQuitBuilder.setBounds(172, 193, 117, 29);
		getContentPane().add(btnQuitBuilder);
	}
	
	public JButton getCreateLevel()
	{
		return btnCreateLevel;
	}
	
	public JButton getEditLevel()
	{
		return btnEditLevel;
	}
	
	public JButton getQuitBtn()
	{
		return btnQuitBuilder;
	}
}
