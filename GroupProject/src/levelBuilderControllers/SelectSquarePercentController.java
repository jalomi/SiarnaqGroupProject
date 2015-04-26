package levelBuilderControllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

import levelBuilderBoundary.LevelBuilderApplication;
import levelBuilderEntity.LevelBuilder;
import levelBuilderMoves.SetLevelNumberMove;
import levelBuilderMoves.SetSquarePercentMove;

public class SelectSquarePercentController implements ActionListener{
	LevelBuilder model;
	LevelBuilderApplication application;
	int percent;
	
	public SelectSquarePercentController(LevelBuilder m, LevelBuilderApplication a, int percent)
	{
		this.model=m;
		this.application=a;
		this.percent=percent;
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
			double num = Double.parseDouble(tf.getText());
			SetSquarePercentMove m=new SetSquarePercentMove(model, num, tf, percent);
			if(m.doMove())
			{
				System.out.println("Percentage of "+(percent+1)+"s: "+model.getPercent(percent));
				model.recordMove(m);
			}
		} catch (Exception e) {
			tf.setText(""+model.getPercent(percent));
		}
		
	}
}
