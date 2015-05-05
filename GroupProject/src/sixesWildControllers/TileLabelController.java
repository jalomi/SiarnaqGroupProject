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

/**
 * Controls all mouse events on board tiles
 * @author John
 *
 */
public class TileLabelController extends MouseAdapter {
	/** TAG for the class */
	public static final String TAG = "JLabelController";
	
	/** the application */
	SixesWildApplication sixesWildApp;
	
	/** the tiles that have been selected */
	ArrayList<TileLabel> selectedLabels;
	
	/** tracks mouse press */
	boolean havePressed;
	
	/**
	 * Constructor
	 * @param app
	 * @param model
	 */
	public TileLabelController(SixesWildApplication app, SixesWild model)
	{
		this.sixesWildApp = app;
		this.selectedLabels = new ArrayList<TileLabel>();
		havePressed = false;
	}
	
	/**
	 * Handles mouse press event
	 */
	@Override
	public void mousePressed(MouseEvent me) {		
		Component c = me.getComponent();
		TileLabel label = (TileLabel) c;
		pressed(label);
	}
	
	/**
	 * Records the tile that the mouse is pressed on
	 */
	public void pressed(TileLabel label)
	{
		label.setIconSelected();
		selectedLabels.add(label);
		havePressed = true;
	}
	
	/**
	 * Handles mouse enter event
	 */
	@Override
	public void mouseEntered(MouseEvent me) {
		//System.out.println(TAG + " mouseEntered" + havePressed);
		if(havePressed) {
			//System.out.println(TAG + " mouseEntered pressed");
			Component c = me.getComponent();
			TileLabel label = (TileLabel) c;
			entered(label);
		}
	}
	
	/**
	 * Records all tiles that the mouse enters
	 */
	public void entered(TileLabel label)
	{
		if(!selectedLabels.contains(label)) {
			//System.out.println(TAG + " mouseEntered add");
			label.setIconSelected();
			selectedLabels.add(label);
		} else {
			int index = selectedLabels.indexOf(label);
			for(int i = selectedLabels.size() - 1; i > index; i--) {
				if(selectedLabels.get(i).getModel().isMarked()){
					selectedLabels.get(i).setIconMarked() ;
				}
				else{
					selectedLabels.get(i).setIconUnselected();
				}
				selectedLabels.remove(i);
			}
		}
	}
	
	/**
	 * Handles mouse release event
	 */
	@Override
	public void mouseReleased(MouseEvent me) {
		released();
	}
	
	/**
	 * Does the proper move on the selected tiles once the mouse is released
	 */
	public void released()
	{
		if(sixesWildApp.getModel().getBoard().getRemoveMove()){
			//Remove tile move
			for(TileLabel label : selectedLabels) {
				if(label.getModel().isMarked()){
					label.setIconMarked() ;
				}
				else{
					label.setIconUnselected();
				}
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
			else{
				sixesWildApp.getModel().getBoard().setRemoveMove(false) ;
				selectedLabels.removeAll(selectedLabels);				
			}
		}
		else if(sixesWildApp.getModel().getBoard().getSwapMove()){
			//Swap tile move
			for(TileLabel label : selectedLabels) {
				if(label.getModel().isMarked()){
					label.setIconMarked() ;
				}
				else{
					label.setIconUnselected();
				}
			}
			havePressed = false;
			
			if(selectedLabels.size() == 2){
				Tile t1 = selectedLabels.get(0).getModel() ;
				Tile t2 = selectedLabels.get(1).getModel() ;
				IMove m = new SwapSquareMove(sixesWildApp.getModel().getBoard(), t1, t2) ;
				
				if(m.doMove(sixesWildApp)){
					sixesWildApp.getGamePanel().refreshBoard();
					sixesWildApp.getLevelPanel().refresh();
					System.out.println(TAG + "SwapSquareMove suceeded");
				} else {
					System.out.println(TAG + "SwapSquareMove failed");
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
				if(label.getModel().isMarked()){
					label.setIconMarked() ;
				}
				else{
					label.setIconUnselected();
				}
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
