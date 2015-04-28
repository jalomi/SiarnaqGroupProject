package levelBuilderControllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

import levelBuilderBoundary.LevelBuilderApplication;
import levelBuilderEntity.LevelBuilder;
import levelBuilderMoves.SetSquarePercentMove;

public class SelectSquarePercentController implements ActionListener{
	LevelBuilder model;
	LevelBuilderApplication application;
	int square;
	
	public SelectSquarePercentController(LevelBuilder m, LevelBuilderApplication a, int square)
	{
		this.model=m;
		this.application=a;
		this.square=square;
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
			SetSquarePercentMove m=new SetSquarePercentMove(model, num, tf, square, application.getInputPanel().getPercent6());
			if(m.doMove())
			{
				System.out.println("Percentage of "+(square+1)+"s: "+model.getPercent(square));
				model.recordMove(m);
			}
		} catch (Exception e) {
			tf.setText(""+model.getPercent(square));
		}
		
	}
}
