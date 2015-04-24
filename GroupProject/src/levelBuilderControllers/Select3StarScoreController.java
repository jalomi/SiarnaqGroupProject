package levelBuilderControllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

import levelBuilderBoundary.LevelBuilderApplication;
import levelBuilderEntity.LevelBuilder;

public class Select3StarScoreController implements ActionListener{
	LevelBuilder model;
	LevelBuilderApplication application;
	
	public Select3StarScoreController(LevelBuilder m, LevelBuilderApplication a)
	{
		this.model=m;
		this.application=a;
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		JTextField tf=(JTextField)ae.getSource();
		update(tf);
	}
	
	public void update(JTextField tf)
	{
		try{
			int num = Integer.valueOf(tf.getText());
			model.setStarScore(3,num);
			application.getInputPanel().getScore3().setText(""+tf.getText());
			System.out.println("Three Star Score: "+model.getThreeStarScore());
		} catch (Exception e) {
			tf.setText(""+model.getThreeStarScore());
		}
		
	}
}
