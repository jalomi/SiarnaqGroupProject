package levelBuilderControllers;

import java.io.IOException;

import junit.framework.TestCase;
import levelBuilderBoundary.LevelBuilderApplication;
import levelBuilderBoundary.LevelBuilderPreviewApplication;

import org.json.JSONException;

public class TestExitController extends TestCase{
	LevelBuilderApplication a;
	
	protected void setUp() throws IOException, JSONException {
		a = new LevelBuilderApplication();
		a.setVisible(true);
	}

	@Override
	protected void tearDown() {
		a.dispose();
	}

	public void testController(){
		ExitController ec=new ExitController(a);
		ec.process();
		
		System.out.println("works");
	}
}
