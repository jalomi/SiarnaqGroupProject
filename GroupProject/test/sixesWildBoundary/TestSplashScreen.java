package sixesWildBoundary;

import junit.framework.TestCase;
import sixesWildBoundary.SplashScreenGame;

public class TestSplashScreen extends TestCase {
	
	SplashScreenGame splash ;
	
	@Override
	protected void setUp(){
		splash = new SplashScreenGame(1000) ;
		splash.showSplash();
		splash.setVisible(true) ;
	}
	
	@Override
	protected void tearDown(){
		if(splash != null){
			splash.dispose() ;
		}
	}
	
	public void test(){
		 System.out.println("Sample SplashScreen") ;
	}

}
