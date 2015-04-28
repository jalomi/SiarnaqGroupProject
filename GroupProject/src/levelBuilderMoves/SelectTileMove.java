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
	boolean selected;
	public SelectTileMove(LevelBuilder model, JToggleButton t, int x, int y){
		
		this.model = model;
		this.tile = t;
		this.posx = x;
		this.posy = y;
		this.selected = tile.isSelected();
	}
	
	
	@Override
	public boolean isValid() {
		if(selected){
			return true;
		}
		else{
			return false;
		}
	}

	@Override
	public boolean doMove() {
		if(!isValid()){
			System.out.println("false");
			return false;
		}
		tile.setSelected(true);
		model.setTileDeactive(posy, posx);
		System.out.println("tile x: "+posx+" y: "+posy+" isActivate: "+ model.getTileActiveAt(posx, posy));
		return true;
	}

	@Override
	public boolean undo() {
		if(tile.isSelected()){
			tile.setSelected(false);
			//tile.updateUI();
			
			model.setTileActive(posy,posx);
			System.out.println("Undo button invoked");
			System.out.println("tile x: "+posx+" y: "+posy+" isActivate: "+ model.getTileActiveAt(posx, posy));
			return true;}
		else{
			return false;
		}
	}

}
