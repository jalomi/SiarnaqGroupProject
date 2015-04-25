package levelBuilderControllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

import levelBuilderBoundary.LevelBuilderApplication;
import levelBuilderEntity.LevelBuilder;
import levelBuilderMoves.Set3StarScoreMove;

public class Select3StarScoreController implements ActionListener{
	LevelBuilder model;
	LevelBuilderApplication application;
	
	public Select3StarScoreController(LevelBuilder m, LevelBuilderApplication a)
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
			Set3StarScoreMove m=new Set3StarScoreMove(model, num, application.getInputPanel().getScore3());;
			if(m.doMove())
			{
				System.out.println("Three Star Score: "+model.getThreeStarScore());
				model.recordMove(m);
			}
		} catch (Exception e) {
			tf.setText(""+model.getThreeStarScore());
		}
		
	}
}
