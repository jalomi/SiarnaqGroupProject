package levelBuilderControllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

import levelBuilderBoundary.LevelBuilderApplication;
import levelBuilderEntity.LevelBuilder;
import levelBuilderMoves.SetMultiplierPercentMove;

public class SelectMultiplierPercentController implements ActionListener{
	LevelBuilder model;
	LevelBuilderApplication application;
	int multiplier;
	
	public SelectMultiplierPercentController(LevelBuilder m, LevelBuilderApplication a, int multiplier)
	{
		this.model=m;
		this.application=a;
		this.multiplier=multiplier;
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
			SetMultiplierPercentMove m = new SetMultiplierPercentMove(model, num, tf, multiplier, application.getInputPanel().getPercentx1());
			if(m.doMove())
			{
				System.out.println("Percentage of x" + (multiplier+1) + "s: " + model.getPercentM(multiplier));
				model.recordMove(m);
			}
		} catch (Exception e) {
			tf.setText("" + model.getPercentM(multiplier));
		}
		
	}
}
