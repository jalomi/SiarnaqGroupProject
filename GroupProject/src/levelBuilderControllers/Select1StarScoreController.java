package levelBuilderControllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

import levelBuilderBoundary.LevelBuilderApplication;
import levelBuilderEntity.LevelBuilder;
import levelBuilderMoves.Set1StarScoreMove;

public class Select1StarScoreController implements ActionListener {
	LevelBuilder model;
	LevelBuilderApplication application;
	int oldValue;
	
	public Select1StarScoreController(LevelBuilder m, LevelBuilderApplication a, int oldValue)
	{
		this.model=m;
		this.application=a;
		this.oldValue=oldValue;
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
			Set1StarScoreMove m=new Set1StarScoreMove(model, num, oldValue, application.getInputPanel().getScore1());;
			if(m.doMove())
			{
				System.out.println("One Star Score: "+model.getOneStarScore());
				model.recordMove(m);
				oldValue=model.getOneStarScore();
			}
		} catch (Exception e) {
			tf.setText(""+model.getOneStarScore());
		}
		
	}
}
