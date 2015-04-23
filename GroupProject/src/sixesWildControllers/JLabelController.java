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

public class JLabelController extends MouseAdapter {
	public static final String TAG = "JLabelController";
	
	SixesWildApplication application;
	SixesWildGamePanel src;
	ArrayList<JLabel> selectedLabels;
	
	boolean havePressed;
	
	public JLabelController(SixesWildGamePanel gamePanel)
	{
		//this.application = application;
		this.src = gamePanel;
		this.selectedLabels = new ArrayList<JLabel>();
		havePressed = false;
	}
	
	public void mousePressed(MouseEvent me) {
		Component c = me.getComponent();
		JLabel label = (JLabel) c;
		label.setIcon(null);
		selectedLabels.add(label);
		havePressed = true;
	}
	
	public void mouseEntered(MouseEvent me) {
		//System.out.println(TAG + " mouseEntered" + havePressed);
		if(havePressed) {
			//System.out.println(TAG + " mouseEntered pressed");
			Component c = me.getComponent();
			JLabel label = (JLabel) c;
			if(!selectedLabels.contains(label)) {
				System.out.println(TAG + " mouseEntered add");
				label.setIcon(null);
				selectedLabels.add(label);
//				havePressed = true;
			} else {
				int index = selectedLabels.indexOf(label);
				for(int i = selectedLabels.size() - 1; i > index; i--) {
					selectedLabels.get(i).setIcon(new ImageIcon(SixesWildGamePanel.class.getResource("/tileIcons/1-1.png")));
					selectedLabels.remove(i);
				}
			}
		}
	}
	
	public void mouseReleased(MouseEvent me) {
		Component c = me.getComponent();
		for(JLabel label : selectedLabels) {
			label.setIcon(new ImageIcon(SixesWildGamePanel.class.getResource("/tileIcons/1-1.png")));
		}
		selectedLabels.removeAll(selectedLabels);
		havePressed = false;
	}
}
