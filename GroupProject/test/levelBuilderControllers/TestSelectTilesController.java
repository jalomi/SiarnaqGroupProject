package levelBuilderControllers;

import java.io.IOException;
import javax.swing.JToggleButton;
import junit.framework.TestCase;
import levelBuilderBoundary.LevelBuilderApplication;
import org.json.JSONException;

public class TestSelectTilesController extends TestCase{
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
	
	public void testSelect() throws IOException, JSONException
	{
		JToggleButton tb=a.getGamePanel().getTile(5, 2);
		SelectTilesController stc=new SelectTilesController(LevelBuilderApplication.model, a, tb, 5, 2);
		stc.process();
		
		assertEquals(LevelBuilderApplication.model.getTileActiveAt(5, 2), true);
	}
	
	public void testDeselect() throws IOException, JSONException
	{
		JToggleButton tb=a.getGamePanel().getTile(5, 2);
		SelectTilesController stc=new SelectTilesController(LevelBuilderApplication.model, a, tb, 5, 2);
		tb.setSelected(true);
		stc.process();
		
		assertEquals(LevelBuilderApplication.model.getTileActiveAt(5, 2), false);
	}
	
	public void testUndo()
	{
		JToggleButton tb=a.getGamePanel().getTile(5, 2);
		SelectTilesController stc=new SelectTilesController(LevelBuilderApplication.model, a, tb, 5, 2);
		tb.setSelected(true);
		stc.process();
		
		UndoController uc=new UndoController(LevelBuilderApplication.model, a);
		uc.process();
		assertEquals(LevelBuilderApplication.model.getTileActiveAt(5, 2), true);
	}
}
