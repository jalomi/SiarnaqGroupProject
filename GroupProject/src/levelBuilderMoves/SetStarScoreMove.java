package levelBuilderMoves;

import javax.swing.JTextField;

import levelBuilderEntity.LevelBuilder;

/**
 * sets scores needed to get each star rank
 * @author Kevin
 *
 */
public class SetStarScoreMove extends Move{
	/** model */
	LevelBuilder model;
	
	/** new value to be set */
	int newValue;
	
	/** the old value */
	int oldValue;
	
	/** text field that gives the input */
	JTextField tf;
	
	/** star number */
	int star;
	
	/**
	 * Constructor
	 * @param model
	 * @param newValue
	 * @param tf
	 * @param star
	 */
	public SetStarScoreMove(LevelBuilder model, int newValue, JTextField tf, int star)
	{
		this.model=model;
		this.newValue=newValue;
		this.oldValue=model.getStarScore(star);
		this.tf=tf;
		this.star=star;
	}

	/**
	 * checks to see if the move is valid
	 */
	@Override
	public boolean isValid() {
		if(star==0)
			try
			{
				if((model.getStarScore(1)!=0 && newValue>=model.getStarScore(1)) || (newValue>=model.getStarScore(2) && model.getStarScore(2)!=0))
					throw new IllegalArgumentException("1 star score too big");
			} catch(IllegalArgumentException iae){
				tf.setText(""+(model.getStarScore(star)));
				return false;
			}
		else if(star==1)
			try
			{
				if((model.getStarScore(0)!=0 && newValue<=model.getStarScore(0)) || (newValue>=model.getStarScore(2) && model.getStarScore(2)!=0))
					throw new IllegalArgumentException("2 star score too big or too small");
			} catch(IllegalArgumentException iae){
				tf.setText(""+(model.getStarScore(star)));
				return false;
			}
		else if(star==2)
			try
			{
				if((model.getStarScore(0)!=0 && newValue<=model.getStarScore(0)) || (newValue<=model.getStarScore(1) && model.getStarScore(1)!=0))
					throw new IllegalArgumentException("3 star score too small");
			} catch(IllegalArgumentException iae){
				tf.setText(""+(model.getStarScore(star)));
				return false;
			}
		
		return newValue>0;
	}

	/**
	 * does the move
	 */
	@Override
	public boolean doMove() {
		// TODO Auto-generated method stub
		if(!isValid()){return false;}
		model.setStarScore(star, newValue);
		tf.setText(""+model.getStarScore(star));
		return true;
	}

	/**
	 * undoes the move
	 */
	@Override
	public boolean undo() {
		// TODO Auto-generated method stub
		model.setStarScore(star, oldValue);
		tf.setText(""+model.getStarScore(star));
		return true;
	}
	
}
