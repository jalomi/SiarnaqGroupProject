package levelBuilderControllers;

import java.awt.event.ActionEvent;
import java.io.IOException;

import javax.swing.JCheckBox;

import junit.framework.TestCase;

import org.json.JSONException;

import levelBuilderBoundary.LevelBuilderApplication;
import levelBuilderEntity.LevelBuilder;

public class TestActivateBucketforSixesController extends TestCase{
	LevelBuilderApplication a;
	
	protected void setUp() throws IOException, JSONException {
		a = new LevelBuilderApplication();
		
		a.setVisible(true);
	}
	
	protected void tearDown() {
		a.dispose();
	}
	
	public void testBucket() throws IOException, JSONException
	{
		ActivateBucketforSixesController abc=new ActivateBucketforSixesController(a.model, a, 0);
		JCheckBox cb=a.getCheckBoxPanel().getCheckBox1();
		cb.setSelected(true);
		abc.update(cb);
		
		assertEquals(a.model.getBucketEnabled(0), true);
		
		cb.setSelected(false);
		abc.update(cb);
		
		assertEquals(a.model.getBucketEnabled(0), false);
	}
}
