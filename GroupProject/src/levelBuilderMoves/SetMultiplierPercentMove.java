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
			double sum = newValue/100;
			for(int i = 1; i < 3; i++)
			{
				sum += model.getPercentM(i);
			}
			sum -= model.getPercentM(multiplierNum);
			
			try
			{
				if(sum > 1)
					throw new IllegalArgumentException("percent for x1s negative");
			} catch(IllegalArgumentException iae){
				tf.setText("" + (model.getPercentM(multiplierNum) * 100));
			}
			
			return newValue >= 0 && newValue <= 100 && sum <= 1;
		}

		@Override
		public boolean doMove() {
			double sum = 0;
			
			if(!isValid()){return false;}
			
			model.setPercentM(multiplierNum, newValue);
			tf.setText("" + (model.getPercentM(multiplierNum) * 100));
			
			for(int i = 1; i < 3; i++){
				sum += model.getPercentM(i);
			}
			
			model.setPercentM(0, (1 - sum) * 100);
			ta.setText("" + (model.getPercentM(0) * 100));
						
			return true;
		}

		@Override
		public boolean undo() {
			// TODO Auto-generated method stub
			double sum=0;
			model.setPercentM(multiplierNum, oldValue);
			tf.setText(""+(model.getPercentM(multiplierNum)*100));
			for(int i=1; i<3; i++)
			{
				sum+=model.getPercentM(i);
			}
			model.setPercentM(0, (1-sum)*100);
			ta.setText(""+(model.getPercentM(0)*100));
			return true;
		}
}

