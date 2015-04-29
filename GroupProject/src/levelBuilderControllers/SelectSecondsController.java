package levelBuilderControllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

import levelBuilderBoundary.LevelBuilderApplication;
import levelBuilderEntity.LevelBuilder;
import levelBuilderMoves.SetTimeMove;

public class SelectSecondsController implements ActionListener{
	/*This controller should be either removed or rewritten
	 * We only need one SetTimeController!!!*/
	
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
			SetTimeMove m=new SetTimeMove(model, num, tf);
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
