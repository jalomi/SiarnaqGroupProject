package sixesWildBoundary;

import sixesWildEntity.Level;
import junit.framework.TestCase;

public class TestSixesWildApplication extends TestCase {
	SixesWildApplication s;
	Level l;
	
	protected void setUp()
	{
		l=new Level();
		s=new SixesWildApplication(l);
	}
	
	public void testSixesWildApplication()
	{
		System.out.println("Sample Sixes Wild");
	}
}
