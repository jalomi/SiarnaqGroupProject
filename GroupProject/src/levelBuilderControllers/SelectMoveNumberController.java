package levelBuilderControllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

import levelBuilderBoundary.LevelBuilderApplication;
import levelBuilderEntity.LevelBuilder;
import levelBuilderMoves.SetMoveNumberMove;

public class SelectMoveNumberController implements ActionListener{
	LevelBuilder model;
	LevelBuilderApplication application;
	int oldValue;
	
	public SelectMoveNumberController(LevelBuilder m, LevelBuilderApplication a, int oldValue)
	{
		this.model=m;
		this.application=a;
		this.oldValue=oldValue;
	}
	
	@Override
	public void actionPerformed(ActionEvent ae)
	{
		System.out.println(model.getMoves());
		JTextField tf=(JTextField)ae.getSource();
		update(tf);
	}
	
	public void update(JTextField tf)
	{
		try{
			int num = Integer.valueOf(tf.getText());
			SetMoveNumberMove m=new SetMoveNumberMove(model, num, oldValue, application.getInputPanel().getMaxMoves());;
			if(m.doMove())
			{
				System.out.println("Number of Moves: "+model.getMoves());
				model.recordMove(m);
				oldValue=model.getMoves();
			}
		} catch (Exception e) {
			tf.setText(""+model.getMoves());
		}
		
	}

}
