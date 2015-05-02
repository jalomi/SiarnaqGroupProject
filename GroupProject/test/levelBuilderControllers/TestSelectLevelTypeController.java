package levelBuilderControllers;

import java.io.IOException;
import javax.swing.JComboBox;
import junit.framework.TestCase;
import levelBuilderBoundary.LevelBuilderApplication;
import org.json.JSONException;

public class TestSelectLevelTypeController extends TestCase{
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
	
	public void testLightning() throws IOException, JSONException
	{
		SelectLevelTypeController sltc=new SelectLevelTypeController(LevelBuilderApplication.model, a);
		JComboBox<String> cb=a.getInputPanel().getType();
		cb.setSelectedItem("Lightning");
		sltc.update(cb);
		
		assertEquals(LevelBuilderApplication.model.getLevelType(), "Lightning");
	}
	
	public void testRelease() throws IOException, JSONException
	{
		SelectLevelTypeController sltc=new SelectLevelTypeController(LevelBuilderApplication.model, a);
		JComboBox<String> cb=a.getInputPanel().getType();
		cb.setSelectedItem("Release");
		sltc.update(cb);
		
		assertEquals(LevelBuilderApplication.model.getLevelType(), "Release");
		assertEquals(LevelBuilderApplication.model.getTileActiveAt(8, 2), false);
	}
}
