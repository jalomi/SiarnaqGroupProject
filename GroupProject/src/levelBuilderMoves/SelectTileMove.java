package levelBuilderMoves;

import javax.swing.JToggleButton;

import levelBuilderEntity.LevelBuilder;

/**
 * Enables a selected tile
 * @author 
 *
 */
public class SelectTileMove extends Move{
	
	/** LevelBuilder entity */
	LevelBuilder model;
	
	/** the tile that is selected */
	JToggleButton tile;
	
	/** the x position of the tile */
	int posx;
	
	/** the y position of the tile */
	int posy;
	
	/** flag for if the tile is already enabled or not */
	boolean selected;
	
	/**
	 * Constructor
	 * @param model LevelBuilder
	 * @param t JToggleButton
	 * @param x int
	 * @param y int
	 */
	public SelectTileMove(LevelBuilder model, JToggleButton t, int x, int y){
		
		this.model = model;
		this.tile = t;
		this.posx = x;
		this.posy = y;
		this.selected = tile.isSelected();
	}
	
	/**
	 * Checks if the move is valid
	 */
	@Override
	public boolean isValid() {
		if(selected){
			return true;
		}
		else{
			return false;
		}
	}

	/**
	 * Enables a selected tile
	 */
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

	/**
	 * Undoes the move
	 */
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
