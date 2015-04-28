package levelBuilderMoves;

import javax.swing.JToggleButton;

import levelBuilderEntity.LevelBuilder;

public class DeselectTilesMove extends Move {
	
	
	LevelBuilder model;
	JToggleButton tile;
	int posx;
	int posy;
	public DeselectTilesMove(LevelBuilder model, JToggleButton t, int x, int y){
		
		this.model = model;
		this.tile = t;
		this.posx = x;
		this.posy = y;
	}
	
	
	@Override
	public boolean isValid() {
		if(tile.isSelected()){
			return false;
		}
		else{
			return true;
		}
	}

	@Override
	public boolean doMove() {
		if(!isValid()){return false;}
		model.setTileActive(posy, posx);
		System.out.println("tile x: "+posx+" y: "+posy+" isActivate: "+ model.getTileActiveAt(posx, posy));
		return true;
	}

	@Override
	public boolean undo() {
		if(!tile.isSelected()){
			tile.setSelected(true);
			tile.updateUI();
		
			model.setTileDeactive(posy,posx);
			System.out.println("Undo button invoked");
			System.out.println("tile x: "+posx+" y: "+posy+" isActivate: "+ model.getTileActiveAt(posx, posy));
			return true;}
		else{
			return false;
		}
	}
}
