package levelBuilderMoves;

import javax.swing.JCheckBox;

import levelBuilderEntity.LevelBuilder;

/**
 * Sets the state of a bucket
 * @author 
 *
 */
public class BucketEnableMove extends Move{

	/** the levelBuilder entity */
	LevelBuilder model;
	
	/** the new state of the bucket */
	boolean state;
	
	/** the checkbox which was clicked */
	JCheckBox ch;
	
	/** the bucket to be set */
	int bucket;
	
	/** the last state of the bucket */
	boolean oldState;
	
	/**
	 * Constructor 
	 * @param m LevelBuilder
	 * @param e boolean
	 * @param ch JCheckBox
	 * @param bucket int
	 */
	public BucketEnableMove(LevelBuilder m, boolean e, JCheckBox ch, int bucket)
	{
		this.model=m;
		this.state=e;
		this.ch=ch;
		this.bucket=bucket;
		this.oldState=model.getBucketEnabled(bucket);
		
	}

	/**
	 * Checks to see if the move is valid.
	 */
	@Override
	public boolean isValid() {
		// TODO Auto-generated method stub
		return true;
	}

	/**
	 * Does the move
	 */
	@Override
	public boolean doMove() {
		// TODO Auto-generated method stub
		if(!isValid()){return false;}
		System.out.println("saving bucket as " + state) ;
		model.setBucketEnabled(bucket, state);
		ch.setSelected(model.getBucketEnabled(bucket));
			
		return true;
	}

	/**
	 * Undoes the move
	 */
	@Override
	public boolean undo() {
		// TODO Auto-generated method stub
		model.setBucketEnabled(bucket, oldState);
		ch.setSelected(model.getBucketEnabled(bucket));
		return true;
	}

}
