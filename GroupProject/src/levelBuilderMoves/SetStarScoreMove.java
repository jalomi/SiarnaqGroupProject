package levelBuilderMoves;

import javax.swing.JTextField;

import levelBuilderEntity.LevelBuilder;

/**
 * Sets the scores threshold for the stars
 * @author 
 *
 */
public class SetStarScoreMove extends Move{

	/** LevelBuilder entity */
	LevelBuilder model;
	
	/** value of new threshold */
	int newValue;
	
	/** value of the old threshold */
	int oldValue;
	
	/** textField in which the threshold was entered */
	JTextField tf;
	
	/** which star threshold is being altered */
	int star;
	
	/**
	 * Constructor
	 * @param model LevelBuilder
	 * @param newValue int
	 * @param tfJTextField
	 * @param star int
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
	 * Checks if the move is valid
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
	 * Sets the star threshold
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
	 * Undoes the move
	 */
	@Override
	public boolean undo() {
		// TODO Auto-generated method stub
		model.setStarScore(star, oldValue);
		tf.setText(""+model.getStarScore(star));
		return true;
	}
	
}
