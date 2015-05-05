package levelBuilderMoves;

import javax.swing.JTextField;

import levelBuilderEntity.LevelBuilder;

/**
 * Sets the max moves
 * @author Kevin
 *
 */
public class SetMoveNumberMove extends Move{
	/** model */
	LevelBuilder model;
	
	/** new move amount */
	int newValue;
	
	/** old move amount */
	int oldValue;
	
	/** text field to show info */
	JTextField tf;
	
	/**
	 * Constructor
	 * @param model
	 * @param newValue
	 * @param tf
	 */
	public SetMoveNumberMove(LevelBuilder model, int newValue, JTextField tf)
	{
		this.model=model;
		this.newValue=newValue;
		this.oldValue=model.getMoves();
		this.tf=tf;
	}

	/**
	 * check to see if valid
	 */
	@Override
	public boolean isValid() {
		return newValue > 0;
	}

	/**
	 * do the move
	 */
	@Override
	public boolean doMove() {
		// TODO Auto-generated method stub
		if(!isValid()){return false;}
		model.setMoves(newValue);
		tf.setText(""+model.getMoves());
		return true;
	}

	/**
	 * undo the move
	 */
	@Override
	public boolean undo() {
		// TODO Auto-generated method stub
		model.setMoves(oldValue);
		tf.setText(""+model.getMoves());
		return true;
	}
	
	/**
	 * change the old value
	 * @param n
	 */
	public void setOldValue(int n)
	{
		oldValue=n;
	}
	
}
