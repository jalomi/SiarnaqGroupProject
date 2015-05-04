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
		model.setLevelNumber(3);
		SavingLoadingLevelController slc=new SavingLoadingLevelController(model);
		slc.process();
		slc.loadingLevel("Puzzle 1");
		System.out.println("generated");
		
	}
}
