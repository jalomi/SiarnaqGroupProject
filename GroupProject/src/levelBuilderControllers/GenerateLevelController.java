package levelBuilderControllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import levelBuilderBoundary.LevelBuilderApplication;
import levelBuilderBoundary.LevelBuilderSavedScreen;

public class GenerateLevelController implements ActionListener{
	LevelBuilderApplication app ;
	
	public GenerateLevelController(LevelBuilderApplication app){
		this.app = app ;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		process();
	}
	
	public void process()
	{ 
		app.setEnabled(false) ;
		
		LevelBuilderSavedScreen p = new LevelBuilderSavedScreen() ;
		p.setVisible(true) ;
		
		p.getContinueBtn().addActionListener(new SavedScreenToLevelBuilderController(app, p)) ;
	}

}
