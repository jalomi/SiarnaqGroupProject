package levelBuilderMoves;

import javax.swing.JComboBox;

import levelBuilderControllers.SelectLevelTypeController;
import levelBuilderEntity.LevelBuilder;

/** 
 * Sets the level type
 * @author 
 *
 */
public class SetLevelTypeMove extends Move{
	
	/** LevelBuilder entity */
	LevelBuilder model;
	
	/** the new value of the level type */
	String newValue;
	
	/** the olds value of the level type */
	String oldValue;
	
	/**  */
	JComboBox<String> cb;
	
	/** the controller for selecting level types */
	SelectLevelTypeController controller;
	
	/**
	 * Constructor
	 * @param model LevelBuilder
	 * @param newValue String
	 * @param cb JComboBox<String>
	 * @param c SelectLevelTypeController
	 */
	public SetLevelTypeMove(LevelBuilder model, String newValue, JComboBox<String> cb, SelectLevelTypeController c) {
		this.model = model;
		this.newValue = newValue;
		this.oldValue = model.getLevelType();
		this.cb=cb;
		this.controller=c;
	}

	/**
	 * Checks if move is valid
	 */
	@Override
	public boolean isValid() {
		if(newValue.equals("Puzzle") || newValue.equals("Release") 
				|| newValue.equals("Elimination")
				|| newValue.equals("Lightning")) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Assigns new level type
	 */
	@Override
	public boolean doMove() {
		// TODO Auto-generated method stub
		if(!isValid()){return false;}
		
		System.out.println("new value: " + newValue);
		model.setLevelType(newValue);
		cb.removeActionListener(controller);
		cb.setSelectedItem(newValue);
		cb.addActionListener(controller);
		return true;
	}

	/**
	 * Undoes the move
	 */
	@Override
	public boolean undo() {
		model.setLevelType(oldValue);
		cb.removeActionListener(controller);
		cb.setSelectedItem(oldValue);
		cb.addActionListener(controller);
		return true;
	}

}
