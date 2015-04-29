package levelBuilderControllers;

import java.io.IOException;

import javax.swing.JTextField;

import junit.framework.TestCase;
import levelBuilderBoundary.LevelBuilderApplication;

import org.json.JSONException;

public class TestSelectMultiplierPercentController extends TestCase{
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
	
	public void testValid() throws IOException, JSONException
	{
		SelectMultiplierPercentController sspc=new SelectMultiplierPercentController(LevelBuilderApplication.model, a, 1);
		JTextField tb=a.getInputPanel().getPercentx2();
		tb.setText("55");
		sspc.update(tb);
		
		assertEquals(LevelBuilderApplication.model.getPercentM(1), 0.55);
		assertEquals(LevelBuilderApplication.model.getPercentM(0), 0.45);
	}
	
	public void testInvalid() throws IOException, JSONException
	{
		SelectMultiplierPercentController sspc=new SelectMultiplierPercentController(LevelBuilderApplication.model, a, 1);
		JTextField tb=a.getInputPanel().getPercentx2();
		tb.setText("abc");
		sspc.update(tb);
		
		assertEquals(LevelBuilderApplication.model.getPercentM(1), 0.55);
		assertEquals(LevelBuilderApplication.model.getPercentM(0), 0.45);
	}
}
