package sixesWildBoundary;

import junit.framework.TestCase;

public class TestAllBoundary extends TestCase {
	public void testAllBoundary() throws Throwable {
		TestGameOverApplication goa = new TestGameOverApplication();
		goa.run();
		goa.testMainMenuLost();
		goa.testMainMenuWon();
		
		TestLevelSelectApplication lsa = new TestLevelSelectApplication();
		lsa.run();
		lsa.testLevelSelect();
	}
}
