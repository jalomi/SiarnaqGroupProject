package levelBuilderMoves;

import javax.swing.JTextField;

import levelBuilderEntity.LevelBuilder;

public class SetLevelNumberMove extends Move{
	LevelBuilder model;
	int newValue;
	int oldValue;
	JTextField tf;
	
	public SetLevelNumberMove(LevelBuilder model, int newValue, JTextField tf)
	{
		this.model=model;
		this.newValue=newValue;
		this.oldValue=model.getLevelNumber();
		this.tf=tf;
	}

	@Override
	public boolean isValid() {
		return newValue > 0;
	}

	@Override
	public boolean doMove() {
		// TODO Auto-generated method stub
		if(!isValid()){return false;}
		model.setLevelNumber(newValue);
		tf.setText(""+model.getLevelNumber());
		return true;
	}

	@Override
	public boolean undo() {
		// TODO Auto-generated method stub
		model.setLevelNumber(oldValue);
		tf.setText(""+model.getLevelNumber());
		return true;
	}
}
