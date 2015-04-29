package sixesWildBoundary;

import sixesWildEntity.SixesWild;
import junit.framework.TestCase;

public class TestLevelSelectApplication extends TestCase {
	LevelSelectApplication l;
	
	@Override
	protected void setUp()
	{
		l=new LevelSelectApplication(new SixesWild());
	}
	
	public void testLevelSelect()
	{
		System.out.println("Sample Level Select");
	}
}

