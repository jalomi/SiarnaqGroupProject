package levelBuilderControllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

import levelBuilderBoundary.LevelBuilderApplication;
import levelBuilderEntity.LevelBuilder;
import levelBuilderMoves.SetLevelNumberMove;

public class SelectLevelNumberController implements ActionListener{
	LevelBuilder model;
	LevelBuilderApplication application;
	
	public SelectLevelNumberController(LevelBuilder m, LevelBuilderApplication a)
	{
		this.model=m;
		this.application=a;
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		JTextField tf=(JTextField)ae.getSource();
		update(tf);
	}
	
	public void update(JTextField tf) {
		try {
			int num = Integer.valueOf(tf.getText());
			System.out.println("TAG:::::" + "num");
			SetLevelNumberMove m=new SetLevelNumberMove(model, num, tf);
			if(m.doMove())
			{
				System.out.println("Number of Level: "+model.getLevelNumber());
				model.recordMove(m);
			}
		} catch (Exception e) {
			tf.setText(""+model.getLevelNumber());
		}
		
	}
}
