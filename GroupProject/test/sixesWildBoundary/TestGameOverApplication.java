package sixesWildBoundary;

import junit.framework.TestCase;

public class TestGameOverApplication extends TestCase{
GameOverApplication m;
	
	@Override
	protected void setUp() {
	}
	
	@Override
	protected void tearDown() {
		if(m != null) {
			m.dispose();
		}
	}
	
	public void testMainMenuWon() {
		m=new GameOverApplication(true);
	}
	
	public void testMainMenuLost() {
		m=new GameOverApplication(true);
	}
}
