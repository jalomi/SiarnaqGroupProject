package levelBuilderMoves;

import javax.swing.JTextField;

import levelBuilderEntity.LevelBuilder;

public class SetMoveNumberMove extends Move{
	LevelBuilder model;
	int newValue;
	int oldValue;
	JTextField tf;
	
	public SetMoveNumberMove(LevelBuilder model, int newValue, int oldValue, JTextField tf)
	{
		this.model=model;
		this.newValue=newValue;
		this.oldValue=oldValue;
		this.tf=tf;
	}

	@Override
	public boolean isValid() {
		return true;
	}

	@Override
	public boolean doMove() {
		// TODO Auto-generated method stub
		model.setMoves(newValue);
		tf.setText(""+model.getMoves());
		return true;
	}

	@Override
	public boolean undo() {
		// TODO Auto-generated method stub
		model.setMoves(oldValue);
		tf.setText(""+model.getMoves());
		return true;
	}
	
}
