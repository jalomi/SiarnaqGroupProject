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
	
	public SetLevelTypeMove(LevelBuilder model, String newValue, JComboBox<String> cb, SelectLevelTypeController c)
	{
		this.model=model;
		this.newValue=newValue;
		this.oldValue=model.getLevelType();
		this.cb=cb;
		this.controller=c;
	}

	@Override
	public boolean isValid() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean doMove() {
		// TODO Auto-generated method stub
		if(!isValid()){return false;}
		switch(newValue)
		{
			case "Puzzle":
				System.out.println("Level Type: Puzzle");
				model.setLevelType(newValue);
				cb.removeActionListener(controller);
				cb.setSelectedItem("Puzzle");
				cb.addActionListener(controller);
				break;
			case "Lightning":
				System.out.println("Level Type: Lightning");
				model.setLevelType(newValue);
				cb.removeActionListener(controller);
				cb.setSelectedItem("Lightning");
				cb.addActionListener(controller);
				break;
			case "Elimination":
				System.out.println("Level Type: Elimination");
				model.setLevelType(newValue);
				cb.removeActionListener(controller);
				cb.setSelectedItem("Elimination");
				cb.addActionListener(controller);
				break;
			case "Release":
				System.out.println("Level Type: Release");
				model.setLevelType(newValue);
				cb.removeActionListener(controller);
				cb.setSelectedItem("Release");
				cb.addActionListener(controller);
				break;
		}
		return true;
	}

	@Override
	public boolean undo() {
		// TODO Auto-generated method stub
		switch(oldValue)
		{
//			case 1:
//				model.setLevelType(1);
//				cb.removeActionListener(controller);
//				cb.setSelectedItem("Puzzle");
//				cb.addActionListener(controller);
//				break;
//			case 2:
//				model.setLevelType(2);
//				cb.removeActionListener(controller);
//				cb.setSelectedItem("Lightning");
//				cb.addActionListener(controller);
//				break;
//			case 3:
//				model.setLevelType(3);
//				cb.removeActionListener(controller);
//				cb.setSelectedItem("Elimination");
//				cb.addActionListener(controller);
//				break;
//			case 4:
//				model.setLevelType(4);
//				cb.removeActionListener(controller);
//				cb.setSelectedItem("Release");
//				cb.addActionListener(controller);
//				break;
		}
		return true;
	}

}
