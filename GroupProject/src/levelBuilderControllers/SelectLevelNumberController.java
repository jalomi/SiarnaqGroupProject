package levelBuilderControllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

import levelBuilderBoundary.LevelBuilderApplication;
import levelBuilderEntity.LevelBuilder;
import levelBuilderMoves.SetLevelNumberMove;

/**
 * Controller that inputs a level number for the game in Level Builder
 * @author Kevin
 *
 */
public class SelectLevelNumberController implements ActionListener{
	
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
	public SelectLevelNumberController(LevelBuilder m, LevelBuilderApplication a)
	{
		this.model=m;
		this.application=a;
	}
	
	/**
	 * Handles entering a number into the text field
	 */
	@Override
	public void actionPerformed(ActionEvent ae) {
		JTextField tf=(JTextField)ae.getSource();
		update(tf);
	}
	
	/**
	 * Updates text field and level number value (or throws exception)
	 * @param tf
	 */
	public void update(JTextField tf) {
		try {
			int num = Integer.valueOf(tf.getText());
			System.out.println("TAG:::::" + "num");
			SetLevelNumberMove m=new SetLevelNumberMove(model, num, tf);
			if(m.doMove())
			{
				System.out.println("Number of Level: "+model.getLevelNumber());
				model.recordMove(m);
				if(model.getLevelNumber()>0 && model.getMoves()>0){
					application.getGenerateBtn().setEnabled(true);
					application.getPreviewBtn().setEnabled(true);
				}
			}
		} catch (Exception e) {
			tf.setText(""+model.getLevelNumber());
		}
		
	}
}
