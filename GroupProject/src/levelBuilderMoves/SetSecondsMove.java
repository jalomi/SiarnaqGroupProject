package levelBuilderMoves;

import javax.swing.JTextField;

import levelBuilderEntity.LevelBuilder;

public class SetSecondsMove extends Move{
	LevelBuilder model;
	int newValue;
	int oldValue;
	JTextField tf;
	
	public SetSecondsMove(LevelBuilder model, int newValue, JTextField tf)
	{
		this.model=model;
		this.newValue=newValue;
		this.oldValue=model.getSeconds();
		this.tf=tf;
	}

	@Override
	public boolean isValid() {
		return newValue>0;
	}

	@Override
	public boolean doMove() {
		// TODO Auto-generated method stub
		if(!isValid()){return false;}
		model.setSeconds(newValue);
		tf.setText(""+model.getSeconds());
		return true;
	}

	@Override
	public boolean undo() {
		// TODO Auto-generated method stub
		model.setSeconds(oldValue);
		tf.setText(""+model.getSeconds());
		return true;
	}
}
