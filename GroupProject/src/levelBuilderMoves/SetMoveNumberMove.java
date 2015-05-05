package levelBuilderMoves;

import javax.swing.JTextField;

import levelBuilderEntity.LevelBuilder;

/**
 * Sets the move number
 * @author 
 *
 */
public class SetMoveNumberMove extends Move{
	
	/** LevelBuilder entity */
	LevelBuilder model;
	
	/** the new move number value */
	int newValue;
	
	/** the old move number value */
	int oldValue;
	
	/** the text field in which the move number was entered */
	JTextField tf;
	
	/**
	 * Constructor
	 * @param model LevelBuilder
	 * @param newValue int
	 * @param tf JTextField
	 */
	public SetMoveNumberMove(LevelBuilder model, int newValue, JTextField tf)
	{
		this.model=model;
		this.newValue=newValue;
		this.oldValue=model.getMoves();
		this.tf=tf;
	}

	/**
	 * Checks if the move is valid
	 */
	@Override
	public boolean isValid() {
		return newValue > 0;
	}

	/**
	 * Sets the move number in the model
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
	 * Undoes the move
	 */
	@Override
	public boolean undo() {
		// TODO Auto-generated method stub
		model.setMoves(oldValue);
		tf.setText(""+model.getMoves());
		return true;
	}
	
	public void setOldValue(int n)
	{
		oldValue=n;
	}
	
}
