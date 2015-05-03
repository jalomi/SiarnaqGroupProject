package levelBuilderControllers;

import java.io.IOException;
import junit.framework.TestCase;
import levelBuilderBoundary.LevelBuilderApplication;
import org.json.JSONException;

public class TestChoosingLevelController extends TestCase{
LevelBuilderApplication a;
	
	@Override
	protected void setUp() throws IOException, JSONException {
		a = new LevelBuilderApplication();
		
		a.setVisible(true);
	}
	
	@Override
	protected void tearDown() {
		a.dispose();
	}
	
	public void testPuzzle() throws IOException, JSONException
	{
		ChoosingLevelController clc=new ChoosingLevelController(a);
		a.getInputPanel().getChoosingLevel().setSelectedItem("Puzzle 1");
		clc.update(a.getInputPanel().getChoosingLevel());
		assertEquals(a.model.getLevelNumber(), 1);
	}
	
	public void testLightning() throws IOException, JSONException
	{
		ChoosingLevelController clc=new ChoosingLevelController(a);
		a.getInputPanel().getChoosingLevel().setSelectedItem("Lightning 2");
		clc.update(a.getInputPanel().getChoosingLevel());
		assertEquals(a.model.getLevelNumber(), 2);
	}
	
	public void testElimination() throws IOException, JSONException
	{
		ChoosingLevelController clc=new ChoosingLevelController(a);
		a.getInputPanel().getChoosingLevel().setSelectedItem("Elimination 3");
		clc.update(a.getInputPanel().getChoosingLevel());
		assertEquals(a.model.getLevelNumber(), 3);
	}
	
	public void testRelease() throws IOException, JSONException
	{
		ChoosingLevelController clc=new ChoosingLevelController(a);
		a.getInputPanel().getChoosingLevel().setSelectedItem("Release 4");
		clc.update(a.getInputPanel().getChoosingLevel());
		assertEquals(a.model.getLevelNumber(), 4);
	}
	
	public void testNewLevel() throws IOException, JSONException
	{
		ChoosingLevelController clc=new ChoosingLevelController(a);
		a.getInputPanel().getChoosingLevel().setSelectedItem("New Level");
		clc.update(a.getInputPanel().getChoosingLevel());
		//assertEquals(a.model.getLevelNumber(), 0);
	}
}
