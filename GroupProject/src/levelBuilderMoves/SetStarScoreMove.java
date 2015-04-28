package levelBuilderMoves;

import javax.swing.JTextField;

import levelBuilderEntity.LevelBuilder;

public class SetStarScoreMove extends Move{

	LevelBuilder model;
	int newValue;
	int oldValue;
	JTextField tf;
	int star;
	
	public SetStarScoreMove(LevelBuilder model, int newValue, JTextField tf, int star)
	{
		this.model=model;
		this.newValue=newValue;
		this.oldValue=model.getStarScore(star);
		this.tf=tf;
		this.star=star;
	}

	@Override
	public boolean isValid() {
		return newValue>=0;
	}

	@Override
	public boolean doMove() {
		// TODO Auto-generated method stub
		if(!isValid()){return false;}
		model.setStarScore(star, newValue);
		tf.setText(""+model.getStarScore(star));
		return true;
	}

	@Override
	public boolean undo() {
		// TODO Auto-generated method stub
		model.setStarScore(star, oldValue);
		tf.setText(""+model.getStarScore(star));
		return true;
	}
	
}
