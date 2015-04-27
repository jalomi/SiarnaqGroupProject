package levelBuilderControllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

import levelBuilderBoundary.LevelBuilderApplication;
import levelBuilderEntity.LevelBuilder;
import levelBuilderMoves.SetMinutesMove;

public class SelectMinutesController implements ActionListener{
	/*This controller should be either removed or rewritten
	 * We only need one SetTimeController!!!*/
	
	
	LevelBuilder model;
	LevelBuilderApplication application;
	
	public SelectMinutesController(LevelBuilder m, LevelBuilderApplication a)
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
//		try{
//			int num = Integer.valueOf(tf.getText());
//			SetMinutesMove m=new SetMinutesMove(model, num, tf);
//			if(m.doMove())
//			{
//				System.out.println("Number of Minutes: "+model.getMinutes());
//				model.recordMove(m);
//			}
//		} catch (Exception e) {
//			tf.setText(""+model.getMinutes());
//		}
		
	}
}
