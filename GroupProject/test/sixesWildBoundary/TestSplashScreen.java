package sixesWildBoundary;

import junit.framework.TestCase;

public class TestSplashScreen extends TestCase {
	SplashScreenGame sg;
	
	protected void setUp()
	{
		sg=new SplashScreenGame(1000);
		sg.showSplash();
		sg.setVisible(true);
	}
	
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
