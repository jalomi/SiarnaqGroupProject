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
import javax.swing.SwingConstants;

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
		lblTile.setHorizontalAlignment(SwingConstants.CENTER);
		lblTile.setBounds(45, 120, 50, 50);
		contentPane.add(lblTile);
		
		JLabel lblNewLabel = new JLabel("tile2");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(100, 120, 50, 50);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("tile3");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(155, 120, 50, 50);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblTile_1 = new JLabel("tile4");
		lblTile_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblTile_1.setBounds(210, 120, 50, 50);
		contentPane.add(lblTile_1);
		
		JLabel lblTile_2 = new JLabel("tile5");
		lblTile_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblTile_2.setBounds(265, 120, 50, 50);
		contentPane.add(lblTile_2);
		
		JLabel lblTile_3 = new JLabel("tile6");
		lblTile_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblTile_3.setBounds(320, 120, 50, 50);
		contentPane.add(lblTile_3);
		
		JLabel lblNewLabel_2 = new JLabel("tile7");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(375, 120, 50, 50);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblTile_4 = new JLabel("tile8");
		lblTile_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblTile_4.setBounds(430, 120, 50, 50);
		contentPane.add(lblTile_4);
		
		JLabel lblTile_5 = new JLabel("tile9");
		lblTile_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblTile_5.setBounds(485, 120, 50, 50);
		contentPane.add(lblTile_5);
		
		JLabel lblTile_6 = new JLabel("tile10");
		lblTile_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblTile_6.setBounds(45, 175, 50, 50);
		contentPane.add(lblTile_6);
		
		JLabel lblTile_7 = new JLabel("tile11");
		lblTile_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblTile_7.setBounds(100, 175, 50, 50);
		contentPane.add(lblTile_7);
		
		JLabel lblTile_8 = new JLabel("tile12");
		lblTile_8.setHorizontalAlignment(SwingConstants.CENTER);
		lblTile_8.setBounds(155, 175, 50, 50);
		contentPane.add(lblTile_8);
		
		JLabel lblTile_9 = new JLabel("tile13");
		lblTile_9.setHorizontalAlignment(SwingConstants.CENTER);
		lblTile_9.setBounds(210, 175, 50, 50);
		contentPane.add(lblTile_9);
		
		JLabel lblTile_10 = new JLabel("tile14");
		lblTile_10.setHorizontalAlignment(SwingConstants.CENTER);
		lblTile_10.setBounds(265, 175, 50, 50);
		contentPane.add(lblTile_10);
		
		JLabel lblTile_11 = new JLabel("tile15");
		lblTile_11.setHorizontalAlignment(SwingConstants.CENTER);
		lblTile_11.setBounds(320, 175, 50, 50);
		contentPane.add(lblTile_11);
		
		JLabel lblTile_12 = new JLabel("tile16");
		lblTile_12.setHorizontalAlignment(SwingConstants.CENTER);
		lblTile_12.setBounds(375, 175, 50, 50);
		contentPane.add(lblTile_12);
		
		JLabel lblTile_13 = new JLabel("tile17");
		lblTile_13.setHorizontalAlignment(SwingConstants.CENTER);
		lblTile_13.setBounds(430, 175, 50, 50);
		contentPane.add(lblTile_13);
		
		JLabel lblTile_14 = new JLabel("tile18");
		lblTile_14.setHorizontalAlignment(SwingConstants.CENTER);
		lblTile_14.setBounds(485, 175, 50, 50);
		contentPane.add(lblTile_14);
		
		JLabel lblTile_15 = new JLabel("tile19");
		lblTile_15.setHorizontalAlignment(SwingConstants.CENTER);
		lblTile_15.setBounds(45, 230, 50, 50);
		contentPane.add(lblTile_15);
		
		JLabel lblTile_16 = new JLabel("tile20");
		lblTile_16.setHorizontalAlignment(SwingConstants.CENTER);
		lblTile_16.setBounds(100, 230, 50, 50);
		contentPane.add(lblTile_16);
		
		JLabel lblTile_17 = new JLabel("tile21");
		lblTile_17.setHorizontalAlignment(SwingConstants.CENTER);
		lblTile_17.setBounds(155, 230, 50, 50);
		contentPane.add(lblTile_17);
		
		JLabel lblTile_18 = new JLabel("tile22");
		lblTile_18.setHorizontalAlignment(SwingConstants.CENTER);
		lblTile_18.setBounds(210, 230, 50, 50);
		contentPane.add(lblTile_18);
		
		JLabel lblTile_19 = new JLabel("tile23");
		lblTile_19.setHorizontalAlignment(SwingConstants.CENTER);
		lblTile_19.setBounds(265, 230, 50, 50);
		contentPane.add(lblTile_19);
		
		JLabel lblTile_20 = new JLabel("tile24");
		lblTile_20.setHorizontalAlignment(SwingConstants.CENTER);
		lblTile_20.setBounds(320, 230, 50, 50);
		contentPane.add(lblTile_20);
		
		JLabel lblTile_21 = new JLabel("tile25");
		lblTile_21.setHorizontalAlignment(SwingConstants.CENTER);
		lblTile_21.setBounds(375, 230, 50, 50);
		contentPane.add(lblTile_21);
		
		JLabel lblTile_22 = new JLabel("tile26");
		lblTile_22.setHorizontalAlignment(SwingConstants.CENTER);
		lblTile_22.setBounds(430, 230, 50, 50);
		contentPane.add(lblTile_22);
		
		JLabel lblTile_23 = new JLabel("tile27");
		lblTile_23.setHorizontalAlignment(SwingConstants.CENTER);
		lblTile_23.setBounds(485, 230, 50, 50);
		contentPane.add(lblTile_23);
		
		JLabel lblTile_24 = new JLabel("tile28");
		lblTile_24.setHorizontalAlignment(SwingConstants.CENTER);
		lblTile_24.setBounds(45, 285, 50, 50);
		contentPane.add(lblTile_24);
		
		JLabel lblTile_25 = new JLabel("tile29");
		lblTile_25.setHorizontalAlignment(SwingConstants.CENTER);
		lblTile_25.setBounds(100, 285, 50, 50);
		contentPane.add(lblTile_25);
		
		JLabel lblTile_26 = new JLabel("tile30");
		lblTile_26.setHorizontalAlignment(SwingConstants.CENTER);
		lblTile_26.setBounds(155, 285, 50, 50);
		contentPane.add(lblTile_26);
		
		JLabel lblTile_27 = new JLabel("tile31");
		lblTile_27.setHorizontalAlignment(SwingConstants.CENTER);
		lblTile_27.setBounds(210, 285, 50, 50);
		contentPane.add(lblTile_27);
		
		JLabel lblTile_28 = new JLabel("tile32");
		lblTile_28.setHorizontalAlignment(SwingConstants.CENTER);
		lblTile_28.setBounds(265, 285, 50, 50);
		contentPane.add(lblTile_28);
		
		JLabel lblTile_29 = new JLabel("tile33");
		lblTile_29.setHorizontalAlignment(SwingConstants.CENTER);
		lblTile_29.setBounds(320, 285, 50, 50);
		contentPane.add(lblTile_29);
		
		JLabel lblTile_30 = new JLabel("tile34");
		lblTile_30.setHorizontalAlignment(SwingConstants.CENTER);
		lblTile_30.setBounds(375, 285, 50, 50);
		contentPane.add(lblTile_30);
		
		JLabel lblTile_31 = new JLabel("tile35");
		lblTile_31.setHorizontalAlignment(SwingConstants.CENTER);
		lblTile_31.setBounds(430, 285, 50, 50);
		contentPane.add(lblTile_31);
		
		JLabel lblTile_32 = new JLabel("tile36");
		lblTile_32.setHorizontalAlignment(SwingConstants.CENTER);
		lblTile_32.setBounds(485, 285, 50, 50);
		contentPane.add(lblTile_32);
		
		JLabel lblTile_33 = new JLabel("tile37");
		lblTile_33.setHorizontalAlignment(SwingConstants.CENTER);
		lblTile_33.setBounds(45, 345, 50, 50);
		contentPane.add(lblTile_33);
		
		JLabel lblTile_42 = new JLabel("tile46");
		lblTile_42.setHorizontalAlignment(SwingConstants.CENTER);
		lblTile_42.setBounds(45, 402, 50, 50);
		contentPane.add(lblTile_42);
		
		JLabel label_2 = new JLabel("tile19");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setBounds(45, 457, 50, 50);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("tile28");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setBounds(45, 512, 50, 50);
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel("tile29");
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setBounds(100, 512, 50, 50);
		contentPane.add(label_4);
		
		JLabel label_5 = new JLabel("tile20");
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setBounds(100, 457, 50, 50);
		contentPane.add(label_5);
		
		JLabel lblTile_43 = new JLabel("tile47");
		lblTile_43.setHorizontalAlignment(SwingConstants.CENTER);
		lblTile_43.setBounds(100, 402, 50, 50);
		contentPane.add(lblTile_43);
		
		JLabel lblTile_34 = new JLabel("tile38");
		lblTile_34.setHorizontalAlignment(SwingConstants.CENTER);
		lblTile_34.setBounds(100, 347, 50, 50);
		contentPane.add(lblTile_34);
		
		JLabel lblTile_35 = new JLabel("tile39");
		lblTile_35.setHorizontalAlignment(SwingConstants.CENTER);
		lblTile_35.setBounds(155, 347, 50, 50);
		contentPane.add(lblTile_35);
		
		JLabel lblTile_44 = new JLabel("tile48");
		lblTile_44.setHorizontalAlignment(SwingConstants.CENTER);
		lblTile_44.setBounds(155, 402, 50, 50);
		contentPane.add(lblTile_44);
		
		JLabel label_10 = new JLabel("tile21");
		label_10.setHorizontalAlignment(SwingConstants.CENTER);
		label_10.setBounds(155, 457, 50, 50);
		contentPane.add(label_10);
		
		JLabel label_11 = new JLabel("tile30");
		label_11.setHorizontalAlignment(SwingConstants.CENTER);
		label_11.setBounds(155, 512, 50, 50);
		contentPane.add(label_11);
		
		JLabel label_12 = new JLabel("tile31");
		label_12.setHorizontalAlignment(SwingConstants.CENTER);
		label_12.setBounds(210, 512, 50, 50);
		contentPane.add(label_12);
		
		JLabel label_13 = new JLabel("tile22");
		label_13.setHorizontalAlignment(SwingConstants.CENTER);
		label_13.setBounds(210, 457, 50, 50);
		contentPane.add(label_13);
		
		JLabel label_14 = new JLabel("tile13");
		label_14.setHorizontalAlignment(SwingConstants.CENTER);
		label_14.setBounds(210, 402, 50, 50);
		contentPane.add(label_14);
		
		JLabel lblTile_36 = new JLabel("tile40");
		lblTile_36.setHorizontalAlignment(SwingConstants.CENTER);
		lblTile_36.setBounds(210, 347, 50, 50);
		contentPane.add(lblTile_36);
		
		JLabel lblTile_37 = new JLabel("tile41");
		lblTile_37.setHorizontalAlignment(SwingConstants.CENTER);
		lblTile_37.setBounds(265, 347, 50, 50);
		contentPane.add(lblTile_37);
		
		JLabel label_17 = new JLabel("tile14");
		label_17.setHorizontalAlignment(SwingConstants.CENTER);
		label_17.setBounds(265, 402, 50, 50);
		contentPane.add(label_17);
		
		JLabel label_18 = new JLabel("tile23");
		label_18.setHorizontalAlignment(SwingConstants.CENTER);
		label_18.setBounds(265, 457, 50, 50);
		contentPane.add(label_18);
		
		JLabel label_19 = new JLabel("tile32");
		label_19.setHorizontalAlignment(SwingConstants.CENTER);
		label_19.setBounds(265, 512, 50, 50);
		contentPane.add(label_19);
		
		JLabel label_20 = new JLabel("tile33");
		label_20.setHorizontalAlignment(SwingConstants.CENTER);
		label_20.setBounds(320, 512, 50, 50);
		contentPane.add(label_20);
		
		JLabel label_21 = new JLabel("tile24");
		label_21.setHorizontalAlignment(SwingConstants.CENTER);
		label_21.setBounds(320, 457, 50, 50);
		contentPane.add(label_21);
		
		JLabel label_22 = new JLabel("tile15");
		label_22.setHorizontalAlignment(SwingConstants.CENTER);
		label_22.setBounds(320, 402, 50, 50);
		contentPane.add(label_22);
		
		JLabel lblTile_38 = new JLabel("tile42");
		lblTile_38.setHorizontalAlignment(SwingConstants.CENTER);
		lblTile_38.setBounds(320, 347, 50, 50);
		contentPane.add(lblTile_38);
		
		JLabel lblTile_41 = new JLabel("tile45");
		lblTile_41.setHorizontalAlignment(SwingConstants.CENTER);
		lblTile_41.setBounds(485, 347, 50, 50);
		contentPane.add(lblTile_41);
		
		JLabel lblTile_40 = new JLabel("tile44");
		lblTile_40.setHorizontalAlignment(SwingConstants.CENTER);
		lblTile_40.setBounds(430, 347, 50, 50);
		contentPane.add(lblTile_40);
		
		JLabel lblTile_39 = new JLabel("tile43");
		lblTile_39.setHorizontalAlignment(SwingConstants.CENTER);
		lblTile_39.setBounds(375, 347, 50, 50);
		contentPane.add(lblTile_39);
		
		JLabel label_27 = new JLabel("tile16");
		label_27.setHorizontalAlignment(SwingConstants.CENTER);
		label_27.setBounds(375, 402, 50, 50);
		contentPane.add(label_27);
		
		JLabel label_28 = new JLabel("tile17");
		label_28.setHorizontalAlignment(SwingConstants.CENTER);
		label_28.setBounds(430, 402, 50, 50);
		contentPane.add(label_28);
		
		JLabel label_29 = new JLabel("tile18");
		label_29.setHorizontalAlignment(SwingConstants.CENTER);
		label_29.setBounds(485, 402, 50, 50);
		contentPane.add(label_29);
		
		JLabel label_30 = new JLabel("tile27");
		label_30.setHorizontalAlignment(SwingConstants.CENTER);
		label_30.setBounds(485, 457, 50, 50);
		contentPane.add(label_30);
		
		JLabel label_31 = new JLabel("tile26");
		label_31.setHorizontalAlignment(SwingConstants.CENTER);
		label_31.setBounds(430, 457, 50, 50);
		contentPane.add(label_31);
		
		JLabel label_32 = new JLabel("tile25");
		label_32.setHorizontalAlignment(SwingConstants.CENTER);
		label_32.setBounds(375, 457, 50, 50);
		contentPane.add(label_32);
		
		JLabel label_33 = new JLabel("tile34");
		label_33.setHorizontalAlignment(SwingConstants.CENTER);
		label_33.setBounds(375, 512, 50, 50);
		contentPane.add(label_33);
		
		JLabel label_34 = new JLabel("tile35");
		label_34.setHorizontalAlignment(SwingConstants.CENTER);
		label_34.setBounds(430, 512, 50, 50);
		contentPane.add(label_34);
		
		JLabel label_35 = new JLabel("tile36");
		label_35.setHorizontalAlignment(SwingConstants.CENTER);
		label_35.setBounds(485, 512, 50, 50);
		contentPane.add(label_35);
		
		JLabel label = new JLabel("tile28");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(45, 572, 50, 50);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("tile29");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setBounds(100, 572, 50, 50);
		contentPane.add(label_1);
		
		JLabel label_6 = new JLabel("tile30");
		label_6.setHorizontalAlignment(SwingConstants.CENTER);
		label_6.setBounds(155, 572, 50, 50);
		contentPane.add(label_6);
		
		JLabel label_7 = new JLabel("tile31");
		label_7.setHorizontalAlignment(SwingConstants.CENTER);
		label_7.setBounds(210, 572, 50, 50);
		contentPane.add(label_7);
		
		JLabel label_8 = new JLabel("tile32");
		label_8.setHorizontalAlignment(SwingConstants.CENTER);
		label_8.setBounds(265, 572, 50, 50);
		contentPane.add(label_8);
		
		JLabel label_9 = new JLabel("tile33");
		label_9.setHorizontalAlignment(SwingConstants.CENTER);
		label_9.setBounds(320, 572, 50, 50);
		contentPane.add(label_9);
		
		JLabel label_15 = new JLabel("tile34");
		label_15.setHorizontalAlignment(SwingConstants.CENTER);
		label_15.setBounds(375, 572, 50, 50);
		contentPane.add(label_15);
		
		JLabel label_16 = new JLabel("tile36");
		label_16.setHorizontalAlignment(SwingConstants.CENTER);
		label_16.setBounds(485, 572, 50, 50);
		contentPane.add(label_16);
		
		JLabel label_23 = new JLabel("tile35");
		label_23.setHorizontalAlignment(SwingConstants.CENTER);
		label_23.setBounds(430, 572, 50, 50);
		contentPane.add(label_23);
	}
}