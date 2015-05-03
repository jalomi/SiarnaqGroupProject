package levelBuilderControllers;

import java.io.IOException;

import javax.swing.JTextField;

import junit.framework.TestCase;
import levelBuilderBoundary.LevelBuilderApplication;

import org.json.JSONException;

public class TestSelectStarScoreController extends TestCase{
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
	
	public void testScore1() throws IOException, JSONException
	{
		SelectStarScoreController sssc=new SelectStarScoreController(LevelBuilderApplication.model, a, 0);
		JTextField tb=a.getInputPanel().getScore1();
		tb.setText("30");
		sssc.update(tb);
		
		assertEquals(LevelBuilderApplication.model.getStarScore(0), 30);
	}
	
	public void testScore2() throws IOException, JSONException
	{
		SelectStarScoreController sssc=new SelectStarScoreController(LevelBuilderApplication.model, a, 1);
		JTextField tb=a.getInputPanel().getScore2();
		tb.setText("40");
		sssc.update(tb);
		
		assertEquals(LevelBuilderApplication.model.getStarScore(1), 40);
	}
	
	public void testScore3() throws IOException, JSONException
	{
		SelectStarScoreController sssc=new SelectStarScoreController(LevelBuilderApplication.model, a, 2);
		JTextField tb=a.getInputPanel().getScore3();
		tb.setText("50");
		sssc.update(tb);
		
		assertEquals(LevelBuilderApplication.model.getStarScore(2), 50);
	}
	
	public void testInvalid() throws IOException, JSONException
	{
		SelectStarScoreController sspc=new SelectStarScoreController(LevelBuilderApplication.model, a, 0);
		JTextField tb=a.getInputPanel().getScore1();
		tb.setText("abc");
		sspc.update(tb);
		
		assertEquals(LevelBuilderApplication.model.getStarScore(0), 0);
	}
	
	public void testUndo()
	{
		SelectStarScoreController sspc=new SelectStarScoreController(LevelBuilderApplication.model, a, 0);
		JTextField tb=a.getInputPanel().getScore1();
		tb.setText("88");
		sspc.update(tb);
		
		UndoController uc=new UndoController(LevelBuilderApplication.model, a);
		uc.process();
		assertEquals(LevelBuilderApplication.model.getStarScore(0), 0);
	}
}
