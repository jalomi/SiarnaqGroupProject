package levelBuilderMoves;

import javax.swing.JComboBox;

import levelBuilderControllers.SelectLevelTypeController;
import levelBuilderEntity.LevelBuilder;

public class SetLevelTypeMove extends Move{
	/**
	 * Please change all the types to String
	 * Then you don't need switch cases!!!
	 * It's a bad idea to use int since you're doing the int-String matching anyway!!
	 */
	LevelBuilder model;
	String newValue;
	String oldValue;
	JComboBox<String> cb;
	SelectLevelTypeController controller;
	
	public SetLevelTypeMove(LevelBuilder model, String newValue, JComboBox<String> cb, SelectLevelTypeController c) {
		this.model = model;
		this.newValue = newValue;
		this.oldValue = model.getLevelType();
		this.cb=cb;
		this.controller=c;
	}

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

	@Override
	public boolean undo() {
		model.setLevelType(oldValue);
		cb.removeActionListener(controller);
		cb.setSelectedItem(oldValue);
		cb.addActionListener(controller);
		return true;
	}

}
