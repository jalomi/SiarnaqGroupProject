package sixesWildControllers;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import sixesWildBoundary.SixesWildApplication;
import sixesWildEntity.SixesWild;
import sixesWildEntity.Tile;

public class TileSelectionController extends MouseAdapter{
	SixesWildApplication application;
	SixesWild model;
	Tile src ;
	
	public TileSelectionController(SixesWildApplication a, SixesWild m, Tile src)
	{
		this.application=a;
		this.model=m;
	}
	
	public void mousePressed(MouseEvent me){
		ArrayList<Tile> sel = model.getBoard().getSelected() ;
		
		sel.add(src) ;		
	}
	
}
