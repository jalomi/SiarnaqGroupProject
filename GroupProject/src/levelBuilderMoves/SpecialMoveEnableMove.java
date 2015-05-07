package levelBuilderMoves;

import javax.swing.JCheckBox;

import levelBuilderEntity.LevelBuilder;

/**
 * enables or disables special moves
 * @author Kevin
 *
 */
public class SpecialMoveEnableMove extends Move{
	/** model */
	LevelBuilder model;
	
	/** state of the special move */
	boolean state;
	
	/** checkbox element */
	JCheckBox ch;
	
	/** the move ID */
	int moveID;
	
	/** old state of the flag */
	boolean oldState;
	
	/**
	 * Constructor
	 * @param m
	 * @param e
	 * @param ch
	 * @param moveID
	 */
	public SpecialMoveEnableMove(LevelBuilder m, boolean e, JCheckBox ch, int moveID)
	{
		this.model=m;
		this.state=e;
		this.ch=ch;
		this.moveID=moveID;
		this.oldState=model.getSpecialEnabled(moveID);
		
	}

	/**
	 * checks to see if it is valid
	 */
	@Override
	public boolean isValid() {
		return true;
	}

	/**
	 * does the move
	 */
	@Override
	public boolean doMove() {
		// TODO Auto-generated method stub
		if(!isValid()){return false;}
		
		if(state==true)
		{
			model.allowSpecials(moveID);
			ch.setSelected(true);
		}
		else
		{
			model.disallowSpecials(moveID);
			ch.setSelected(false);
		}
			
		return true;
	}

	/**
	 * undoes the move
	 */
	@Override
	public boolean undo() {
		// TODO Auto-generated method stub
		model.setSpecialEnabled(moveID, oldState);
		ch.setSelected(model.getSpecialEnabled(moveID));
		return true;
	}
}
