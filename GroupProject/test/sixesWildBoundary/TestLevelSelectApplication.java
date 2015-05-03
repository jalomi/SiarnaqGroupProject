package sixesWildBoundary;

import junit.framework.TestCase;

public class TestLevelSelectApplication extends TestCase {
	LevelSelectApplication l;
	
	@Override
	protected void setUp() {
		l = new LevelSelectApplication();
	}
	
	@Override
	protected void tearDown() {
		if(l != null) {
			l.dispose();
		}
	}
	
	public void testLevelSelect() {
	}
}

