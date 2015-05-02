package levelBuilderBoundary;

import java.io.IOException;

import junit.framework.TestCase;

import org.json.JSONException;

public class TestLevelBuilderSavedScreen extends TestCase{
	LevelBuilderSavedScreen lbs;
	protected void setUp() throws IOException, JSONException{
		lbs = new LevelBuilderSavedScreen() ;
		
		lbs.setVisible(true) ;
	}
	
	@Override
	protected void tearDown(){
		if(lbs != null){
			lbs.dispose() ;
		}
	}
	
	public void test(){
		 System.out.println("Sample SavedScreen GUI") ;
	}
}
