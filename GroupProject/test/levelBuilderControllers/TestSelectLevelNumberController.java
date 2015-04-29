package levelBuilderControllers;

import java.io.IOException;

import javax.swing.JCheckBox;
import javax.swing.JTextField;

import junit.framework.TestCase;
import levelBuilderBoundary.LevelBuilderApplication;

import org.json.JSONException;

public class TestSelectLevelNumberController extends TestCase{
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
		SelectLevelNumberController slc=new SelectLevelNumberController(a.model, a);
		JTextField tb=a.getInputPanel().getLevel();
		tb.setText("55");
		slc.update(tb);
		
		assertEquals(a.model.getLevelNumber(), 55);
	}
	
	public void testInvalid() throws IOException, JSONException
	{
		SelectLevelNumberController slc=new SelectLevelNumberController(a.model, a);
		JTextField tb=a.getInputPanel().getLevel();
		tb.setText("abc");
		slc.update(tb);
		
		assertEquals(a.model.getLevelNumber(), 55);
	}
}
