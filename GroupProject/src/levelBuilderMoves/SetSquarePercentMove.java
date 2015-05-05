package levelBuilderMoves;

import javax.swing.JTextArea;
import javax.swing.JTextField;

import levelBuilderEntity.LevelBuilder;

/**
 * Sets the percentages of each square
 * @author 
 *
 */
public class SetSquarePercentMove extends Move{
	
	/** LevelBuilder entity */
	LevelBuilder model;
	
	/** new value of percentage */
	double newValue;
	
	/** old value of percentage */
	double oldValue;
	
	/** text field in which the percentage is entered */
	JTextField tf;
	
	/** which square percentage is being altered */
	int squareNum;
	JTextArea ta;
	
	/**
	 * Constructor
	 * @param model LevelBuilder
	 * @param newValue double
	 * @param tf JTextField
	 * @param squareNum int
	 * @param ta JTextArea
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
	 * Checks if the move is valid
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
	 * Sets the percentages of the squares
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
	 * Undoes the move
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
