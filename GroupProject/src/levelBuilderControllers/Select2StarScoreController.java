package levelBuilderControllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

import levelBuilderBoundary.LevelBuilderApplication;
import levelBuilderEntity.LevelBuilder;
import levelBuilderMoves.Set1StarScoreMove;
import levelBuilderMoves.Set2StarScoreMove;

public class Select2StarScoreController implements ActionListener{
	LevelBuilder model;
	LevelBuilderApplication application;
	int oldValue;
	
	public Select2StarScoreController(LevelBuilder m, LevelBuilderApplication a, int oldValue)
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
			Set2StarScoreMove m=new Set2StarScoreMove(model, num, oldValue, application.getInputPanel().getScore2());;
			if(m.doMove())
			{
				System.out.println("Two Star Score: "+model.getTwoStarScore());
				model.recordMove(m);
				oldValue=model.getTwoStarScore();
			}
		} catch (Exception e) {
			tf.setText(""+model.getTwoStarScore());
		}
		
	}
}
