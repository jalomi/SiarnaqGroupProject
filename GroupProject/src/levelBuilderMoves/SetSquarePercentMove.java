package levelBuilderMoves;

import javax.swing.JTextArea;
import javax.swing.JTextField;

import levelBuilderEntity.LevelBuilder;

public class SetSquarePercentMove extends Move{
	LevelBuilder model;
	double newValue;
	double oldValue;
	JTextField tf;
	int squareNum;
	JTextArea ta;
	
	public SetSquarePercentMove(LevelBuilder model, double newValue, JTextField tf, int squareNum, JTextArea ta)
	{
		this.model=model;
		this.newValue=newValue;
		this.oldValue=model.getPercent(squareNum);
		this.tf=tf;
		this.squareNum=squareNum;
		this.ta=ta;
	}

	@Override
	public boolean isValid() {
		return newValue>=0 && newValue<=100; /*&& (model.getPercent(0)+model.getPercent(1)+model.getPercent(2)
				+model.getPercent(3)+model.getPercent(4)+model.getPercent(5))==100*/
	}

	@Override
	public boolean doMove() {
		// TODO Auto-generated method stub
		double sum=0;
		if(!isValid()){return false;}
		model.setPercents(squareNum, newValue);
		tf.setText(""+(model.getPercent(squareNum)*100));
		for(int i=0; i<5; i++)
		{
			sum+=model.getPercent(i);
		}
		model.setPercents(5, (1-sum)*100);
		ta.setText(""+(model.getPercent(5)*100));
		return true;
	}

	@Override
	public boolean undo() {
		// TODO Auto-generated method stub
		double sum=0;
		model.setPercents(squareNum, oldValue);
		tf.setText(""+(model.getPercent(squareNum)*100));
		for(int i=0; i<5; i++)
		{
			sum+=model.getPercent(i);
		}
		model.setPercents(5, (1-sum)*100);
		ta.setText(""+(model.getPercent(5)*100));
		return true;
	}
}
