package levelBuilderMoves;

import javax.swing.JTextField;

import levelBuilderEntity.LevelBuilder;

public class SetSquarePercentMove extends Move{
	LevelBuilder model;
	double newValue;
	double oldValue;
	JTextField tf;
	int percent;
	
	public SetSquarePercentMove(LevelBuilder model, double newValue, JTextField tf, int percent)
	{
		this.model=model;
		this.newValue=newValue;
		this.oldValue=model.getPercent(percent);
		this.tf=tf;
		this.percent=percent;
	}

	@Override
	public boolean isValid() {
		return newValue>=0 /*&& (model.getPercent(0)+model.getPercent(1)+model.getPercent(2)
				+model.getPercent(3)+model.getPercent(4)+model.getPercent(5))==100*/;
	}

	@Override
	public boolean doMove() {
		// TODO Auto-generated method stub
		if(!isValid()){return false;}
		model.setPercents(percent, newValue);
		tf.setText(""+model.getPercent(percent));
		return true;
	}

	@Override
	public boolean undo() {
		// TODO Auto-generated method stub
		model.setPercents(percent, oldValue);
		tf.setText(""+model.getPercent(percent));
		return true;
	}
}
