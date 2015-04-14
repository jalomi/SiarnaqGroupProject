package levelBuilderBoundary;

import junit.framework.TestCase;

public class TestSplashScreen extends TestCase {
	
	SplashScreen splash ;
	
	@Override
	protected void setUp(){
		splash = new SplashScreen(1000) ;
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
