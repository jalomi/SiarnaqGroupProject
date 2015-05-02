package levelBuilderControllers;

import java.io.IOException;

import junit.framework.TestCase;

import org.json.JSONException;

import levelBuilderBoundary.LevelBuilderApplication;
import levelBuilderBoundary.LevelBuilderPreviewApplication;

public class TestPreviewtoLevelBuilderController extends TestCase{
LevelBuilderApplication a;
LevelBuilderPreviewApplication p;

protected void setUp() throws IOException, JSONException {
	a = new LevelBuilderApplication();
	p= new LevelBuilderPreviewApplication();
	p.setVisible(true);
}

@Override
protected void tearDown() {
	p.dispose();
	a.dispose();
}

public void testController(){
	PreviewToLevelBuilderController plbc=new PreviewToLevelBuilderController(a, p);
	plbc.process();
	
	System.out.println("works");
}

}
