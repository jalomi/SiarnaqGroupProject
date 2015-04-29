package levelBuilderControllers;

import java.io.IOException;

import javax.swing.JCheckBox;

import junit.framework.TestCase;
import levelBuilderBoundary.LevelBuilderApplication;

import org.json.JSONException;

public class TestActivateSpecialMoveController extends TestCase{
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
	
	public void testSpecialMove() throws IOException, JSONException
	{
		ActivateSpecialMoveController asc=new ActivateSpecialMoveController(LevelBuilderApplication.model, a, 1);
		JCheckBox cb=a.getInputPanel().getResetEnabled();
		cb.setSelected(true);
		asc.update(cb);
		
		assertEquals(LevelBuilderApplication.model.getReset(), true);
		
		cb.setSelected(false);
		asc.update(cb);
		
		assertEquals(LevelBuilderApplication.model.getReset(), false);
	}
}
