package levelBuilderControllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

import levelBuilderBoundary.LevelBuilderApplication;
import levelBuilderEntity.LevelBuilder;

public class SelectLevelNumberController implements ActionListener{
	LevelBuilder model;
	LevelBuilderApplication application;
	int oldValue;
	
	public SelectLevelNumberController(LevelBuilder m, LevelBuilderApplication a)
	{
		this.model=m;
		this.application=a;
		this.oldValue=model.getLevelNumber();
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
				model.setLevelNumber(num);
				System.out.println("Number of Level: "+model.getLevelNumber());
				application.getInputPanel().getLevel().setText(""+tf.getText());
		} catch (Exception e) {
			tf.setText(""+model.getLevelNumber());
		}
		
	}
}
