package sixesWildControllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import sixesWildEntity.SixesWild;

public class ResetProgressController implements ActionListener{

	JFrame frame ;
	
	public  ResetProgressController(JFrame f){
		this.frame = f ;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		SixesWild sw  = SixesWild.newInstance();
		//TODO clear progress for the levels
	}

}
