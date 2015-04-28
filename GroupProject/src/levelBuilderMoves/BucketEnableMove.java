package levelBuilderMoves;

import javax.swing.JCheckBox;

import levelBuilderEntity.LevelBuilder;

public class BucketEnableMove extends Move{

	LevelBuilder model;
	boolean state;
	JCheckBox ch;
	int bucket;
	boolean oldState;
	
	public BucketEnableMove(LevelBuilder m, boolean e, JCheckBox ch, int bucket)
	{
		this.model=m;
		this.state=e;
		this.ch=ch;
		this.bucket=bucket;
		this.oldState=model.getBucketEnabled(bucket);
		
	}

	@Override
	public boolean isValid() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean doMove() {
		// TODO Auto-generated method stub
		if(!isValid()){return false;}
		
		model.setBucketEnabled(bucket, state);
		ch.setSelected(model.getBucketEnabled(bucket));
			
		return true;
	}

	@Override
	public boolean undo() {
		// TODO Auto-generated method stub
		model.setBucketEnabled(bucket, oldState);
		ch.setSelected(model.getBucketEnabled(bucket));
		return true;
	}

}
