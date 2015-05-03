package levelBuilderControllers;

import java.io.IOException;

import javax.swing.JCheckBox;

import junit.framework.TestCase;
import levelBuilderBoundary.LevelBuilderApplication;

import org.json.JSONException;

public class TestChoosingLevelController extends TestCase{
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
	
	public void testChooseLevel() throws IOException, JSONException
	{
		ChoosingLevelController clc=new ChoosingLevelController(a);
		a.getInputPanel().getChoosingLevel().setSelectedItem("Puzzle 1");
		clc.update(a.getInputPanel().getChoosingLevel());
	}
}
