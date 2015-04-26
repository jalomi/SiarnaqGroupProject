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
		current.setVisible(false) ;
		app.setEnabled(true) ;
		app.setVisible(true) ;
	}

}
