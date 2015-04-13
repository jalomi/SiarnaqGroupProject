package levelBuilderPreviewGUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.Color;

public class LevelBuilderPreviewApplication extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LevelBuilderPreviewApplication frame = new LevelBuilderPreviewApplication();
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
	public LevelBuilderPreviewApplication() {
		setBackground(new Color(238, 238, 238));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 580, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnBack = new JButton("Back");
		btnBack.setBounds(45, 45, 117, 29);
		contentPane.add(btnBack);
		
		JLabel lblTile = new JLabel("tile1");
		lblTile.setBounds(45, 120, 50, 50);
		contentPane.add(lblTile);
		
		JLabel lblNewLabel = new JLabel("tile2");
		lblNewLabel.setBounds(100, 120, 50, 50);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("tile3");
		lblNewLabel_1.setBounds(155, 120, 50, 50);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblTile_1 = new JLabel("tile4");
		lblTile_1.setBounds(210, 120, 50, 50);
		contentPane.add(lblTile_1);
		
		JLabel lblTile_2 = new JLabel("tile5");
		lblTile_2.setBounds(265, 120, 50, 50);
		contentPane.add(lblTile_2);
		
		JLabel lblTile_3 = new JLabel("tile6");
		lblTile_3.setBounds(320, 120, 50, 50);
		contentPane.add(lblTile_3);
		
		JLabel lblNewLabel_2 = new JLabel("tile7");
		lblNewLabel_2.setBounds(375, 120, 50, 50);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblTile_4 = new JLabel("tile8");
		lblTile_4.setBounds(430, 120, 50, 50);
		contentPane.add(lblTile_4);
		
		JLabel lblTile_5 = new JLabel("tile9");
		lblTile_5.setBounds(485, 120, 50, 50);
		contentPane.add(lblTile_5);
		
		JLabel lblTile_6 = new JLabel("tile10");
		lblTile_6.setBounds(45, 175, 50, 50);
		contentPane.add(lblTile_6);
		
		JLabel lblTile_7 = new JLabel("tile11");
		lblTile_7.setBounds(100, 175, 50, 50);
		contentPane.add(lblTile_7);
		
		JLabel lblTile_8 = new JLabel("tile12");
		lblTile_8.setBounds(155, 175, 50, 50);
		contentPane.add(lblTile_8);
		
		JLabel lblTile_9 = new JLabel("tile13");
		lblTile_9.setBounds(210, 175, 50, 50);
		contentPane.add(lblTile_9);
		
		JLabel lblTile_10 = new JLabel("tile14");
		lblTile_10.setBounds(265, 175, 50, 50);
		contentPane.add(lblTile_10);
		
		JLabel lblTile_11 = new JLabel("tile15");
		lblTile_11.setBounds(320, 175, 50, 50);
		contentPane.add(lblTile_11);
		
		JLabel lblTile_12 = new JLabel("tile16");
		lblTile_12.setBounds(375, 175, 50, 50);
		contentPane.add(lblTile_12);
		
		JLabel lblTile_13 = new JLabel("tile17");
		lblTile_13.setBounds(430, 175, 50, 50);
		contentPane.add(lblTile_13);
		
		JLabel lblTile_14 = new JLabel("tile18");
		lblTile_14.setBounds(485, 175, 50, 50);
		contentPane.add(lblTile_14);
		
		JLabel lblTile_15 = new JLabel("tile19");
		lblTile_15.setBounds(45, 235, 50, 50);
		contentPane.add(lblTile_15);
		
		JLabel lblTile_16 = new JLabel("tile20");
		lblTile_16.setBounds(100, 235, 50, 50);
		contentPane.add(lblTile_16);
		
		JLabel lblTile_17 = new JLabel("tile21");
		lblTile_17.setBounds(155, 235, 50, 50);
		contentPane.add(lblTile_17);
		
		JLabel lblTile_18 = new JLabel("tile22");
		lblTile_18.setBounds(210, 235, 50, 50);
		contentPane.add(lblTile_18);
		
		JLabel label_13 = new JLabel("tile5");
		label_13.setBounds(265, 235, 50, 50);
		contentPane.add(label_13);
		
		JLabel label_14 = new JLabel("tile6");
		label_14.setBounds(320, 235, 50, 50);
		contentPane.add(label_14);
		
		JLabel label_15 = new JLabel("tile7");
		label_15.setBounds(375, 235, 50, 50);
		contentPane.add(label_15);
		
		JLabel label_16 = new JLabel("tile8");
		label_16.setBounds(430, 235, 50, 50);
		contentPane.add(label_16);
		
		JLabel label_17 = new JLabel("tile9");
		label_17.setBounds(485, 237, 50, 50);
		contentPane.add(label_17);
	}
}
