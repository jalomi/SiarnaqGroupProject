package levelBuilderControllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import levelBuilderBoundary.LevelBuilderApplication;
import levelBuilderBoundary.LevelBuilderPreviewApplication;

public class PreviewController implements ActionListener {
	LevelBuilderApplication app ;
	
	public PreviewController(LevelBuilderApplication app){
		this.app = app ;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		app.setVisible(false) ;
		
		LevelBuilderPreviewApplication p = new LevelBuilderPreviewApplication() ;
		p.setVisible(true) ;
		
		p.getBackBtn().addActionListener(new PreviewToLevelBuilderController(app, p)) ;
		
	}
	
	
	
}
