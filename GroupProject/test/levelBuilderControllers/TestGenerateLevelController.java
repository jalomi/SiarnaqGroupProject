package levelBuilderControllers;

import java.io.IOException;

import junit.framework.TestCase;
import levelBuilderBoundary.LevelBuilderApplication;

import org.json.JSONException;

public class TestGenerateLevelController extends TestCase{
LevelBuilderApplication a;
	
	protected void setUp() throws IOException, JSONException {
		a = new LevelBuilderApplication();
		a.setVisible(true);
	}

	@Override
	protected void tearDown() {
		a.dispose();
	}

	public void testController() throws IOException, JSONException{
		GenerateLevelController gc=new GenerateLevelController(a);
		gc.process();
		
		System.out.println("works");
	}
}
