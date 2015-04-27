package levelBuilderControllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import org.json.JSONException;

import sixesWildEntity.Level;
import JSONSerializer.LevelJSONSerializer;
import levelBuilderBoundary.LevelBuilderApplication;
import levelBuilderEntity.LevelBuilder;

/**
 * This controller should be add to the generate level button
 * and an instance of this controller should be created when the model
 * is initialized 
 * @author albert
 *
 */
public class SavingLoadingLevelController implements ActionListener{
	
	public static final String TAG = "SavingLoadingLevelController";
	
	LevelBuilderApplication app;
	LevelBuilder model;
	
	public SavingLoadingLevelController(LevelBuilderApplication app, LevelBuilder model) {
		this.app = app;
		this.model = model;
	}
	
	@Override
	public void actionPerformed(ActionEvent event) {
		//generate a level based on level builders' attributes(configuration)
		//Please change getLevelType to String!
		LevelJSONSerializer json = 
				new LevelJSONSerializer(model.getLevelType() + " " + model.getLevelNumber());
		try {
			json.saveSingleLevel(model.generateLevel(model.getLevelType()));
		} catch (JSONException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Level loadingLevel(String levelName) throws IOException, JSONException {
		LevelJSONSerializer json = 
				new LevelJSONSerializer(levelName);
		return json.loadSingleLevel(levelName.substring(0, -2));
	}
}
