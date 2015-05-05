package levelBuilderMoves;

import javax.swing.JTextArea;
import javax.swing.JTextField;

import levelBuilderEntity.LevelBuilder;

/**
 * sets the percentage for a square value
 * @author Kevin
 *
 */
public class SetSquarePercentMove extends Move{
	/** model */
	LevelBuilder model;
	
	/** new value to be set */
	double newValue;
	
	/** the old value */
	double oldValue;
	
	/** the text field to get the input */
	JTextField tf;
	
	/** the square value being adjusted */
	int squareNum;
	
	/** text area to display percentage for 6 squares */
	JTextArea ta;
	
	/**
	 * Constructor
	 * @param model
	 * @param newValue
	 * @param tf
	 * @param squareNum
	 * @param ta
	 */
	public SetSquarePercentMove(LevelBuilder model, double newValue, JTextField tf, int squareNum, JTextArea ta)
	{
		this.model=model;
		this.newValue=newValue;
		this.oldValue=model.getPercent(squareNum);
		this.tf=tf;
		this.squareNum=squareNum;
		this.ta=ta;
	}

	/**
	 * checks to see if the move is valid
	 */
	@Override
	public boolean isValid() {
		double sum=newValue/100;
		for(int i = 0; i < 5; i++){
			sum += model.getPercent(i);
		}
		
		sum -= model.getPercent(squareNum);
		
		try
		{
			if(sum>1)
				throw new IllegalArgumentException("percent for 6s negative");
		} catch(IllegalArgumentException iae){
			tf.setText("" + (model.getPercent(squareNum) * 100));
		}
		
		return newValue >= 0 && newValue <= 100 && sum <= 1;
	}

	/**
	 * does the move
	 */
	@Override
	public boolean doMove() {
		// TODO Auto-generated method stub
		double sum = 0;
		
		if(!isValid()){return false;}
		
		model.setPercents(squareNum, newValue);
		tf.setText("" + (model.getPercent(squareNum) * 100));
		
		for(int i = 0; i < 5; i++){
			sum += model.getPercent(i);
		}
		model.setPercents(5, (1-sum) * 100);
		ta.setText("" + (model.getPercent(5) * 100));
		
		return true;
	}

	/**
	 * undoes the move
	 */
	@Override
	public boolean undo() {
		// TODO Auto-generated method stub
		double sum=0;
		model.setPercents(squareNum, oldValue*100);
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
