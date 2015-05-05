package levelBuilderMoves;

import javax.swing.JTextField;

import levelBuilderEntity.LevelBuilder;

/**
 * Sets the max time
 * @author Kevin
 *
 */
public class SetTimeMove extends Move{
	/** model */
	LevelBuilder model;
	
	/** new value to be set */
	int newValue;
	
	/** old value */
	int oldValue;
	
	/** text field that gives the input */
	JTextField tf;
	
	/**
	 * Constructor
	 * @param model
	 * @param newValue
	 * @param tf
	 */
	public SetTimeMove(LevelBuilder model, int newValue, JTextField tf)
	{
		this.model=model;
		this.newValue=newValue;
		//this.oldValue=model.getMs();
		this.tf=tf;
	}

	/**
	 * checks to see if the move is valid
	 */
	@Override
	public boolean isValid() {
		return newValue>0;
	}

	/**
	 * does the move
	 */
	@Override
	public boolean doMove() {
		// TODO Auto-generated method stub
		if(!isValid()){return false;}
		model.setSeconds(newValue);
		tf.setText(""+model.getSeconds());
		return true;
	}

	/** 
	 * undoes the move
	 */
	@Override
	public boolean undo() {
		// TODO Auto-generated method stub
		model.setSeconds(oldValue);
		tf.setText(""+model.getSeconds());
		return true;
	}
}
