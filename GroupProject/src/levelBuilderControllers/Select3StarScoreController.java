package levelBuilderControllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

import levelBuilderBoundary.LevelBuilderApplication;
import levelBuilderEntity.LevelBuilder;
import levelBuilderMoves.Set2StarScoreMove;
import levelBuilderMoves.Set3StarScoreMove;

public class Select3StarScoreController implements ActionListener{
	LevelBuilder model;
	LevelBuilderApplication application;
	int oldValue;
	
	public Select3StarScoreController(LevelBuilder m, LevelBuilderApplication a, int oldValue)
	{
		this.model=m;
		this.application=a;
		this.oldValue=oldValue;
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
			Set3StarScoreMove m=new Set3StarScoreMove(model, num, oldValue, application.getInputPanel().getScore3());;
			if(m.doMove())
			{
				System.out.println("Three Star Score: "+model.getThreeStarScore());
				model.recordMove(m);
				oldValue=model.getThreeStarScore();
			}
		} catch (Exception e) {
			tf.setText(""+model.getThreeStarScore());
		}
		
	}
}
