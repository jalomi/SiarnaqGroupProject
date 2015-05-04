package levelBuilderMoves;

import javax.swing.JToggleButton;

import levelBuilderEntity.LevelBuilder;

/**
 * Deselects a currently selected tile.
 * @author 
 *
 */
public class DeselectTilesMove extends Move {
	
	/** the levelBuilder entity */
	LevelBuilder model;
	
	/** the tile to be deslected */
	JToggleButton tile;
	
	/** the x position of the tile */
	int posx;
	
	/** the y position of the tile */
	int posy;
	
	/** flag for if the tile is already selected or not */
	boolean selected;
	
	/**
	 * Constructor
	 * @param model LevelBuilder
	 * @param t JToggleButton
	 * @param x int
	 * @param y int
	 */
	public DeselectTilesMove(LevelBuilder model, JToggleButton t, int x, int y){
		
		this.model = model;
		this.tile = t;
		this.posx = x;
		this.posy = y;
		selected = tile.isSelected();
	}
	
	/**
	 * Checks if the move is valid
	 */
	@Override
	public boolean isValid() {
		if(tile.isSelected()){
			return false;
		}
		else{
			return true;
		}
	}

	/**
	 * Deselects the tile if valid
	 */
	@Override
	public boolean doMove() {
		if(!isValid()){return false;}
		tile.setSelected(false);
		model.setTileActive(posy, posx);
		System.out.println("tile x: "+posx+" y: "+posy+" isActivate: "+ model.getTileActiveAt(posx, posy));
		return true;
	}

	/**
	 * Undoes the move
	 */
	@Override
	public boolean undo() {
		if(!tile.isSelected()){
			tile.setSelected(true);
			//tile.updateUI();
		
			model.setTileDeactive(posy,posx);
			System.out.println("Undo button invoked");
			System.out.println("tile x: "+posx+" y: "+posy+" isActivate: "+ model.getTileActiveAt(posx, posy));
			return true;}
		else{
			return false;
		}
	}
}
