package levelBuilderMoves;

import javax.swing.JCheckBox;

import levelBuilderEntity.LevelBuilder;

/**
 * Toggles the special move enable
 * @author 
 *
 */
public class SpecialMoveEnableMove extends Move{
	
	/** LevelBuilder entity */
	LevelBuilder model;
	
	/** current state of the enable */
	boolean state;
	
	/** checkbox toggled */
	JCheckBox ch;
	
	/** the number of the special move */
	int moveID;
	
	/** the old state of the enable */
	boolean oldState;
	
	/**
	 * Constructor
	 * @param m LevelBuilder
	 * @param e boolean
	 * @param ch JCheckBox
	 * @param moveID int
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
	 * Checks if the move is valid
	 */
	@Override
	public boolean isValid() {
		// TODO Auto-generated method stub
		return true;
	}

	/**
	 * Toggles the enable for the special move
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
	 * Undoes the move
	 */
	@Override
	public boolean undo() {
		// TODO Auto-generated method stub
		model.setSpecialEnabled(moveID, oldState);
		ch.setSelected(model.getSpecialEnabled(moveID));
		return true;
	}
}
