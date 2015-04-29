package levelBuilderControllers;

import java.io.IOException;

import javax.swing.JTextField;

import junit.framework.TestCase;
import levelBuilderBoundary.LevelBuilderApplication;

import org.json.JSONException;

public class TestSelectSecondsController extends TestCase{
LevelBuilderApplication a;
	
	protected void setUp() throws IOException, JSONException {
		a = new LevelBuilderApplication();
		
		a.setVisible(true);
	}
	
	protected void tearDown() {
		a.dispose();
	}
	
	public void testValid() throws IOException, JSONException
	{
		SelectSecondsController ssc=new SelectSecondsController(a.model, a);
		JTextField tb=a.getInputPanel().getSeconds();
		tb.setText("55");
		ssc.update(tb);
		
		assertEquals(a.model.getSeconds(), 55);
	}
	
	public void testInvalid() throws IOException, JSONException
	{
		SelectSecondsController smc=new SelectSecondsController(a.model, a);
		JTextField tb=a.getInputPanel().getSeconds();
		tb.setText("abc");
		smc.update(tb);
		
		assertEquals(a.model.getSeconds(), 55);
	}
}
