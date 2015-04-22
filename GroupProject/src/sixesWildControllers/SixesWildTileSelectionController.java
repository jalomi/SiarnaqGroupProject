package sixesWildControllers;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;

import sixesWildBoundary.SixesWildApplication;
import sixesWildEntity.Position;
import sixesWildEntity.SixesWild;
import sixesWildEntity.Tile;

public class SixesWildTileSelectionController extends MouseAdapter{
	SixesWildApplication application;
	SixesWild model;
	JLabel tile;
	
	public SixesWildTileSelectionController(SixesWildApplication a, SixesWild m)
	{
		this.application=a;
		this.model=m;
	}
	
	public void mousePressed(MouseEvent me)
	{
		int x=me.getX();
		int y=me.getY();
		Position point=new Position(x, y);
	}
}
