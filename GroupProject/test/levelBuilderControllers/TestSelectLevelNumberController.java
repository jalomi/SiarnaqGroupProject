package levelBuilderControllers;

import java.io.IOException;

import javax.swing.JTextField;

import junit.framework.TestCase;
import levelBuilderBoundary.LevelBuilderApplication;

import org.json.JSONException;

public class TestSelectLevelNumberController extends TestCase{
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
		
		assertEquals(LevelBuilderApplication.model.getLevelNumber(), 55);
	}
	
	public void testInvalid() throws IOException, JSONException
	{
		SelectLevelNumberController slc=new SelectLevelNumberController(LevelBuilderApplication.model, a);
		JTextField tb=a.getInputPanel().getLevel();
		tb.setText("abc");
		slc.update(tb);
		
		assertEquals(LevelBuilderApplication.model.getLevelNumber(), 55);
	}
	
	public void testUndo()
	{
		SelectLevelNumberController slc=new SelectLevelNumberController(LevelBuilderApplication.model, a);
		JTextField tb=a.getInputPanel().getLevel();
		tb.setText("65");
		slc.update(tb);
		
		UndoController uc=new UndoController(LevelBuilderApplication.model, a);
		uc.process();
		assertEquals(LevelBuilderApplication.model.getLevelNumber(), 55);
	}
}
