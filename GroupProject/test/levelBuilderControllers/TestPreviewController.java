package levelBuilderControllers;

import java.io.IOException;

import junit.framework.TestCase;
import levelBuilderBoundary.LevelBuilderApplication;

import org.json.JSONException;

public class TestPreviewController extends TestCase{
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
		PreviewController pc=new PreviewController(a);
		pc.process();
		
		System.out.println("works");
	}
}
