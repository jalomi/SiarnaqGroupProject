package levelBuilderControllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JToggleButton;

import levelBuilderBoundary.LevelBuilderApplication;
import levelBuilderEntity.LevelBuilder;
import levelBuilderMoves.DeselectTilesMove;
import levelBuilderMoves.Move;
import levelBuilderMoves.SelectTileMove;

/**
 * Controller that selects or deselects Game Tiles in Level Builder
 * @author Yuheng
 *
 */
public class SelectTilesController implements ActionListener{
	
	/**
	 * the Level Builder entity
	 */
	LevelBuilder model;
	
	/**
	 * the tile being selected or deselected
	 */
	JToggleButton tile;
	
	/**
	 * the Level Builder application
	 */
	LevelBuilderApplication app;
	
	/**
	 * the x and y positions of the tile
	 */
	int posx, posy;
	
	/**
	 * Constructor
	 * Creates the controller based on the entity, application, tile, and position
	 * @param model
	 * @param app
	 * @param t
	 * @param x
	 * @param y
	 */
	public SelectTilesController(LevelBuilder model, LevelBuilderApplication app, JToggleButton t, int x, int y){
		this.model = model;
		this.tile = t;
		this.posx = x;
		this.posy = y;
		this.app = app;
	}
	
	/**
	 * Handles press of tile
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		process();
	}
	
	/**
	 * Sets tile to be selected or deselected depending on current state
	 * @return
	 */
	public boolean process(){
		Move m1 = new SelectTileMove(model, tile, posx, posy);
		Move m2 = new DeselectTilesMove(model,tile,posx,posy);
		
		if(tile.isSelected()){
			m1.doMove();
			System.out.println("tile x:"+posx+" y: "+ posy +"is deactivated");
			model.recordMove(m1);
			return true;
		}
		else{
			m2.doMove();
			System.out.println("tile x:"+posx+" y: "+ posy +"is activated");
			model.recordMove(m2);
			return true;
		}
		
	}

}
