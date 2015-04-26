package levelBuilderControllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

import levelBuilderBoundary.LevelBuilderApplication;
import levelBuilderEntity.LevelBuilder;
import levelBuilderMoves.SetSecondsMove;

public class SelectSecondsController implements ActionListener{
	LevelBuilder model;
	LevelBuilderApplication application;
	
	public SelectSecondsController(LevelBuilder m, LevelBuilderApplication a)
	{
		this.model=m;
		this.application=a;
	}
	
	@Override
	public void actionPerformed(ActionEvent ae)
	{
		JTextField tf=(JTextField)ae.getSource();
		update(tf);
	}
	
	public void update(JTextField tf)
	{
		try{
			int num = Integer.valueOf(tf.getText());
			SetSecondsMove m=new SetSecondsMove(model, num, tf);
			if(m.doMove())
			{
				System.out.println("Number of Seconds: "+model.getSeconds());
				model.recordMove(m);
			}
		} catch (Exception e) {
			tf.setText(""+model.getSeconds());
		}
		
	}
}
