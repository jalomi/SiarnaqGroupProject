package levelBuilderControllers;

import java.io.IOException;
import org.json.JSONException;
import junit.framework.TestCase;
import levelBuilderEntity.LevelBuilder;

public class TestSavingLoadingLevelController extends TestCase{
	LevelBuilder model;
	
	public void testValid() throws IOException, JSONException
	{
		model=new LevelBuilder();
		model.setLevelType("Puzzle");
		model.setLevelNumber(7);
		SavingLoadingLevelController slc=new SavingLoadingLevelController(model);
		slc.process();
		System.out.println("generated");
	}
}
