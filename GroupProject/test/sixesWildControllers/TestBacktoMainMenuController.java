package sixesWildControllers;

import java.io.IOException;

import org.json.JSONException;

import sixesWildBoundary.LevelSelectApplication;
import sixesWildBoundary.MainMenuApplication;
import junit.framework.TestCase;

public class TestBacktoMainMenuController extends TestCase{
LevelSelectApplication a;
	
	protected void setUp() throws IOException, JSONException {
		a = new LevelSelectApplication();
		a.setVisible(true);
	}

	@Override
	protected void tearDown() {
		a.dispose();
	}

	public void testController(){
		BacktoMainMenuController bc=new BacktoMainMenuController(a);
		bc.process();
		
		System.out.println("works");
	}
}
