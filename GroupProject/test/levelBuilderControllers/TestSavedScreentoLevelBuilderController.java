package levelBuilderControllers;

import java.io.IOException;

import junit.framework.TestCase;

import org.json.JSONException;

import levelBuilderBoundary.LevelBuilderApplication;
import levelBuilderBoundary.LevelBuilderSavedScreen;

public class TestSavedScreentoLevelBuilderController extends TestCase{
LevelBuilderSavedScreen s;
LevelBuilderApplication a;

protected void setUp() throws IOException, JSONException {
	s = new LevelBuilderSavedScreen();
	a=new LevelBuilderApplication();
	s.setVisible(true);
}

@Override
protected void tearDown() {
	a.dispose();
}

public void testController() throws IOException, JSONException{
	SavedScreenToLevelBuilderController sc=new SavedScreenToLevelBuilderController(a, s);
	sc.process();
	
	System.out.println("works");
}
}
