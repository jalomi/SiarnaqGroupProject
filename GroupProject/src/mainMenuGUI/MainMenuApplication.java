package mainMenuGUI;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class MainMenuApplication extends JFrame {

	private JPanel contentPane;
	private JButton btnNewButton_1;
	private JLabel lblSixesWild;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainMenuApplication frame = new MainMenuApplication();
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
	public MainMenuApplication() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 580, 750);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Level Select");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(100, 400, 150, 75);
		contentPane.add(btnNewButton);

		btnNewButton_1 = new JButton("Quit Game");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_1.setBounds(330, 400, 150, 75);
		contentPane.add(btnNewButton_1);

		lblSixesWild = new JLabel("Sixes Wild");
		lblSixesWild.setFont(new Font("Matura MT Script Capitals", Font.PLAIN, 56));
		lblSixesWild.setBounds(135, 100, 305, 200);
		contentPane.add(lblSixesWild);
	}

}
