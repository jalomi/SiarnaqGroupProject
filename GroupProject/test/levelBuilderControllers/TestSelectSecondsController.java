package levelBuilderControllers;

import java.io.IOException;

import javax.swing.JTextField;

import junit.framework.TestCase;
import levelBuilderBoundary.LevelBuilderApplication;

import org.json.JSONException;

public class TestSelectSecondsController extends TestCase{
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
		SelectSecondsController ssc=new SelectSecondsController(LevelBuilderApplication.model, a);
		JTextField tb=a.getInputPanel().getSeconds();
		tb.setText("55");
		ssc.update(tb);
		
		assertEquals(LevelBuilderApplication.model.getSeconds(), 55);
	}
	
	public void testInvalid() throws IOException, JSONException
	{
		LevelBuilderApplication.model.setSeconds(0);
		SelectSecondsController smc=new SelectSecondsController(LevelBuilderApplication.model, a);
		JTextField tb=a.getInputPanel().getSeconds();
		tb.setText("abc");
		smc.update(tb);
		
		assertEquals(LevelBuilderApplication.model.getSeconds(), 0);
	}
	
	public void testUndo()
	{
		SelectSecondsController ssc=new SelectSecondsController(LevelBuilderApplication.model, a);
		JTextField tb=a.getInputPanel().getSeconds();
		tb.setText("55");
		ssc.update(tb);
		
		UndoController uc=new UndoController(LevelBuilderApplication.model, a);
		uc.process();
		assertEquals(LevelBuilderApplication.model.getSeconds(), 0);
	}
}
