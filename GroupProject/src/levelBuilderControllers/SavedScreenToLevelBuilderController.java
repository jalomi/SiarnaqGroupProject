package levelBuilderControllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import levelBuilderBoundary.LevelBuilderApplication;

public class SavedScreenToLevelBuilderController implements ActionListener{
	LevelBuilderApplication app ;
	JFrame current ;
	
	public SavedScreenToLevelBuilderController(LevelBuilderApplication app, JFrame current){
		this.app = app ;
		this.current = current ;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		process();
	}
	
	public void process()
	{
		current.setVisible(false) ;
		current.dispose() ;
		app.setEnabled(true) ;
		app.setVisible(true) ;
	}

}
