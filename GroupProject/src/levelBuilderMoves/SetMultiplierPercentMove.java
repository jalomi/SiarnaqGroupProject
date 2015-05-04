package levelBuilderMoves;

import javax.swing.JTextArea;
import javax.swing.JTextField;

import levelBuilderEntity.LevelBuilder;
import levelBuilderMoves.Move;

/**
 * Sets a multiplier percentage
 * @author 
 *
 */
public class SetMultiplierPercentMove extends Move{

	/** LevelBuilder entity */
	LevelBuilder model;
	
	/** the new percentage */
	double newValue;
	
	/** the old percentage */
	double oldValue;
	
	/** the text field in which the percentage was entered */
	JTextField tf;
	
	/** which percentage is being altered */
	int multiplierNum;
	
	/** percentage for normal tiles */
	JTextArea ta;

	/**
	 * Constructor
	 * @param model LevelBuilder
	 * @param newValue double
	 * @param tf JTextField
	 * @param multiplierNum int
	 * @param ta JTextArea
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
	 * Checks if the move is valid
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
	 * Sets the multiplier percentages
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
	 * Undoes the move
	 */
	@Override
	public boolean undo() {
		double sum = 0;
		
		model.setPercentM(multiplierNum, oldValue * 100);
		tf.setText("" + (model.getPercentM(multiplierNum) * 100));
		
		for(int i = 1; i < 3; i++){
			sum+=model.getPercentM(i);
		}
		
		model.setPercentM(0, (1 - sum) * 100);
		ta.setText("" + (model.getPercentM(0) * 100));
		
		return true;
	}
}

