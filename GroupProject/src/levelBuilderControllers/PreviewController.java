package levelBuilderControllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import org.json.JSONException;

import levelBuilderBoundary.LevelBuilderApplication;
import levelBuilderBoundary.LevelBuilderPreviewApplication;
import levelBuilderEntity.LevelBuilder;

/**
 * Controller that enters Preview application from Level Builder application
 * @author Kevin
 *
 */
public class PreviewController implements ActionListener {
	
	/**
	 * the Level Builder application
	 */
	LevelBuilderApplication app ;
	
	/**
	 * the Level Builder entity
	 */
	LevelBuilder model;
	
	/**
	 * Constructor
	 * Creates the controller based on the application
	 * @param app
	 * @throws IOException
	 * @throws JSONException
	 */
	public PreviewController(LevelBuilderApplication app) throws IOException, JSONException{

		this.app = app ;

		this.model = LevelBuilder.newInstance();
	}

	/**
	 * Handles press of preview button
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		process();
	}
	
	/**
	 * Goes to Preview application from Level Builder application
	 */
	public void process()
	{
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
