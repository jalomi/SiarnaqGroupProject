package levelBuilderMoves;

import javax.swing.JTextField;

import levelBuilderEntity.LevelBuilder;

public class SetMinutesMove extends Move{
	LevelBuilder model;
	int newValue;
	int oldValue;
	JTextField tf;
	
	public SetMinutesMove(LevelBuilder model, int newValue, JTextField tf)
	{
		this.model=model;
		this.newValue=newValue;
		this.oldValue=model.getMinutes();
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
		model.setMinutes(newValue);
		tf.setText(""+model.getMinutes());
		return true;
	}

	@Override
	public boolean undo() {
		// TODO Auto-generated method stub
		model.setMinutes(oldValue);
		tf.setText(""+model.getMinutes());
		return true;
	}
}
