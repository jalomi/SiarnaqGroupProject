package levelBuilderMoves;

import javax.swing.JToggleButton;

import levelBuilderBoundary.LevelBuilderApplication;
import levelBuilderEntity.LevelBuilder;

public class SelectTileMove extends Move{
	
	LevelBuilder model;
	//LevelBuilderApplication lba;
	JToggleButton tile;
	int posx;
	int posy;
	public SelectTileMove(LevelBuilder model, JToggleButton t, int x, int y){
		
		this.model = model;
		this.tile = t;
		this.posx = x;
		this.posy = y;
	}
	
	
	@Override
	public boolean isValid() {
		if(tile.isSelected()){
			return true;
		}
		else{
			return false;
		}
	}

	@Override
	public boolean doMove() {
		if(!isValid()){return false;}
		model.setTileDeactive(posy, posx);
		System.out.println("tile x: "+posx+" y: "+posy+" isActivate: "+ model.getTileActiveAt(posx, posy));
		return true;
	}

	@Override
	public boolean undo() {
		if(tile.isSelected()){
		tile.setSelected(true);

		model.setTileActive(posy,posx);
		System.out.println("Undo button invoked");
		System.out.println("tile x: "+posx+" y: "+posy+" isActivate: "+ model.getTileActiveAt(posx, posy));
		return true;}
		else{
			return false;
		}
	}

}
