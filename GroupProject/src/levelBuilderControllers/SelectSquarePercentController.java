package levelBuilderControllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

import levelBuilderBoundary.LevelBuilderApplication;
import levelBuilderEntity.LevelBuilder;
import levelBuilderMoves.SetSquarePercentMove;

/**
 * Controller that inputs a square percent for the game in Level Builder
 * @author Kevin
 *
 */
public class SelectSquarePercentController implements ActionListener{
	/**
	 * the Level Builder entity
	 */
	LevelBuilder model;
	
	/**
	 * the Level Builder application
	 */
	LevelBuilderApplication application;
	
	/**
	 * the number of the square type being set
	 */
	int square;
	
	/**
	 * Constructor
	 * Creates the controller based on the entity, application, and square number
	 * @param m
	 * @param a
	 * @param square
	 */
	public SelectSquarePercentController(LevelBuilder m, LevelBuilderApplication a, int square)
	{
		this.model=m;
		this.application=a;
		this.square=square;
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
	 * Updates text field and square percent value (or throws exception)
	 * @param tf
	 */
	public void update(JTextField tf)
	{
		try{
			double num = Double.parseDouble(tf.getText());
			SetSquarePercentMove m=new SetSquarePercentMove(model, num, tf, square, application.getInputPanel().getPercent6());
			if(m.doMove())
			{	
				
				System.out.println("Percentage of "+(square+1)+"s: "+model.getPercent(square));
				model.recordMove(m);
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
			}
		} catch (Exception e) {
			tf.setText("" + model.getPercent(square));
		}
		
	}
}
