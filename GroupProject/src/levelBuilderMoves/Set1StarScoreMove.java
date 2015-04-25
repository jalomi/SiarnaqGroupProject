package levelBuilderMoves;

import javax.swing.JTextField;

import levelBuilderEntity.LevelBuilder;

public class Set1StarScoreMove extends Move{

	LevelBuilder model;
	int newValue;
	int oldValue;
	JTextField tf;
	
	public Set1StarScoreMove(LevelBuilder model, int newValue, JTextField tf)
	{
		this.model=model;
		this.newValue=newValue;
		this.oldValue=model.getOneStarScore();
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
		model.setStarScore(1, newValue);
		tf.setText(""+model.getOneStarScore());
		return true;
	}

	@Override
	public boolean undo() {
		// TODO Auto-generated method stub
		model.setStarScore(1, oldValue);
		tf.setText(""+model.getOneStarScore());
		return true;
	}
	
}
