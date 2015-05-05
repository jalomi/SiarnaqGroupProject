package levelBuilderControllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

import levelBuilderBoundary.LevelBuilderApplication;
import levelBuilderEntity.LevelBuilder;
import levelBuilderMoves.SetStarScoreMove;

/**
 * Controller that inputs a star score for the game in Level Builder
 * @author Kevin
 *
 */
public class SelectStarScoreController implements ActionListener {
	
	/**
	 * the Level Builder entity
	 */
	LevelBuilder model;
	
	/**
	 * the Level Builder model
	 */
	LevelBuilderApplication application;
	
	/**
	 * the star number of the score being changed
	 */
	int star;
	
	/**
	 * Constructor
	 * Creates the controller based on the entity, application, and star number
	 * @param m
	 * @param a
	 * @param star
	 */
	public SelectStarScoreController(LevelBuilder m, LevelBuilderApplication a, int star)
	{
		this.model=m;
		this.application=a;
		this.star=star;
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
	 * Updates text field and star score value (or throws exception)
	 * @param tf
	 */
	public void update(JTextField tf)
	{
		try{
			int num = Integer.valueOf(tf.getText());
			SetStarScoreMove m=null;
			if(star==0)
			{
				m =new SetStarScoreMove(model, num, application.getInputPanel().getScore1(), star);
			}
			else if(star==1)
			{
				m =new SetStarScoreMove(model, num, application.getInputPanel().getScore2(), star);
			}
			else
			{
				m =new SetStarScoreMove(model, num, application.getInputPanel().getScore3(), star);
			}
			
			if(m.doMove())
			{
				System.out.println((star+1)+" Star Score: "+model.getStarScore(star));
				model.recordMove(m);
			}
		} catch (Exception e) {
			tf.setText("TAG " + model.getStarScore(star));
		}
		
	}
}
