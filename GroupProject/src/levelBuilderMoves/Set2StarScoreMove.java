package levelBuilderMoves;

import javax.swing.JTextField;

import levelBuilderEntity.LevelBuilder;

public class Set2StarScoreMove extends Move{
	LevelBuilder model;
	int newValue;
	int oldValue;
	JTextField tf;
	
	public Set2StarScoreMove(LevelBuilder model, int newValue, int oldValue, JTextField tf)
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
		model.setStarScore(2, newValue);
		tf.setText(""+model.getTwoStarScore());
		return true;
	}

	@Override
	public boolean undo() {
		// TODO Auto-generated method stub
		model.setStarScore(2, oldValue);
		tf.setText(""+model.getTwoStarScore());
		return true;
	}
	
}
