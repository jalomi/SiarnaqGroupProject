package sixesWildControllers;

import java.awt.Component;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import javax.swing.JLabel;
import javax.swing.JPanel;

import sixesWildBoundary.SixesWildApplication;
import sixesWildBoundary.SixesWildGamePanel;

/**
 * This is a reason that this class should not be called TileSelectionController
 * Because this controller is not only in charge of selection of tiles
 * It is in charge of all the swing UI event on our JLabels in SixesWildGamePanel
 * This class should be called GamePanelController
 * @author albert
 *
 */
public class GamePanelController extends MouseAdapter{
	
	public static final String TAG = "TileController";
	
	SixesWildApplication application;
	
	/* SixesWildGamePanel is the actual view MouseAdapter is active on */
	SixesWildGamePanel src;
	
	//It should be a set of JLabels!
	//you can never select a tile directly!!! Tiles are entities!
	//you select boundaries!
	//the only reason that I am using a HashSet here is that HashSet checks for duplication
	//so that we can never add same JLabel twice
	ArrayList<JLabel> selectedLabels;
	
	boolean havePressed;
	JLabel previousLabel;
	
	public GamePanelController(SixesWildGamePanel gamePanel)
	{
		//this.application = application;
		this.src = gamePanel;
		this.selectedLabels = new ArrayList<JLabel>();
		havePressed = false;
		previousLabel = null;
	}
	
	public void mousePressed(MouseEvent me){
		Component c = me.getComponent();
		JPanel p = (JPanel) c;
		Point point = me.getPoint();
		
		Component c1 = p.getComponentAt(point);
		if(c1 instanceof JLabel) {
			JLabel label;
			label = (JLabel) c1;
			label.setVisible(false);
			selectedLabels.add(label);
			previousLabel = label;
			havePressed = true;
		}
	}
	
	public void mouseReleased(MouseEvent me){
		Component c = me.getComponent();
		//c.setVisible(true);
		for(JLabel label : selectedLabels) {
			label.setVisible(true);
		}
		//havePressed = false;
		//Move move = new NormalSelectionMove() ;
		
//		if(move.doMove()){
//			//do the move code
//			//model.pushMove(move) ;
//		}
	}
	
	@Override
	public void mouseDragged(MouseEvent me) {
		//System.out.println(TAG + " mouseDragged");
		if(havePressed) {
			//System.out.println(TAG + " have pressed");
			Component c = me.getComponent();
			JPanel p = (JPanel) c;
			Point point = me.getPoint();
			Component c1 = p.getComponentAt(point);
			if(c1 instanceof JLabel) {
				JLabel label;
				label = (JLabel) c1;
				if(selectedLabels.contains(label)) {

				} else {

				}
			}
		}
	}
	
}
