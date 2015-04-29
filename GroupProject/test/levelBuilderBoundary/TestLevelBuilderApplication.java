package levelBuilderBoundary;

import java.io.IOException;

import org.json.JSONException;

import junit.framework.TestCase;

public class TestLevelBuilderApplication extends TestCase {
	
	LevelBuilderApplication LBA ;
	
	@Override
	protected void setUp() throws IOException, JSONException{
		LBA = new LevelBuilderApplication() ;
		
		LBA.setVisible(true) ;
	}
	
	@Override
	protected void tearDown(){
		if(LBA != null){
			LBA.dispose() ;
		}
	}
	
	public void test(){
		 System.out.println("Sample LevelBuilder GUI") ;
	}
}