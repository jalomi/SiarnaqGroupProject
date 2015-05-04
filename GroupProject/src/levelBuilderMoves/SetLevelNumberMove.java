package levelBuilderMoves;

import javax.swing.JTextField;

import levelBuilderEntity.LevelBuilder;

/**
 * Sets the level number
 * @author 
 *
 */
public class SetLevelNumberMove extends Move{
	
	/** LevelBuilder entity */
	LevelBuilder model;
	
	/** the new level number */
	int newValue;
	
	/** the old level number */
	int oldValue;
	
	/** the text field which the level number is entered into */
	JTextField tf;
	
	/**
	 * Constructor
	 * @param model LevelBuilder
	 * @param newValue in
	 * @param tf JTextField
	 */
	public SetLevelNumberMove(LevelBuilder model, int newValue, JTextField tf)
	{
		this.model=model;
		this.newValue=newValue;
		this.oldValue=model.getLevelNumber();
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
	 * Sets the level number in the LevelBuilder entity
	 */
	@Override
	public boolean doMove() {
		// TODO Auto-generated method stub
		if(!isValid()){return false;}
		model.setLevelNumber(newValue);
		tf.setText(""+model.getLevelNumber());
		return true;
	}

	/**
	 * Undoes the move
	 */
	@Override
	public boolean undo() {
		// TODO Auto-generated method stub
		model.setLevelNumber(oldValue);
		tf.setText(""+model.getLevelNumber());
		return true;
	}
}
