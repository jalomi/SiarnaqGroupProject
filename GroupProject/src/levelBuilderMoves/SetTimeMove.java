package levelBuilderMoves;

import javax.swing.JTextField;

import levelBuilderEntity.LevelBuilder;

/**
 * Sets the time for lightning
 * @author 
 *
 */
public class SetTimeMove extends Move{
	
	/** LevelBuilder entity */
	LevelBuilder model;
	
	/** value of the new time */
	int newValue;
	
	/** value of the old time */
	int oldValue;
	
	/** text field in which the time was entered */
	JTextField tf;
	
	/**
	 * Constructor
	 * @param model LevelBuilder
	 * @param newValue int
	 * @param tf JTextField
	 */
	public SetTimeMove(LevelBuilder model, int newValue, JTextField tf)
	{
		this.model=model;
		this.newValue=newValue;
		//this.oldValue=model.getMs();
		this.tf=tf;
	}

	/**
	 * Checks if the move is valid
	 */
	@Override
	public boolean isValid() {
		return newValue>0;
	}

	/**
	 * Sets the time
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
	 * Undoes the move
	 */
	@Override
	public boolean undo() {
		// TODO Auto-generated method stub
		model.setSeconds(oldValue);
		tf.setText(""+model.getSeconds());
		return true;
	}
}
