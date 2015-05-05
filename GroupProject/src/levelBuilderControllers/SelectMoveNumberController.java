package levelBuilderControllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

import levelBuilderBoundary.LevelBuilderApplication;
import levelBuilderEntity.LevelBuilder;
import levelBuilderMoves.SetMoveNumberMove;

/**
 * Controller that inputs number of moves for the game in Level Builder
 * @author Kevin
 *
 */
public class SelectMoveNumberController implements ActionListener{
	
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
	public SelectMoveNumberController(LevelBuilder m, LevelBuilderApplication a)
	{
		this.model=m;
		this.application=a;
	}
	
	/**
	 * Handles entering a number into the text field
	 */
	@Override
	public void actionPerformed(ActionEvent ae)
	{
		System.out.println(model.getMoves());
		JTextField tf=(JTextField)ae.getSource();
		update(tf);
	}
	
	/**
	 * Updates the text field and the number of moves (or throws exception)
	 * @param tf
	 */
	public void update(JTextField tf)
	{
		try{
			int num = Integer.valueOf(tf.getText());
			SetMoveNumberMove m=new SetMoveNumberMove(model, num, application.getInputPanel().getMaxMoves());
			if(m.doMove())
			{
				if(model.getLevelType().equals("Release")){
					if((model.getLevelNumber()>0 || model.getMoves()>0)&&model.getPercent(5)<1){
						application.getGenerateBtn().setEnabled(true);
						application.getPreviewBtn().setEnabled(true);
					}
				}
				else{
					if(model.getLevelNumber()>0 || model.getMoves()>0){
						application.getGenerateBtn().setEnabled(true);
						application.getPreviewBtn().setEnabled(true);
					}
				}
				System.out.println("Number of Moves: "+model.getMoves());
				model.recordMove(m);
			}
		} catch (Exception e) {
			tf.setText(""+model.getMoves());
		}
		
	}

}
