package levelBuilderControllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

import levelBuilderBoundary.LevelBuilderApplication;
import levelBuilderEntity.LevelBuilder;

public class SelectMinutesController implements ActionListener{
	LevelBuilder model;
	LevelBuilderApplication application;
	
	public SelectMinutesController(LevelBuilder m, LevelBuilderApplication a)
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
			model.setMinutes(num);
			application.getInputPanel().getMinutes().setText(""+tf.getText());
			System.out.println("Number of Minutes: "+model.getMinutes());
		} catch (Exception e) {
			tf.setText(""+model.getMinutes());
		}
		
	}
}
