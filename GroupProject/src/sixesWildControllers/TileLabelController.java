package sixesWildControllers;

import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import sixesWildBoundary.SixesWildApplication;
import sixesWildBoundary.TileLabel;
import sixesWildEntity.SixesWild;
import sixesWildEntity.Tile;
import sixesWildMoves.IMove;
import sixesWildMoves.NormalSelectionMove;
import sixesWildMoves.RemoveSquareMove;
import sixesWildMoves.SwapSquareMove;

public class TileLabelController extends MouseAdapter {
	public static final String TAG = "JLabelController";
	
	SixesWildApplication sixesWildApp;
	
	ArrayList<TileLabel> selectedLabels;
	boolean havePressed;
	
	public TileLabelController(SixesWildApplication app, SixesWild model)
	{
		this.sixesWildApp = app;
		this.selectedLabels = new ArrayList<TileLabel>();
		havePressed = false;
	}
	
	@Override
	public void mousePressed(MouseEvent me) {		
		Component c = me.getComponent();
		TileLabel label = (TileLabel) c;
		label.setIconSelected();
		selectedLabels.add(label);
		havePressed = true;
	}
	
	@Override
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
	
	@Override
	public void mouseReleased(MouseEvent me) {
		if(sixesWildApp.getModel().getBoard().getRemoveMove()){
			//Remove tile move
			for(TileLabel label : selectedLabels) {
				label.setIconUnselected();
			}
			havePressed = false;
			
			if(selectedLabels.size() == 1){
				Tile tile = selectedLabels.get(0).getModel() ;
				IMove m = new RemoveSquareMove(sixesWildApp.getModel().getBoard(), tile) ;
				
				if(m.doMove(sixesWildApp)){
					sixesWildApp.getGamePanel().refreshBoard();
					sixesWildApp.getLevelPanel().refresh();
					System.out.println(TAG + "RemoveSquareMove suceeded");
				} else {
					System.out.println(TAG + "RemoveSquareMove failed");
				}
				selectedLabels.removeAll(selectedLabels);
			}
		}
		else if(sixesWildApp.getModel().getBoard().getSwapMove()){
			//Swap tile move
			for(TileLabel label : selectedLabels) {
				label.setIconUnselected();
			}
			havePressed = false;
			
			if(selectedLabels.size() == 2){
				Tile t1 = selectedLabels.get(0).getModel() ;
				Tile t2 = selectedLabels.get(1).getModel() ;
				IMove m = new SwapSquareMove(sixesWildApp.getModel().getBoard(), t1, t2) ;
				
				if(m.doMove(sixesWildApp)){
					sixesWildApp.getGamePanel().refreshBoard();
					sixesWildApp.getLevelPanel().refresh();
					System.out.println(TAG + "RemoveSquareMove suceeded");
				} else {
					System.out.println(TAG + "RemoveSquareMove failed");
				}
				selectedLabels.removeAll(selectedLabels);				
			}
			else{
				sixesWildApp.getModel().getBoard().setSwapMove(false) ;
				selectedLabels.removeAll(selectedLabels);				
			}
		}
		else{
			//Normal move
			for(TileLabel label : selectedLabels) {
				label.setIconUnselected();
			}
			havePressed = false;
			
			ArrayList<Tile> tiles = new ArrayList<Tile>();
			for(TileLabel tl : selectedLabels) {
				tiles.add(tl.getModel());
			}
			IMove m = new NormalSelectionMove(tiles, sixesWildApp.getModel().getBoard());
			
			if(m.doMove(sixesWildApp)) {
				sixesWildApp.getGamePanel().refreshBoard();
				sixesWildApp.getLevelPanel().refresh();
				System.out.println(TAG + "NormalSelectionMove suceeded");
			} else {
				System.out.println(TAG + "NormalSelectionMove failed");
			}
			selectedLabels.removeAll(selectedLabels);
		}
	}
}
