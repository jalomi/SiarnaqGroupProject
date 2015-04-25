package sixesWildControllers;

import java.awt.Color;
import java.awt.Component;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import sixesWildBoundary.SixesWildApplication;
import sixesWildBoundary.SixesWildGamePanel;
import sixesWildBoundary.TileLabel;
import sixesWildEntity.SixesWild;
import sixesWildEntity.Tile;
import sixesWildMoves.IMove;
import sixesWildMoves.NormalSelectionMove;

public class TileLabelController extends MouseAdapter {
	public static final String TAG = "JLabelController";
	
	SixesWildApplication theGame;
	
	ArrayList<TileLabel> selectedLabels;
	boolean havePressed;
	
	public TileLabelController(SixesWildApplication app, SixesWild model)
	{
		this.theGame = app;
		this.selectedLabels = new ArrayList<TileLabel>();
		havePressed = false;
	}
	
	public void mousePressed(MouseEvent me) {
		Component c = me.getComponent();
		TileLabel label = (TileLabel) c;
		label.setIconSelected();
		selectedLabels.add(label);
		havePressed = true;
	}
	
	public void mouseEntered(MouseEvent me) {
		//System.out.println(TAG + " mouseEntered" + havePressed);
		if(havePressed) {
			//System.out.println(TAG + " mouseEntered pressed");
			Component c = me.getComponent();
			TileLabel label = (TileLabel) c;
			if(!selectedLabels.contains(label)) {
				//System.out.println(TAG + " mouseEntered add");
				label.setIconSelected();
				selectedLabels.add(label);
			} else {
				int index = selectedLabels.indexOf(label);
				for(int i = selectedLabels.size() - 1; i > index; i--) {
					selectedLabels.get(i).setIconUnselected();
					selectedLabels.remove(i);
				}
			}
		}
	}
	
	public void mouseReleased(MouseEvent me) {
		
		for(TileLabel label : selectedLabels) {
			label.setIconUnselected();
		}
		havePressed = false;
		
		ArrayList<Tile> tiles = new ArrayList<Tile>();
		for(TileLabel tl : selectedLabels) {
			tiles.add(tl.getModel());
		}
		IMove m = new NormalSelectionMove(tiles, theGame.getModel().getBoard());
		
		System.out.println("Before: (0,0):  " + theGame.getModel().getBoard().getSquare(0,0).getValue() + 
				"   (0,1): " + theGame.getModel().getBoard().getSquare(0,0).getValue()) ;
		
		if(m.doMove(theGame)) {
			theGame.getGamePanel().refreshBoard();
			System.out.println(TAG + "NormalSelectionMove suceeded");
		} else {
			System.out.println(TAG + "NormalSelectionMove failed");
		}
		selectedLabels.removeAll(selectedLabels);
	}
}