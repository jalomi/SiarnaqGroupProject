package sixesWildBoundary;

import junit.framework.TestCase;

public class TestMainMenuApplication extends TestCase {
	MainMenuApplication m;
	
	@Override
	protected void setUp() {
		m=new MainMenuApplication();
	}
	
	@Override
	protected void tearDown() {
		if(m != null) {
			m.dispose();
		}
	}
	
	public void testMainMenu() {
	}
}
