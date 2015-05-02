package levelBuilderControllers;

import java.io.IOException;

import javax.swing.JTextField;

import junit.framework.TestCase;
import levelBuilderBoundary.LevelBuilderApplication;

import org.json.JSONException;

public class TestSelectSquarePercentController extends TestCase{
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
		SelectSquarePercentController sspc=new SelectSquarePercentController(LevelBuilderApplication.model, a, 0);
		JTextField tb=a.getInputPanel().getPercent1();
		tb.setText("30");
		sspc.update(tb);
		
		assertEquals(LevelBuilderApplication.model.getPercent(0), 0.3);
		assertEquals(LevelBuilderApplication.model.getPercent(5), 0.7);
	}
	
	public void testInvalid() throws IOException, JSONException
	{
		SelectSquarePercentController sspc=new SelectSquarePercentController(LevelBuilderApplication.model, a, 0);
		JTextField tb=a.getInputPanel().getPercent1();
		tb.setText("abc");
		sspc.update(tb);
		
		assertEquals(LevelBuilderApplication.model.getPercent(0), 0.3);
		assertEquals(LevelBuilderApplication.model.getPercent(5), 0.7);
	}
}
