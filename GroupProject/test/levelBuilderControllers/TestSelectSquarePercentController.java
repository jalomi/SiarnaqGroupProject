package levelBuilderControllers;

import java.io.IOException;

import javax.swing.JTextField;

import junit.framework.TestCase;
import levelBuilderBoundary.LevelBuilderApplication;

import org.json.JSONException;

public class TestSelectSquarePercentController extends TestCase{
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
		SelectSquarePercentController sspc=new SelectSquarePercentController(a.model, a, 0);
		JTextField tb=a.getInputPanel().getPercent1();
		tb.setText("55");
		sspc.update(tb);
		
		assertEquals(a.model.getPercent(0), 0.55);
		assertEquals(a.model.getPercent(5), 0.45);
	}
	
	public void testInvalid() throws IOException, JSONException
	{
		SelectSquarePercentController sspc=new SelectSquarePercentController(a.model, a, 0);
		JTextField tb=a.getInputPanel().getPercent1();
		tb.setText("abc");
		sspc.update(tb);
		
		assertEquals(a.model.getPercent(0), 0.55);
		assertEquals(a.model.getPercent(5), 0.45);
	}
}
