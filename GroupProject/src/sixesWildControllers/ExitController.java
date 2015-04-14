package sixesWildControllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class ExitController implements ActionListener {
	JFrame frame;

	public ExitController(JFrame frame)
	{
		this.frame=frame;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(frame!=null)
			frame.dispose();
	}
}