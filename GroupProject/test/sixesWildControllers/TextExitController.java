package sixesWildControllers;

import java.io.IOException;

import junit.framework.TestCase;
import levelBuilderBoundary.LevelBuilderApplication;
import sixesWildControllers.ExitController;

import org.json.JSONException;

import sixesWildBoundary.MainMenuApplication;
import sixesWildBoundary.SixesWildApplication;
import sixesWildEntity.SixesWild;

public class TextExitController extends TestCase{
MainMenuApplication a;
	
	protected void setUp() throws IOException, JSONException {
		a = new MainMenuApplication();
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
