package levelBuilderMoves;

import javax.swing.JTextArea;
import javax.swing.JTextField;

import levelBuilderEntity.LevelBuilder;
import levelBuilderMoves.Move;

/**
 * sets the multipier percentages
 * @author Kevin
 *
 */
public class SetMultiplierPercentMove extends Move{
	/** model */
	LevelBuilder model;
	
	/** the new value to be set */
	double newValue;
	
	/** the old value */
	double oldValue;
	
	/** text field to get the input */
	JTextField tf;
	
	/** the multiplier being changed */
	int multiplierNum;
	
	/** the text area to display 1 star percentage */
	JTextArea ta;

	/**
	 * Constructor
	 * @param model
	 * @param newValue
	 * @param tf
	 * @param multiplierNum
	 * @param ta
	 */
	public SetMultiplierPercentMove(LevelBuilder model, double newValue, JTextField tf, int multiplierNum, JTextArea ta)
	{
		this.model=model;
		this.newValue=newValue;
		this.oldValue=model.getPercentM(multiplierNum);
		this.tf=tf;
		this.multiplierNum=multiplierNum;
		this.ta=ta;
	}

	/**
	 * checks to see if the move is valid
	 */
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

	/**
	 * do the move
	 */
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

	/**
	 * undo the move
	 */
	@Override
	public boolean undo() {
		// TODO Auto-generated method stub
		double sum=0;
		model.setPercentM(multiplierNum, oldValue*100);
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

