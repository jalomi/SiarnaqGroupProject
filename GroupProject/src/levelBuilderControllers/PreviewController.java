package levelBuilderControllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import org.json.JSONException;

import levelBuilderBoundary.LevelBuilderApplication;
import levelBuilderBoundary.LevelBuilderPreviewApplication;
import levelBuilderEntity.LevelBuilder;

public class PreviewController implements ActionListener {
	LevelBuilderApplication app ;
	LevelBuilder model;
	
	public PreviewController(LevelBuilderApplication app, LevelBuilder model){
		this.app = app ;
		this.model=model;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		app.setVisible(false) ;
		
		LevelBuilderPreviewApplication p;
		try {
			p = new LevelBuilderPreviewApplication();
			p.setVisible(true) ;
			p.getBackBtn().addActionListener(new PreviewToLevelBuilderController(app, p)) ;
		} catch (IOException e) {
			e.printStackTrace();
		} catch (JSONException e) {
			e.printStackTrace();
		}
		
	}
	
	
	
}
