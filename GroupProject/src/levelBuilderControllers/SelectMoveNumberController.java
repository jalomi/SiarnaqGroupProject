package levelBuilderControllers;

import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

import levelBuilderBoundary.LevelBuilderApplication;
import levelBuilderEntity.LevelBuilder;

public class SelectMoveNumberController implements ActionListener{
	LevelBuilder model;
	LevelBuilderApplication application;
	
	public SelectMoveNumberController(LevelBuilder m, LevelBuilderApplication a)
	{
		this.model=m;
		this.application=a;
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		model.setMoves(0);
		System.out.println(model.getMoves());
		JTextField tf=(JTextField)ae.getSource();
		String s=tf.getText();
		update(tf, s);
	}
	
	public void update(JTextField tf, String s)
	{
		try{
			int num = Integer.valueOf(tf.getText());
			model.setMoves(num);
			System.out.println(model.getMoves());
			application.getInputPanel().getMaxMoves().setText(""+tf.getText());
		} catch (Exception e) {
			tf.setText(s);
		}
		
	}

}
