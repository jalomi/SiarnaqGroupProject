package sixesWildBoundary;

import junit.framework.TestCase;
import sixesWildBoundary.SplashScreenGame;

public class TestSplashScreen extends TestCase {

	SplashScreenGame sg;
	
	@Override
	protected void setUp()
	{
		sg=new SplashScreenGame(1000);
		sg.showSplash();
		sg.setVisible(true);
	}
	
	@Override
	protected void tearDown(){
		if(sg != null){
			sg.dispose() ;
		}
	}
	
	public void testSplashScreenGame()
	{
		System.out.println("Sample Splash Screen");
	}
}
