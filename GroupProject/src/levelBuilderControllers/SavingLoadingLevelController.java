package levelBuilderControllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import org.json.JSONException;

import sixesWildEntity.Level;
import JSONSerializer.LevelJSONSerializer;
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
	
	//LevelBuilderApplication app;
	LevelBuilder model;
	
	public SavingLoadingLevelController(LevelBuilder model) {
		//this.app = app;
		this.model = model;
	}
	
	@Override
	public void actionPerformed(ActionEvent event) {
		//generate a level based on level builders' attributes(configuration)
		//Please change getLevelType to String!
		String fileName = model.getLevelType() + " " + model.getLevelNumber();
		LevelJSONSerializer json = 
				new LevelJSONSerializer(fileName);
		try {
			System.out.println("!!!----!!!");
			json.saveSingleLevel(model.generateLevel(model.getLevelType()));
			LevelBuilder.getLevelList().add(fileName);
		} catch (Exception e) {
			System.out.println("!!!-22-!!!");
			e.printStackTrace();
		}
	}
	
	public Level loadingLevel(String levelName) throws IOException, JSONException {
		LevelJSONSerializer json = 
				new LevelJSONSerializer(levelName);
		return json.loadSingleLevel(levelName.substring(0, -2));
	}
}
