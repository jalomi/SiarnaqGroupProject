package levelBuilderControllers;

import java.io.IOException;

import javax.swing.JTextField;

import junit.framework.TestCase;
import levelBuilderBoundary.LevelBuilderApplication;

import org.json.JSONException;

public class TestRedoController extends TestCase{
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
		LevelBuilderApplication.model.setLevelNumber(1);
		SelectLevelNumberController slc=new SelectLevelNumberController(LevelBuilderApplication.model, a);
		JTextField tb=a.getInputPanel().getLevel();
		tb.setText("0");
		slc.update(tb);
		
		tb.setText("14") ;
		slc.update(tb) ;
		
		UndoController uc=new UndoController(LevelBuilderApplication.model, a);
		uc.process();
		
		assertEquals(LevelBuilderApplication.model.getLevelNumber(), 1);
		
		RedoController rc=new RedoController(LevelBuilderApplication.model, a);
		rc.process();
		
		assertEquals(LevelBuilderApplication.model.getLevelNumber(), 14);
	}
	
	public void testInvalid() throws IOException, JSONException
	{
		LevelBuilderApplication.model.redoStack.clear();
		RedoController rc=new RedoController(LevelBuilderApplication.model, a);
		assertEquals(rc.process(), false);
	}
}
