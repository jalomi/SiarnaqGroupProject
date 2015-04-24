package levelBuilderControllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

import levelBuilderBoundary.LevelBuilderApplication;
import levelBuilderEntity.LevelBuilder;

public class Select2StarScoreController implements ActionListener{
	LevelBuilder model;
	LevelBuilderApplication application;
	
	public Select2StarScoreController(LevelBuilder m, LevelBuilderApplication a)
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
			model.setStarScore(2,num);
			application.getInputPanel().getScore2().setText(""+tf.getText());
			System.out.println("Two Star Score: "+model.getTwoStarScore());
		} catch (Exception e) {
			tf.setText(""+model.getTwoStarScore());
		}
		
	}
}
