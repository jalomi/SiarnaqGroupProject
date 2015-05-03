package sixesWildBoundary;

import junit.framework.TestCase;
import sixesWildBoundary.SplashScreen;

public class TestSplashScreen extends TestCase {

	SplashScreen sg;
	
	@Override
	protected void setUp() {
		sg=new SplashScreen(1000);
		sg.showSplash();
		sg.setVisible(true);
	}
	
	@Override
	protected void tearDown() {
		if(sg != null){
			sg.dispose() ;
		}
	}
	
	public void testSplashScreenGame() {
	}
}
