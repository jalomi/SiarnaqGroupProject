package levelBuilderControllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

import levelBuilderBoundary.LevelBuilderApplication;
import levelBuilderEntity.LevelBuilder;
import levelBuilderMoves.SetMultiplierPercentMove;

/**
 * Controller that inputs a multiplier percent for the game in Level Builder
 * @author Kevin
 *
 */
public class SelectMultiplierPercentController implements ActionListener{
	
	/**
	 * the Level Builder entity
	 */
	LevelBuilder model;
	
	/**
	 * the Level Builder application
	 */
	LevelBuilderApplication application;
	
	/**
	 * the number of the multiplier type being set
	 */
	int multiplier;
	
	/**
	 * Constructor
	 * Creates the controller based on the entity, the application, and the multiplier number
	 * @param m
	 * @param a
	 * @param multiplier
	 */
	public SelectMultiplierPercentController(LevelBuilder m, LevelBuilderApplication a, int multiplier)
	{
		this.model=m;
		this.application=a;
		this.multiplier=multiplier;
	}
	
	/**
	 * Handles entering number into text field
	 */
	@Override
	public void actionPerformed(ActionEvent ae)
	{
		JTextField tf=(JTextField)ae.getSource();
		update(tf);
	}
	
	/**
	 * Updates text field and multiplier number (or throws exception)
	 * @param tf
	 */
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
