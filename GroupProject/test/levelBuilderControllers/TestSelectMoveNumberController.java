package levelBuilderControllers;

import java.io.IOException;

import javax.swing.JTextField;

import org.json.JSONException;

import junit.framework.TestCase;
import levelBuilderBoundary.LevelBuilderApplication;

public class TestSelectMoveNumberController extends TestCase{
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
		SelectMoveNumberController smc=new SelectMoveNumberController(LevelBuilderApplication.model, a);
		JTextField tb=a.getInputPanel().getMaxMoves();
		tb.setText("55");
		smc.update(tb);
		
		assertEquals(LevelBuilderApplication.model.getMoves(), 55);
	}
	
	public void testInvalid() throws IOException, JSONException
	{
		SelectMoveNumberController smc=new SelectMoveNumberController(LevelBuilderApplication.model, a);
		JTextField tb=a.getInputPanel().getMaxMoves();
		tb.setText("abc");
		smc.update(tb);
		
		assertEquals(LevelBuilderApplication.model.getMoves(), 55);
	}
}
