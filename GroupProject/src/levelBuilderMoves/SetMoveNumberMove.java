package levelBuilderMoves;

import levelBuilderEntity.LevelBuilder;

public class SetMoveNumberMove extends Move{
	LevelBuilder model;
	int newValue;
	int oldValue;
	
	public SetMoveNumberMove(LevelBuilder model, int newValue, int oldValue)
	{
		this.model=model;
		this.newValue=newValue;
		this.oldValue=oldValue;
	}

	@Override
	public boolean isValid() {
		return true;
	}

	@Override
	public boolean doMove() {
		// TODO Auto-generated method stub
		model.setMoves(newValue);
		return true;
	}

	@Override
	public boolean undo() {
		// TODO Auto-generated method stub
		model.setMoves(oldValue);
		return true;
	}
	
}
