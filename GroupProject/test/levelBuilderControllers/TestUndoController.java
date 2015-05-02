package levelBuilderControllers;

import java.io.IOException;

import javax.swing.JTextField;

import junit.framework.TestCase;

import org.json.JSONException;

import levelBuilderBoundary.LevelBuilderApplication;

public class TestUndoController extends TestCase{
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
		SelectLevelNumberController slc=new SelectLevelNumberController(LevelBuilderApplication.model, a);
		JTextField tb=a.getInputPanel().getLevel();
		tb.setText("55");
		slc.update(tb);
		
		UndoController uc=new UndoController(LevelBuilderApplication.model, a);
		uc.process();
		
		assertEquals(LevelBuilderApplication.model.getLevelNumber(), 0);
	}
	
	public void testInvalid() throws IOException, JSONException
	{
		LevelBuilderApplication.model.moveStack.clear();
		UndoController uc=new UndoController(LevelBuilderApplication.model, a);
		assertEquals(uc.process(), false);
	}
}
