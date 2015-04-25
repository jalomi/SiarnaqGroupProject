package levelBuilderMoves;

import javax.swing.JTextField;

import levelBuilderEntity.LevelBuilder;

public class Set3StarScoreMove extends Move{
	LevelBuilder model;
	int newValue;
	int oldValue;
	JTextField tf;
	
	public Set3StarScoreMove(LevelBuilder model, int newValue, int oldValue, JTextField tf)
	{
		this.model=model;
		this.newValue=newValue;
		this.oldValue=oldValue;
		this.tf=tf;
	}

	@Override
	public boolean isValid() {
		return newValue>=0;
	}

	@Override
	public boolean doMove() {
		// TODO Auto-generated method stub
		if(!isValid()){return false;}
		model.setStarScore(3, newValue);
		tf.setText(""+model.getThreeStarScore());
		return true;
	}

	@Override
	public boolean undo() {
		// TODO Auto-generated method stub
		model.setStarScore(3, oldValue);
		tf.setText(""+model.getThreeStarScore());
		return true;
	}
	
}
