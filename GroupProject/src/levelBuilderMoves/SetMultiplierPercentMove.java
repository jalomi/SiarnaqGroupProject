package levelBuilderMoves;

import javax.swing.JTextArea;
import javax.swing.JTextField;

import levelBuilderEntity.LevelBuilder;
import levelBuilderMoves.Move;

public class SetMultiplierPercentMove extends Move{

		LevelBuilder model;
		double newValue;
		double oldValue;
		JTextField tf;
		int multiplierNum;
		JTextArea ta;
		
		public SetMultiplierPercentMove(LevelBuilder model, double newValue, JTextField tf, int multiplierNum, JTextArea ta)
		{
			this.model=model;
			this.newValue=newValue;
			this.oldValue=model.getPercentM(multiplierNum);
			this.tf=tf;
			this.multiplierNum=multiplierNum;
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
			int sum=0;
			if(!isValid()){return false;}
			model.setPercentM(multiplierNum, newValue);
			tf.setText(""+model.getPercentM(multiplierNum));
			for(int i=1; i<3; i++)
			{
				sum+=model.getPercentM(i);
			}
			model.setPercentM(0, 100-sum);
			ta.setText(""+model.getPercentM(0));
			return true;
		}

		@Override
		public boolean undo() {
			// TODO Auto-generated method stub
			int sum=0;
			model.setPercentM(multiplierNum, oldValue);
			tf.setText(""+model.getPercentM(multiplierNum));
			for(int i=1; i<3; i++)
			{
				sum+=model.getPercentM(i);
			}
			model.setPercentM(0, 100-sum);
			ta.setText(""+model.getPercentM(0));
			return true;
		}
}

