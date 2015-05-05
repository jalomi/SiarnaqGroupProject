package levelBuilderControllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

import levelBuilderBoundary.LevelBuilderApplication;
import levelBuilderEntity.LevelBuilder;
import levelBuilderMoves.SetTimeMove;

/**
 * Controller that inputs the remaining time for the game in Level Builder
 * @author Kevin
 *
 */
public class SelectSecondsController implements ActionListener{
	/*This controller should be either removed or rewritten
	 * We only need one SetTimeController!!!*/
	
	/**
	 * the Level Builder entity
	 */
	LevelBuilder model;
	
	/**
	 * the Level Builder application
	 */
	LevelBuilderApplication application;
	
	/**
	 * Constructor
	 * Creates the controller based on the entity and application
	 * @param m
	 * @param a
	 */
	public SelectSecondsController(LevelBuilder m, LevelBuilderApplication a)
	{
		this.model=m;
		this.application=a;
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
	 * Updates text field and number of seconds remaining (or throws exception)
	 * @param tf
	 */
	public void update(JTextField tf)
	{
		try{
			int num = Integer.valueOf(tf.getText());
			SetTimeMove m=new SetTimeMove(model, num, tf);
			if(m.doMove())
			{
				System.out.println("Number of Seconds: "+model.getSeconds());
				model.recordMove(m);
			}
		} catch (Exception e) {
			tf.setText(""+model.getSeconds());
		}
		
	}
}
