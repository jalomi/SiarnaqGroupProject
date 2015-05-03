package levelBuilderControllers;

import java.io.IOException;

import javax.swing.JCheckBox;
import javax.swing.JToggleButton;

import junit.framework.TestCase;

import org.json.JSONException;

import levelBuilderBoundary.LevelBuilderApplication;

public class TestActivateBucketforSixesController extends TestCase{
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
	
	public void testBucket() throws IOException, JSONException
	{
		ActivateBucketforSixesController abc=new ActivateBucketforSixesController(LevelBuilderApplication.model, a, 0);
		JCheckBox cb=a.getCheckBoxPanel().getCheckBox(0);
		cb.setSelected(true);
		abc.update(cb);
		
		assertEquals(LevelBuilderApplication.model.getBucketEnabled(0), true);
		
		cb.setSelected(false);
		abc.update(cb);
		
		assertEquals(LevelBuilderApplication.model.getBucketEnabled(0), false);
	}
	
	public void testUndo()
	{
		ActivateBucketforSixesController abc=new ActivateBucketforSixesController(LevelBuilderApplication.model, a, 0);
		JCheckBox cb=a.getCheckBoxPanel().getCheckBox(0);
		cb.setSelected(false);
		abc.update(cb);
		
		UndoController uc=new UndoController(LevelBuilderApplication.model, a);
		uc.process();
		assertEquals(LevelBuilderApplication.model.getBucketEnabled(0), false);
	}
}
