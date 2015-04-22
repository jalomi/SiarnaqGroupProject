package levelBuilderControllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

import levelBuilderBoundary.LevelBuilderApplication;
import levelBuilderEntity.LevelBuilder;

public class Select1StarScoreController implements ActionListener {
	LevelBuilder model;
	LevelBuilderApplication application;
	
	public Select1StarScoreController(LevelBuilder m, LevelBuilderApplication a)
	{
		this.model=m;
		this.application=a;
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		JTextField tf=(JTextField)ae.getSource();
		String s=tf.getText();
		update(tf, s);
	}
	
	public void update(JTextField tf, String s)
	{
		try{
			int num = Integer.valueOf(tf.getText());
			model.setStarScore(1,num);
			application.getInputPanel().getScore1().setText(""+tf.getText());
			System.out.println(model.getOneStarScore());
		} catch (Exception e) {
			tf.setText(s);
		}
		
	}
}
