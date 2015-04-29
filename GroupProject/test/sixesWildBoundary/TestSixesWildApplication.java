package sixesWildBoundary;

import junit.framework.TestCase;
import sixesWildEntity.Level;
import sixesWildEntity.SixesWild;
import sixesWildBoundary.SixesWildApplication;

public class TestSixesWildApplication extends TestCase {
	SixesWildApplication s;
	
	@Override
	protected void setUp()
	{
		s=new SixesWildApplication(new SixesWild());
	}
	
	public void testSixesWildApplication()
	{
		System.out.println("Sample Sixes Wild");
	}
}
