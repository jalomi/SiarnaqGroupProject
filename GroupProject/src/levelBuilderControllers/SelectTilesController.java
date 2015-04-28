package levelBuilderControllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JToggleButton;

import levelBuilderBoundary.LevelBuilderApplication;
import levelBuilderEntity.LevelBuilder;
import levelBuilderMoves.DeselectTilesMove;
import levelBuilderMoves.Move;
import levelBuilderMoves.SelectTileMove;

public class SelectTilesController implements ActionListener{
	LevelBuilder model;
	JToggleButton tile;
	LevelBuilderApplication app;
	int posx, posy;
	
	public SelectTilesController(LevelBuilder model, LevelBuilderApplication app, JToggleButton t, int x, int y){
		this.model = model;
		this.tile = t;
		this.posx = x;
		this.posy = y;
		this.app = app;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		process();
	}
	
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
