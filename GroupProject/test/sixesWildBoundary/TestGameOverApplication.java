package sixesWildBoundary;

import junit.framework.TestCase;

public class TestGameOverApplication extends TestCase{
GameOverApplication m;
	
	@Override
	protected void setUp()
	{
		m=new GameOverApplication(true);
	}
	
	public void testMainMenu()
	{
		System.out.println("Sample Game Over");
	}
}
